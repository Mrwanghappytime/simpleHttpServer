package net.http;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestPacket {
    public METHOD method;
    public String uri;
    public VERSION version;
    public Map<String,String> config = new HashMap<>();
    public String body;



    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public METHOD getMethod() {
        return method;
    }

    public void setMethod(METHOD method) {
        this.method = method;
    }

    public VERSION getVersion() {
        return version;
    }

    public void setVersion(VERSION version) {
        this.version = version;
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


    @Override
    public String toString() {
        return "HttpRequestPacket{" +
                "method=" + method +
                ", uri='" + uri + '\'' +
                ", version=" + version +
                ", config=" + config +
                ", body='" + body + '\'' +
                '}';
    }
}
