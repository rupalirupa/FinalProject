package com.cjc.DaoI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.Customer;
import com.cjc.model.Ledger;

@Repository
public interface DaoiLedger extends CrudRepository<Ledger, Integer>{

	//Customer findAllByledgerId(int l);

}
