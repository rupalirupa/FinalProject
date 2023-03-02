package com.cjc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Customer 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private Integer customerId;
	private String customerName;
	private String customerDateOfBirth;
	private Integer customerAge;
	private String customerGender;
	private String customerEmail;
	private String status;
	private Integer requiredAmount;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Enquiry enquirydetails;
	
	@OneToOne(cascade =CascadeType.ALL)
	private Address address;
	
	@OneToOne(cascade =CascadeType.ALL)
	private AccountDetail accountdetails;
	
	@OneToOne(cascade =CascadeType.ALL)
	private Profession profession;
	
	@OneToOne(cascade =CascadeType.ALL)
	private CarInfo carinfo;

	
	@OneToOne(cascade =CascadeType.ALL)
	private GuarantorDetails gurantordetails;
	
	@OneToOne(cascade =CascadeType.ALL)
	private Ledger ledger;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Sanction sanctiondetails;
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDisbursement loanDisbursementDetails;
	
	
	
}
