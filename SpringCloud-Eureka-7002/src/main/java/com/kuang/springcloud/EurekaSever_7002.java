package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer //EnableEurekaServer,服务端启动类，可以接受别人注册进来
public class EurekaSever_7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaSever_7002.class, args);
    }
}
