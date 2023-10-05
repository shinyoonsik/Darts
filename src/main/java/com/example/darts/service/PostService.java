package com.example.darts.service;

import com.example.darts.domain.post.dto.PostDTO;
import com.example.darts.domain.post.entity.PostEntity;
import com.example.darts.mapper.PostMapper;
import com.example.darts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public List<PostDTO> getPostListByJPA() {
        return postRepository.findAll().stream()
                .map(PostDTO::new)
                .toList();
    }

    public List<PostDTO> getPostListByMybatis(){
        List<PostEntity> postEntities = postMapper.selectPostList();
        return postEntities.stream().map(PostDTO::new).toList();
    }
}
