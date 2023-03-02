package com.cjc.controller;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cjc.exception.CustomerServiceException;
import com.cjc.model.Customer;
import com.cjc.model.CustomerDocuments;
import com.cjc.model.Enquiry;
import com.cjc.model.ExcelGenrator;
import com.cjc.model.Ledger;
import com.cjc.model.LoanDisbursement;
import com.cjc.model.PdfGenerator;
import com.cjc.model.Sanction;
import com.cjc.model.ViewEmi;
import com.cjc.serviceI.ServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.lowagie.text.DocumentException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
//@RequestMapping("/document")
public class HomeController {
	@Autowired
	ServiceI usi;
	@GetMapping(value="/getAllData") 
	public List<Customer> getLoginPage() throws CustomerServiceException{
		List<Customer> al=usi.getAllData();
		
		
			return al;
	}
	@PostMapping(value="/savecust")
	public int savedata(@RequestBody Customer c)
	{
		Customer u= usi.savecostmer(c);
		int id=u.getCustomerId();
		return id;
	}
	@PostMapping(value="/postSingleData")
	public String postSingleData(@RequestBody Customer s2 ) throws IOException {
		
	     usi.saveData(s2);	
		return "success";}
	
	@PutMapping("/updateSingle")
	public String updateSingleData(@RequestBody Customer s2) {
		usi.updateData(s2);
	
		return "success";
	}
	@DeleteMapping("/deleteData/{customerId}")
	public String deleteSingleData(@PathVariable int customerId) {
		System.out.println(customerId);
		usi.deleteData(customerId);
		return "success";
	}
	@GetMapping(value="/getSingleData/{customerId}")
	public Customer getSingledata(@PathVariable int customerId) throws CustomerServiceException{
		Customer e=usi.getSingleData(customerId);
		return e;
	}
	
	@GetMapping(value ="/getbystatus/{status}")
	public List<Customer> getListByStatus(@PathVariable("status") String status )
	{		
		return usi.getByStatus(status);		
	}
	
	
	
	@GetMapping("/getDocc/{customerId}")
	public ResponseEntity< CustomerDocuments> getDocumentByCusId(@PathVariable Integer customerId) {
		 CustomerDocuments document = usi.getCustomerDocuments(customerId);
		return new ResponseEntity<>(document, HttpStatus.OK);				
	}
	
	@GetMapping("/changeStatus/{customerId}")
	public String changeStatus(@PathVariable Integer customerId) {
		
		
		boolean status = usi.changeStatus(customerId);
						
		 if(status==true)
		 {
			 return "Success";
			 
		 }
		 else
		 {
			 return "Operation Fail";
		 }
		 
	}
	
	
	@PostMapping(value ="/document")
	public void saveDoc(@RequestParam(value ="profilePhoto") MultipartFile file1,
			@RequestParam(value="signature")MultipartFile file2,
			@RequestParam(value ="pancard") MultipartFile file3, 
			@RequestParam(value="salaryslip")MultipartFile file4,
			@RequestParam(value="bankStatement")MultipartFile file5,
			@RequestParam(value="addressProof")MultipartFile file6,
			
			
			@RequestPart("customerId") String customerId) throws IOException
	{

		try {
			ObjectMapper om = new ObjectMapper();
			CustomerDocuments d = new CustomerDocuments();
			CustomerDocuments document=om.readValue(customerId, CustomerDocuments.class);

			d.setCustomerId(document.getCustomerId());
			d.setProfilePhoto(file1.getBytes());
			d.setSignature(file2.getBytes());
			d.setPancard(file3.getBytes());
			
			d.setSalaryslip(file4.getBytes());
			d.setBankStatement(file5.getBytes());
			
		   d.setAddressProof(file6.getBytes());
			usi.saveDoc(d);
		} catch (Exception e) {

			e.printStackTrace();
			// TODO: handle exception
		}

	}
	
	
	@Autowired
	public JavaMailSender javamailsender;
//	@GetMapping(value="/getAllDataEnquiry")
//	public List<Enquiry> getLoginPage1(){
//		List<Enquiry> al=usi.getAllData1();		
//			return al;
//	}
//	@PostMapping(value="/postSingleDataEnquiry")
//	public String postSingleData(@RequestBody Enquiry s2) {
//		
//		usi.saveData1(s2);	
//		return "success";
//	}
//	@PutMapping("/updateSingleEnquiry")
//	public String updateSingleData(@RequestBody Enquiry s2) {
//		usi.updateData1(s2);
//	
//		return "success";
//	}
//	@DeleteMapping("/deleteDataEnquiry/{fid}")
//	public String deleteSingleData1(@PathVariable int fid) {
//		System.out.println(fid);
//		usi.deleteData(fid);
//		return "success";
//	}
//	@GetMapping(value="/getSingleDataEnquiry/{cID}")
//	public Enquiry getSingledata1(@PathVariable int cID) {
//		Enquiry e=usi.getSingleData1(cID);
//		return e;
//	}
//	
//	@PostMapping("/getCibilEnquiry/{cID}")
//	public Integer getcibilScore(@PathVariable int cID) {
//		Enquiry e=usi.getSingleData1(cID);
//		String endpointUrl="http://localhost:9092/document/creditscore";
//		
//		RestTemplate rt=new RestTemplate();
//		ResponseEntity<Integer> cib=rt.getForEntity(endpointUrl, Integer.class);
//		Integer cibil=cib.getBody();
//		//Cibil c=new Cibil();
//		
//		e.setCScore(cibil);
//		if(cibil>700) {
//			e.setCibilstatus("eligible");			
//		}
//		else {
//			e.setCibilstatus("lowcibil");
//		}
//		usi.saveData1(e);
//		return cibil;
//	}
//	@GetMapping("/mailsendEnquiry/{cID}")
//	public Enquiry sendMail(@PathVariable int cID) {
//		Enquiry e=usi.getSingleData1(cID);
//		System.out.println(e.getCibilstatus());
//		String status=e.getCibilstatus();
//		System.out.println(status);		
//			SimpleMailMessage m=new SimpleMailMessage();
//			m.setTo(e.getEmail());
//			m.setSubject("Enquiry Accepted Mail");
//			m.setText("For further enquiry, your profile will be submitted to bank manager and further"
//					+ "you will be acknowledged");			
//			javamailsender.send(m);		
//		return e;
//	}
//	@GetMapping("/mailrejectsendEnquiry/{cID}")
//	public Enquiry sendRejectedMail(@PathVariable int cID) {
//		Enquiry e=usi.getSingleData1(cID);
//		System.out.println(e.getCibilstatus());
//		String status=e.getCibilstatus();
//		System.out.println(status);		
//			SimpleMailMessage m=new SimpleMailMessage();
//			m.setTo(e.getEmail());
//			m.setSubject("Loan Rejection Mail");
//			m.setText("We are sorry to inform that due to low cibil your enquiry is rejected");			
//			javamailsender.send(m);		
//		return e;
//	}
@GetMapping("/creditscore")
	public ResponseEntity<Integer> getCreditScore(){
		int min=600;
		int max=700;
		Random r=new Random();
		int showMe=r.nextInt(max);
		return new ResponseEntity<>(showMe,HttpStatus.OK);		
	}

	@PutMapping(value="/postSingleDataSanction")
	public String postSingleData2( @RequestBody Sanction s ) {	
		float t=s.getLoanTenure();
		float mon=t*12;
		float i=s.getRateOfInterest();
		float am=s.getLoanAmtSanctioned();
		//long r =  (am/12/100);
		float r = i / (12 * 100); // one month interest
        t = t * 12; // one month period
       int  emi = (int) ((am * r * (float)Math.pow(1 + r, mon)) 
                / (float)(Math.pow(1 + r, mon) - 1));
      
		s.setMonthlyEmiAmount((int) emi);
		usi.saveData2(s);
			 
		
//		usi.saveData2(sanctionId);	
return "success";
	}
	
	@GetMapping(value="/getSingleDataSanction/{sanctionId}")
	public Sanction getSingleData2(@PathVariable int sanctionId ) throws IOException {	
		Sanction u=usi.getData2(sanctionId);	
		return u;
	}
	
	
	
	@PostMapping("/mailsendSanction/{customerId}")
	public Customer sendSanctionMail(@PathVariable int customerId) {
		Customer e=usi.getSingleData2(customerId);
	
		
			SimpleMailMessage m=new SimpleMailMessage();
			m.setTo(e.getCustomerEmail());
			m.setSubject("Loan sanction Mail");
			m.setText("Greetings! dear  "
					+ e.getCustomerName()+ " we are delighted to inform that your to loan is sanctioned." 
					+"following are the details.\n"+
					"ApplicantName: "+e.getSanctiondetails().getApplicantName()+"\n"+
					"SanctionDate: "+e.getSanctiondetails().getSanctionDate()+"\n"+
					"ApplicantName: "+e.getSanctiondetails().getContactDetails()+"\n"+
					"ContactDetails: "+e.getSanctiondetails().getLoanAmtSanctioned()+"\n"+
					"InterestType: "+e.getSanctiondetails().getInterestType()+"\n"+
					"RateOfInterest: "+e.getSanctiondetails().getRateOfInterest()+"\n"+
					"LoanTenure: "+e.getSanctiondetails().getLoanTenure()+"\n"+
					"MonthlyEmiAmount: "+e.getSanctiondetails().getMonthlyEmiAmount()+"\n"+
					"ModeOfPayment: "+e.getSanctiondetails().getModeOfPayment()+"\n"
									
					);
			
			javamailsender.send(m);		
		return e;
	}
	 
	 @GetMapping("/export-to-excel/{customerId}")
	    public void exportIntoExcelFile(@PathVariable int customerId ,  HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());

	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=Ledger" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);

	       // List <Ledger> data = usi.getTheListLedger();
	       List<ViewEmi> data= usi.getDatabyCustomerId1(customerId);
	        ExcelGenrator generator = new ExcelGenrator(data);
	        generator.generateExcelFile(response);
	    }
	
	 @GetMapping("defaulterlist")
	 public List<Customer> defaulterlist(){
		 List<Customer> u =usi.getdatabydefaulter();
		 return u;
	 }
	 @GetMapping("/mailsendDefaulter")
		public  List <Ledger> sendDefaulterMail() {
//		 ledger l=usi.getledgerbyledgerid(ledgerid);
//		 Customer u=usi.getcustomerbyledgerId(l);
//		if( l.getDefaulterCount()>3) {
//								SimpleMailMessage m=new SimpleMailMessage();
//				m.setTo(u.getCustomerEmail());
//				m.setSubject("Loan Defaulter Mail");
//				m.setText(u.getCustomerName()+" Your loan installment is pending kindly pay within 1 month or strict action will be taken");			
//				javamailsender.send(m);
//				//cust.add(u);)
//				
				
				
				
		    List <Ledger> data = usi.getTheListLedger();
			//List<Customer> cust=new ArrayList<Customer>();
			data.forEach((l)->{
				if(l.getDefaulterCount()>3) {
					int l1=l.getLedgerId();
					Customer u=usi.getcustomerbyledgerId(l);
					SimpleMailMessage m=new SimpleMailMessage();
					m.setTo(u.getCustomerEmail());
					m.setSubject("Loan Defaulter Mail");
					m.setText(u.getCustomerName()+" Your loan installment is pending kindly pay within 1 month or strict action will be taken");			
					javamailsender.send(m);
					//cust.add(u);)
				}
			});
					
						
			return data;
		}
	 @PutMapping("saveDisbursement")
	 public LoanDisbursement saveLoanDisbursement(@RequestBody LoanDisbursement l) {
		 
		 LoanDisbursement u =usi.saveLoandisbursement(l);
		return u;
		 
		 
	 }
	 @GetMapping("getDisbursement/{agreementId}")
	 public LoanDisbursement getLoanDisbursement(@PathVariable int agreementId  ) {
		 
		 LoanDisbursement u =usi.getLoandisbursement(agreementId);
		return u;
		 
		 
	 }
	@PostMapping("/mailsendDisbursment/{customerId}")
		public Customer sendDisbursmentMail(@PathVariable int customerId) throws CustomerServiceException {
		    Customer u = usi.getSingleData(customerId);		
					
					SimpleMailMessage m=new SimpleMailMessage();
					m.setTo(u.getCustomerEmail());
					m.setSubject("Loan Disbursment Mail");
					m.setText(u.getCustomerName()+" congratulation your loan request is accepted, following are the details of your disbursement kindly check your account for the same."
							+"\n"+"AgreementId: "+u.getLoanDisbursementDetails().getAgreementId()+"\n"
							+"LoanNo: "+u.getLoanDisbursementDetails().getLoanNo()+"\n"
							+"AgreementDate: "+u.getLoanDisbursementDetails().getAgreementDate()+"\n"
							+"AmountPayType: "+u.getLoanDisbursementDetails().getAmountPayType()+"\n"
							+"TotalAmount: "+u.getLoanDisbursementDetails().getTotalAmount()+"\n"
							+"BankName: "+u.getLoanDisbursementDetails().getBankName()+"\n"
							+"AccountNumber: "+u.getLoanDisbursementDetails().getAccountNumber()+"\n"
							+"IFSCCode: "+u.getLoanDisbursementDetails().getIFSCCode()+"\n"
							+"AccountType: "+u.getLoanDisbursementDetails().getAccountType()+"\n"
							+"TransferAmount: "+u.getLoanDisbursementDetails().getTransferAmount()+"\n"
							+"PaymentStatus: "+u.getLoanDisbursementDetails().getPaymentStatus()+"\n"
							+"AmountPaidDate: "+u.getLoanDisbursementDetails().getAmountPaidDate()+"\n"
							
							
							);			
					javamailsender.send(m);	
				
			
					
						
			return u;
		}
	@PutMapping("saveledger")
	public Ledger saveledger(@RequestBody Ledger l) {
	Ledger u=usi.saveledger(l);
	return u;
	}
	@PostMapping("saveemi/{customerId}")
	public String saveviewEmi(@PathVariable int customerId ) throws ParseException {
		Customer c=usi.getCustomerbyCustomerId(customerId);
		long amt=c.getSanctiondetails().getLoanAmtSanctioned();
		int rt=c.getSanctiondetails().getRateOfInterest();
		int t=c.getSanctiondetails().getLoanTenure();
		int m=c.getSanctiondetails().getMonthlyEmiAmount();
		int id=c.getCustomerId();
		
		String agreementdate=c.getLoanDisbursementDetails().getAgreementDate();
		//System.out.println(agreementdate+" is the date before adding days");  
        
        // create instance of the SimpleDateFormat that matches the given date  
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
          
        //create instance of the Calendar class and set the date to the given date  
//        Calendar cal = Calendar.getInstance();  
//        try{  
//           cal.setTime(sdf.parse(agreementdate));  
//        }catch(ParseException e){  
//            e.printStackTrace();  
//         }  
             
        // use add() method to add the days to the given date  
        //cal.add(Calendar.DAY_OF_MONTH, 30);  
       // String dateAfter = sdf.format(cal.getTime());  
          
        //date after adding three days to the given date  
        //System.out.println(dateAfter+" is the date after adding 3 days.");  
		int n=1;
		for(int i=0;i<t*12;i++) {
			ViewEmi v=new ViewEmi();
			v.setAgreementDate(agreementdate);
			 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");  
	          
		        //create instance of the Calendar class and set the date to the given date  
		        Calendar cal = Calendar.getInstance();  
		        try{  
		           cal.setTime(sdf.parse(agreementdate));  
		        }catch(ParseException e){  
		            e.printStackTrace();  
		         }  
		             
		        // use add() method to add the days to the given date  
		        cal.add(Calendar.DAY_OF_MONTH, 30);  
		        String dateAfter = sdf.format(cal.getTime()); 
		        agreementdate=dateAfter;
			v.setLoanAmtSanctioned(amt);
			v.setLoanTenure(t);
			v.setMonthlyEmiAmount(m);
			v.setRateOfInterest(rt);
			v.setCustomerId(id);
			v.setStatus("notpaid");
			v.setNum(n);
			n++;
			usi.saveEmi(v);
		}
		return "success";
		
	}
	
	@GetMapping("getbycustomerID/{customerId}")
	public List<ViewEmi> getViewEmi(@PathVariable("customerId") int customerId)
	{
	 List<ViewEmi> u = usi.getDatabyCustomerId1(customerId);
		return u;		
	}
	
	@GetMapping("getviewemi")
	public List<ViewEmi> getallviewemi() {
		List<ViewEmi> u=usi.getallviewdata();
		return u;
	}
	
	@PutMapping("saveviewemibycustomer/{emiid}")
	public void saveemipaidunpaid(@PathVariable("emiid") int emiid) {
		usi.saveemibynum(emiid);
	}
	@PutMapping("saveviewemibycustomer/{emiid}/{agreementDate}")
	public void saveemipaidunpaid2(@PathVariable("emiid") int emiid,@PathVariable("agreementDate") String agreementDate) {
		usi.saveemibynum2(emiid,agreementDate);
	}
	
//	@GetMapping("findviewemidefaulter")
//	public   List<Customer> finddefaulter( ) {
//		//ViewEmi u=usi.getDatabyCustomerId(customerId);
//		List<ViewEmi> u=usi.getallviewdata();
//		System.out.println(u);
////		  Date date = Calendar.getInstance().getTime();
////		//  Date date= java.time.LocalDate.now()
////          DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
////          String strDate = dateFormat.format(date);
//          boolean found=true;
//          List<Customer> l=new ArrayList<Customer>();
//		//int t=u.getLoanTenure();
//          AtomicInteger count = new AtomicInteger();
//         
//          final int[] id = {0};
//		u.forEach((s)->{
//			
//			if(s.getStatus().equals("notpaid"))
//			{			
//				id[0]=s.getCustomerId();
//			count.getAndIncrement();
//			
//				  }
//		});
//		System.out.println("count:"+count.get());
//	
//		if(count.get()>3) {	
//			
//			Customer c=usi.getCustomerbyCustomerId(id[0]);
//			
//				l.add(c);
//		}
//		l.forEach((p)->{
//			System.out.println("customerId:"+p.getCustomerId());
//		});		
//	
//		
////		
//return l;
// 
//}
	@GetMapping("getdistinct")
	public List<Customer> def() {
		List<Integer> s=usi.selectdistinctemp();
		System.out.println(s);
		List<Integer> l1=new ArrayList<Integer>();
		   List<Customer> l=new ArrayList<Customer>();
		  
		s.forEach((n)->{
			String status="notpaid";
			System.out.println("n:"+n);
			Integer m=usi.getcountofstatus(n,status);
			System.out.println("m:"+m);
			if(m>3) {
			l1.add(n);
			}
		});
	l1.forEach((t)->{
		Customer c=usi.getCustomerbyCustomerId(t);
		l.add(c);
	});	
	return l;
	}
	@PostMapping("sentemidefaultermail/{customerId}")
	public Customer defaultermail(@PathVariable int customerId) {
		
		Customer c=usi.getCustomerbyCustomerId(customerId);
		SimpleMailMessage m=new SimpleMailMessage();
		m.setTo(c.getCustomerEmail());
		m.setSubject("Loan Defaulter Mail");
		m.setText(c.getCustomerName()+" Your loan installment is pending kindly pay within 1 month or strict action will be taken");			
		javamailsender.send(m);
		//cust.add(u);)
	
	return c;
	}
	@GetMapping("pdfgenerator/{customerId}")
	public void generatePdfFile(@PathVariable int customerId,  HttpServletResponse response) throws DocumentException, IOException 
	  {
	    response.setContentType("application/pdf");
	    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
	    String currentDateTime = dateFormat.format(new Date());
	    String headerkey = "Content-Disposition";
	    String headervalue = "attachment; filename=emilist" + currentDateTime + ".pdf";
	    response.setHeader(headerkey, headervalue);
	    List<ViewEmi> emilist = usi.getDatabyCustomerId1(customerId);
	    PdfGenerator generator = new PdfGenerator();
	    generator.generate(emilist, response);
	  }
}