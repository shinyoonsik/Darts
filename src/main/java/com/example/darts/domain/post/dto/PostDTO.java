package com.example.darts.domain.post.dto;

import com.example.darts.domain.post.entity.PostEntity;
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

    public PostDTO(PostEntity postEntity){
        this.id = postEntity.getId();
        this.title = postEntity.getTitle();
        this.author = postEntity.getAuthor();
        this.contents = postEntity.getContents();
    }
}
