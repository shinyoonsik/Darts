package com.example.darts.initializer;

import com.example.darts.domain.member.entity.MemberEntity;
import com.example.darts.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberEntityInitializer implements CommandLineRunner {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        MemberEntity tempMember = MemberEntity.builder()
                .name("ys")
                .email("ys@gmail.com")
                .password(passwordEncoder.encode("1234"))
                .build();

        memberRepository.save(tempMember);
    }
}
