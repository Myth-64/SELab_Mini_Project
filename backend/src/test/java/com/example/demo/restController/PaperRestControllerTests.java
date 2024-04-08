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

public class PaperRestControllerTests {
    
    @Mock
    private PaperRepository paperRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private TrackRepository trackRepository;
    @Mock
    private ReviewRepository reviewRepository;
    @Mock
    private PaperIdRequest paperIdBody;
    @Mock
    private Paper paper;
    @Mock
    private User user;
    @Mock
    private EmailService mailSender;

    @InjectMocks
    private PaperRestController paperRestController;

    Set<Track> emptyTrack;
    User author=new User();

    Paper paper1=new Paper(1L,"Paper1","Paper1","UNASSIGNED",author,emptyTrack);
    Paper paper2=new Paper(2L,"Paper2","Paper2","UNDER_REVIEW",author,emptyTrack);
    Paper paper3=new Paper(3L,"Paper3","Paper3","COMPLETED_REVIEW",author,emptyTrack);

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll_TestForEmpty(){
        List<Paper> mockResult=new ArrayList<>();

        when(paperRepository.findAll()).thenReturn(mockResult);

        ResponseEntity<List<Paper>> currentResult=paperRestController.findAll();

        assertEquals(currentResult,ResponseEntity.noContent().build());
    }

    @Test
    public void findAll_TestForNonEmpty(){
        List<Paper> mockResult=new ArrayList<>();
        mockResult.add(paper1);
        mockResult.add(paper2);
        mockResult.add(paper3);

        when(paperRepository.findAll()).thenReturn(mockResult);

        ResponseEntity<List<Paper>> currentResult=paperRestController.findAll();

        assertEquals(mockResult, currentResult.getBody());
    }

    @Test
    public void findById_TestForEmpty(){
        Optional<Paper> mockResult=Optional.empty();

        when(paperRepository.findById(paper1.getPaperId())).thenReturn(mockResult);

        ResponseEntity<Optional<Paper>> currentResult=paperRestController.findById(paper1.getPaperId());

        assertEquals(ResponseEntity.noContent().build(), currentResult);
    }

    @Test
    public void findById_TestForNonEmpty(){
        Optional<Paper> mockResult=Optional.of(paper1);

        when(paperRepository.findById(paper1.getPaperId())).thenReturn(mockResult);

        ResponseEntity<Optional<Paper>> currentResult=paperRestController.findById(paper1.getPaperId());

        assertEquals(mockResult, currentResult.getBody());
    }

    @Test
    public void findByStatus_TestForEmpty(){
        List<Paper> mockResult=new ArrayList<>();

        when(paperRepository.findByStatus(paper2.getStatus())).thenReturn(mockResult);

        ResponseEntity<List<Paper>> currentResult=paperRestController.findByStatus(paper2.getStatus());

        assertEquals(ResponseEntity.noContent().build(), currentResult);
    }

    @Test
    public void findByStatus_TestForNonEmpty(){
        List<Paper> mockResult=new ArrayList<>();
        mockResult.add(paper2);

        when(paperRepository.findByStatus(paper2.getStatus())).thenReturn(mockResult);

        ResponseEntity<List<Paper>> currentResult=paperRestController.findByStatus(paper2.getStatus());

        assertEquals(mockResult, currentResult.getBody());
    }

    @Test
    public void findByAuthor_TestForEmpty(){
        List<Paper> mockResult=new ArrayList<>();

        when(paperRepository.findByAuthor(paper1.getAuthor().getId())).thenReturn(mockResult);

        ResponseEntity<List<Paper>> currentResult=paperRestController.findByAuthor(paper1.getAuthor().getId());

        assertEquals(ResponseEntity.noContent().build(), currentResult);
    }

    @Test
    public void findByAuthor_TestForNonEmpty(){
        List<Paper> mockResult=new ArrayList<>();
        mockResult.add(paper1);
        mockResult.add(paper2);
        mockResult.add(paper3);

        when(paperRepository.findByAuthor(paper1.getAuthor().getId())).thenReturn(mockResult);

        ResponseEntity<List<Paper>> currentResult=paperRestController.findByAuthor(paper1.getAuthor().getId());

        assertEquals(mockResult, currentResult.getBody());
    }

    @Test
    public void countByStatus_Test(){
        List<PaperStatusCountMap> statusList=new ArrayList<>();
        
        when(paperRepository.countByStatus()).thenReturn(statusList);

        ResponseEntity<List<PaperStatusCountMap>> currentResult=paperRestController.countByStatus();

        assertEquals(statusList, currentResult.getBody());
    }

    @Test
    public void accept_TestForValid(){
        Long paperId=1L;
        Paper tempPaper=new Paper(1L,"Hii","Hello","COMPLETED_REVIEW",null,null);

        when(paperIdBody.getPaperId()).thenReturn(paperId);
        when(paperRepository.findById(paperId)).thenReturn(Optional.of(tempPaper));
        doAnswer((i)->{
            return null;
        }).when(paperRepository).updateStatus("ACCEPTED", paperId);

        ResponseEntity<String> currentResult=paperRestController.accept(paperIdBody);

        assertEquals(ResponseEntity.ok("Status changed successfully"), currentResult);
    }

    @Test
    public void accept_TestForNotValid(){
        Long paperId=1L;
        Paper tempPaper=new Paper(1L,"Hii","Hello","NOT_COMPLETED_REVIEW",null,null);

        when(paperIdBody.getPaperId()).thenReturn(paperId);
        when(paperRepository.findById(paperId)).thenReturn(Optional.of(tempPaper));
        doAnswer((i)->{
            return null;
        }).when(paperRepository).updateStatus("ACCEPTED", paperId);

        ResponseEntity<String> currentResult=paperRestController.accept(paperIdBody);

        assertEquals(ResponseEntity.badRequest().build(), currentResult);
    }

    @Test
    public void reject_TestForValid(){
        Long paperId=1L;
        Paper tempPaper=new Paper(1L,"Hii","Hello","COMPLETED_REVIEW",null,null);

        when(paperIdBody.getPaperId()).thenReturn(paperId);
        when(paperRepository.findById(paperId)).thenReturn(Optional.of(tempPaper));
        doAnswer((i)->{
            return null;
        }).when(paperRepository).updateStatus("ACCEPTED", paperId);

        ResponseEntity<String> currentResult=paperRestController.reject(paperIdBody);

        assertEquals(ResponseEntity.ok("Status changed successfully"), currentResult);
    }

    @Test
    public void reject_TestForNotValid(){
        Long paperId=1L;
        Paper tempPaper=new Paper(1L,"Hii","Hello","NOT_COMPLETED_REVIEW",null,null);

        when(paperIdBody.getPaperId()).thenReturn(paperId);
        when(paperRepository.findById(paperId)).thenReturn(Optional.of(tempPaper));
        doAnswer((i)->{
            return null;
        }).when(paperRepository).updateStatus("ACCEPTED", paperId);

        ResponseEntity<String> currentResult=paperRestController.reject(paperIdBody);

        assertEquals(ResponseEntity.badRequest().build(), currentResult);
    }

    @Test
    public void getReviewers_Test(){
        List<User> tempUserList=new ArrayList<>();
        List<Track> trackList=new ArrayList<>();
        Set<Track> trackSet=new TreeSet<>();
        User tempUser=new User(1L,"Heyy","Hola","bruh","Lmao",null,null);
        tempUserList.add(tempUser);

        when(userRepository.getUnassignedReviewers(1L)).thenReturn(tempUserList);
        when(trackRepository.findCommonTracks(1L, 1L)).thenReturn(trackList);
        doAnswer((i)->{
            return null;
        }).when(user).setTracks(trackSet);

        ResponseEntity<List<User>> currentResult=paperRestController.getReviewers(1L);

        assertEquals(currentResult, ResponseEntity.ok(tempUserList));
    }

    @Test
    public void addReviewers_Test(){
        AddReviewerRequest request=new AddReviewerRequest();
        request.setPaperId(1L);
        request.setUsername("Mithun");
        request.setUserIds(new ArrayList<>());
        request.getUserIds().add(1L);

        when(userRepository.findByUsername("Mithun")).thenReturn(Optional.of(new User(2L,"Mithun","Mithun","haha","Lmao",null,null)));
        doAnswer((i)->{
            return null;
        }).when(paperRepository).updateStatus("UNDER_REVIEW", 1L);
        doAnswer((i)->{
            return null;
        }).when(reviewRepository).insertReview(1L, 1L, 2L);

        ResponseEntity<String> currentResult=paperRestController.addReviewers(request);

        assertEquals(ResponseEntity.ok("Added reviewers successfully"), currentResult);
    }

    @Test
    public void notify_TestValid(){
        PaperIdRequest paperIdRequest=new PaperIdRequest();
        paperIdRequest.setPaperId(1L);
        Paper tempPaper=new Paper(1L,"Title","Yoo","Supp",null,null);
        
        User author=new User(1L, null, null, null, null, null, null);
        Review review1=new Review(null, tempPaper, author, null, null, null, author);
        Review review2=new Review(null, tempPaper, author, "Yo", null, null, author);
        List<Review> reviewList=new ArrayList<>();
        reviewList.add(review1);
        reviewList.add(review2);

        when(paperRepository.findById(1L)).thenReturn(Optional.of(tempPaper));
        when(reviewRepository.findByPaper(1L)).thenReturn(reviewList);
        doAnswer((i)->{
            return null;
        }).when(mailSender).sendEmail(null, null, "Review Pending","Your review of the paper "+"Title"+" is pending");

        ResponseEntity<String> currentResult=paperRestController.notify(paperIdRequest);

        assertEquals(ResponseEntity.ok("Mails sent successfully"), currentResult);
    }

    @Test
    public void notify_TestNonValid(){
        PaperIdRequest paperIdRequest=new PaperIdRequest();
        paperIdRequest.setPaperId(1L);
        Paper tempPaper=new Paper(1L,"Title","Yoo","Supp",null,null);
        
        List<Review> reviewList=new ArrayList<>();

        when(paperRepository.findById(1L)).thenReturn(Optional.of(tempPaper));
        when(reviewRepository.findByPaper(1L)).thenReturn(reviewList);
        doAnswer((i)->{
            return null;
        }).when(mailSender).sendEmail(null, null, "Review Pending","Your review of the paper "+"Title"+" is pending");

        ResponseEntity<String> currentResult=paperRestController.notify(paperIdRequest);

        assertEquals(ResponseEntity.noContent().build(), currentResult);
    }
}
