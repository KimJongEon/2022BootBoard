package com.board.dto;

import java.sql.Timestamp;


import com.board.domain.entity.PostEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
//Dto - Request, Response 모두 만들면 복잡해져서
//inner class로 구현
public class PostDto {
	private int p_no; // PK
	private String mbr_id; // 아이디
	private String p_title; // 제목
	private String p_content; // 내용
	private Timestamp p_dt; // 작성 시간
	private int p_read_cnt; // 조회수
	
	/* Dto -> Entity */
	public PostEntity toEntity() {
		PostEntity postEntity = PostEntity.builder()
				.p_no(p_no)
				.mbr_id(mbr_id)
				.p_title(p_title)
				.p_content(p_content)
				.p_dt(p_dt)
				.p_read_cnt(p_read_cnt)
				.build();
		return postEntity;
	} // Post toEntity 끝
	
	@Builder
	public PostDto(int p_no, String mbr_id, String p_title, String p_content, Timestamp p_dt, int p_read_cnt ) {
		this.p_no = p_no;
		this.mbr_id = mbr_id;
		this.p_title = p_title;
		this.p_content = p_content;
		this.p_dt = p_dt;
		this.p_read_cnt = p_read_cnt;
	}	
	
//	// 글 조회시 사용될 Dto
//	@Getter
//	public static class PostListResponse {
//		private int p_no; // PK
//
//		private String mbr_id; // 아이디
//		private String p_title; // 제목
////		private String p_content; // 내용
//		private Timestamp p_dt; // 작성 시간
//		private int p_read_cnt; // 조회수
//
//		/* Dto -> Entity */
//		public Post toEntity() {
//			Post post = Post.builder()
//					.mbr_id(mbr_id)
//					.p_title(p_title)
//					.p_dt(p_dt)
//					.p_read_cnt(p_read_cnt)
//					.build();
//			return post;
//		} // Post toEntity 끝
//		
//		@Builder
//		public PostListResponse(String mbr_id, String p_title, Timestamp p_dt, int p_read_cnt ) {
//			this.mbr_id = mbr_id;
//			this.p_title = p_title;
//			this.p_dt = p_dt;
//			this.p_read_cnt = p_read_cnt;
//		}
//		
//	} // PostListResponse 
}
