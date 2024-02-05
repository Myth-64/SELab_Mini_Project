package com.example.demo.model;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "papers")
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paperId;

    private String title;

    private String description;

    private String status;

    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    private User author;

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