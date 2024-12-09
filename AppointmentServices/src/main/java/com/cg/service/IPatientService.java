package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.Appointment;

public interface IPatientService {
	
	public List<Appointment> findAllPatientsData();
	public Optional<Appointment> findPatientDataById(int pid);
	public Appointment createPatientData(Appointment p);
	public String deletePatientData(int pid);
	public String updatePatientData(int id, Appointment p);
	public List<Appointment> findPatientDataByName(String name);

}
