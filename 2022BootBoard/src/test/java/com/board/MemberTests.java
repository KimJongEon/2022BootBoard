package com.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.entity.MemberEntity;
import com.board.domain.entity.MemberRepository;

@SpringBootTest
public class MemberTests {
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	void saveID() {
		MemberEntity params = MemberEntity.builder()
				.mbrId("JongEonTest")
				.build();
		
		memberRepository.save(params);
		
	} //End Save
	
}
