package com.genieworks.ginterface.product.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Test Configuration.
 */
@Configuration
@ComponentScan("com.genieworks.ginterface.product")
@EnableJpaRepositories("com.genieworks.ginterface.product")
public class ProductTestConfig { }
