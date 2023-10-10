package com.example.darts.repository;

import com.example.darts.domain.score.dto.SubjectScoreResponse;
import com.example.darts.domain.score.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectScoreRepository extends JpaRepository<Score, Long>, SubjectScoreCustom {
}
