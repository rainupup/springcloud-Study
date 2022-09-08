package cn.rainupup;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain02 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain02.class,args);
    }
}