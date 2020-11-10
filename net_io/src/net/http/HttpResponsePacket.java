package net.http;

import java.util.HashMap;
import java.util.Map;

public class HttpResponsePacket {
    public VERSION version;
    public STATUS status;
    public String reason;
    public Map<String ,String> config = new HashMap<>();
    public String body;

    public VERSION getVersion() {
        return version;
    }

    public void setVersion(VERSION version) {
        this.version = version;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public String parseConfigToString(){
        String str = "";
        for(String s:config.keySet()){
            str += s + ": " +  config.get(s) + "\r\n";
        }
        return str;
    }
    public String parsePacketToString(){
        String str = "";
        System.out.println(this.toString());
        str += HttpUtils.parseVersionToString(version) + " " + HttpUtils.parseStatusToString(status) + " " + reason + "\r\n" +
        parseConfigToString() + "\r\n" + body;
        return str;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "HttpResponsePacket{" +
                "version=" + version +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                ", config=" + config +
                ", body='" + body + '\'' +
                '}';
    }
}
