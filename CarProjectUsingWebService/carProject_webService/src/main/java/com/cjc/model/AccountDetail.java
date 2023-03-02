package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class AccountDetail 
{
	 @GeneratedValue(strategy = GenerationType.AUTO)
    @Id   
	private Integer accountId;
	private String accountHolderName;
	private Long accountNumber;
	

}