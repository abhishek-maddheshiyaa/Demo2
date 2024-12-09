package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Appointment;
import com.cg.repository.PatientRepository;

@Service
public class PatientService implements IPatientService {
	
	@Autowired
	PatientRepository patientrepo;
	
	
	
	public List<Appointment> findAllPatientsData() {
		return patientrepo.findAll();
		
	}
	
	public Optional<Appointment> findPatientDataById(int pid) {
		return patientrepo.findById(pid);
	}
   
	public Appointment createPatientData(Appointment p) {
		
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
	
	public String updatePatientData(int id, Appointment p) {
	    if (patientrepo.existsById(id)) {
	    	Appointment p1 = new Appointment(); 
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
	
	
	public List<Appointment> findPatientDataByName(String name){
		return patientrepo.findAllByPname(name);
		
	}

}
