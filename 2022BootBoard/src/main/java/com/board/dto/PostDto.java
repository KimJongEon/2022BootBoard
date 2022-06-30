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
	public static class PostListDto{ //게시글 조회 Dto
		private int p_no; // PK
		private String mbr_id; // 아이디
		private String p_title; // 제목
		private Timestamp p_dt; // 작성 시간
		private int p_read_cnt; // 조회수
	}
}
