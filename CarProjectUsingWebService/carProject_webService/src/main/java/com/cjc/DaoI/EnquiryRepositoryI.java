package com.cjc.DaoI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.Enquiry;




@Repository
public interface EnquiryRepositoryI extends CrudRepository<Enquiry, Integer>
{
  Enquiry findByCid(int cid);
}
