package com.cg.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.cg.dto.PatientDTO;

@FeignClient(name = "PatientServices", url = "${DOCTOR_SERVICE:http://localhost:9091}")
public interface PatientFeignClient {
 
    // GET method to fetch doctor by ID
    //@GetMapping("/test/patients")
     @GetMapping("/test/patients/{id}")
     PatientDTO getPatientById(@PathVariable int id);
}