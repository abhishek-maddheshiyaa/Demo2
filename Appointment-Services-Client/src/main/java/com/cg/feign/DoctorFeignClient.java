package com.cg.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.dto.DoctorDTO;


@FeignClient(name = "DoctorServices", url = "${DOCTOR_SERVICE:http://localhost:9090}", fallback=DoctorFeignClientFallback.class)
public interface DoctorFeignClient {
 
    // GET method to fetch doctor by ID
    //@GetMapping("/doc/doctors")
     @GetMapping("doc/doctors/{id}")
     DoctorDTO getDoctorById(@PathVariable int id);
}