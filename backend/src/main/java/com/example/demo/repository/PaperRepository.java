package com.example.demo.repository;

import com.example.demo.model.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperRepository extends JpaRepository<Paper,Long>{

    
}