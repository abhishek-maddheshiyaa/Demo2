package com.cg.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

//@Headers("Content-Type: application/json")
//@FeignClient(name = "emp-ws", url = "${feign.url}")
@FeignClient(name = "auth-ws", url = "${PATIENT_SERVICE:http://localhost:1114}")
public interface AuthFeign {
	@GetMapping("/authenticate")
	public boolean getTokenValidity(@RequestHeader("Authorization") String token);
}
