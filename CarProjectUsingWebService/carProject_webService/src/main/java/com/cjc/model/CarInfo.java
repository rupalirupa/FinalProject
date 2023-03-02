package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CarInfo 
{					 
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer carId;
	private Integer carModelNo;
	private String carName;
	private String brandName;
	private Double carPrice;
	private String colour;
	
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public Integer getCarModelNo() {
		return carModelNo;
	}
	public void setCarModelNo(Integer carModelNo) {
		this.carModelNo = carModelNo;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public CarInfo(Integer carId, Integer carModelNo, String carName, String brandName, Double carPrice,
			String colour) 
	{
		super();
		this.carId = carId;
		this.carModelNo = carModelNo;
		this.carName = carName;
		this.brandName = brandName;
		this.carPrice = carPrice;
		this.colour = colour;
	}
	
	public CarInfo() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
}