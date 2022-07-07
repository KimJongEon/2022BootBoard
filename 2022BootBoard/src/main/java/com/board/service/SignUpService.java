package com.board.service;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.board.domain.entity.MemberRepository;
import com.board.dto.MemberDto.SignUpDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

//implements UserDetailsService
public class SignUpService {
	private MemberRepository memberRepository;
	
	@Transactional
    public String SignUp (SignUpDto signUpDto) {
		
		System.out.println("여기까지오니@@@@@@@@@@@@@");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 비밀번호 암호화
        // SignUpDto 에서 get한 mbr_pwd에 암호화된 비밀번호를 set
        signUpDto.setMbr_pwd(passwordEncoder.encode(signUpDto.getMbr_pwd()));

        return memberRepository.save(signUpDto.toEntity()).getMbr_id();
    } // SignUp End

	
	// loadUserByUsername : 상세 정보 조회 메소드
	// 사용자의 계정정보와 권한을 갖는 UserDetails 인터페이스를 반환하여야 함
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
//		
//		return null; //UserDetails 인터페이스를 반환
//	}

} // SignUpService End
