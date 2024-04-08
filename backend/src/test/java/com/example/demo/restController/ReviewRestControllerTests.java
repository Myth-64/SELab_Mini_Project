package com.example.demo.restController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Paper;
import com.example.demo.model.Review;
import com.example.demo.model.Track;
import com.example.demo.model.User;
import com.example.demo.repository.PaperRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.TrackRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.requestClasses.AddReviewerRequest;
import com.example.demo.requestClasses.PaperIdRequest;
import com.example.demo.service.EmailService;
import com.example.demo.sqlQueryClasses.PaperStatusCountMap;


public class ReviewRestControllerTests {
    
    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewRestController reviewRestController;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll_Test(){
        List<Review> reviewList=new ArrayList<>();

        when(reviewRepository.findAll()).thenReturn(reviewList);

        ResponseEntity<List<Review>> currentResult=reviewRestController.findAll();

        assertEquals(ResponseEntity.ok(reviewList), currentResult);
    }
    @Test
    public void findByPaper_Test(){
        List<Review> reviewList=new ArrayList<>();

        when(reviewRepository.findAll()).thenReturn(reviewList);

        ResponseEntity<List<Review>> currentResult=reviewRestController.findByPaper(1L);

        assertEquals(ResponseEntity.ok(reviewList), currentResult);
    }
    @Test
    public void findByPaperCompleted_Test(){
        List<Review> reviewList=new ArrayList<>();

        when(reviewRepository.findAll()).thenReturn(reviewList);

        ResponseEntity<List<Review>> currentResult=reviewRestController.findByPaperCompleted(1L);

        assertEquals(ResponseEntity.ok(reviewList), currentResult);
    }
    @Test
    public void findByReviewer_Test(){
        List<Review> reviewList=new ArrayList<>();

        when(reviewRepository.findAll()).thenReturn(reviewList);

        ResponseEntity<List<Review>> currentResult=reviewRestController.findByReviewer(1L);

        assertEquals(ResponseEntity.ok(reviewList), currentResult);
    }
    @Test
    public void findByAssignee_Test(){
        List<Review> reviewList=new ArrayList<>();

        when(reviewRepository.findAll()).thenReturn(reviewList);

        ResponseEntity<List<Review>> currentResult=reviewRestController.findByAssignee(1L);

        assertEquals(ResponseEntity.ok(reviewList), currentResult);
    }
}
