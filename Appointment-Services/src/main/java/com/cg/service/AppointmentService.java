package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.AppointmentDTO;
import com.cg.dto.DoctorDTO;
import com.cg.dto.PatientDTO;
import com.cg.entity.Appointment;
import com.cg.feign.DoctorFeignClient;
import com.cg.feign.PatientFeignClient;
import com.cg.repository.AppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService {
	
	@Autowired
	AppointmentRepository appointRepository;
	
	@Autowired DoctorFeignClient dClient;
	
	@Autowired
	PatientFeignClient pClient;
	
	@Override
	public List<Appointment> findAll() {
		// TODO Auto-generated method stub
		return appointRepository.findAll();
	}

	@Override
	public Optional<Appointment> findAppointmentById(int Id) {
		// TODO Auto-generated method stub
		return appointRepository.findById(Id);
	}

	@Override
	public Appointment createAppointment(Appointment a) {
		// TODO Auto-generated method stub
		return appointRepository.save(a);
	}

	@Override
	public boolean deleteAppointment(int id) {
		// TODO Auto-generated method stub
		try {
			appointRepository.deleteById(id);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Appointment update(Appointment a) {
		// TODO Auto-generated method stub
		return appointRepository.save(a);
	}

	@Override
	public AppointmentDTO getAppointmentWithPatientAndDoctor(int apId) {
		// TODO Auto-generated method stub
		
		Appointment appointment=appointRepository.findById(apId).orElseThrow(() -> new RuntimeException("Appointment not found with id " + apId));
		DoctorDTO doctor=dClient.getDoctorById(appointment.getDid());
		PatientDTO patient=pClient.getPatientById(appointment.getPid());
		AppointmentDTO appointmentDTO=new AppointmentDTO();
		appointmentDTO.setAid(appointment.getId());
		appointmentDTO.setDate(appointment.getDate());
		appointmentDTO.setTime(appointment.getTime());
		appointmentDTO.setStatus(appointment.getStatus());
		appointmentDTO.setFees(appointment.getFees());
		appointmentDTO.setIssue(appointment.getIssue());
		appointmentDTO.setDoctor(doctor);
		appointmentDTO.setPatient(patient);
		
		return appointmentDTO;
		
	}

}
