package com.nagarro.demo.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.demo.Entity.Account;
import com.nagarro.demo.Entity.Statement;
import com.nagarro.demo.requests.AmountRange;
import com.nagarro.demo.requests.DateRange;

import lombok.NonNull;

@Repository
public interface BankRepository extends JpaRepository<Statement,Integer>{

	

	@Query(value="Select * from STATEMENT WHERE  PARSEDATETIME( DATEFIELD,'dd.MM.yyyy','en') >= DATEADD(MONTH,-3,CURRENT_DATE()) and account_id=?1 ",nativeQuery = true)
	public List<Statement> getStatementForUser(int account_id);
	
	@Query(value="Select * from STATEMENT WHERE AMOUNT between ?1 and ?2 and account_id=?3",nativeQuery = true)
	public  List<Statement> getStatementForamountRange(Integer fromamount,Integer toAmount, Integer account_id);

	@Query(value="Select * from STATEMENT WHERE PARSEDATETIME( DATEFIELD,'dd.MM.yyyy','en')"
			+ "between ?1 and ?2 and account_id=?3",nativeQuery = true)
	public  List<Statement> getStatementForDateRange(LocalDate fromDate,LocalDate toDate, Integer account_id);

	@Query(value="Select * from STATEMENT WHERE PARSEDATETIME( DATEFIELD,'dd.MM.yyyy','en')"
			+ "between ?3 and ?4 and AMOUNT between ?1 and ?2 and account_id=?5",nativeQuery = true)
	public  List<Statement> getStatementForBoth(Integer fromamount,Integer toAmount, LocalDate fromDate,LocalDate toDate, Integer account_id);

}
