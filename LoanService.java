package edu.jsp.BankingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.BankingApplication.entity.Loan;
import edu.jsp.BankingApplication.entity.User;
import edu.jsp.BankingApplication.exception.NotFoundException;
import edu.jsp.BankingApplication.repository.LoanRepository;
import edu.jsp.BankingApplication.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public String applyLoan(Long userId, Loan loan) {
		Optional<User> o = userRepository.findById(userId);
		if (o.isPresent()) {
			User u = o.get();
			u.addLaon(loan);
			userRepository.save(u);

			return "Laon appllied !!!";
		} else {
			throw new NotFoundException("User not found");
		}
	}

	@Transactional
	public String deleteLoan(Long userId, Long loanId) {
		Optional<User> uo = userRepository.findById(userId);
		Optional<Loan> lo = loanRepository.findById(loanId);
		if (uo.isPresent() && lo.isPresent()) {
			User u = uo.get();
			Loan l = lo.get();

			u.removeLoan(l);

			userRepository.save(u);

			return "Laon Deleted !!!";
		} else {
			throw new NotFoundException("User not found");
		}
	}

	public Loan getLoanById(long id) {
		return loanRepository.findById(id).orElseThrow(() -> new NotFoundException("Loan not found"));
	}

	public List<Loan> getLoanByUserId(Long userId) {
		return loanRepository.getLoanBYUserId(userId);
	}

	public String repayLoan(Long loanId, String status) {
		Loan l = loanRepository.findById(loanId).orElseThrow(() -> new NotFoundException("Loan not found"));
		l.setStatus(status);
		return "Status updated";
	}

	public String getStatus(Long loanId) {
		Loan l = loanRepository.findById(loanId).orElseThrow(() -> new NotFoundException("Loan not found"));
		return l.getStatus();
	}

}
