package com.genieworks.ginterface.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Genie Works [Interface Server] <br />
 * Eureka Server!
 *
 * TODO : Eureka Server 설명 추가 필요..
 * <pre>
 *
 * </pre>
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    /**
     * Start Eureka Server.
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}