package com.hotel.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.net.entities.Login;
import com.hotel.net.enumex.Role;
import com.hotel.net.repo.LoginRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private LoginRepo loginRepo;
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
		Login login = loginRepo.findByUsername(username);
		session.setAttribute("login", login);
		if(login!=null && login.getPassword().equals(password)) {
			if(login.getRole() == Role.OWNER) {
				return "owner";
			} else if(login.getRole() == Role.MANAGER) {
				return "manager";
			}
			else if(login.getRole() == Role.RECEPTIONIST) {
				return "receptionist";
			}
		}
		return "redirect:/error";
	}
	
}
