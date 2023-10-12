package com.example.darts.repository;

import com.example.darts.domain.auth.entity.Tokens;

import java.util.List;

public interface TokenRepositoryCustom {
    List<Tokens> findAllValidTokenByUserId(String userName);
}