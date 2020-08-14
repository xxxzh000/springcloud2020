package com.atguigu.springcloud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/{id}")
    String paymentinfo_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix")
    String paymentinfo_timeout();

}
