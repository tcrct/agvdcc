package com.agvdcc.core.handshaker;

import cn.hutool.core.thread.ThreadUtil;
import com.agvdcc.core.protocol.IProtocol;

import java.util.Objects;

/**
 * Created by laotang on 2019/12/16.
 */
public final class HandshakerFactory {

    private static final HandshakerFactory HANDSHAKER_FACTORY = new HandshakerFactory();
    private HandshakerFactory() {
        return HANDSHAKER_FACTORY;
    }

    public static HandshakerFactory duang() {
        return HANDSHAKER_FACTORY;
    }

    public void replyProtocol(IProtocol protocol) {
        Objects.requireNonNull(protocol, "协议对象不能为空");
        if ("s".equals(protocol.getDirection())) {
            ThreadUtil.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }

}
