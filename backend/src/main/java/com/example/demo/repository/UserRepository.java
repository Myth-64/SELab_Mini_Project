package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
/**
 * Repository interface for accessing and managing User entities in the database.
 */
public interface UserRepository extends JpaRepository<User, Long> {
  
    Optional<User> findByUsername(String username);
    
    Boolean existsByEmail(String email);
     
    Optional<User> findByUsernameOrEmail(String username, String email);
    
    boolean existsByUsername(String username);

    @Query(value="SELECT * FROM users WHERE id NOT IN (SELECT author_id FROM reviews WHERE paper_id=?1)",nativeQuery=true)
    List<User> getUnassignedReviewers(Long paperId);
}
