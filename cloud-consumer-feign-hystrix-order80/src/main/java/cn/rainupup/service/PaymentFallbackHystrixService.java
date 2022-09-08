package cn.rainupup.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackHystrixService implements PaymentFeignHystrixService{
    //@Override
    public String paymentInfo_OK(Integer id) {
        return "访问错误，请稍后再试";
    }

    //@Override
    public String paymentInfo_TimeOut(Integer id) {
        return "访问错误，请稍后再试";
    }
}
