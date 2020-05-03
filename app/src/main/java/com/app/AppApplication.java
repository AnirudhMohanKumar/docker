package com.app;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@GetMapping("/")
	public String getApp() throws UnknownHostException {
		
		return "App says \"Hello!\" to you. # " + InetAddress.getLocalHost().getHostName();
	}
	
	@GetMapping("/health")
	public String getFromApp() {
		
		return "App says \"Hello!\" to web and to you.";
	}
}
