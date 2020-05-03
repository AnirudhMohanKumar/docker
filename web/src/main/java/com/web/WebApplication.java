package com.web;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@RestController
public class WebApplication {
	
	@Autowired
	private WebService service;
	
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
	
	@GetMapping("/")
	public String getFromApp() throws UnknownHostException {
		
		return service.getFromApp() + " # " + InetAddress.getLocalHost().getHostName();
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
