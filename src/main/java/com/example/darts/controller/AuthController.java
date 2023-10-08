package com.example.darts.controller;

import com.example.darts.domain.member.dto.MemberFormDTO;
import com.example.darts.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<MemberFormDTO> authenticateMember(@RequestBody MemberFormDTO memberFormDTO){
        MemberFormDTO result = authService.authenticateMember(memberFormDTO);

        log.info("{}로 로그인 성공", memberFormDTO.getEmail());

        return ResponseEntity.ok(authService.authenticateMember(result));
    }

}
