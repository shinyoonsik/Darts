package com.example.darts.initializer;

import com.example.darts.domain.post.entity.PostEntity;
import com.example.darts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PostEntityInitializer implements CommandLineRunner {

    private final PostRepository postRepository;

    @Override
    public void run(String... args) {
        List<PostEntity> postList = List.of(
                PostEntity.builder().title("title1").contents("contents1").author("ys").build(),
                PostEntity.builder().title("title2").contents("contents2").author("yoonsik").build(),
                PostEntity.builder().title("title3").contents("contents3").author("yoonsik").build()
        );

        // TODO 혼자 개발하는게 아니기 때문에 postRepository를 통해 값이 있는지 체크하고 없을때 넣도록 수정
        postRepository.saveAll(postList);
    }
}
