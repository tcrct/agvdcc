package com.agvdcc.service;

import cn.hutool.core.thread.ThreadUtil;
import com.agvdcc.core.annotations.Service;
import com.agvdcc.core.protocol.IProtocol;

@Service
public class A001Service extends BaseService<IProtocol> {

    @Override
    public String setRout(IProtocol protocol) {
        System.out.println("Thread.currentThread().getName(): " + Thread.currentThread().getId());
//        System.out.println(protocol.getDeviceId());
//        System.out.println(protocol.getCommand());
//        System.out.println(protocol.getBody());
        ThreadUtil.safeSleep(3000L);
        return protocol.getBody();
    }
}
