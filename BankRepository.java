package SB.Thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SB.Thymeleaf.entities.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {
	
	//custom repository interface
	Bank findByEmail(String email);

}
