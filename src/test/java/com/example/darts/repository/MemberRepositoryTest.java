package com.example.darts.repository;

import com.example.darts.domain.member.entity.MemberEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    private MemberEntity createMember(){
        return MemberEntity.builder()
                .name("테스트")
                .email("테스트@email.com")
                .password("test123")
                .build();
    }

    @Test
    @DisplayName("테스트 memberRepository")
    void 테스트_memberRepository(){
        // given
        MemberEntity member = createMember();

        // when
        MemberEntity savedMember = memberRepository.save(member);

        // then
        assertThat(savedMember).isNotNull();
        assertThat(savedMember.getName()).isEqualTo("테스트");
    }


}