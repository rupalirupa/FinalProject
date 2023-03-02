package com.cjc.DaoI;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.Customer;
import com.cjc.model.CustomerDocuments;
import com.cjc.model.Ledger;
@Repository
public interface DaoI extends CrudRepository<Customer, Integer>{

	Customer findAllBycustomerId(int customerId);
	//void saveAllById(int fid);

	//Customer findAllByledger(int l1);

	Customer findAllByledger(Ledger l);
//
//	

//	Enquiry findAllByUsernameAndPassword(String username, String password);
//
//	List<Enquiry> findAllByStafftype(String stafftype);

	public List<Customer> findByStatus( String status);
	
@Query(value="select * from enquiry.customer,enquiry.ledger where defaulter_count>3 and enquiry.customer.ledger_ledger_id=enquiry.ledger.ledger_id",nativeQuery = true)
	List<Customer> findcustomerwithdefaulter();

Customer findBycustomerId(int customerId);

///Customer findAllByledgerId(int ledgerId);
}
