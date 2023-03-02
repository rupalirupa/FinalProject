package com.cjc.DaoI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.Sanction;
@Repository
public interface DaoiSanction extends CrudRepository<Sanction, Integer>{

	Sanction findAllBysanctionId(int sanctionId);

	

}
