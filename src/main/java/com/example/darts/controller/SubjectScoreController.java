package com.example.darts.controller;

import com.example.darts.domain.score.dto.SubjectScoreResponse;
import com.example.darts.service.SubjectScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectScoreController {
    private final SubjectScoreService subjectScoreService;

    @GetMapping("/score/{studentId}")
    public ResponseEntity<List<SubjectScoreResponse>> getScoreOfStudent(@PathVariable Long studentId){
        List<SubjectScoreResponse> scores = subjectScoreService.getScores(studentId);
        return ResponseEntity.ok(scores);
    }
}
