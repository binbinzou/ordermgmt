package com.wifishared.ordermgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients(basePackages = {"com.wifishared.ordermgmt.client"})
@EnableHystrix
@ComponentScan(basePackages = "com.wifishared")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
