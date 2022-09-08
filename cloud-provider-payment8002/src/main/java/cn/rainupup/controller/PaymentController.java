package cn.rainupup.controller;


import cn.rainupup.service.PaymentService;
import cn.rainupup.emtities.CommonResult;
import cn.rainupup.emtities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

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
}
