package com.example.demo.repository;

import com.example.demo.model.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repository interface for accessing and managing paper entities in the database.
 */
public interface PaperRepository extends JpaRepository<Paper,Long>{

    
}