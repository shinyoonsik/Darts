package com.example.darts.repository;

import com.example.darts.domain.auth.entity.Tokens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Tokens, Long>, TokenRepositoryCustom {
    Optional<Tokens> findByToken(String token);
}