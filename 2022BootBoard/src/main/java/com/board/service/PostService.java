package com.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.board.domain.entity.MemberEntity;
import com.board.domain.entity.PostEntity;
import com.board.domain.entity.PostRepository;
import com.board.dto.PostDto.PostDetailDto;
import com.board.dto.PostDto.PostListDto;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class PostService {
	private final PostRepository postRepository;
	
	// ########## 글목록 service ########## 
//	@Transactional
//	@Transactional(rollbackFor = Exception.class) 
	public List<PostListDto> getPostList(){
		//postEntities에 findall 메소드를 사용하여 PostEntity 의 데이터 전부를 가져온다
//        List<PostEntity> postEntities = postRepository.findAll();
        List<PostEntity> postEntities = postRepository.findAllPost();
        
        //postList -> ArrayList로 선언
        List<PostListDto> postList = new ArrayList<>();
        
        for ( PostEntity postEntity : postEntities) { // for A : B -> B에서 차례대로 객체를 꺼내서 A에 넣겠다.
        	System.out.println("여기오는지@@@@@@@@@2");
            PostListDto postListDto = PostListDto.builder()
            		.postNumber(postEntity.getPostNumber())
            		.mbrIdx(postEntity.getMbrIdx())
                    .mbrNickName(postEntity.getMbrNickName())
                    .postTitle(postEntity.getPostTitle())
                    .postDate(postEntity.getPostDate())
                    .postReadCount(postEntity.getPostReadCount())
                    .build();
            
            // postList A객체에 배열 0 1 2 3 4 에 데이터를 담고 저장/ B객체에 배열 0 1 2 3 4 에 데이터를 담고 저장
            postList.add(postListDto);
        } // for End
		
		return postList; // 데이터를 다 담고 리스트 객체 postList 컨트롤러로 return
	} //getPostList End
	
//	// ########## 글 상세페이지 service ########## 
//	public PostDetailDto getPostDetail(Long postNumber) {
//		 // findById - PK 값을 where 조건으로 하여, 데이터를 가져오기 위한 메서드이며, JpaRepository 인터페이스에서 정의되어 있다
//		Optional<PostEntity> postEntityWrapper = postRepository.findById(postNumber);
//		
//		// 반환 값은 Optional 타입인데, 엔티티를 가져오려면 boardEntityWrapper.get(); 이렇게 get() 메서드를 사용해서 가져온다
//		PostEntity postEntity = postEntityWrapper.get();
//		
//		// 가져온 p_no에 해당하는 글의 데이터를 담아서 postDetailDto에 저장하고 return
//        PostDetailDto postDetailDto = PostDetailDto.builder()
//        		.postNumber(postEntity.getPostNumber())
//        		.mbrIdx(postEntity.getMbrIdx())
////        		.mbrEmail(postEntity.getMbrEmail())
//                .postTitle(postEntity.getPostTitle())
//                .postContent(postEntity.getPostContent())
//                .postDate(postEntity.getPostDate())
//                .postReadCount(postEntity.getPostReadCount())
//                .build();
//
//		return postDetailDto;
//	} //getPostDetail End
}
