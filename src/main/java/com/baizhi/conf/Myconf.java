package com.baizhi.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Myconf {
    @LoadBalanced       //负载均衡
    @Bean   //交给工厂管理
    public RestTemplate getRestTempleta(){
        return new RestTemplate();
    }
}
