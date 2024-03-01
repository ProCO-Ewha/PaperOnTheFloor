package com.example.paperonthefloor.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Paper {
    @Id
    @GeneratedValue
    @Column(name = "paper_id")
    private Long id;
    private String author;
    private String text;
    private LocalDateTime date;
}
