package edu.jsp.BankingApplication.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import edu.jsp.BankingApplication.entity.Account;
import edu.jsp.BankingApplication.entity.Transaction;
import edu.jsp.BankingApplication.exception.NotFoundException;
import edu.jsp.BankingApplication.repository.AccountRepository;
import edu.jsp.BankingApplication.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	public String addTransaction(long aid, Transaction t) {

		Account a = accountRepository.findById(aid).orElseThrow(() -> new NotFoundException("Account not found"));

		a.addTransaction(t);

		accountRepository.save(a);

		return "Transaction added";
	}

	public String removeTransaction(long aid, long tid) {
		Account a = accountRepository.findById(aid).orElseThrow(() -> new NotFoundException("Account not found"));
		Transaction t = transactionRepository.findById(tid)
				.orElseThrow(() -> new NotFoundException("Transaction not found"));
		a.removeTranaction(t);

		accountRepository.save(a);
		return "Transaction removed";

	}
	
	public List<Transaction> getAllTransactionByUser(Long userId){
		return  transactionRepository.getAllTransactionByUser(userId);
	}

	public List<Transaction> getAllTransactionByUserDate(Long userId, LocalDateTime st, LocalDateTime end){
		return  transactionRepository.getAllTransactionByUserDate(userId, st, end);
	}

	public List<Transaction> getAlltranactionByUserUidAndAmountBetween(Long uid, double st, double end) {
		return transactionRepository.findByAccountUserUidAndAmountBetween(uid, st, end);
	}


}
