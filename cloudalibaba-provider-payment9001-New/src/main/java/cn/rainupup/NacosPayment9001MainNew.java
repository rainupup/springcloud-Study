package cn.rainupup;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosPayment9001MainNew {
    public static void main(String[] args) {
        SpringApplication.run(NacosPayment9001MainNew.class,args);
    }
}