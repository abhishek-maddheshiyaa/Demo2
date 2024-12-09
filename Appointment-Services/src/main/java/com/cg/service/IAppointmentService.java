package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.dto.AppointmentDTO;
import com.cg.entity.Appointment;

public interface IAppointmentService {
	public List<Appointment> findAll();
	public Optional<Appointment> findAppointmentById(int Id);
	public Appointment createAppointment(Appointment a);
	public boolean deleteAppointment(int id);
	public Appointment update(Appointment a);
	public AppointmentDTO getAppointmentWithPatientAndDoctor(int apId);

}
