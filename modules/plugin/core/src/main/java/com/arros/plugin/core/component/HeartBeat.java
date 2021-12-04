package com.arros.plugin.core.component;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.arros.plugin.core.dto.BeatBody;
import com.arros.plugin.core.properties.CoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author Verge
 * @Date 2021/12/4 17:31
 * @Version 1.0
 */
public class HeartBeat{
    private final static Logger LOGGER = LoggerFactory.getLogger(HeartBeat.class);

    public static void beat(BeatBody beatBody, String serverHost) {
        LOGGER.info("发送心跳: " + beatBody);

        String response = HttpRequest
                .post(serverHost + "/beat")
                .body(JSONUtil.toJsonStr(beatBody))
                .execute()
                .body();

        LOGGER.info(response);
    }
}
