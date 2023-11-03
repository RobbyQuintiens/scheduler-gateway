package com.example.schedulergateway;

import com.example.schedulergateway.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class SchedulerGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerGatewayApplication.class, args);
    }

}
