package com.board.domain.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//JpaRepository를 상속하면 기본적인 CRUD 메소드가 자동으로 생성
//JpaRepository를 상속한 Interface는 @Repository 생략해도 Spring 로딩시 자동으로 Repository를 등록한다.
public interface PostRepository extends JpaRepository<PostEntity, Long>{ // 데이터 양이 많으면 Integer보단 Long 추천
	
	//postList 가져오기
//	@Query(value = "select * from POST_TB", nativeQuery = true) 
//	@Query(value = "select * from POST_TB")
	@Query(value = 
			"select p.*, m.mbrNickName "
		+ "from POST_TB p, MEMBER_TB m "
		+ "where p.mbrIdx = m.mbrIdx"			
					, nativeQuery =true)
//		+ "join fetch p.MEMBER_TB", nativeQuery =true)
	public List<PostEntity> findAllPost();
	

}
