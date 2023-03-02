package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int cid;
	 private String firstName;
	 private String lastName;
	 private String status;
	 private int age;
	 private String email;
	 private int mobileNo;
	 private String pancardNo;
	 private int cibilscore;
	
	 
}
