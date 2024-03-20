package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Review;

import jakarta.transaction.Transactional;

public interface ReviewRepository extends JpaRepository<Review,Long>{
    
    @Query(value="SELECT * FROM reviews WHERE paper_id=?1",nativeQuery=true)
    List<Review> findByPaper(Long paperId);

    @Query(value="SELECT * FROM reviews WHERE author_id=?1",nativeQuery=true)
    List<Review> findByReviewer(Long id);

    @Query(value="SELECT * FROM reviews WHERE assignee_id=?1",nativeQuery=true)
    List<Review> findByAssignee(Long id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO reviews (author_id,paper_id,assignee_id) VALUES (?1,?2,?3)",nativeQuery=true)
    void insertReview(Long authorId, Long paperId, Long assigneeId);
}
