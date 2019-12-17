package com.agvdcc.core.interfaces;

import java.util.List;

/**
 * 将报文转换成IRequest对象接口
 *
 * @author Laotang
 */
public interface IConvertTelegram {

    /**
     *  将接收到的协议报文转换为IRequest对象
     *
     * @param telegram 协议报文对象
     * @return  IRequest对象集合
     */
    List<IRequest> convert(Object telegram);

}
