package com.agvdcc.service;

import com.agvdcc.core.annotations.Service;
import com.agvdcc.core.protocol.IProtocol;

@Service(value = "A001")
public class A001Service extends BaseService<IProtocol> {

    @Override
    public String setRout(IProtocol protocol) {
        System.out.println(protocol.getDeviceId());
        System.out.println(protocol.getCommand());
        System.out.println(protocol.getBody());
        return protocol.getBody();
    }
}
