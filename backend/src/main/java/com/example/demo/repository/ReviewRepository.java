package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Review;

public interface ReviewRepository extends JpaRepository<Review,Long>{

    @Query(value="SELECT * FROM reviews WHERE paper_id=?1",nativeQuery=true)
    List<Review> findByPaper(Long paperId);
}