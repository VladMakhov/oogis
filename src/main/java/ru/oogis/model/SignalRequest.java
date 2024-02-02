package ru.oogis.model;

import java.util.List;

public class SignalRequest {
    private String mode;
    private String ip;
    private int port;
    private List<String> parameters;

    public SignalRequest(String mode, String ip, int port, List<String> parameters) {
        this.mode = mode;
        this.ip = ip;
        this.port = port;
        this.parameters = parameters;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }
}