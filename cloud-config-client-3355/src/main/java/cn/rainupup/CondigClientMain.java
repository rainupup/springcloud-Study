package cn.rainupup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CondigClientMain {
    public static void main(String[] args) {
        SpringApplication.run(CondigClientMain.class,args);
    }
}