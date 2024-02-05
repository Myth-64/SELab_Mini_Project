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

@RestController
@RequestMapping("/api")
public class PaperRestController {

    private PaperDao paperdao;

    // public PaperRestController(){

    // }

    public PaperRestController (PaperDao paperdao){
        this.paperdao=paperdao;
    }
    
    @GetMapping("/papers")
    public List<Paper>findAll() {
        return paperdao.findAll();
    }
    
}
