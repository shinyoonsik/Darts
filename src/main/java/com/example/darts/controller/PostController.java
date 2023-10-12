package com.example.darts.controller;

import com.example.darts.domain.post.dto.PostDTO;
import com.example.darts.service.AuthService;
import com.example.darts.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    // postService를 통해 service layer에 접근한다.
    // 즉 controller입장에서는 데이터 엑세스 기술이 JPA든 MyBatis든 상관없다 == 레이어드 아키텍처의 장점
    private final PostService postService;
    private final AuthService authService;

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

    @GetMapping("/test/exception")
    public void testException() throws Exception {
        log.info("exception 테스트");
        throw new Exception("exception 나가신다!");
    }

    @PostMapping("/refresh-token")
    public void getAccessTokenByRefreshToken(HttpServletRequest request, HttpServletResponse  response) throws IOException {
        authService.refreshToken(request, response);
    }
}
