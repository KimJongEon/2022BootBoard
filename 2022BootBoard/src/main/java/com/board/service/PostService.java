package com.board.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.board.domain.entity.PostEntity;
import com.board.domain.entity.PostRepository;
import com.board.dto.PostDto;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class PostService {
	private PostRepository postRepository;
	 
	@Transactional
	public List<PostDto> getPostList(){

        List<PostEntity> postEntities = postRepository.findAll();
        List<PostDto> postDtoList = new ArrayList<>();
        
        for ( PostEntity postEntity : postEntities) {
            PostDto postDto = PostDto.builder()
            		.p_no(postEntity.getP_no())
                    .mbr_id(postEntity.getMbr_id())
                    .p_title(postEntity.getP_title())
                    .p_content(postEntity.getP_content())
                    .p_dt(postEntity.getP_dt())
                    .p_read_cnt(postEntity.getP_read_cnt())
                    .build();

            postDtoList.add(postDto);
        }
		System.out.println(postDtoList);
		System.out.println("서비스 테스트");
		
		return postDtoList;
	} //getPostList 끝
}
