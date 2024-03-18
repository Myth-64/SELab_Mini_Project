package com.example.demo.restController;


import org.springframework.web.bind.annotation.*;


import com.example.demo.model.Paper;
import com.example.demo.model.Track;
import com.example.demo.model.User;
import com.example.demo.repository.PaperRepository;
import com.example.demo.repository.TrackRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.sqlQueryClasses.PaperStatusCountMap;

import io.swagger.v3.oas.annotations.Operation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

class SortByTrackCount implements Comparator<User>{
    public int compare(User left,User right){
        return right.getTracks().size()-left.getTracks().size();
    }
}

/**
 * Controller class responsible for handling HTTP requests related to Paper entities.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/papers")
public class PaperRestController {

    @Autowired
    PaperRepository paperRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TrackRepository trackRepository;

    @Operation(summary = "findAll", description="Return the list of all papers")
    @GetMapping("")
    public ResponseEntity<List<Paper>> findAll() {
        List<Paper> paperList=paperRepository.findAll();
        if(paperList.size()==0){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(paperList);
        }
    }

    @Operation(summary = "findById", description="Returns the paper with the given ID")
    @GetMapping("/findById")
    public ResponseEntity<Optional<Paper>> findById(@RequestParam Long id) {
        Optional<Paper> paper=paperRepository.findById(id);
        if(paper.isPresent()){
            return ResponseEntity.ok(paper);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @Operation(summary = "findByStatus", description="Returns the list of all papers with the given status")
    @GetMapping("/findByStatus")
    public ResponseEntity<List<Paper>> findByStatus(@RequestParam String status) {
        List<Paper> paperList=paperRepository.findByStatus(status);
        if(paperList.size()==0){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(paperList);
        }
    }
  
    @Operation(summary = "findByAuthor", description="Returns the list of all papers submitted by the author with given authorId")
    @GetMapping("/findByAuthor")
    public ResponseEntity<List<Paper>> findByAuthor(@RequestParam Long authorId) {
        List<Paper> paperList=paperRepository.findByAuthor(authorId);
        if(paperList.size()==0){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(paperList);
        }
    }

    @GetMapping("/countByStatus")
    public ResponseEntity<List<PaperStatusCountMap>> countByStatus(){
        List<PaperStatusCountMap> statusList = paperRepository.countByStatus();
        return ResponseEntity.ok(statusList);
    }

    @GetMapping(value="/getReviewers")
    public ResponseEntity<List<User>> getReviewers(@RequestParam Long paperId){
        List<User> unassignedReviewers=userRepository.getUnassignedReviewers(paperId);

        for(int i1=0;i1<unassignedReviewers.size();++i1){
            List<Track> commonTracks=trackRepository.findCommonTracks(unassignedReviewers.get(i1).getId(),paperId);
            Set<Track> commonTracksSet=commonTracks.stream().collect(Collectors.toSet());
            unassignedReviewers.get(i1).setTracks(commonTracksSet);
        }

        Collections.sort(unassignedReviewers,new SortByTrackCount());

        return ResponseEntity.ok(unassignedReviewers);
    }
}
