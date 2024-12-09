package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Appointment;

public interface PatientRepository extends JpaRepository<Appointment, Integer>{
	

	public List<Appointment> findAllByPname(String name);

}
