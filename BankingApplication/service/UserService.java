package edu.jsp.BankingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.jsp.BankingApplication.entity.User;
import edu.jsp.BankingApplication.exception.NotFoundException;
import edu.jsp.BankingApplication.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(() -> new NotFoundException("id not found"));
	}

	public ResponseEntity<User> createUser(User u) {
		return new ResponseEntity<User>(userRepository.save(u), HttpStatus.CREATED);
	}

	public ResponseEntity<String> deleteUser(long id) {
		Optional<User> ou = userRepository.findById(id);
		if (ou.isPresent()) {
			userRepository.deleteById(id);
			return new ResponseEntity<String>("Data deleted", HttpStatus.NO_CONTENT);
		} else {
			throw new NotFoundException("Id not found");
		}
	}

	public ResponseEntity<List<User>> searchUserByName(String name) {
		return new ResponseEntity<List<User>>(userRepository.findByName(name), HttpStatus.OK);
	}

}
