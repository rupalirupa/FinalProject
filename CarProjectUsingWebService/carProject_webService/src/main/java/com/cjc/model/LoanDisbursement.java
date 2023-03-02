package com.cjc.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class LoanDisbursement {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int agreementId;
	private int loanNo;
	private String agreementDate;
	private String amountPayType;
	private long totalAmount;
	private String bankName;
	private long accountNumber;
	private String IFSCCode;
	private String accountType;
	private long transferAmount;
	private String paymentStatus;
	private String amountPaidDate;

}
