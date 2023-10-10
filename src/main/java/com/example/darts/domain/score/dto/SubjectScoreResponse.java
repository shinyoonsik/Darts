package com.example.darts.domain.score.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectScoreResponse {
    private Long studentId;
    private String name;
    private Integer age;
    private String subject;
    private Integer score;
}
