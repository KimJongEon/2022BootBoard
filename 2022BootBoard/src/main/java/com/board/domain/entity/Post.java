package com.board.domain.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Table(name = "POST_TB")
public class Post {
	
	@Id // PK 지정 Annotation
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동 증가(auto increment) 지원 Annotation -> auto_increment 사용을 위해 선언필요
	private int p_no; // PK
	
	private String mbr_id;
	private String p_title;
	private String p_content;
	private Timestamp p_dt;
	private int p_read_cnt;
	
	@Builder
	public Post(int p_no, String mbr_id, String p_title, String p_content, Timestamp p_dt, int p_read_cnt) {
		this.mbr_id = mbr_id;
		this.p_title = p_title;
		
		
	}
}
