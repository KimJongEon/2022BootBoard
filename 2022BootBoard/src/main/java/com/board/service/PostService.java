package com.board.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.board.domain.entity.PostEntity;
import com.board.domain.entity.PostRepository;
import com.board.dto.PostDto.PostListDto;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class PostService {
	private PostRepository postRepository;
	
	//PostDto inner class 적용
//	@Transactional
//	@Transactional(rollbackFor = Exception.class) 
	public List<PostListDto> getPostList(){
		
		//postEntities에 findall 메소드를 사용하여 PostEntity 의 데이터 전부를 가져온다
        List<PostEntity> postEntities = postRepository.findAll();
        
        //postList -> ArrayList로 선언
        List<PostListDto> postList = new ArrayList<>();
        
        for ( PostEntity postEntity : postEntities) { // for A : B -> B에서 차례대로 객체를 꺼내서 A에 넣겠다.
            PostListDto postListDto = PostListDto.builder()
            		.p_no(postEntity.getP_no())
                    .mbr_id(postEntity.getMbr_id())
                    .p_title(postEntity.getP_title())
                    .p_dt(postEntity.getP_dt())
                    .p_read_cnt(postEntity.getP_read_cnt())
                    .build();

            postList.add(postListDto);
        }
		
		return postList;
	} //getPostList End
}
