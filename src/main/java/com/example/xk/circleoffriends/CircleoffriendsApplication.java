package com.example.xk.circleoffriends;

import com.example.xk.circleoffriends.common.BaseMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.example.xk.circleoffriends.mapper", markerInterface = BaseMapper.class)
@SpringBootApplication
public class CircleoffriendsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircleoffriendsApplication.class, args);

    }
}
