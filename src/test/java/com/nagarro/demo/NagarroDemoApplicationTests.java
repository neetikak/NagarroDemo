package com.nagarro.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nagarro.demo.Controller.StatementController;
import com.nagarro.demo.Entity.Statement;
import com.nagarro.demo.requests.StatementRequest;

@SpringBootTest


class NagarroDemoApplicationTests {
	
	@MockBean
	StatementController c;
	
	
	@Test
	void testUserstatement() {
		Statement s = new Statement();
		s.setAccount_id(56787543);
		s.setAmount("500");
		s.setDatefield("09.08.2022");
		s.setID(1001);
		List<Statement> l= new ArrayList<Statement>();
		l.add(s);
		Mockito.when(c.getStatementUser(56787543)).thenReturn(l);
		
		 Assertions.assertEquals("500",l.get(0).getAmount());
	}

	@Test
	void testasmintatement() {
		Statement s = new Statement();
		s.setAccount_id(56787543);
		s.setAmount("1500");
		s.setDatefield("09.08.2022");
		s.setID(1001);
		List<Statement> l= new ArrayList<Statement>();
		l.add(s);
		StatementRequest re= new StatementRequest();
		re.setAccountId(56787543);
		Mockito.when(c.fetchStatements(re)).thenReturn(l);
		
		 Assertions.assertEquals("1500",l.get(0).getAmount());
	}
}
