package com.example.darts.controller;

import com.example.darts.domain.post.dto.PostDTO;
import com.example.darts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    // postService를 통해 service layer에 접근한다.
    // 즉 controller입장에서는 데이터 엑세스 기술이 JPA든 MyBatis든 상관없다 == 레이어드 아키텍처의 장점
    private final PostService postService;

    @GetMapping("/jpa/list")
    public List<PostDTO> showPostList() {
        return postService.getPostListByJPA();
    }

    @GetMapping("/mybatis/list")
    public List<PostDTO> showPostListByMybatis() {
        return postService.getPostListByMybatis();
    }

    @GetMapping("/{postId}")
    public String getPost(@PathVariable String postId) {
        return postId + " 블로그 상세 내용입니다";
    }

}
