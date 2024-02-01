package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    private Long paperId;

    @Id
    private Long userId;

    private String title;

    private String reviewDescription;

    private String status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deadline;

}