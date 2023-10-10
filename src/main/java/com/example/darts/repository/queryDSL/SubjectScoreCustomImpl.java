package com.example.darts.repository.queryDSL;

import com.example.darts.domain.score.dto.SubjectScoreResponse;
import com.example.darts.domain.score.entity.QScore;
import com.example.darts.domain.student.entity.QStudent;
import com.example.darts.repository.SubjectScoreCustom;
import com.example.darts.repository.SubjectScoreRepository;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SubjectScoreCustomImpl implements SubjectScoreCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<SubjectScoreResponse> findScoresByStudent(Long studentId) {
        QStudent st = QStudent.student;
        QScore sc = QScore.score1;

        JPAQuery<Tuple> result = jpaQueryFactory.select(
                        st.id,
                        st.name,
                        st.age,
                        sc.subject,
                        sc.score
                ).from(st)
                .join(sc).on(st.id.eq(sc.studentId))
                .where(st.id.eq(studentId))
                .orderBy(st.id.asc());

        return result.fetchJoin().fetch().stream()
                .map(tuple -> SubjectScoreResponse.builder()
                        .studentId(tuple.get(st.id))
                        .age(tuple.get(st.age))
                        .name(tuple.get(st.name))
                        .subject(tuple.get(sc.subject))
                        .score(tuple.get(sc.score))
                        .build()
                )
                .toList();
    }
}
