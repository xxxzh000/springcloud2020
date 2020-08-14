package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PayMentController {
    @Autowired
    private PayMentService payMentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int id = payMentService.create(payment);
        if (id > 0) {
            log.info("****Payment创建成功:" + id);
            return new CommonResult(200, "插入数据成功,服务端口号是:" + serverPort, id);
        } else {
            return new CommonResult(444, "插入数据失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id) {
        Payment payment = payMentService.getPaymentById(id);
        if (payment != null) {
            log.info("****Payment数据查询成功:" + id);
            return new CommonResult(200, "数据查询成功,服务端口号是:" + serverPort, payment);
        } else {
            return new CommonResult(444, "数据查询失败");
        }
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String el : services) {
            System.out.println("services:"+el);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance in:instances
             ) {
            System.out.println(in.getServiceId()+"\t"+in.getHost()+"\t"+in.getPort()+"\t"+in.getUri());
        }
        return  this.discoveryClient;
    }

    @GetMapping(value = "/payment/test")
    public String test() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  serverPort;
    }
}
