package com.example.darts.service;

import com.example.darts.domain.member.dto.MemberFormDTO;
import com.example.darts.domain.member.entity.MemberEntity;
import com.example.darts.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @MockBean
    MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    private MemberEntity createMember(){
        return MemberEntity.builder()
                .name("테스트")
                .email("테스트@email.com")
                .password("test123")
                .build();
    }

    private MemberFormDTO createMemberDTO() {
        return MemberFormDTO.builder()
                .name("테스트")
                .email("테스트@email.com")
                .password("test123")
                .build();
    }

    @Test
    @DisplayName("중복 회원 가입 예외 테스트 with memberRepository")
    void 테스트_중복_회원가입_with_memberRepository() {
        // given
        MemberFormDTO member1 = createMemberDTO();
        MemberFormDTO member2 = createMemberDTO();
        memberService.saveMember(member1);

        // when
        IllegalStateException resultException = assertThrows(IllegalStateException.class, () -> {
            memberService.saveMember(member2);
        });

        // then
        assertThat(resultException.getMessage()).isEqualTo(member1.getName() + "님은 이미 가입된 회원입니다.");
    }

    @Test
    @DisplayName("중복 회원 가입 예외 테스트 mocking memberRepository")
    void 테스트_중복_회원가입_mocking_memberRepository() {
        // given
        MemberFormDTO memberDTO = createMemberDTO();
        MemberEntity member = createMember();
        given(memberRepository.findMemberByEmail(any())).willReturn(Optional.empty());
        given(memberRepository.save(any())).willReturn(member);

        // when
        MemberFormDTO memberFormDTO = memberService.saveMember(memberDTO);

        // then
        assertThat(memberFormDTO.getName()).isEqualTo(member.getName());
    }
}