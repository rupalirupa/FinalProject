package com.cjc.DaoI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.CustomerDocuments;

@Repository
public interface DaoIDoc extends JpaRepository<CustomerDocuments,Integer> {
	CustomerDocuments findByCustomerId (Integer customerId);
}
