package com.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.dto.PostDto;
import com.board.dto.PostDto.PostListDto;
import com.board.service.PostService;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@Controller
public class PostController {
	private PostService postService;
	
	//글 목록 페이지로 이동, postListPage가 첫 화면
	@GetMapping("/")
	public String postListPage(Model model) { //Model 사용을 위해 선언
		
//		List<PostDto> postList = postService.getPostList();
		
		// inner class 테스트
		List<PostListDto> postList = postService.getPostList();
		
		System.out.println("컨트롤러 테스트 : "+postList);
		//(key, value) 형태를 지닌 model 객체를 이용하여 postList값을 view(postListPage.html)로 전달
		model.addAttribute("postList", postList); 
		
		return "board/post/postListPage.html";
	}
	
	//글 작성 페이지로 이동
	@GetMapping("/postWritePage")
	public String postWritePage() {
		return "board/post/postWritePage.html";
	}

	//글 상세 페이지 이동
	@RequestMapping(value = "postDetailPage/{p_no}" , method = RequestMethod.GET )
	public String postDetailPage(
			//PathVariable annotation
			//tr 클릭 시 해당 p_no값을 받아 오기 위한 annotation
			@PathVariable("p_no") int p_no
			
			) { 
		
		System.out.println("p_no값 넘어 오는지 컨트롤러 테스트 : "+p_no);
		return "board/post/postDetailPage.html";
	}	
	
	//글 수정 페이지로 이동
	@GetMapping("/postEditPage")
	public String postEditPage() {
		return "board/post/postEditPage.html";
	}

	
}
