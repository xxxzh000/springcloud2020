package com.atguigu.mtrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.nio.cs.ext.IBM037;

@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return  new RandomRule();
    }
}
