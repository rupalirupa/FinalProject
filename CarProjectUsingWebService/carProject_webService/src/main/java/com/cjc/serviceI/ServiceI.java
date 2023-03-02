package com.cjc.serviceI;

import java.util.List;

import javax.swing.text.Document;

import com.cjc.exception.CustomerServiceException;
import com.cjc.model.Customer;
import com.cjc.model.CustomerDocuments;
import com.cjc.model.Enquiry;
import com.cjc.model.Ledger;
import com.cjc.model.LoanDisbursement;
import com.cjc.model.Sanction;
import com.cjc.model.ViewEmi;

public interface ServiceI  {
	
	
	
	public Customer savecostmer(Customer c);

	List<Customer> getAllData();

	void saveData(Customer s2);

	void updateData(Customer s2);

	void deleteData(int customerId);

	Customer getSingleData(int customerId) throws CustomerServiceException;
	public List<Customer>getByStatus( String status);
	
	
//	public boolean changeStatus(Integer id);
//	public boolean changeStatusFailed(Integer id);
	public void saveDoc(CustomerDocuments d);
    
	//List<CustomerDocuments> saveData1(CustomerDocuments d);

//	Enquiry getSingleData1(String username, String password);
//
//	List<Enquiry> getSingleDatabystaff(String stafftype);
	
	

void saveData2(Sanction s);

	Customer getSingleData2(int customerId);


//
	List<Ledger> getTheListLedger();
//
	Customer getcustomerbyledgerId(Ledger l);

	public LoanDisbursement saveLoandisbursement(LoanDisbursement l);

	public Ledger saveledger(Ledger l);

	public List<Customer> getdatabydefaulter();

	public Sanction getData2(int sanctionId);

	public LoanDisbursement getLoandisbursement(int agreementId);

	public Customer getCustomerbyCustomerId(int customerId);

	public void saveEmi(ViewEmi v);

	public List<ViewEmi> getemidata(int customerId);

	public ViewEmi saveemibynum(int emiid);

	public List<ViewEmi> getallviewdata();

	public ViewEmi getDatabyCustomerId(int customerId);

	public List<Integer> selectdistinctemp();

	public Integer getcountofstatus(Integer n,String status);

	public List<ViewEmi> getDatabyCustomerId1(int customerId);

	public void saveemibynum2(int emiid, String agreementDate);
	

	
	public CustomerDocuments getCustomerDocuments(Integer customerId);
	public boolean changeStatus(Integer customerId);
	
	
}
