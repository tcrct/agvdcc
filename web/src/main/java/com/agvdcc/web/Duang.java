package com.agvdcc.web;

import com.agvdcc.core.dispatch.DispatchFactory;
import com.agvdcc.core.helper.BeanHelper;
import com.agvdcc.core.helper.ClassHelper;
import com.agvdcc.core.protocol.IProtocol;
import com.agvdcc.core.protocol.Protocol;

public class Duang {

    public static void main(String[] args) {
        ClassHelper.duang();
        BeanHelper.duang();
        for (int i=0; i<10; i++) {
            IProtocol protocol = new Protocol("A001", "setrout", System.currentTimeMillis()+ "A001##,,A001,,s,,setrout,,mb234::mb214::mb235::mb229::mb226::mb219::mb225::eb223,,0000,,ZZ"); //ProtocolFactory.toProtocol("");
            Object protocolObj = DispatchFactory.execute(protocol);
            System.out.println("#############: " + protocolObj);
        }
    }

}
