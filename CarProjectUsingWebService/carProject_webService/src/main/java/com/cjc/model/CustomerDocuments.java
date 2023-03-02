package com.cjc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class CustomerDocuments {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int customerDocumentsId;

private  int customerId;;
@Lob
private byte[] profilePhoto;
@Lob
private byte[] signature;
@Lob
private byte[] pancard;
@Lob
private byte[] bankcheque;
@Lob
private byte[] salaryslip;
@Lob
private byte[] bankStatement;
@Lob
private byte[] addressProof;

}
