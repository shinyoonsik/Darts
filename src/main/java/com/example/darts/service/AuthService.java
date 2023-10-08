package com.example.darts.service;

import com.example.darts.domain.member.dto.MemberFormDTO;
import com.example.darts.domain.member.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;

    public MemberFormDTO authenticateMember(MemberFormDTO memberFromDTO) {
        Authentication authenticatedMember = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(memberFromDTO.getEmail(), memberFromDTO.getPassword())
        );

        if (authenticatedMember.isAuthenticated()) return memberFromDTO;
        else throw new IllegalStateException("email: " + memberFromDTO.getEmail() + " 로그인 실패");
    }
}
