package com.cjc.DaoI;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.cjc.model.Email;
@Service
public interface ReportCommunication {
	@PostMapping(value="/report/email")
	public void sendMail(@RequestBody Email request);
}
