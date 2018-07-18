package com.bamboo.registry;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心
 * Created by yklin on 2018/4/17.
 */
@EnableEurekaServer
@SpringBootApplication
public class RegistryApplicaion {
    public static void main(String[] args) {
        SpringApplication.run(RegistryApplicaion.class, args);
    }
}
