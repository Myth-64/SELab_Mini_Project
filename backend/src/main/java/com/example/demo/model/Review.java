package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
/**Review
 * <ul>
 * <li>This class represents a Reviews in the system</li>.
 * <li>It contains various attributes such as reviewId, paper,author, reviewDescription, status, and assignedBy</li>.
 * <li>The User class is annotated with JPA annotations to map it to a database table</li>.
 * </ul> .
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
  /**
     * The unique identifier for the review.
     *
     * <p>Generated automatically using the GenerationType.IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

      /**
     * The paper associated with the review.
     */
    @ManyToOne
    @JoinColumn(name="paper_id", nullable=false)
    private Paper paper;
 /**
     * The author of the review.
     */
    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    private User author;
 /**
     * The description of the review.
     */
    private String reviewDescription;

     /**
     * The status of the review.
     */
    private String status;

     /**
     * The deadline for the review.
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deadline;

      /**
     * The user who assigned the review.
     */

    @ManyToOne
    @JoinColumn(name="assignee_id", nullable=false)
    private User assignedBy;
}