package com.agvdcc.adapter;

import com.agvdcc.core.interfaces.IConvertTelegram;
import com.agvdcc.core.interfaces.IRequest;

import java.util.List;

/**
 * 协议报文转换处理器
 *
 * @author Laotang
 */
public class ConvertTelegramHandler implements IConvertTelegram {
    @Override
    public List<IRequest> convert(Object telegram) {
        return null;
    }
}
