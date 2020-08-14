package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

public interface PayMentService {
    int create(Payment payment);

    Payment getPaymentById(Integer id);
}
