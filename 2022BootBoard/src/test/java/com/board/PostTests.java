package com.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.entity.PostEntity;
import com.board.domain.entity.PostRepository;

@SpringBootTest
public class PostTests {
	
	@Autowired
	PostRepository postRepository;
	
	@Test
	void save() {
		//게시글 저장에 이용되는 params는 빌더(Builder) 패턴을 통해 생성된 객체

        // 1. 게시글 파라미터 생성
        PostEntity params = PostEntity.builder()
                .p_title("1번 게시글 제목")
                .p_content("1번 게시글 내용")
                .mbr_id("JongEonTest")
                .p_read_cnt(0)
//                .deleteYn('N')
                .build();

        // 2. 게시글 저장
        postRepository.save(params);

        // 3. 1번 게시글 정보 조회
        PostEntity entity = postRepository.findById((int) 1).get();
        assertThat(entity.getP_title()).isEqualTo("1번 게시글 제목");
        assertThat(entity.getP_content()).isEqualTo("1번 게시글 내용");
        assertThat(entity.getMbr_id()).isEqualTo("JongEonTest");
	} // Save  End
}
