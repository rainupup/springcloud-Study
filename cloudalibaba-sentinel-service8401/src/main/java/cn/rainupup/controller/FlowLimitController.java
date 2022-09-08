package cn.rainupup.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }
    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info(Thread.currentThread().getName()+"\t"+"...testD");
        return "------testD";
    }

    @GetMapping("/testE")
    @SentinelResource(value = "testEError",blockHandler = "testEError")
    public String testE() {
        int i = 10 / 0;
        log.info(Thread.currentThread().getName()+"\t"+"...testD");
        return "------testE";
    }
    @GetMapping("/testF")
    @SentinelResource(value = "testF")
    public String testF(String p1,String p2) {
        log.info(Thread.currentThread().getName()+"\t"+"...testF");
        return "------testF";
    }

    @GetMapping("/testG")
//    @SentinelResource(value = "testG",blockHandlerClass = testBlockHandler.class,
//            blockHandler = "testBlock")
    @SentinelResource(value = "testG",
            blockHandlerClass = testBlockHandler.class,//<-------- 自定义限流处理类
            blockHandler = "testBlock1")//<-----------
    public String testG() {
        log.info(Thread.currentThread().getName()+"\t"+"...testG");
        return "------testG";
    }


    @RequestMapping("/testZ/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback",exceptionsToIgnore = {IllegalArgumentException.class}) //fallback只负责业务异常
    public String fallback(@PathVariable Long id) {
        if (id == 337) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }
        return "ZZZZZZZ";
    }

    //本例是fallback
    public String handlerFallback(@PathVariable Long id, Throwable e) {
        return "错误";
    }
//    public String testBlock(BlockException ex){
//        ex.printStackTrace();
//        return "访问失败 :(,请稍后再试";
//    }
//
//    public String testFallBack(String p1, String p2){
//        return "内部发生异常";
//    }
}
