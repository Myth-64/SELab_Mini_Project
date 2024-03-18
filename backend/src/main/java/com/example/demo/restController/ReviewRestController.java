package com.example.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/findByReviewer")
    public ResponseEntity<List<Review>> findByReviewer(@RequestParam Long id){
        List<Review> reviewList=reviewRepository.findByReviewer(id);
        return ResponseEntity.ok(reviewList);
    }

    @GetMapping("/findByAssignee")
    public ResponseEntity<List<Review>> findByAssignee(@RequestParam Long id){
        List<Review> reviewList=reviewRepository.findByAssignee(id);
        return ResponseEntity.ok(reviewList);
    }
}
