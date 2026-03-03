package edu.jsp.BankingApplication.contoller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.BankingApplication.entity.Transaction;
import edu.jsp.BankingApplication.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/{aid}")
	public String addTransaction(@PathVariable long aid,@RequestBody Transaction t) {
		return transactionService.addTransaction(aid, t);
	}

	@DeleteMapping("/{aid}/tranaction/{tid}")
	public String removeTransaction(@PathVariable long aid, @PathVariable long tid) {
		return transactionService.removeTransaction(aid, tid);
	}

	@GetMapping("/user/{userId}")
	public List<Transaction> getAllTransactionByUser (@PathVariable Long userId) {
		return transactionService.getAllTransactionByUser(userId);
	}

	@GetMapping("/byDate")
	public List<Transaction> getAllTransactionByUserDate(@RequestParam Long userId, @RequestParam LocalDateTime st,
			@RequestParam LocalDateTime end) {
		return transactionService.getAllTransactionByUserDate(userId, st, end);

	}

	@GetMapping("/byAmount")
	public List<Transaction> getAlltranactionByUserUidAndAmountBetween(@RequestParam Long uid, @RequestParam double st,
			@RequestParam double end) {
		return transactionService.getAlltranactionByUserUidAndAmountBetween(uid, st, end);
	}
}
