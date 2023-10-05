package com.example.darts.domain.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String contents;
    private String author;
    private LocalDateTime createdDate;
}
