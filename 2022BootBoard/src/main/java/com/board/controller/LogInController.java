package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController

//Get, Method로 통신, 
//@RequestMapping(value = "logInPage")

//LogInPage로 이동, 로그인 페이지가 첫 화면으로 설정
@Controller
public class LogInController {	
	@GetMapping("/")
	public String logInPage() {
		return "board/login/logInPage.html";
	}
}
