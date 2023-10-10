package com.example.darts.repository;

import com.example.darts.domain.score.dto.SubjectScoreResponse;

import java.util.List;

public interface SubjectScoreCustom {
    List<SubjectScoreResponse> findScoresByStudent(Long studentId);
}
