package com.example.darts.service;

import com.example.darts.domain.member.dto.MemberFormDTO;
import com.example.darts.domain.member.entity.MemberEntity;
import com.example.darts.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberFormDTO saveMember(MemberFormDTO memberFormDTO){
        MemberEntity member = validateDuplicateMember(memberFormDTO);
        MemberEntity savedMember = memberRepository.save(member);

        return MemberFormDTO.from(savedMember);
    }

    private MemberEntity validateDuplicateMember(MemberFormDTO memberFormDTO) {
        memberRepository.findMemberByEmail(memberFormDTO.getEmail())
                .ifPresent(member -> {
                    throw new IllegalStateException(member.getName() + "님은 이미 가입된 회원입니다.");
                });

        return MemberEntity.builder()
                .name(memberFormDTO.getName())
                .email(memberFormDTO.getEmail())
                .password(memberFormDTO.getPassword())
                .address(memberFormDTO.getAddress())
                .phoneNumber(memberFormDTO.getPhoneNumber())
                .build();
    }
}
