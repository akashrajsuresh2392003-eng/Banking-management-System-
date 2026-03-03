package edu.jsp.BankingApplication.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.BankingApplication.entity.Loan;
import edu.jsp.BankingApplication.service.LoanService;

@RestController
@RequestMapping("/api/loan")
public class LoanContoller {

	@Autowired
	private LoanService loanService;

	@PostMapping("/{userId}")
	public String applyLoan(@PathVariable Long userId,@RequestBody Loan loan) {
		return loanService.applyLoan(userId, loan);
	}

	@DeleteMapping("/{userId}/loan/{loanId}")
	public String deleteLoan(@PathVariable Long userId,@PathVariable Long loanId) {
		return loanService.deleteLoan(userId, loanId);
	}

	@GetMapping("/{id}")
	public Loan getLoanById(@PathVariable long id) {
		return loanService.getLoanById(id);
	}

	@GetMapping("/user/{userId}")
	public List<Loan> getLoanByUserId(@PathVariable Long userId) {
		return loanService.getLoanByUserId(userId);
	}

	@PutMapping("/{loanId}/status/{status}")
	public String repayLoan(@PathVariable Long loanId,@PathVariable  String status) {
		return loanService.repayLoan(loanId, status);
	}

	@GetMapping("/status/{loanId}")
	public String getStatus(Long loanId) {
		return loanService.getStatus(loanId);
	}

}
