package com.cjc.model;

public class CustomerError {
	private int errorcode;
	private String customermessage;
	public CustomerError(int errorcode, String customermessage) {
		super();
		this.errorcode = errorcode;
		this.customermessage = customermessage;
	}
	public CustomerError() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getcustomermessage() {
		return customermessage;
	}
	public void setcustomermessage(String customermessage) {
		this.customermessage = customermessage;
	}
	

}
