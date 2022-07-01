package com.board.dto;

import java.sql.Timestamp;


import com.board.domain.entity.PostEntity;

import lombok.Builder;
import lombok.Getter;

//@Getter
public class PostDto {
	// inner class 적용
	
	@Getter
	@Builder
	public static class PostListDto{  //게시글 조회 Dto
		private int p_no; // PK
		private String mbr_id; // 아이디
		private String p_title; // 제목
		private Timestamp p_dt; // 작성 시간
		private int p_read_cnt; // 조회수
	} // PostListDto End
	
	@Getter
	@Builder
	public static class PostDetailDto{ // 게시글 상세 페이지 Dto
		private int p_no; //PK
		private String mbr_id; // 아이디
		private String p_title; // 제목
		private String p_content; //내용
		private Timestamp p_dt; // 작성 시간
		private int p_read_cnt; // 조회
	} // PostDetailDto End
	
	
//	@Getter
//	@Builder
//	public static class PostSaveDto{ // 게시글 저장 Dto
//		private int p_no; // PK
//		private String mbr_id; // 아이디
//		private String p_title; // 제목
//		private String p_content; // 글 내용
//		private Timestamp p_dt; // 작성 시간
//		private int p_read_cnt; // 조회수
//		
//		/* Dto -> Entity */
//		public PostEntity toEntity() {
////			return PostEntity.builder();
//			PostEntity postEntity = PostEntity.builder()
//					.p_no(p_no)
//					.mbr_id(mbr_id)
////					.p_title(p_title)
//					.p_content(p_content)
//					.p_dt(p_dt)
//					.p_read_cnt(p_read_cnt)
//					.build();
//			return postEntity;
//		} // Post toEntity End
//	} //PostSaveDto End
}
