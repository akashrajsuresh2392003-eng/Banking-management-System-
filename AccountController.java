package edu.jsp.BankingApplication.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.BankingApplication.entity.Account;
import edu.jsp.BankingApplication.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/{userId}")
	public String createAccount(@PathVariable Long userId,@RequestBody Account a) {
		return  accountService.createAccount(userId, a);
	}

	@DeleteMapping("/{userId}/account/{accountId}")
	public String deleteAccount(@PathVariable Long userId,@PathVariable Long accountId) {
		return  accountService.deleteAccount(userId, accountId);
	}

	@GetMapping("/{accountId}")
	public Account getAccountById(Long accountId) {
		return accountService.getAccountById(accountId);
	}

	@GetMapping("/getAccountsByUserId/{userId}")
	public List<Account> getAccountsByUserId(@PathVariable Long userId) {
		return accountService.getAccountsByUserId(userId);
	}
	
	@GetMapping("/getbalance/{accountId}")
	public Double getBalance(Long accountId) {
		return accountService.getBalance(accountId);
	}


}
