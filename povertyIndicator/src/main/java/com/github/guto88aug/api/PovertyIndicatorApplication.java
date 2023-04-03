package com.github.guto88aug.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PovertyIndicatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PovertyIndicatorApplication.class, args);
	}

}
