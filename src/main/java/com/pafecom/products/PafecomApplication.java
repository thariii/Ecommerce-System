package com.pafecom.products;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@EnableAutoConfiguration
@ComponentScan ({"controller","service"})
@SpringBootApplication
public class PafecomApplication {

	public static void main(String[] args) {
		SpringApplication.run(PafecomApplication.class, args);
	}

}
