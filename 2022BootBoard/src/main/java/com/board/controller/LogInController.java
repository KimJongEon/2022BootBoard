package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController

//Get, Method로 통신, 
//@RequestMapping(value = "logInPage")

@Controller
public class LogInController {	
	@GetMapping("/logInPage")
	public String logInPage() {
		return "board/login/logInPage.html";
	}
}
