package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

  /**
 * UserPageController
 *
 * <p>This controller handles requests for the User page of the application.

 */
@Controller
public class UserPageController{
	
    /**
     * Gets the User page.
     *
     * @return The User page view.
     */
	@GetMapping("/user")
	public String getPage(){
		return "userPage";
	}
	
}
