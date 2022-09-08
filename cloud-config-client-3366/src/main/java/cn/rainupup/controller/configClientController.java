package cn.rainupup.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope      //开启动态刷新
public class configClientController {

    @Value("${config.info}")
    private String info;

    @Value("${server.port}")
    private String port;
    @GetMapping("/get")
    public String getInfo(){
        return info + " 端口：" + port;
    }
}
