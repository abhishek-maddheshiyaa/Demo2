package com.cg.feign;

import org.springframework.stereotype.Component;

import com.cg.dto.DoctorDTO;

@Component
public class DoctorFeignClientFallback implements DoctorFeignClient {
 
	@Override
	public DoctorDTO getDoctorById(int id) {
       DoctorDTO doctorDTO=new DoctorDTO();
       doctorDTO.setId(1);
       doctorDTO.setDoctorName("Anu");
       doctorDTO.setQualification("MD");
       return doctorDTO;
	}
}
