package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.services.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentHystrixController {

    @Autowired

    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/{id}")
    public String paymentinfo_ok(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentinfo_ok(id);
    }

    @GetMapping("/payment/hystrix")
    public String paymentinfo_timeout() {
        return paymentHystrixService.paymentinfo_timeout();
    }
}
