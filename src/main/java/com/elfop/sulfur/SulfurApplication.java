package com.elfop.sulfur;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2018/4/9 10:52
 */
@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.elfop.sulfur.**.mapper")
public class SulfurApplication {


    public static void main(String[] args) {
        SpringApplication.run(SulfurApplication.class, args);
    }


}
