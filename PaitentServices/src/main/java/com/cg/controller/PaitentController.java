package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Paitent;
import com.cg.service.IPaitentService;



@RequestMapping("/test")
@RestController //combines @controller and @responsebody
public class PaitentController {
	
	@Autowired
	IPaitentService paitentService;
	
	@GetMapping("/paitents")
	   public List<Paitent> getAllPaitentsData() {
		   return paitentService.findAllPaitentsData();
	   }
	
	@GetMapping(path = "/paitents/{id}")
 	public Optional<Paitent> getByProductId(@PathVariable int id)
 	{
 		return paitentService.findPaitentDataById(id);
 	}
	
	@PostMapping("/paitents")
	public Paitent createMyProduct(@RequestBody Paitent p)
	{
		return paitentService.createPaitentData(p);
	}
	
	@DeleteMapping(path = "/paitent/{id}")
 	public String deleteByProductId(@PathVariable int id)
 	{
 		return paitentService.deletePaitentData(id);
 	}
	
	@PutMapping(path = "/paitent")
	public String updatePaitentById(@RequestBody Paitent p)
	{
		int id= p.getPid();
		return paitentService.updatePaitentData(id, p);
	}

}
