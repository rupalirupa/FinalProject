package com.cjc.model;

public class EnquiryError {
	private int errorcode;
	private String enquirymessage;
	public EnquiryError(int errorcode, String enquirymessage) {
		super();
		this.errorcode = errorcode;
		this.enquirymessage = enquirymessage;
	}
	public EnquiryError() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getenquirymessage() {
		return enquirymessage;
	}
	public void setenquirymessage(String enquirymessage) {
		this.enquirymessage = enquirymessage;
	}
	

}
