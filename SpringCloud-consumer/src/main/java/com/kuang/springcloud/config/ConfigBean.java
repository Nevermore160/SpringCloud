package com.kuang.springcloud.config;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //配置负载均衡实现RestTemplate
    /**
     *IRule负载均衡策略：
     *AvailabilityFilteringRule:过滤掉崩溃（跳闸），访问故障的服务，对剩下的服务进行轮询
     * RoundRobinRule 轮询
     * RandomRule 随机
     * RetryRule 先轮询获取服务，如果失败，会定时重发（重试）
     */
    @Bean
    @LoadBalanced //Ribbon实现负载均衡的注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
