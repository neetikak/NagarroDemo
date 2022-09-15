package com.nagarro.demo.Services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nagarro.demo.Entity.Statement;
import com.nagarro.demo.Repositories.BankRepository;
import com.nagarro.demo.requests.AmountRange;
import com.nagarro.demo.requests.DateRange;
import com.nagarro.demo.requests.StatementRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ViewStatementService {

	@Autowired
	BankRepository statementRepository;
	
	
		public List<Statement> getStatementUser(int account_id){
			try {
			return statementRepository.getStatementForUser(account_id);
			}catch(RuntimeException ex) {
				log.error("Error Occurred while fetching statements for user account id: {}", account_id);
				throw new RuntimeException(ex.getMessage());
			}
			
		}

		public List<Statement> fetchStatementsForAdmin(StatementRequest statementRequest
				) {
			DateRange dateRange = statementRequest.getDateRange();
			AmountRange amountRange = statementRequest.getAmountRange();
			List<Statement> statementResponse = null;
			try {
				if(dateRange == null && amountRange == null) {
					statementResponse = statementRepository.getStatementForUser(statementRequest.getAccountId());
				}else if(dateRange == null && amountRange != null){
					statementResponse = statementRepository.getStatementForamountRange(amountRange.getFromAmount(),
							amountRange.getToAmount(),statementRequest.getAccountId());
	
				}else if(dateRange != null && amountRange == null) {
					statementResponse = statementRepository.getStatementForDateRange(dateRange.getFromDate(),
							dateRange.getToDate(),statementRequest.getAccountId());
	
				}else {
					statementResponse = statementRepository.getStatementForBoth(amountRange.getFromAmount(),
							amountRange.getToAmount(),dateRange.getFromDate(),dateRange.getToDate(),statementRequest.getAccountId());
				}
			}catch(RuntimeException ex) {
				log.error("Error Occurred while fetching statements for admin account id: {}", statementRequest
						.getAccountId());
				throw new RuntimeException(ex.getMessage());
			}
			return statementResponse;
		}
		
	}

