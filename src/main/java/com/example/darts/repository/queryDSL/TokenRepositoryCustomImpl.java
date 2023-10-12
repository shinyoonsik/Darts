package com.example.darts.repository.queryDSL;

import com.example.darts.domain.auth.entity.QTokens;
import com.example.darts.domain.auth.entity.Tokens;
import com.example.darts.repository.TokenRepositoryCustom;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.micrometer.common.lang.NonNull;
import lombok.RequiredArgsConstructor;

import javax.inject.Qualifier;
import java.util.List;

@RequiredArgsConstructor
public class TokenRepositoryCustomImpl implements TokenRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Tokens> findAllValidTokenByUserId(@NonNull String userName) {
        QTokens t = QTokens.tokens;

        JPAQuery<Tuple> query = queryFactory
                .select(t.id, t.token, t.tokenType, t.expired, t.revoked, t.userName)
                .from(t)
                .where(t.expired.isFalse())
                .where(t.revoked.isFalse())
                .where(t.userName.eq(userName));

        return query.fetch()
                .stream().map(tuple ->
                        Tokens.builder()
                                .id(tuple.get(t.id))
                                .token(tuple.get(t.token))
                                .tokenType(tuple.get(t.tokenType))
                                .expired(tuple.get(t.expired))
                                .revoked(tuple.get(t.revoked))
                                .userName(tuple.get(t.userName))
                                .build()
                ).toList();
    }
}