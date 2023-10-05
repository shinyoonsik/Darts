package com.example.darts.initializer;

import com.example.darts.domain.post.entity.PostEntity;
import com.example.darts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final PostRepository postRepository;

    @Override
    public void run(String... args) {
        List<PostEntity> postList = List.of(
                PostEntity.builder().title("title1").contents("contents1").author("ys").build(),
                PostEntity.builder().title("title2").contents("contents2").author("yoonsik").build(),
                PostEntity.builder().title("title3").contents("contents3").author("yoonsik").build()
        );

        postRepository.saveAll(postList);
    }
}
