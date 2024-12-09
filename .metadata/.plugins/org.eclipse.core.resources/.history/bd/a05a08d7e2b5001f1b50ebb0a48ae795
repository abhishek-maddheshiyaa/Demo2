package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Patient;
import com.cg.repository.PatientRepository;

@Service
public class PatientService implements IPatientService {
	
	@Autowired
	PatientRepository patientrepo;
	
	
	
	public List<Patient> findAllPatientsData() {
		return patientrepo.findAll();
		
	}
	
	public Optional<Patient> findPatientDataById(int pid) {
		return patientrepo.findById(pid);
	}
   
	public Patient createPatientData(Patient p) {
		
		return patientrepo.save(p);
		
	}
	
	public String deletePatientData(int pid) {
	    if (patientrepo.existsById(pid)) {
	    	patientrepo.deleteById(pid);
	         return "Patient Data deleted";
	    } else {
	    	 return "Patient Id not found";
	    }
	}
	
	public String updatePatientData(int id, Patient p) {
	    if (patientrepo.existsById(id)) {
	    	Patient p1 = new Patient(); 
	        p1.setPid(p.getPid());
	        p1.setPname(p.getPname());
	        p1.setPphnno(p.getPphnno());
	        p1.setPaddress(p.getPaddress());
	      
	        patientrepo.save(p); 
	        return "Patient Data updated successfully";
	    } else {
	        return "Patient Data not found";
	    }
	}
	
	
	public List<Patient> findPatientDataByName(String name){
		return patientrepo.findAllByPname(name);
		
	}

}
