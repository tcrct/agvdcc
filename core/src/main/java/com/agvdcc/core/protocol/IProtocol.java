package com.agvdcc.core.protocol;

public interface IProtocol {

    // 设备/车辆id
    String getDeviceId();

    // 功能指令
    String getCommand();

    // 协议原始内容
    String getBody();

}
