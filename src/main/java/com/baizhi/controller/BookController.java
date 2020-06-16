package com.baizhi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
@RestController
@RequestMapping("book")
public class BookController {
    @Resource
    RestTemplate restTemplate;

    /*@Resource
    LoadBalancerClient loadBalancerClient;*/

    @RequestMapping("queryByName")
    public String query(String byname)throws Exception{

        //ServiceInstance choose = loadBalancerClient.choose("EUREKA-CLIENT2");
        /*System.out.println("getHost:"+choose.getHost());
        System.out.println("getServiceId:"+choose.getServiceId());
        System.out.println("getPort:"+choose.getPort());
        System.out.println("getUri:"+choose.getUri());
        System.out.println("getMetadata:"+choose.getMetadata());*/

        String forObject = restTemplate.getForObject("http://EUREKA-CLIENT2/category/query?name="+byname, String.class);
        return  "Client1的请求=    "+forObject;
    }

    @RequestMapping("books")
    @HystrixCommand(fallbackMethod ="Hystrixclient" )  //需要指定一个熔断后访问的方法  方法名参数表一致
    public String querybooks(String byname,Integer id)throws Exception{
        String forObject = restTemplate.getForObject("http://EUREKA-CLIENT2/category/querys?name="+byname+"&id="+id, String.class);

        return  "Client1的books请求=    "+forObject;
    }


    public String Hystrixclient(String byname,Integer id){
        return "EUREKA-CLIENT2 此集群已宕机";
    }
}
