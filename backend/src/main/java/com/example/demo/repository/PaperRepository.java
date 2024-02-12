package com.example.demo.repository;

import com.example.demo.model.Paper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repository interface for accessing and managing paper entities in the database.
 */
import org.springframework.data.jpa.repository.Query;
public interface PaperRepository extends JpaRepository<Paper,Long>{

     @Query(value="SELECT * FROM Papers WHERE status=?1",nativeQuery=true)
     List<Paper> findByStatus(String status);

     @Query(value="SELECT * FROM Papers WHERE author_id=?1",nativeQuery=true)
     List<Paper> findByAuthor(Long authorId);
}