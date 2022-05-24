package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {
	//글 목록 페이지로 이동, postListPage가 첫 화면
		@GetMapping("/signUpPage")
		public String signUpPage() {
			return "board/signup/signUpPage.html";
		}
}
