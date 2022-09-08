package cn.rainupup.controller;


import cn.rainupup.emtities.CommonResult;
import cn.rainupup.emtities.Payment;
import cn.rainupup.service.PaymentFeignService;
import org.apache.tomcat.util.descriptor.web.MessageDestinationRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {
    @Resource
    PaymentFeignService service;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return service.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return service.selectOneaa(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String paymentFeignTimeout(){
        return service.paymentFeignTimeout();
    }
}
