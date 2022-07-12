package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;


//Get, Method로 통신, 
//@RequestMapping(value = "logInPage")
@AllArgsConstructor
@Controller
public class LogInController {	
	// ########## 로그인 페이지 이동 ##########
	@GetMapping("/logInPage")
	public String logInPage() {
		return "board/login/logInPage.html";
	}

// ▼▼▼▼▼ 로그인, 로그아웃 기능 ▼▼▼▼▼
	
// *Spring Security에서 로그인, 로그아웃에 해당하는 URL 가로채기 때문에 컨트롤러 구현 불필요	
// *SecurityConfig 참고	
	
//.loginProcessingUrl("/securityLogIn") //Spring Security 가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인해줌(서비스의 loadUserByName로 알아서)
	// ########## 로그인 기능 ##########
//	@PostMapping("/securityLogIn")
//	public String securityLogIn() {
//		System.out.println("LogInController - securityLogIn() : 확인 @@@@@");
//		return "board/post/postListPage.html";
//	}

	
// .logoutRequestMatcher(new AntPathRequestMatcher("/securityLogOut")) // 로그아웃 URL 설정 , Controller로 가지 않고 가로 챔
//	// ########## 로그아웃 ##########
//	@PostMapping("/securityLogOut")
//	public String securityLogOut() {
//		System.out.println("LogInController - securityLogOut() : 확인 @@@@@");
//		return "board/post/postListPage.html";
//	}

// ▲▲▲▲▲ 로그인, 로그아웃 기능 ▲▲▲▲▲
}
