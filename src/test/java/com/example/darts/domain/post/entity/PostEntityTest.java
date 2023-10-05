package com.example.darts.domain.post.entity;

import com.example.darts.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostEntityTest {

    @Autowired
    PostRepository postRepository;

    private PostEntity createPostEntity(){
        return PostEntity.builder()
                .author("ys")
                .contents("울라라정말 좋은 포스트다")
                .title("프로그래밍")
                .build();
    }

    @Test
    @DisplayName("PostEntity저장 테스트")
    void testName(){
        // given
        PostEntity postEntity = createPostEntity();

        // when
        PostEntity savedPostEntity = postRepository.save(postEntity);

        // then
        assertThat(savedPostEntity).isNotNull();
        assertThat(savedPostEntity.getAuthor()).isEqualTo("ys");
    }

}