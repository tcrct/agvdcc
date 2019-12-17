package com.agvdcc.core.interfaces;

import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;

/**
 * 适配器接口
 *主要用于对每个客户端所需要的协议，命令等进行适配
 *
 * @author Laotang
 */
public interface IAdapter {

    /**协议编码*/
    MessageToMessageEncoder encoder();

    /**协议解码*/
    MessageToMessageDecoder decoder();

    /**转换对象*/
    IConvertTelegram convertTelegram();
}
