package com.cjc.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cjc.exception.CustomerServiceException;
import com.cjc.exception.EnquiryServiceException;
import com.cjc.model.Cibil;
import com.cjc.model.Email;
import com.cjc.model.Enquiry;

import com.cjc.serviceI.EnquiryServicei;



@CrossOrigin("*")
@RestController
public class EnquiryHomecontroller {
	@Autowired
	EnquiryServicei es;
	@PostMapping("/saveEn")
     public List<Enquiry> saveEn(@RequestBody List<Enquiry>e)
     {
    	
    	 return  es.saveen(e);
     }
	@PostMapping("/saveEnn")
	public Enquiry saveen(@RequestBody Enquiry e)
	{
		return  es.saveen(e);
	}
	@GetMapping("/getAll")
	public Iterable<Enquiry> getEn() throws  EnquiryServiceException
		{try {
			 return es.getAll();}
		catch(Exception e) {
			throw new EnquiryServiceException("enquiry data not available");
		}
		}
	@PutMapping("/updateEn")
	public void updateEn(@RequestBody Enquiry e)
	{
		 es.updateEn(e);
	}
	@DeleteMapping("/deleteEn/{cid}")
	public Iterable<Enquiry> deleteEn(@PathVariable("cid")int cid) throws EnquiryServiceException
	{try {
		return es.deleteEn(cid);}
	catch(Exception e) {
		throw new EnquiryServiceException("cid not present");
	}
	}
	
	@Autowired
	public JavaMailSender javamailsender;

	@GetMapping("/send")
	
	public String send() {
		SimpleMailMessage m = new SimpleMailMessage();
		m.setTo("varpe.rupali198@gmail.com");
		m.setSubject("EVCarNo");
		m.setText("cid:1,name:xyz");

		javamailsender.send(m);
		return "send";

	}
//	@GetMapping("/getcibil/{cid}")
//	public Integer getcibilscore(@PathVariable int cid)
//	{
//         Enquiry e	=es.Enquiry(cid);
//         int c=e.getCibilscore();
//            if(c>=700)
//            {
//            	e.setStatus("eligible");
//            	//return "eligible";
//            }
//            else
//            {
//            	e.setStatus("lowcibil");
//            	//return "lowcibil";
//            	
//            }
//          
//            return c;         
//   }
	@GetMapping("/getcibil/{cid}")
	public Integer getcibilscore(@PathVariable int cid)
	{
         Enquiry e	=es.Enquiry(cid);
         
	    String Url="http://localhost:9090/cbscore";
	    RestTemplate rt=new RestTemplate();
	    ResponseEntity<Integer> cib=rt.getForEntity(Url, Integer.class);
	    Integer cibil=cib.getBody();
	   e.setCibilscore(cibil);
	    if(cibil>700)
         {
         	e.setStatus("eligible");
         	//return "eligible";
         }         
	    else
         {
        	e.setStatus("lowCibil");
         	//return "lowcibil";
          	 }
	    es.saveen(e);
	 return cibil;
	 }
	
	@GetMapping(value="/getSingleDataEnquiry/{cid}")
	public Enquiry getSingledata1(@PathVariable int cid) {
		Enquiry e=es.getSingleenquriy(cid);

	return e;	
	}
	
	
	
	
	@GetMapping("/cbscore")
	public ResponseEntity<Integer> getCreditScore(){
		int min=600;
		int max=900;
		Random r=new Random();
		int showMe=r.nextInt(max);
		return new ResponseEntity<>(showMe,HttpStatus.OK);		
	}
	
	
	@PostMapping("/mailrejectsendEnquiry/{cid}")
	public Enquiry sendRejectedMail(@PathVariable int cid) {
		Enquiry e=es.getSingleenquriy(cid);
		System.out.println(e.getStatus());
		String status=e.getStatus();
		System.out.println(status);		
			SimpleMailMessage m=new SimpleMailMessage();
			m.setTo(e.getEmail());
			m.setSubject("Loan Rejection Mail");
			m.setText("We are sorry to inform that due to low cibil your enquiry is rejected");			
			javamailsender.send(m);		
		return e;
	}
	@PostMapping("/emailsave")
	public Email saveemail(@RequestBody Email e)
	{
		return es.saveEmail(e);
				
	}
	
	
	
}
