package com.board.domain.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//JpaRepository를 상속하면 기본적인 CRUD 메소드가 자동으로 생성
//JpaRepository를 상속한 Interface는 @Repository 생략해도 Spring 로딩시 자동으로 Repository를 등록한다.
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
	
	MemberEntity findByMbrEmail(String mbrEmail);
	
	
	
//	// for 로그인
//	Optional<MemberEntity> findByMbrId(String mbrEmail);
	
	
}
