package cn.arros.plugin.core.dto;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author Verge
 * @Date 2021/12/4 19:08
 * @Version 1.0
 */
public class BeatBody {
    private String name;
    private String host;
    private String port;

    public BeatBody(String name, String host, String port) {
        this.name = name;
        this.host = host;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "BeatBody{" +
                "name='" + name + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
