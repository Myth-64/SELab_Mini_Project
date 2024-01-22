package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class userPage{
	@GetMapping("/user")
	public String getPage(){
		return "userPage";
	}
	
}
