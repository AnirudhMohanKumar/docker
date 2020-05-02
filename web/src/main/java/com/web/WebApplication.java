package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class WebApplication {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${app.url}")
	private String appUrl;

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
	
	@GetMapping("/")
	public String getFromApp() {
		
		return restTemplate.getForObject(appUrl, String.class);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
