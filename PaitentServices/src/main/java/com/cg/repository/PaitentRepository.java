package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Paitent;

public interface PaitentRepository extends JpaRepository<Paitent, Integer>{
	

	public List<Paitent> findAllByPname(String name);

}
