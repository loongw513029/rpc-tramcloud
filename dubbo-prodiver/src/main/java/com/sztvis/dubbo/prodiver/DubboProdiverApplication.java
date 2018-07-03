package com.sztvis.dubbo.prodiver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.sztvis.domain.domain")
@MapperScan(basePackages = "com.sztvis.dubbo.prodiver.mapper")
public class DubboProdiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboProdiverApplication.class, args);
	}
}
