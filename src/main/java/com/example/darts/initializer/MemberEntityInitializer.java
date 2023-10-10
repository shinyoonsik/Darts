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

        // TODO 혼자 개발하는게 아니기 때문에 postRepository를 통해 값이 있는지 체크하고 없을때 넣도록 수정
        memberRepository.save(tempMember);
    }
}
