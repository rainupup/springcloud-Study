package cn.rainupup.controller;


import cn.rainupup.service.PaymentService;
import cn.rainupup.emtities.CommonResult;
import cn.rainupup.emtities.Payment;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;  //获取端口号

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int i = this.paymentService.create(payment);

        return new CommonResult<>(200, "insert success， serverPort：" + serverPort, i);
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);

        return new CommonResult<Payment>(200, "select success， serverPort：" + serverPort, payment);
    }

    @GetMapping("timeout")
    public String paymentFeignTimeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "服务提供者TimeOut";
    }
//    @GetMapping("discovery")
//    public Object discovery(){
//
//        List<String> services = discoveryClient.getServices();
//        for (String s:services){
//            System.out.println(serverPort);
//        }
//
//        for (ServiceInstance instance : discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE")) {
//            System.out.println(instance.getInstanceId() + "/" + instance.getHost() + "/" + instance.getPort());
//        }
//
//        return discoveryClient;
//    }
    @GetMapping("discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        });

        return this.discoveryClient;
    }
}
