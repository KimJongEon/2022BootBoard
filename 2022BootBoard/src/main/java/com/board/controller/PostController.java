package com.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.board.dto.PostDto;
import com.board.service.PostService;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@Controller
public class PostController {
	private PostService postService;
	
	//글 목록 페이지로 이동, postListPage가 첫 화면
	@GetMapping("/")
	public String postListPage(Model model) {
		
		System.out.println("컨트롤러 테스트");
		
		List<PostDto> postList = postService.getPostList();
		model.addAttribute("postList", postList);
		System.out.println(postList);
		
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
