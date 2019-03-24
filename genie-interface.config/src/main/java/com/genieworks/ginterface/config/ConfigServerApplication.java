package com.genieworks.ginterface.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Genie Works [Config Server] <br />
 * Config Server!
 *
 * TODO : Config Server 설명 추가 필요..
 * <pre>
 *
 * </pre>
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    /**
     * Start Config Server.
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}