package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.AppointmentDTO;
import com.cg.dto.DoctorDTO;
import com.cg.dto.PatientDTO;
import com.cg.entity.Appointment;
import com.cg.feign.DoctorFeignClient;
import com.cg.feign.PatientFeignClient;
import com.cg.service.IAppointmentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
@RestController
@RequestMapping("/api")
public class AppointmentController {
	@Autowired
	IAppointmentService appointmentService;
	
	@GetMapping("/appointment")
	public List<Appointment> getAllAppointment(Appointment o)
	{
		return appointmentService.findAll();
	}
	
//	feignClient doctor
	
	@Autowired
	DoctorFeignClient dClient;      //http://localhost:9093/api/doctors/1
//	@GetMapping(path="/doctors/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
//	public DoctorDTO getDoctors(@PathVariable int id)
//	{
//		return dClient.getDoctorById(id);
//	}

	
//    feignClient patient
	
	@Autowired
	PatientFeignClient pClient;          //http://localhost:9093/api/patients/4
	
	@GetMapping(path="/patients/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public PatientDTO getPatients(@PathVariable int id)
	{
		return pClient.getPatientById(id);
	}
	
//	@GetMapping("/find/{id}")
//	public Optional<Appointment> findAppointmentById(@PathVariable int id)
//	{
//		return appointmentService.findAppointmentById(id);
//	}
	
	@PostMapping("/appointment")
	public Appointment createAppointment(@RequestBody Appointment a)
	{
		return appointmentService.createAppointment(a);
	}
	
//	@PostMapping("/appointment")
//    public AppointmentDTO createAppointment1(@Validated @RequestBody AppointmentDTO appointmentDTO) {
//		Appointment appointment=appointmentDTO.toEntity();
//        Appointment createAppointment=appointmentService.createAppointment(appointment);
//        return appointmentDTO.fromEntity(createAppointment);
//    }
	
	@DeleteMapping("/appointment/{id}")
	public String delete(@PathVariable int id)
	{
		appointmentService.deleteAppointment(id);
		return "Id is deleted";
	}
	
	@PutMapping("/appointment")
	public Appointment update(@RequestBody Appointment a)
	{
		return appointmentService.update(a);
	}
	
	@GetMapping("/appointment/{id}")
	public AppointmentDTO getAppointment(@PathVariable int id)
	{
		return appointmentService.getAppointmentWithPatientAndDoctor(id);
	}
	
	private static final String DOCTOR_SERVICE = "DoctorService";
//	 private int attempt = 1;
	
	@GetMapping(path="/doctors/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})
	@CircuitBreaker(name = DOCTOR_SERVICE, fallbackMethod = "getDoctorFallback")
    @Retry(name = DOCTOR_SERVICE, fallbackMethod = "getDoctorFallback")
	public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable int id) {
		DoctorDTO doctor=dClient.getDoctorById(id);
	        return ResponseEntity.ok().body(doctor);
    }
	
	public ResponseEntity<DoctorDTO> getDoctorFallback(int id, Throwable throwable) {
		DoctorDTO fallback=dClient.getDoctorById(id);
        return ResponseEntity.ok().body(fallback);
    }
}
