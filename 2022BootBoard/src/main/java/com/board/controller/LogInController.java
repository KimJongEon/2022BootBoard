package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController

//Get, Method로 통신, 
//@RequestMapping(value = "logInPage")

@Controller
public class LogInController {	
	// ########## 로그인 페이지 이동 ##########
	@GetMapping("/logInPage")
	public String logInPage() {
		return "board/login/logInPage.html";
	}
	
	// ########## 로그인 기능 ##########
	@GetMapping("/SecuritylogIn")
	public String SecurityLogIn() {
		System.out.println("@@@@@@@@@@@로그인@@@@@@");
		return "/";
	}
	
}
