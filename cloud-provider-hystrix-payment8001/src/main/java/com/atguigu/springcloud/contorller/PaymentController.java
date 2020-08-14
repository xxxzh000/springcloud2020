package com.atguigu.springcloud.contorller;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {


    @Autowired
    private PaymentService paymentService;
    @GetMapping("/payment/hystrix/{id}")
    public String paymentinfo_ok(@PathVariable("id") Integer id){
        return  paymentService.paymentinfo_ok(id);
    }
    @GetMapping("/payment/hystrix")
    public String paymentinfo_timeout(){
        return paymentService.paymentinfo_timeout();
    }
}
