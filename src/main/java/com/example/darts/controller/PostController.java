package com.example.darts.controller;

import com.example.darts.domain.post.dto.PostDTO;
import com.example.darts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public List<PostDTO> showPostList(){
        return postService.getPostList();
    }

    @GetMapping("/{postId}")
    public String getPost(@PathVariable String postId){
        return postId + " 블로그 상세 내용입니다";
    }

}
