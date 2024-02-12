package com.example.demo.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.ReviewRepository;

@RestController
@RequestMapping("api/reviews")
public class ReviewRestController {
    
    @Autowired
    ReviewRepository reviewRepository;

}
