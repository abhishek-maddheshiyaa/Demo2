package com.cg.dto;

import com.cg.entity.Appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PatientDTO {
	
	    private int pid;
	    private String pname;
	    private int pphnno;
	    private String paddress;

		
		// to convert product Entity to DTO obj
			public static PatientDTO fromEntity(Appointment patient)
			{
				return new PatientDTO(patient.getPid(),patient.getPname(),patient.getPphnno(),patient.getPaddress());
			}
			// to convert product to DTO
			public Appointment toEntity()    
			{
				return new Appointment(this.pid,this.pname,this.pphnno,this.paddress); 
			}


}
