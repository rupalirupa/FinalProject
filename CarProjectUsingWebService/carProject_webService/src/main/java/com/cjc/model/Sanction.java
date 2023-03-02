package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Sanction 
{
	@Id   
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sanctionId;
	private String sanctionDate;
	private String applicantName;
	private long contactDetails;
	private long loanAmtSanctioned;
	private String interestType;
	private int rateOfInterest;
	private int loanTenure;
	private int monthlyEmiAmount;
	private String modeOfPayment;
private String	status;

	
}