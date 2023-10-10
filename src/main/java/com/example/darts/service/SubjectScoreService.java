package com.example.darts.service;

import com.example.darts.domain.score.dto.SubjectScoreResponse;
import com.example.darts.repository.SubjectScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectScoreService {
    private final SubjectScoreRepository subjectScoreRepository;

    public List<SubjectScoreResponse> getScores(Long studentId){
        return subjectScoreRepository.findScoresByStudent(studentId);
    }
}
