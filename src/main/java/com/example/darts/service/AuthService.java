package com.example.darts.service;

import com.example.darts.constant.TokenType;
import com.example.darts.domain.auth.AuthResponse;
import com.example.darts.domain.auth.entity.Tokens;
import com.example.darts.domain.member.dto.MemberFormDTO;
import com.example.darts.domain.member.entity.MemberEntity;
import com.example.darts.repository.MemberRepository;
import com.example.darts.repository.TokenRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final MemberRepository memberRepository;
    private final TokenRepository tokenRepository;

    // public User authenticate(User user) {
    public AuthResponse authenticate(MemberEntity user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveToken(user, jwtToken);
        return new AuthResponse(jwtToken, refreshToken);
    }

    private void revokeAllUserTokens(MemberEntity user) {
        List<Tokens> validTokens = tokenRepository.findAllValidTokenByUserId(user.getEmail());
        if (!validTokens.isEmpty()) {
            validTokens.forEach(t -> {
                t.setExpired(true);
                t.setRevoked(true);
            });
            tokenRepository.saveAll(validTokens);
        }
    }

    private void saveToken(MemberEntity user, String jwtToken) {
        Tokens token = Tokens.builder()
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .userName(user.getUsername())
                .build();
        tokenRepository.save(token);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail; // username
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }

        // TODO HttpHeaders.AUTHORIZATION에서 추출한게 refresh-token? access-token은 어디에 위치시키지?
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            MemberEntity user = this.memberRepository.findMemberByEmail(userEmail).get();
            if (jwtService.isTokenValid(refreshToken, user)) {
                String accessToken = jwtService.generateToken(user);
                AuthResponse authResponse = new AuthResponse(accessToken, refreshToken);
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

}