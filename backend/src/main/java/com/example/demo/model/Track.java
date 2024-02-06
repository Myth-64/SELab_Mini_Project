package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Track Entity
 *<ul>
 * <li>This class represents a track entity .
 * <li>It contains various attributes such as trackid and title</li>.
 * </ul>
 *

 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tracks")
public class Track {
 /**
     * The unique identifier for the track.
     *
     * <p>Generated automatically using the GenerationType.IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;
    /**The title of the track.*/ 
    private String title;
} 