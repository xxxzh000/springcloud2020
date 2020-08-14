package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderZKController {

    //服务地址 8004暴露出来的名字
    public static final String INVOK_URL="http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentinfo(){
        String forObject = restTemplate.getForObject(INVOK_URL + "/payment/zookeeper", String.class);
        return  forObject;
    }
}
