package com.example.darts.domain.post.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "POST")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENTS")
    private String contents;

    @Column(name = "AUTHOR")
    private String author;


}
