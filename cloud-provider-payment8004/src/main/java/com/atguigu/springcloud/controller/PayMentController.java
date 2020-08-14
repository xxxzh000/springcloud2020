package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.nio.cs.ext.IBM037;

import java.util.UUID;

@RestController
public class PayMentController {

    @Value("${server.port}")
    private String serverport;

    @GetMapping("/payment/zookeeper")
    public String paymentzk(){
        return "springcloud zookeeper:"+serverport+"----"+ UUID.randomUUID();
    }

}
