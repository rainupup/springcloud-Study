package cn.rainupup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"cn.rainupup.service"})
public class FeignOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderMain.class,args);
    }
}