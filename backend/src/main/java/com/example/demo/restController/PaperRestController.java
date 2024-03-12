package com.example.demo.restController;


import org.springframework.web.bind.annotation.*;


import com.example.demo.model.Paper;
import com.example.demo.repository.PaperRepository;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Controller class responsible for handling HTTP requests related to Paper entities.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/papers")
public class PaperRestController {

    @Autowired
    PaperRepository paperRepository;

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
}
