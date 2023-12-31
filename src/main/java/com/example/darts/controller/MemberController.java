package com.example.darts.controller;

import com.example.darts.domain.member.dto.MemberFormDTO;
import com.example.darts.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 로그인

    // 로그아웃

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<MemberFormDTO> signupMember(@Valid @RequestBody MemberFormDTO memberFormDTO) {
        log.info("MemberController, 메소드: joinMember, 파라미터: MemberFormDTO -> {}", memberFormDTO);

        MemberFormDTO result = memberService.saveMember(memberFormDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
