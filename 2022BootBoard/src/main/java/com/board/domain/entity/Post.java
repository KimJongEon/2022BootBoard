package com.board.domain.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//컬럼에 대한 setter를 무작정 생성하는 경우, 객체의 값이 어느 시점에 변경되었는지 알 수가 없다
// 이러한 이유로 Entity 클래스에는 절대로 Set 메서드가 존재해서는 안된다
@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@Entity
@Table(name = "POST_TB")
public class Post {
	
	@Id // PK 지정 Annotation
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동 증가(auto increment) 지원 Annotation -> auto_increment 사용을 위해 선언필요
	private int p_no; // PK
	
	private String mbr_id; // 아이디
	private String p_title; // 제목
	private String p_content; // 내용
	private Timestamp p_dt; // 작성 시간
	private int p_read_cnt; // 조회수
	
	@Builder
	public Post(String mbr_id, String p_title, String p_content, Timestamp p_dt, int p_read_cnt) {
		
		this.mbr_id = mbr_id;
		this.p_title = p_title;
		this.p_content = p_content;
		this.p_dt = p_dt;
		this.p_read_cnt = p_read_cnt;
	}
}
