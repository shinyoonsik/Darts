package com.example.darts.domain.member.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberEntityTest {

    @PersistenceContext
    private EntityManager em;


    @Test
    @DisplayName("member엔티티 테스트")
    void testName(){
        // given
        String myName = "윤식";
        String myEmail = "ys@naver.com";
        String myPassword = "tlsdbstlr1";
        MemberEntity member = MemberEntity.builder()
                .name(myName)
                .email(myEmail)
                .password(myPassword)
                .build();

        // when
        em.persist(member);
        em.flush();
        em.clear();

        // then
        MemberEntity foundMember = em.find(MemberEntity.class, member.getId());
        assertThat(foundMember).isNotNull();
        assertThat(foundMember.getName()).isEqualTo(myName);
        assertThat(foundMember.getEmail()).isEqualTo(myEmail);
        assertThat(foundMember.getPassword()).isEqualTo(myPassword);
    }
}