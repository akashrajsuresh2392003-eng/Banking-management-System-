package edu.jsp.BankingApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.BankingApplication.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByName(String name);

}
