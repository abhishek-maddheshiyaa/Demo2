package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="PatientTable")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paitent {
	
	

	@Id
	@NotNull(message = "Id of paitent cannot be null")
    private int pid;
	
	@NotBlank(message = "Name of paitent cannot be blank")
    private String pname;
	
	@NotNull(message = "Phone no cannot be null")
	
    private long pphnno;
	
	@NotBlank(message = "address cannot be blank")
    private String paddress;


}
