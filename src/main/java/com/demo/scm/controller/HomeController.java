package com.demo.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.scm.entity.User;
import com.demo.scm.model.Message;
import com.demo.scm.repo.SCMRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
@Autowired	
SCMRepository repo;
	
	@GetMapping("/")
public String getHomePage(Model model) {
		model.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}
	@GetMapping("/about")
public String getAboutPage(Model model) {
		model.addAttribute("title", "About - Smart Contact Manager");
		return "about";
	}
	@GetMapping("/signup")
public String getSignUpPage(Model model) {
		model.addAttribute("title", "Sign Up - Smart Contact Manager");
		model.addAttribute("user", new User ());
		
		return "signup";
	}
	@PostMapping("/do_register")
	public String getDoRegisetr(HttpSession sesssion,Model model, @Valid @ModelAttribute("user") User user,BindingResult result,
		    @RequestParam(value = "term_check", required = false) boolean termcheck) {
		System.out.println("user"+user);
	try {
		if(!termcheck) {
			System.out.println("You are not checked the term and condition");
			throw new Exception("You are not checked the term and condition");
		}
		if(result.hasErrors()) {
			model.addAttribute("user",user);
			return "signup";
		}
		
	     user.setRole("ROLE_USER");
	     user.setEnabled(true);
	     //user.setTerm_check(true);
	     User save = repo.save(user);
		model.addAttribute("title", "Sign Up - Smart Contact Manager");
		model.addAttribute("user", save);
		sesssion.setAttribute("message",  new Message("Registration Success !!","alert-primary"));
	}catch(Exception e) {
		e.printStackTrace();
		model.addAttribute("user", user);
		sesssion.setAttribute("message",  new Message("Something went wrong !!","alert-danger"));
		return "signup";
	}
		
		return "signup";
	}

}
