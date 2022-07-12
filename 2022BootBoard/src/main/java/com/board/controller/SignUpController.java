package com.board.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.board.dto.MemberDto.SignUpDto;
import com.board.service.SignUpService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class SignUpController {
	private SignUpService signUpService;
	
	
	// 회원가입 페이지로 이동, postListPage가 첫 화면
	@GetMapping("/signUpPage")
	public String signUpPage() {
		return "board/signup/signUpPage.html";
	}
		
	// ########## 회원가입  ##########
	@PostMapping("/signUp") //view단(form태그) 에서 /signUp으로 보낸걸 컨트롤러에서 받음
	public String signUp(SignUpDto signUpDto) { // 회원가입 Dto 선언
		
		//######## 테스트 ##########	
		
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 비밀번호 암호화
//	    // SignUpDto 에서 get한 mbr_pwd에 암호화된 비밀번호를 set
//	    signUpDto.setMbr_pwd(passwordEncoder.encode(signUpDto.getMbr_pwd()));
		
	    //######## 테스트 ##########
		
		
		// 값들고오는지 확인
		System.out.println(signUpDto.getMbrId());
		System.out.println("@########가입 시간 : "+signUpDto.toEntity().getSignup_dt());
		System.out.println(" ######### 휴대폰 번호 : " + signUpDto.toEntity().getTel_no() );
		System.out.println(signUpDto.getMbr_pwd());
		System.out.println(signUpDto.getMbr_nm());
		System.out.println(signUpDto.getTel_no());
		System.out.println("@@@@@@@signUp 회원가입 컨트롤러 테스트 ");
		
		
		
		signUpService.SignUp(signUpDto);
		System.out.println("가입 시간 확인222222222 : " + signUpDto.getSignup_dt());
		
		return "/board/login/logInPage.html";
	}
}
