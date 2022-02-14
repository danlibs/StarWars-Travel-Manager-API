package com.danlibs.StarWarsTravelManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StarWarsTravelManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarWarsTravelManagerApplication.class, args);
	}

}
