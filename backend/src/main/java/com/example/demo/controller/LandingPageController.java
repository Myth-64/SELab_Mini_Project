package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * <ul>
 * <li>Landing Page Controller
 *
 * <li><p>This controller handles requests for the landing page of the application.
 </ul>
 */

@Controller
public class LandingPageController{

	/**
     * Gets the landing page.
     *
     * @return The landing page view.
     */
	@GetMapping("/")
	public String getPage(){
		return "landingPage";
	}
}
