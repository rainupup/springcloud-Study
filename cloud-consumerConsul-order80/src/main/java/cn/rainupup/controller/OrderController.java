package cn.rainupup.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {
    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/consul")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }

}
