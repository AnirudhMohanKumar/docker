package com.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "app")
public interface WebService {

	@GetMapping("/health")
	public String getFromApp();
}
