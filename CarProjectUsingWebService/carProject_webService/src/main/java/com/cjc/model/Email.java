package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Email {
	@Id
	@GeneratedValue
	private int id;
	 private String name;
	 private String sender;
	 private String receiver;
	 private String status;
	 
}
