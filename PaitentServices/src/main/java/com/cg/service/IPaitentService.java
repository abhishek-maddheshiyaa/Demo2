package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.Paitent;

public interface IPaitentService {
	
	public List<Paitent> findAllPaitentsData();
	public Optional<Paitent> findPaitentDataById(int pid);
	public Paitent createPaitentData(Paitent p);
	public String deletePaitentData(int pid);
	public String updatePaitentData(int id, Paitent p);
	public List<Paitent> findPaitentDataByName(String name);

}
