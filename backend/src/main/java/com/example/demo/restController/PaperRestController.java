package com.example.demo.restController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Paper;
import com.example.demo.repository.PaperRepository;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controller class responsible for handling HTTP requests related to Paper entities.
 */
@RestController
@RequestMapping("/api/papers")
public class PaperRestController {

    @Autowired
    PaperRepository paperRepository;

    @Operation(summary = "findAll", description="Return the list of all papers")
    @GetMapping("")
    public List<Paper> findAll() {
        return paperRepository.findAll();
    }

    @Operation(summary = "findById", description="Returns the paper with the given ID")
    @GetMapping("/id={id}")
    public Optional<Paper> findById(@PathVariable Long id) {
        return paperRepository.findById(id);
    }

    @Operation(summary = "findByStatus", description="Returns the list of all papers with the given status")
    @GetMapping("/status={status}")
    public List<Paper> findByStatus(@PathVariable String status) {
        return paperRepository.findByStatus(status);
    }
  
    @Operation(summary = "findByAuthor", description="Returns the list of all papers submitted by the author with given authorId")
    @GetMapping("/author={authorId}")
    public List<Paper> findByAuthor(@PathVariable Long authorId) {
        return paperRepository.findByAuthor(authorId);
    }
}