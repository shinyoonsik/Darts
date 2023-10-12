package com.example.darts.domain.member.entity;

import com.example.darts.constant.Role;
import com.example.darts.domain.member.dto.MemberFormDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.Member;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "MEMBER")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email; // 로그인할 때의 ID == security's username

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public MemberEntity(MemberFormDTO memberFormDTO){
        name = memberFormDTO.getName();
        email = memberFormDTO.getEmail();
        password = memberFormDTO.getPassword();
        address = memberFormDTO.getAddress();
        phoneNumber = memberFormDTO.getPhoneNumber();
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
