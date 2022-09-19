package com.nagarro.demo.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.demo.Entity.Statement;
import com.nagarro.demo.Repositories.BankRepository;
import com.nagarro.demo.Services.ViewStatementService;
import com.nagarro.demo.requests.StatementRequest;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StatementController {

	@Autowired
	ViewStatementService viewStatementService;
	
	  @GetMapping("/view/admin/statements") 
	  public List<Statement> fetchStatements(@RequestBody StatementRequest statementRequest) {
		   log.info("Request Received for admin view statements for account id : {}", statementRequest.getAccountId());
	       return viewStatementService.fetchStatementsForAdmin(statementRequest); 
	  }
	 
	@GetMapping("/view/user/{account_id}")
	public List<Statement> getStatementUser(@PathVariable int account_id) {
		
		log.info("Request Received for user view statements for account id : {}", account_id);
		return	viewStatementService.getStatementUser(account_id);
		
	}
	
	
}
