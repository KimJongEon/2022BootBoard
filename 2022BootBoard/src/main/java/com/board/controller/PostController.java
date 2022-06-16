package com.board.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PostController {
	//글 목록 페이지로 이동, postListPage가 첫 화면
	@GetMapping("/")
	public String postListPage() {
		return "board/post/postListPage.html";
	}
	
	//글 작성 페이지로 이동
	@GetMapping("/postWritePage")
	public String postWritePage() {
		return "board/post/postWritePage.html";
	}

	//글 상세 페이지 이동
	@GetMapping("/postDetailPage")
	public String postDetailPage() {
		return "board/post/postDetailPage.html";
	}	
	
	//글 수정 페이지로 이동
	@GetMapping("/postEditPage")
	public String postEditPage() {
		return "board/post/postEditPage.html";
	}

	
}
