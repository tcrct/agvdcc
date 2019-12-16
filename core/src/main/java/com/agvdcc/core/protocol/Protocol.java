package com.agvdcc.core.protocol;

public class Protocol implements IProtocol {

    private String deviceId;
    private String command;
    private String body;

    public Protocol(String deviceId, String command, String body) {
        this.deviceId = deviceId;
        this.command = command;
        this.body = body;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getBody() {
        return body;
    }
}
