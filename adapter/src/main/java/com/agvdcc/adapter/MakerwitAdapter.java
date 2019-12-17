package com.agvdcc.adapter;

import com.agvdcc.core.interfaces.IAdapter;
import com.agvdcc.core.interfaces.IConvertTelegram;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;

/**
 * 创智适配器
 *
 * @author Laotang
 */
public class MakerwitAdapter implements IAdapter {

    @Override
    public MessageToMessageEncoder encoder() {
        return new VehicleTelegramEncoder();
    }

    @Override
    public MessageToMessageDecoder decoder() {
        return new VehicleTelegramDecoder();
    }

    @Override
    public IConvertTelegram convertTelegram() {
        return new ConvertTelegramHandler();
    }
}
