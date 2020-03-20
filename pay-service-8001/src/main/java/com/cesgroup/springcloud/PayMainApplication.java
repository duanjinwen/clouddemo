package com.cesgroup.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: Duan.jw
 * @create: 2020/3/16 9:38
 **/
@SpringBootApplication
@MapperScan("com.cesgroup.springcloud.mapper")
public class PayMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayMainApplication.class, args);
    }
}
