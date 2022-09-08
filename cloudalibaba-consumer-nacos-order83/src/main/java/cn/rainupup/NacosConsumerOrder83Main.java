package cn.rainupup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerOrder83Main {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerOrder83Main.class,args);
    }
}