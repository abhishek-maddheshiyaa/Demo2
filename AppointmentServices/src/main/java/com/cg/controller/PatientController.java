package com.cg.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.cg.dto.PatientDTO;
import com.cg.entity.Appointment;
import com.cg.service.IPatientService;



@RequestMapping("/test")
@RestController //combines @controller and @responsebody
public class PatientController {
	
	@Autowired
	IPatientService patientService;
	
//	@GetMapping("/patients")
//	   public List<Patient> getAllPatientsData() {
//		   return PatientService.findAllPatientsData();
//	   }
	
	@GetMapping("/patients")
    public List<PatientDTO> getAllPatientsData() {
        return patientService.findAllPatientsData()
                            .stream()
                            .map(PatientDTO::fromEntity)  // Convert to ProductDTO
                            .collect(Collectors.toList());
    }
	
	@GetMapping(path = "/patients/{id}")
 	public Optional<Appointment> getByProductId(@PathVariable int id)
 	{
 		return patientService.findPatientDataById(id);
 	}
	
	
	
//	@PostMapping("/patients")
//	public Patient createMyProduct(@RequestBody Patient p)
//	{
//		System.out.println("Patient data: "+p);
//		return PatientService.createPatientData(p);
//	}
	
	
	@PostMapping("/patients")
	public PatientDTO createProduct(@Validated @RequestBody PatientDTO patientDTO)
	{
				Appointment patient = patientDTO.toEntity();  // Convert DTO to Entity
				Appointment createdPatient = patientService.createPatientData(patient);
		        return PatientDTO.fromEntity(createdPatient);  // Return as DTO
	}
	
	@DeleteMapping(path = "/patient/{id}")
 	public String deleteByProductId(@PathVariable int id)
 	{
 		return patientService.deletePatientData(id);
 	}
	
	@PutMapping(path = "/patient")
	public String updatePatientById(@RequestBody Appointment p)
	{
		int id= p.getPid();
		return patientService.updatePatientData(id, p);
	}

}
