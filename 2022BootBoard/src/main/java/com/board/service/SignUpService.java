package com.board.service;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.board.domain.entity.MemberEntity;
import com.board.domain.entity.MemberRepository;
import com.board.dto.MemberDto.SignUpDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SignUpService {
	private final MemberRepository memberRepository; //JpaRepository의 함수 사용 하기 위해 선언 ex) .save()
	
	
	
	//회원가입
		@Transactional //어노테이션은 함수가 불의의 사고로 구동 실패 시 Rollback 할 수 있도록 안전장치하는 어노테이션
	    public Long SignUp (SignUpDto signUpDto) {
			MemberEntity memberEntity = signUpDto.toEntity();
			memberRepository.save(memberEntity); // .save()는 JpaRepository에서 제공하는 함수 : DB에 저장시켜준다
			
			return memberEntity.getMbrIdx();
	    } // SignUp End
	
	
//	//회원가입
//	@Transactional //어노테이션은 함수가 불의의 사고로 구동 실패 시 Rollback 할 수 있도록 안전장치하는 어노테이션
//    public Long SignUp (SignUpDto signUpDto) {
//		
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 비밀번호 암호화
//        // SignUpDto 에서 get한 mbr_pwd에 암호화된 비밀번호를 set
//        signUpDto.setMbrPassword(passwordEncoder.encode(signUpDto.getMbrPassword()));
//
//        return memberRepository.save(signUpDto.toEntity()).getMbrId();
//    } // SignUp End

} // SignUpService End
