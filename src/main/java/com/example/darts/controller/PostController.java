package com.example.darts.controller;

import com.example.darts.domain.post.dto.PostDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @GetMapping("/list")
    public List<PostDTO> showPostList(){
        return List.of(
                new PostDTO(1L, "title1", "contents1", "ys", LocalDateTime.now()),
                new PostDTO(2L, "title2", "contents2", "ys", LocalDateTime.now()),
                new PostDTO(3L, "title3", "contents3", "ys", LocalDateTime.now())
        );
    }

    @GetMapping("/{postId}")
    public String getPost(@PathVariable String postId){
        return postId + " 블로그 상세 내용입니다";
    }

}
