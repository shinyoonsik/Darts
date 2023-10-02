package com.example.darts.domain.member.entity;

import com.example.darts.constant.Role;
import com.example.darts.domain.member.dto.MemberFormDTO;
import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Member;
import java.util.Objects;

@Entity
@Table(name = "MEMBER")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @PrePersist
    public void setDefaultRole() {
        if (Objects.isNull(role)) {
            role = Role.NORMAL;
        }
    }

//    public static MemberEntity from(MemberFormDTO memberFormDTO, PasswordEncoder passwordEncoder) {
//        return MemberEntity.builder()
//                .name(memberFormDTO.getName())
//                .address(memberFormDTO.getAddress())
//                .password(passwordEncoder.encode(memberFormDTO.getPassword()))
//                .email(memberFormDTO.getEmail())
//                .build();
//    }
}
