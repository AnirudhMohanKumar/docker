package com.app;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class AppApplication {

	@Value(value = "${spring.application.name}")
	private String appname;
	
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@GetMapping("/")
	public String getApp() throws UnknownHostException {
		
		return "Appname - "+appname;
				//+" . # " + InetAddress.getLocalHost().getHostName();
	}
	
	@GetMapping("/health")
	public String getFromApp() throws UnknownHostException {
		
		return "Appname - "+appname;
				//+" . # " + InetAddress.getLocalHost().getHostName();
	}
}
