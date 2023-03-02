package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Address 
{	 	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer permanentAddressId;	
	private String areaname;
	private String cityname;
	private String district;
	private String state;
	private Long pincode;
	
	public Integer getPermanentAddressId() {
		return permanentAddressId;
	}
	public void setPermanentAddressId(Integer permanentAddressId) {
		this.permanentAddressId = permanentAddressId;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	
	public Address(Integer permanentAddressId, String areaname, String cityname, String district, String state,
			Long pincode) 
	{
		super();
		this.permanentAddressId = permanentAddressId;
		this.areaname = areaname;
		this.cityname = cityname;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}
	
	public Address() 
	{
		super();
		// TODO Auto-generated constructor stub
	}	
}