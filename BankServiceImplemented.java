package SB.Thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SB.Thymeleaf.entities.Bank;
import SB.Thymeleaf.repository.BankRepository;
@Service
public class BankServiceImplemented implements BankService{
	
	@Autowired
	private BankRepository brepo;

	@Override
	public boolean registerUser(Bank bank) {
		try {
			brepo.save(bank);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Bank loginBank(String email, String password) {
		Bank validBank= brepo.findByEmail(email);
		if(validBank != null && validBank.getPassword().equals(password)) {
			return validBank;
		}
		return null;
	}

}
