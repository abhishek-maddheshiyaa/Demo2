package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Paitent;
import com.cg.repository.PaitentRepository;

@Service
public class PaitentService implements IPaitentService {
	
	@Autowired
	PaitentRepository paitentrepo;
	
	
	
	public List<Paitent> findAllPaitentsData() {
		return paitentrepo.findAll();
		
	}
	
	public Optional<Paitent> findPaitentDataById(int pid) {
		return paitentrepo.findById(pid);
	}
   
	public Paitent createPaitentData(Paitent p) {
		return paitentrepo.save(p);
		
	}
	
	public String deletePaitentData(int pid) {
	    if (paitentrepo.existsById(pid)) {
	    	paitentrepo.deleteById(pid);
	         return "Paitent Data deleted";
	    } else {
	    	 return "Paitent Id not found";
	    }
	}
	
	public String updatePaitentData(int id, Paitent p) {
	    if (paitentrepo.existsById(id)) {
	    	Paitent p1 = new Paitent(); 
	        p1.setPid(p.getPid());
	        p1.setPname(p.getPname());
	        p1.setPphnno(p.getPphnno());
	        p1.setPaddress(p.getPaddress());
	      
	        paitentrepo.save(p); 
	        return "Paitent Data updated successfully";
	    } else {
	        return "Paitent Data not found";
	    }
	}
	
	
	public List<Paitent> findPaitentDataByName(String name){
		return paitentrepo.findAllByPname(name);
		
	}

}
