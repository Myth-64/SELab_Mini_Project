package com.example.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;

@RestController
@CrossOrigin
@RequestMapping("api/reviews")
public class ReviewRestController {

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping("")
    public ResponseEntity<List<Review>> findAll(){
        List<Review> reviewList=reviewRepository.findAll();
        return ResponseEntity.ok(reviewList);
    }

    @GetMapping("/findByPaper")
    public ResponseEntity<List<Review>> findByPaper(@RequestParam Long paperId){
        List<Review> reviewList=reviewRepository.findByPaper(paperId);
        return ResponseEntity.ok(reviewList);
    }

}