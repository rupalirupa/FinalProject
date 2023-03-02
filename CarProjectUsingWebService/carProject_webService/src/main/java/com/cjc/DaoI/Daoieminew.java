package com.cjc.DaoI;

import java.util.List;

import org.aspectj.weaver.tools.Trace;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.ViewEmi;
@Repository
public interface Daoieminew extends CrudRepository<ViewEmi, Integer>{
@Query(value="select * from view_emi v where v.customer_id=?1",nativeQuery = true)
	List<ViewEmi> findAllBycustomerId(int customerId);

@Query(value="select * from view_emi v where v.customer_id=?1 and v.agreementDate=?2",nativeQuery = true)
ViewEmi findAllByIdandDate(int emiid, String agreementDate);

}
