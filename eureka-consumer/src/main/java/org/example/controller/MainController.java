package org.example.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MainController {

    @Qualifier("eurekaClient")
    @Autowired
    EurekaClient eurekaClient;
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @ResponseBody
    @GetMapping("test")
    public String test(){
        return "";
    }
    @ResponseBody
    @GetMapping("getService")
    public Object getService(){
        return discoveryClient.getServices();
    }

    @ResponseBody
    @GetMapping("getInstances")
    public Object getInstances(){
        return discoveryClient.getInstances("provider");
    }

    @ResponseBody
    @GetMapping("exc")
    public Object exc(){
        // Ribbon 客户端 负载均衡 过滤了状态为down的节点
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider");


        String url = serviceInstance.getUri()+ "/hi?name=ssaa";
        System.out.println(serviceInstance.getUri());
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, String.class);
    }
}
