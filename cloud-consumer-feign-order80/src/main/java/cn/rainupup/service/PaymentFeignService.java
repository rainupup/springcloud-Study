package cn.rainupup.service;


import cn.rainupup.emtities.CommonResult;
import cn.rainupup.emtities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")   //指定服务提供者在Eureka中的名字
public interface PaymentFeignService {
    @PostMapping("/payment/create")          //访问的是服务提供者的/payment/create
    public CommonResult<Payment> create(@RequestBody Payment payment);

    @GetMapping("/payment/get/{id}")                  //访问的是服务提供者的/payment/get/{id}
    public CommonResult<Payment> selectOneaa(@PathVariable("id") Long id);
    @GetMapping("/payment/timeout")
    public String paymentFeignTimeout();
/*    @PostMapping("create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int i = this.paymentService.create(payment);

        return new CommonResult<>(200, "insert success， serverPort：" + serverPort, i);
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);

        return new CommonResult<Payment>(200, "select success， serverPort：" + serverPort, payment);
    }*/
}
