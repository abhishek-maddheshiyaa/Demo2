package com.cg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Patient_Table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "aid")
	@NotNull(message = "Id of appointment cannot be null")
    private int aid;
	
	@Column(name = "did")
	@NotNull(message = "Id of doctor cannot be null")
    private int did;
	
	@Column(name = "pid")
	@NotNull(message = "Id of patient cannot be null")
    private int pid;
	
	@Column(name = "Patient_Name")
	@NotBlank(message = "Name of patient cannot be blank")
    private String pname;
	
	@NotNull(message = "Phone no cannot be null")
	@Column(name = "Phone_no")
    private int pphnno;
	
	@Column(name = "Address")
	@NotBlank(message = "address cannot be blank")
    private String paddress;

	
	

	

}
