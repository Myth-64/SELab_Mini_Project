package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class loginPage{
	@GetMapping("/")
	public String getPage(){
		return "loginPage";
	}
	
}
