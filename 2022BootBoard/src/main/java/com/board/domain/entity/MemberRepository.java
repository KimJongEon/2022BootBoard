package com.board.domain.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
	
	// for 로그인
	Optional<MemberEntity> findByMbrId(String mbr_id);
}
