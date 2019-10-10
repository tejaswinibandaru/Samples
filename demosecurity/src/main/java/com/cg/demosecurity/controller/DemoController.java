package com.cg.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping(value="/admin")
	public String getAdmin() {
		return "AdminPage";
	}
	
	@GetMapping(value="/user")
	public String getUser() {
		return "UserPage";
	}
	
	@GetMapping(value = "/")
	public String getHome() {
		return "HomePage";
	}
	
	

}
