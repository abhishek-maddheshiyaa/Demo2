package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{
	

	public List<Patient> findAllByPname(String name);

}
