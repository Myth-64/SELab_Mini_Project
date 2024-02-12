package com.example.demo.model;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Paper Entity
 *
 * <p>This class represents a paper in the system.
 *  <ul>
 * <li>This class represents a papers in the system</li>.
 * <li>It contains various attributes such as paperId,title,author, Description, status, and tracks associated with it.</li>.
 * <li>The User class is annotated with JPA annotations to map it to a database table.</li>.
 * </ul> .
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "papers")
public class Paper {
    /**
     * The unique identifier for the paper.
     *
     * <p>Generated automatically using the GenerationType.IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paperId;
    /**
     * The title of the paper.
     */
    private String title;

     /**
     * The description of the paper.
     */
    private String description;

    /**
     * The status of the paper.
     */
    private String status;
    /**
     * The author of the paper.
     */
    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    private User author;
     /**
     * The tracks associated with the paper.
     */
    @ManyToMany
    @JoinTable(
        name="paperTracks",
        joinColumns = @JoinColumn(name="paperId"),
        inverseJoinColumns = @JoinColumn(name="trackId")
    )
    Set<Track> tracks;

    // @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    // private LocalDateTime schedule;

}