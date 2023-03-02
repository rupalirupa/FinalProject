package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Profession 
{ 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer professionId;
	private String professionType;
	private Double professionSalary;
	private String professionSalaryType;
	private String professionDesignation;
	private String workingFrom;
	
	public Integer getProfessionId() {
		return professionId;
	}
	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}
	public String getProfessionType() {
		return professionType;
	}
	public void setProfessionType(String professionType) {
		this.professionType = professionType;
	}
	public Double getProfessionSalary() {
		return professionSalary;
	}
	public void setProfessionSalary(Double professionSalary) {
		this.professionSalary = professionSalary;
	}
	public String getProfessionSalaryType() {
		return professionSalaryType;
	}
	public void setProfessionSalaryType(String professionSalaryType) {
		this.professionSalaryType = professionSalaryType;
	}
	public String getProfessionDesignation() {
		return professionDesignation;
	}
	public void setProfessionDesignation(String professionDesignation) {
		this.professionDesignation = professionDesignation;
	}
	public String getWorkingFrom() {
		return workingFrom;
	}
	public void setWorkingFrom(String workingFrom) {
		this.workingFrom = workingFrom;
	}
	
	public Profession(Integer professionId, String professionType, Double professionSalary, String professionSalaryType,
			String professionDesignation, String workingFrom)
	{
		super();
		this.professionId = professionId;
		this.professionType = professionType;
		this.professionSalary = professionSalary;
		this.professionSalaryType = professionSalaryType;
		this.professionDesignation = professionDesignation;
		this.workingFrom = workingFrom;
	}
	
	public Profession() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}