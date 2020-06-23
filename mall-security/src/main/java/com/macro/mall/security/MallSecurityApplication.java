package com.macro.mall.security;

//import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@NacosPropertySource(dataId = "security", autoRefreshed = true)
@EnableDubbo
public class MallSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSecurityApplication.class, args);
    }

}
