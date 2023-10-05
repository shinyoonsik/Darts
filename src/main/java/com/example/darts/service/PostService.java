package com.example.darts.service;

import com.example.darts.domain.post.dto.PostDTO;
import com.example.darts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<PostDTO> getPostList(){
        return postRepository.findAll().stream().map(
                PostDTO::new
        ).toList();
    }
}
