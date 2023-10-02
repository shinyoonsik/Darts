package com.example.darts.domain.member.dto;

import com.example.darts.domain.member.entity.MemberEntity;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
@Builder
public class MemberFormDTO {
    @Nullable
    private Long id;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    @Email(message = "이메일 형식으로 입력해주세요.")
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min=8, max=16, message = "비밀번호는 8자리 이상, 16자 이하로 작성해주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "비밀번호는 영문과 숫자로만 이루어져 있어야 합니다.")
    private String password;

    @Nullable
    private String phoneNumber;

    @Nullable
    private String address;

    public static MemberFormDTO from(MemberEntity memberEntity){
        return MemberFormDTO.builder()
                .id(memberEntity.getId())
                .name(memberEntity.getName())
                .address(memberEntity.getAddress())
                .email(memberEntity.getEmail())
                .password(memberEntity.getPassword())
                .phoneNumber(memberEntity.getPhoneNumber())
                .build();
    }
}
