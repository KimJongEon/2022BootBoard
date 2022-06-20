package com.board.domain.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//컬럼에 대한 setter를 무작정 생성하는 경우, 객체의 값이 어느 시점에 변경되었는지 알 수가 없다
//이러한 이유로 Entity 클래스에는 절대로 Set 메서드가 존재해서는 안된다
@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MEMBER_TB")
public class Member {
	@Id // PK 지정 Annotation
	private String mbr_id; // pk
	
	private String mbr_pwd; // 비밀번호
	private String mbr_nm; // 이름
	private String tel_no; // 전화번호 (휴대폰번호)
	private Timestamp signup_dt; // 회원가입 일시
	private int mbr_type; // 회원 유형
	
	@Builder
	public Member(String mbr_id, String mbr_pwd, String mbr_nm, String tel_no, Timestamp signup_dt, int mbr_type) {
		this.mbr_id = mbr_id;
		this.mbr_pwd = mbr_pwd;
		this.mbr_nm = mbr_nm;
		this.tel_no = tel_no;
		this.signup_dt = signup_dt;
		this.mbr_type = mbr_type;
	}
	
}
