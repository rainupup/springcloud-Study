package cn.rainupup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"cn.rainupup.service"})
//@EnableHystrix
public class HystrixOrder {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOrder.class,args);
    }
}