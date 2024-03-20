package com.example.demo.repository;

import com.example.demo.model.Paper;
import com.example.demo.sqlQueryClasses.PaperStatusCountMap;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
/**
 * Repository interface for accessing and managing paper entities in the database.
 */
public interface PaperRepository extends JpaRepository<Paper,Long>{

     @Query(value="SELECT * FROM Papers WHERE status=?1",nativeQuery=true)
     List<Paper> findByStatus(String status);

     @Query(value="SELECT * FROM Papers WHERE author_id=?1",nativeQuery=true)
     List<Paper> findByAuthor(Long authorId);

     @Query(value="SELECT P.status AS status,COUNT(*) AS count FROM Papers P GROUP BY P.status",nativeQuery=true)
     List<PaperStatusCountMap> countByStatus();

     @Modifying
     @Transactional
     @Query(value="UPDATE Papers SET status=\"UNDER_REVIEW\" WHERE paper_id=?1",nativeQuery=true)
     void setStatusToUnderReview(Long paperId);
}