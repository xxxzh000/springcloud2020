package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentinfo_ok(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"\t paymentinfo_ok,id:"+id;
    }
    public String paymentinfo_timeout(){
        int time=3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "paymentinfo_timeout:"+Thread.currentThread().getName()+"\t paymentinfo_timeout,id:";
    }
}
