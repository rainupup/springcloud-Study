package cn.rainupup.controller;


import cn.rainupup.service.PaymentFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//@DefaultProperties(defaultFallback = "GlobalFallbackMethod")
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class PaymentFeignHystrixController {
    @Resource
    PaymentFeignHystrixService service;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
/*        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        return service.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return service.paymentInfo_TimeOut(id);
    }
    private String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "服务消费者服务降级,请稍后重试";
    }
    public String GlobalFallbackMethod(){
        return "全局服务降价";
    }
    // 下面是全局fallback方法
//    public String payment_Global_FallbackMethod()
//    {
//        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
//    }
}
