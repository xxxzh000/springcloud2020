package com.atguigu.springcloud.controlle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
public class PaymnetController {

    @Value("${server.port}")
    private String serverport;

    @GetMapping("/payment/consul")
    public String paymentInfo(){
        return "springcloud with consul"+serverport+"\t\t"+ UUID.randomUUID().toString();
    }
}
