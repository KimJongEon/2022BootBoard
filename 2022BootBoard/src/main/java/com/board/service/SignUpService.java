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
public class SignUpService {
	private final MemberRepository memberRepository;
	
	@Transactional
    public String SignUp (SignUpDto signUpDto) {
		
		System.out.println("여기까지오니@@@@@@@@@@@@@");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 비밀번호 암호화
        // SignUpDto 에서 get한 mbr_pwd에 암호화된 비밀번호를 set
        signUpDto.setMbr_pwd(passwordEncoder.encode(signUpDto.getMbr_pwd()));

        return memberRepository.save(signUpDto.toEntity()).getMbrId();
    } // SignUp End

} // SignUpService End
