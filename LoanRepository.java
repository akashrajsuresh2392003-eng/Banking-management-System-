package edu.jsp.BankingApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jsp.BankingApplication.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan,Long> {
	
	
	@Query("select l from Loan l  where l.user.uid = ?1")
	List<Loan>  getLoanBYUserId(long userId);

}
