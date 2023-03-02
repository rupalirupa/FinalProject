package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Ledger 
{ 
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ledgerId;	
	private String ledgerCreatedDate;
	private long totalLoanAmount;
	private long payableAmountwithInterest;
	private int tenure;
	private long monthlyEmi;	
	private String amountPaidTillDate;	
	private long remainingAmount;	
	private String nextEmiStartDate;
	private String nextEmiEnddate;
	private int defaulterCount;
	private String previousEmiStatus;
	private String currentMonthEmiStatus;
	private String loanEndDate;
	private String loanStatus;
	
	
}
