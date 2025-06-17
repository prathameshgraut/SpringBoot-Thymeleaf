package SB.Thymeleaf.service;

import SB.Thymeleaf.entities.Bank;

public interface BankService {
	
	public boolean registerUser(Bank bank);

	public Bank loginBank(String email,String password);
}
