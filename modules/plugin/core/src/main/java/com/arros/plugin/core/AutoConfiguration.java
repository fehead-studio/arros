package com.arros.plugin.core;

import com.arros.plugin.core.component.HeartBeat;
import com.arros.plugin.core.dto.BeatBody;
import com.arros.plugin.core.properties.CoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author Verge
 * @Date 2021/12/4 16:14
 * @Version 1.0
 */

@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "arros.plugin", name = "enable", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(CoreProperties.class)
@EnableScheduling
public class AutoConfiguration {
    private final static Logger LOGGER = LoggerFactory.getLogger(HeartBeat.class);

    @Autowired
    private CoreProperties properties;
    @Autowired
    private Environment environment;

    @Scheduled(fixedDelay = 10000)
    public void beat() {
        String port = environment.getProperty("server.port");
        String name = environment.getProperty("spring.application.name");
        InetAddress localHost = null;
        try {
            localHost = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            LOGGER.error(e.getMessage(),e);
        }

        assert localHost != null;
        BeatBody beatBody = new BeatBody(name, localHost.getHostAddress(), port);

        HeartBeat.beat(beatBody, properties.getServer());
    }
}
