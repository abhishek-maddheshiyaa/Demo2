package com.cg.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.DoctorDTO;
import com.cg.model.Doctor;
import com.cg.service.IDoctorService;





@RequestMapping("/doc")
@RestController
public class DoctorController {
	
	@Autowired
	IDoctorService doctorService;
	
	private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	@GetMapping("/hello")
	public String getD()
	{
		return "Hello Doctor";
	}
	
//	@GetMapping("/doctors")
//	public List<Doctor> getDoctors()
//	{
//		return doctorService.findAllDoctors();
//	}
	
	@GetMapping("/doctors")
    public List<DoctorDTO> getDoctors() {
		logger.info("Here is your doctors: ");
        return doctorService.findAllDoctors()
                            .stream()
                            .map(DoctorDTO::fromEntity)  // Convert to ProductDTO
                            .collect(Collectors.toList());
    }
	
	@GetMapping(path = "/doctors/{id}")       
 	public Optional<Doctor> getDoctorById(@PathVariable int id)
 	{
		logger.info("Here is your doctors: with id ", id);
 		return doctorService.findDoctorById(id);
 	}
	
//	@GetMapping(path = "/doctors/{id}")
//	public List<DoctorDTO> getDoctorById(@PathVariable int id)
//	{
//		return doctorService.findDoctorById(id)
//                .stream()
//                .map(DoctorDTO::fromEntity)  
//                .collect(Collectors.toList());
//	}
	
//	@PostMapping("/doctors")
//	public Doctor createMyDoctor(@RequestBody Doctor d)
//	{
//		return doctorService.createDoctor(d);
//	}
	
	
	@PostMapping("/doctors")
	public DoctorDTO createDoctor(@Validated @RequestBody DoctorDTO doctorDTO)
	{
				Doctor doctor = doctorDTO.toEntity();  // Convert DTO to Entity
				Doctor createdProduct = doctorService.createDoctor(doctor);
		        return DoctorDTO.fromEntity(createdProduct);  // Return as DTO
	}
	
	
	
	@DeleteMapping(path = "/doctors/{id}")
 	public Optional<Doctor> deleteByDoctorId(@PathVariable int id)
 	{
 		return doctorService.deleteDoctor(id);
 	}
	
	@PutMapping(path = "/doctors")
	public String updateDocterById(@RequestBody Doctor d)
	{
		int id= d.getId();
		
		return doctorService.updateDoctor(d, id);
	}
	
	@GetMapping(path = "/doctors/name/{name}")
	public List<Doctor> getByDoctorName(@PathVariable String name)
 	{
 		return doctorService.findDoctorByName(name);
 	}
	
	@GetMapping(path = "/doctors/countbyname/{name}")
 	public int findcountByDoctorName(@PathVariable String name)
 	{
		logger.info("Counting doctors by name: ",doctorService.getCountBydoctorName(name));
		System.out.println("no of doctors: "+doctorService.getCountBydoctorName(name));
 		return doctorService.getCountBydoctorName(name);
 	}
}
