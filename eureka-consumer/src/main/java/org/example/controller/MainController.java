package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    DiscoveryClient discoveryClient;

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

}
