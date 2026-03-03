package edu.jsp.BankingApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.BankingApplication.entity.Account;
import edu.jsp.BankingApplication.entity.User;
import edu.jsp.BankingApplication.exception.NotFoundException;
import edu.jsp.BankingApplication.repository.AccountRepository;
import edu.jsp.BankingApplication.repository.LoanRepository;
import edu.jsp.BankingApplication.repository.UserRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	public String createAccount(Long userId, Account a) {
		User u = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("user not found"));
		u.addAccount(a);
		userRepository.save(u);

		return "Account created";
	}

	public String deleteAccount(Long userId, Long accountId) {
		User u = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("user not found"));
		Account a = accountRepository.findById(accountId).orElseThrow(() -> new NotFoundException("Account not found"));

		u.removeAccount(a);

		userRepository.save(u);

		return "account deleted";

	}

	public Account getAccountById(Long accountId) {
		return accountRepository.findById(accountId).orElseThrow(() -> new NotFoundException("Account not found"));
	}

	public List<Account> getAccountsByUserId(Long userId) {
		
		return accountRepository.getAccountsByUserId(userId);
	}

	public Double getBalance(Long accountId) {
		Account a = accountRepository.findById(accountId).orElseThrow(() -> new NotFoundException("Account not found"));
		return a.getBalance();
	}

}
