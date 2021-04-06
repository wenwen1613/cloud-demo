package org.example.controller;

import org.example.health.HealthStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HealthStatusService healthStatusService;

    @GetMapping("/hi")
    @ResponseBody
    public String hi(@RequestParam String name){

        return "Hi," + name;
    }

    @GetMapping("health")
    public Object health(@RequestParam Boolean status){
        healthStatusService.setStatus(status);
        return healthStatusService.getStatus();
    }
}
