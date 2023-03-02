package com.cjc.DaoI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.LoanDisbursement;
@Repository
public interface DisbursementDaoi extends CrudRepository<LoanDisbursement, Integer>{

	LoanDisbursement findAllByagreementId(int agreementId);

}
