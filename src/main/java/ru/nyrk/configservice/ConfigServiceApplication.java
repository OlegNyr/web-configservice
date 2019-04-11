package ru.nyrk.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.config.EncryptionAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication(exclude = EncryptionAutoConfiguration.class)
public class ConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceApplication.class, args);
    }



}
