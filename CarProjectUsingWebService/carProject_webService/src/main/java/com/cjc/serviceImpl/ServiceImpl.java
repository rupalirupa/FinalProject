package com.cjc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.DaoI.DaoI;
import com.cjc.DaoI.DaoIDoc;
import com.cjc.DaoI.DaoiEmi;
import com.cjc.DaoI.DaoiLedger;
import com.cjc.DaoI.DaoiSanction;
import com.cjc.DaoI.Daoieminew;
import com.cjc.DaoI.DisbursementDaoi;
import com.cjc.DaoI.ReportCommunication;
import com.cjc.exception.CustomerIdNotFoundException;
import com.cjc.exception.CustomerNotFoundException;
import com.cjc.exception.CustomerServiceException;
import com.cjc.model.Customer;
import com.cjc.model.CustomerDocuments;
import com.cjc.model.Email;
import com.cjc.model.Enquiry;
import com.cjc.model.Ledger;
import com.cjc.model.LoanDisbursement;
import com.cjc.model.Sanction;
import com.cjc.model.ViewEmi;
import com.cjc.serviceI.ServiceI;
@Service
public class ServiceImpl implements ServiceI{
@Autowired
DaoI udi;
@Autowired 
DaoIDoc udic;

@Autowired
DaoiLedger udil;
	@Override
	public List<Customer> getAllData() {
		List<Customer> l=(List<Customer>) udi.findAll();
		return l;
	}
	@Override
	public void saveData(Customer s2) {
		udi.save(s2);
		
	}
	@Override
	public void updateData(Customer s2) {
		
		udi.save(s2);
		
	}
	@Override
	public void deleteData(int fid) {
		udi.deleteById(fid);
		
	}
	@Override
	public Customer getSingleData(int customerId) throws CustomerServiceException {
		Customer customer=null;
	try{
		Customer u=udi.findAllBycustomerId(customerId);
		u.getCustomerId();
		return u;
	}
	catch(Exception e) {
		throw new CustomerServiceException("not found");
	}
	
		
	}
//	@Override
//	public Enquiry getSingleData1(String username, String password) {
//		Enquiry u=udi.findAllByUsernameAndPassword(username,password);
//		return u;
//	}
//	@Override
//	public List<Enquiry> getSingleDatabystaff(String stafftype) {
//		List<Enquiry> u=udi.findAllByStafftype(stafftype);
//		return u;
//	}
	
	
	
	
		
		@Autowired
		DaoiSanction udiS;
		@Override
		public void saveData2(Sanction s) {
//			Optional<Customer> cust = udi.findById(sanctionId);
//			Customer Ap = cust.get();
//			
//			Integer id = Ap.getSanctiondetails().getSanctionId();
//			s.setSanctionId(id);
//
//			Ap.setSanctiondetails(s);
//			Ap.setStatus("sanction");
//				udi.save(Ap);
				udiS.save(s);
				
				
			
			
		
		}
		@Override
		public Customer getSingleData2(int customerId) {
			Customer c= udi.findAllBycustomerId(customerId);
			return c;
		}
		@Override
		public List<Ledger> getTheListLedger() {
			List<Ledger> u=(List<Ledger>) udil.findAll();
			return u;
		}
		@Override
		public Customer getcustomerbyledgerId(Ledger l) {
			Customer u=udi.findAllByledger(l);
			return u;
		}
		@Override
		public Customer savecostmer(Customer c) {
			
			return udi.save(c);
		}
@Override
public void saveDoc(CustomerDocuments d) {
	udic.save(d);
}
@Override
public List<Customer> getByStatus(String status) {
	
	return udi.findByStatus(status);
}
@Autowired
DisbursementDaoi udid;
@Override
public LoanDisbursement saveLoandisbursement(LoanDisbursement l) {
	 LoanDisbursement u=udid.save(l);
	return u;
}

@Override
public Ledger saveledger(Ledger l) {
	
	Ledger l1=udil.save(l);
	return l1;
}
@Override
public List<Customer> getdatabydefaulter() {
	List<Customer> l=udi.findcustomerwithdefaulter();
	return l;
}
@Override
public Sanction getData2(int sanctionId) {
	Sanction u=udiS.findAllBysanctionId(sanctionId);
	return u;
}
@Override
public LoanDisbursement getLoandisbursement(int agreementId) {
	LoanDisbursement u=udid.findAllByagreementId(agreementId);
	return u;
}
@Override
public Customer getCustomerbyCustomerId(int customerId) {
	Customer c=udi.findBycustomerId(customerId);
	return c;
}
@Autowired
DaoiEmi udie;
@Override
public void saveEmi(ViewEmi v) {
	udie.save(v);
	
}
@Override
public List<ViewEmi> getemidata(int customerId) {
	List<ViewEmi> u=(List<ViewEmi>) udie.findAllBycustomerId(customerId);
	return u;
}
@Override
public ViewEmi saveemibynum(int emiid) {
	ViewEmi u=udie.findAllByemiid(emiid);
	u.setStatus("paid");
	udie.save(u);
	return u;
	
}
@Override
public List<ViewEmi> getallviewdata() {
	List<ViewEmi> u=(List<ViewEmi>) udie.findAll();
	return u;
}
@Override
public ViewEmi getDatabyCustomerId(int customerId) {
	ViewEmi u=udie.findAllBycustomerId(customerId);
	return u;
}
@Override
public List<Integer> selectdistinctemp() {
	List<Integer> l=udie.selectdistint();
	return l;
}
@Override
public Integer getcountofstatus(Integer n,String status) {
	int s=udie.getcountstatus(n,status);
	return s;
}
@Autowired
Daoieminew udiee;
@Override
public List<ViewEmi> getDatabyCustomerId1(int customerId) {
	List<ViewEmi> u=udiee.findAllBycustomerId(customerId);
	return u;
}
@Override
public void saveemibynum2(int emiid, String agreementDate) {
	ViewEmi u=udiee.findAllByIdandDate(emiid,agreementDate);
	u.setStatus("paid");
}
@Override
public CustomerDocuments getCustomerDocuments(Integer customerId) {
	
	CustomerDocuments findByCustomerId = udic.findByCustomerId(customerId);
	if(findByCustomerId!=null)
	{
		return findByCustomerId;
	}
	else
	{
		throw new CustomerIdNotFoundException("No Such Id's Customer Present");
	}
}
@Override
public boolean changeStatus(Integer customerId) {
	Optional<Customer> cust =udi.findById(customerId);
	if(cust!=null)
	{
		Customer Ap = cust.get();
		

		if(Ap.getStatus().equals("register")) {
			Ap.setStatus("verified");
	
		}
		udi.save(Ap);			
		return true;

	}
	else
	{
		throw new CustomerNotFoundException("Customer Not Found");
	}
	
	

}
	
}
	

		
		

