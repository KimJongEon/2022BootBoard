package com.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.dto.PostDto.PostDetailDto;
import com.board.dto.PostDto.PostListDto;
import com.board.dto.PostDto.PostRegisterDto;
import com.board.service.PostService;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@Controller
public class PostController {
	//PostService 이용을 위해 선언
	private PostService postService;
	
	// ########## 글 목록 페이지로 이동, postListPage가 첫 화면 ##########
	@GetMapping("/")
	public String postListPage(Model model) { //Model 사용을 위해 선언
		System.out.println("여기오");
		// service 에서 생성한 객체 리스트 postList를 postList에 담는다
		List<PostListDto> postList = postService.getPostList();
		
		//(key, value) 형태를 지닌 model 객체를 이용하여 postList값을 view(postListPage.html)로 전달
		// => postList value를 postList 이름을 가진 key에 저장
		model.addAttribute("postList", postList); 
		
		return "board/post/postListPage.html";
	}
	
	// ########## 글 작성 페이지로 이동 ########## 
	@GetMapping("/postRegisterPage")
	public String postWritePage() {
		return "board/post/postRegisterPage.html";
	}

	// ########## 글 상세 페이지 이동 ########## 
	//RequestMappping Annotation으로 value 를 통해 request 받는다
	@RequestMapping(value = "/postDetailPage/{p_no}" , method = RequestMethod.GET )
	public String postDetailPage(
			@PathVariable("p_no") int p_no, //PathVariable : 클릭 시 해당 p_no값을 받아 오기 위한 annotation
			Model model
			) { 
		// PathVariable 을 통해 p_no 받아온다
		// 해당 p_no의 글 정보 가져온다
		PostDetailDto postDetail = postService.getPostDetail(p_no);

		System.out.println("@@@@@@@@@@@@@@@@@ p_no값 넘어 오는지 컨트롤러 테스트 : "+p_no);
		
		model.addAttribute("postDetail", postDetail);
		return "board/post/postDetailPage.html";
	}	
	
	// ########## 글 수정 페이지로 이동 ########## 
	@GetMapping("/postEditPage")
	public String postEditPage() {
		return "board/post/postEditPage.html";
	}
	
	// ########## 글 등록 ##########  
	//RequestMapping method post -> PostMapping annotation으로 해결
	@PostMapping("/postRegister")
	public String postRegister (PostRegisterDto postRegisterDto) { // 게시글 등록 dto 선언
		// 값들고오는지 확인
		System.out.println(postRegisterDto.getP_title());
		System.out.println(postRegisterDto.getP_content());
		System.out.println("글 등록 확인@@@@@@@@@@@@@@@@@@@");
		
		return "redirect:/";
		
	}
	
}
