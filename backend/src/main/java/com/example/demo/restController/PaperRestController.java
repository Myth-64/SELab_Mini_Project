package com.example.demo.restController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.PaperDao;
import com.example.demo.model.Paper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * Controller class responsible for handling HTTP requests related to Paper entities.
 */
@RestController
@RequestMapping("/api")
public class PaperRestController {

    private PaperDao paperdao;
/**
     * Constructs a new PaperRestController with the specified PaperDao dependency.
     *
     * @param paperdao The data access object for Paper entities.
     */

    public PaperRestController (PaperDao paperdao){
        this.paperdao=paperdao;
    }
     /**
     * Get a list of all papers.
     *
     * @return List of Paper objects.
     */
    @GetMapping("/papers")
    public List<Paper>findAll() {
        return paperdao.findAll();
    }
    
}
