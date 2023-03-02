package com.cjc.DaoI;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cjc.model.ViewEmi;
@Repository
public interface DaoiEmi extends CrudRepository<ViewEmi, Integer> {

	

	ViewEmi findAllBycustomerId(int customerId);
	
@Query(value="SELECT * FROM enquiry.view_emi v where v.num=:num1 and v.customer_id=:customerId and v.emiid=:emiid",nativeQuery = true)
	void findBynum(@Param("num1")int num1,@Param("customerId")int customerId,@Param("emiid") int emiid);

ViewEmi findAllByemiid(int emiid);

@Query(value="select distinct customer_id FROM enquiry.view_emi v",nativeQuery = true)
List<Integer> selectdistint();

@Query(value="SELECT  COUNT(*)  FROM view_emi v WHERE v.customer_id=?1 and v.status=?2 ",nativeQuery = true)
int getcountstatus(Integer n, String status);



}
