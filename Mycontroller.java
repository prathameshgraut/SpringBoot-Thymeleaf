package SB.Thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import SB.Thymeleaf.entities.Bank;
import SB.Thymeleaf.service.BankService;

@Controller
public class Mycontroller {
	
	@Autowired
	private BankService bankService;
	
	@GetMapping("/regpage")
	public String Myreg(Model model) {
		model.addAttribute("bank",new Bank());
		return "register";
	}
	
	@PostMapping("/regForm")
	public String submitform(@ModelAttribute("bank") Bank bank ,Model model) {
		
		boolean status=bankService.registerUser(bank);
		if (status) {
			model.addAttribute("successmsg","Register Successfully...");
		}else {
			model.addAttribute("errormsg","User Not Register due to some regsiter");
		}
		
		return "register";
	}
	
	
	//login page...................................
	@GetMapping("/loginForm")
	public String openLogin(Model model) {
		model.addAttribute("bank",new Bank());
		return "login";
	}
	
	@PostMapping("/loginForm")
	public String submitlogin(@ModelAttribute("bank") Bank bank, Model model) {
		Bank validbank=bankService.loginBank(bank.getEmail(),bank.getPassword());
		if(validbank != null) {
			return "profile";
		}else {
			model.addAttribute("errormsg","Email Id and Password didn't Matched");
		}
		return "login";
	}

}
