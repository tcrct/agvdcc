package com.agvdcc.core.dispatch;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.ReflectUtil;
import com.agvdcc.core.handshaker.HandshakerFactory;
import com.agvdcc.core.helper.BeanHelper;
import com.agvdcc.core.protocol.IProtocol;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;

/**
 * 调度分发工厂
 * 根据协议指令中的车辆ID及指令动作，将协议分发到对应的service里的method。
 * 所以在Service里必须要实现对应指令动作的方法。
 *
 * @author Laotang
 */
public class DispatchFactory {

    private static final Logger logger = LoggerFactory.getLogger(DispatchFactory.class);

    private static final Map<String, ServiceBean> SERVICE_METHOD_MAP = new ConcurrentHashMap<>();

    /**
     * 根据IProtocol里的参数，反射调用对应Service里的方法
     * @param protocol
     */
    public static Object execute(IProtocol protocol) {
        if (SERVICE_METHOD_MAP.isEmpty()) {
            SERVICE_METHOD_MAP.putAll(BeanHelper.duang().toServiceBean());
        }


        ThreadUtil.execute(new Runnable() {
            @Override
            public void run() {
                HandshakerFactory.duang().replyProtocol(protocol);
            }
        });

        FutureTask<Object> futureTask = (FutureTask<Object>) ThreadUtil.execAsync(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                ServiceBean serviceBean = Optional.ofNullable(SERVICE_METHOD_MAP.get(protocol.getDeviceId())).orElseThrow(NullPointerException::new);
                Method method = Optional.ofNullable(serviceBean.getMethodMap().get(protocol.getCommand().toLowerCase())).orElseThrow(NullPointerException::new);
                return ReflectUtil.invoke(serviceBean.getServiceObj(), method, protocol);
            }
        });

        try {
            return futureTask.get(3000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ie) {
            logger.error("执行时发生InterruptedException: {}, {}", ie.getMessage(), ie);
        } catch (ExecutionException ee) {
            logger.error("执行时发生ExecutionException :{}, {}", ee.getMessage(), ee);
        } catch (TimeoutException te) {
            logger.error("执行时发生TimeoutException:{}, {}", te.getMessage(), te);
        } finally {
            if (futureTask.isDone()) {
                // 中止线程，参数为true时，会中止正在运行的线程，为false时，如果线程未开始，则停止运行
                futureTask.cancel(true);
                // 回复握手消息
                HandshakerFactory.duang().replyProtocol(protocol);
            }
        }
        return  null;
    }

}
