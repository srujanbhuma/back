package com.gsr.patientMicro.model;
//
//public class Patient {
//
//}
//


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//@Data
@Entity
@Table(name="patientdetails")


public class Patient {
	// to make this column as primary key for our employees table
	@Id 
	// for auto generation of employee id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 

	private long patientid;
	@Column(name="pname")
	private String pName;
	
	
	
	@Column(name="email")
	private String email; 
	
	@Column(name="problem")
	private String problem; 
	
	 public Patient(){
		
	}

	public Patient(long patientid, String pName,  String email, String problem) {
		super();
		this.patientid = patientid;
		this.pName = pName;
		//this.lastName = lastName;
		this.email = email;
		this.problem = problem;
	    
	}

	public long getpatientId() {
		return patientid;
	}

	public void setpatientId(long patientid) {
		this.patientid = patientid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

//	public String getLastName() {
//		return lastName;
//	}

//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getProblem() {
		return problem;
	}
	
	public void setProblem(String problem) {
		this.problem = problem;
	}
	
	

	@Override
	public String toString() {
		return "Employee [patientid=" + patientid + ", pName=" + pName + ",  email=" + email + ",problem =" + problem + "]";
	}
	
	

}
