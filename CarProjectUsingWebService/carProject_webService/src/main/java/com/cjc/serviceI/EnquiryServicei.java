package com.cjc.serviceI;

import java.util.List;

import com.cjc.exception.EnquiryServiceException;
import com.cjc.model.Email;
import com.cjc.model.Enquiry;


public interface EnquiryServicei {
public List<Enquiry>saveen(List<Enquiry> e);
public Enquiry saveen(Enquiry e);
public Iterable<Enquiry>getAll() throws EnquiryServiceException;
public void updateEn(Enquiry e);
public Iterable<Enquiry>deleteEn(int cid) throws EnquiryServiceException;
public Enquiry Enquiry(int cid);
public Enquiry getSingleenquriy(int cid);
public Email saveEmail(Email e);
}
