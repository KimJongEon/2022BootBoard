package com.board.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer>{ // 데이터 양이 많으면 Integer보단 Long 추천
	
}
