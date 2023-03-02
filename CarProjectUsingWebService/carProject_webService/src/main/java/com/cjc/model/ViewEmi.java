package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ViewEmi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int emiid;
	
	private int num;
private int customerId;
private String agreementDate;
private long loanAmtSanctioned;

private int rateOfInterest;
private int loanTenure;
private int monthlyEmiAmount;
	private String status;

}
