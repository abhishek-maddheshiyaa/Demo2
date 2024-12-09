package com.cg.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Appointment_id")
	private int id;
	
	@Column(name="Patient_id")
	private int pid;
	
	@Column(name="Doctor_id")
	private int did;
	
	@Column(name="Time")
	private LocalDateTime time;
	
	@Column(name="Date")
	private LocalDate date;
	
	@Column(name="Issue")
	private String issue;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="Fees")
	private String fees;

	

	
}
