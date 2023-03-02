package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class GuarantorDetails 
{ 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer guarantorId;
	private String guarantorName;
	private Long guarantorMobileNo;
	private String guarantorPermanentAddress;
	
	public Integer getGuarantorId() {
		return guarantorId;
	}
	public void setGuarantorId(Integer guarantorId) {
		this.guarantorId = guarantorId;
	}
	
	public String getGuarantorName() {
		return guarantorName;
	}
	public void setGuarantorName(String guarantorName) {
		this.guarantorName = guarantorName;
	}
	
	public Long getGuarantorMobileNo() {
		return guarantorMobileNo;
	}
	public void setGuarantorMobileNo(Long guarantorMobileNo) {
		this.guarantorMobileNo = guarantorMobileNo;
	}
	
	public String getGuarantorPermanentAddress() {
		return guarantorPermanentAddress;
	}
	public void setGuarantorPermanentAddress(String guarantorPermanentAddress) {
		this.guarantorPermanentAddress = guarantorPermanentAddress;
	}
	public GuarantorDetails(Integer guarantorId, String guarantorName, Long guarantorMobileNo,
			String guarantorPermanentAddress) 
	{
		super();
		this.guarantorId = guarantorId;
		this.guarantorName = guarantorName;
		this.guarantorMobileNo = guarantorMobileNo;
		this.guarantorPermanentAddress = guarantorPermanentAddress;
	}
	
	public GuarantorDetails()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}