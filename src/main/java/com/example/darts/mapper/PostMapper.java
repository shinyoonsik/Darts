package com.example.darts.mapper;

import com.example.darts.domain.post.entity.PostEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    /**
     * <mapper namespace="[path]"> : [path]는 참조하고 싶은 Mapper인터페이스의 경로
     * <select id="[id]"> : method명이 mapper가 참조하는 id이다. 즉, 구현체는 sql쿼리문이다
     * ?? mybatis는 트랜잭션 처리????
     */

    public List<PostEntity>  selectPostList(); // method명이 mapper가 참조하는 id이다. 즉, 구현체는 sql쿼리문이가
}
