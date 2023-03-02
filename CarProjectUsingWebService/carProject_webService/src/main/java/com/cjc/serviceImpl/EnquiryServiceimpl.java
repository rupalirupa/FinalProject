package com.cjc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.DaoI.EamilReposioty;
import com.cjc.DaoI.EnquiryRepositoryI;
import com.cjc.exception.EnquiryServiceException;
import com.cjc.model.Email;
import com.cjc.model.Enquiry;

import com.cjc.serviceI.EnquiryServicei;
@Service
public class EnquiryServiceimpl implements EnquiryServicei
{
	@Autowired
	EnquiryRepositoryI er;
	@Autowired
	EamilReposioty  ee;
	@Override
	public List<Enquiry> saveen(List<Enquiry> e) {
		
		return (List<Enquiry>) er.saveAll(e);
	}

	@Override
	public Enquiry saveen(Enquiry e) {
		
		return er.save(e);
	}

	@Override
	public Iterable<Enquiry> getAll() throws EnquiryServiceException{
		try {
		return er.findAll();}
		catch(Exception e) {
			throw new EnquiryServiceException("no enquiry");
		}
	}

	@Override
	public void updateEn(Enquiry e) {
		er.save(e);
		
	}

	@Override
	public Iterable<Enquiry> deleteEn(int cid) throws EnquiryServiceException {
		try{er.deleteById(cid);
		return getAll();}
		catch(Exception e) {
			throw new EnquiryServiceException("cid not present");
		}
	}

	@Override
	public Enquiry Enquiry(int cid) {
	
		return er.findByCid(cid);
	}

	@Override
	public Enquiry getSingleenquriy(int cid) {
		
		return er.findByCid(cid);
	}

	@Override
	public Email saveEmail(Email e) {
		
		return ee.save(e);
	}
	
	

}
