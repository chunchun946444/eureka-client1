package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//@EnableDiscoveryClient //不仅支持Eureka作为注册中心还支持Zookeeper

@EnableHystrix  //消费者入口类上开启熔断器的注解
@EnableEurekaClient   //只支持eureka
@SpringBootApplication
public class EurekaServiceApplication1 {

    public static void main(String[] args) {

        SpringApplication.run(EurekaServiceApplication1.class, args);
    }

}
