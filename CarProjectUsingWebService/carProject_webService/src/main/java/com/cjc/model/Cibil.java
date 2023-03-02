package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Cibil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int cibilId;
private int cibilscore;
private String cibilstatus;
}
