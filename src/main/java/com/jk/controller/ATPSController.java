package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ATPSController {
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
}
