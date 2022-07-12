package com.board.domain.entity;


import javax.persistence.Column;
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
@NoArgsConstructor( access = AccessLevel.PROTECTED) //protected로 변경하면 new Member() 사용을 막을 수 있어 객체의 일관성을 더 유지할 수 있다.
@Entity
@Table(name = "MEMBER_TB")
public class MemberEntity extends MemberTimeEntity {
	
	@Id // PK 지정 Annotation
	@Column(name = "mbr_id") // memberRepository 에서 findBy~컬럼명 할 때 _(언더바) 인식을 못해서 Column annotation으로 컬럼명 지정함
	private String mbrId; // pk
	
	@Column(name = "mbr_pwd")
	private String mbr_pwd; // 비밀번호
	
	@Column(name = "mbr_nm")
	private String mbr_nm; // 이름
	
	@Column(name = "tel_no")
	private String tel_no; // 전화번호 (휴대폰번호)
	
	@Column(name = "mbr_role")
	private String mbr_role; // 회원 유형
	
	@Builder
	public MemberEntity(String mbrId, String mbr_pwd, String mbr_nm, String tel_no, String mbr_role) {
		this.mbrId = mbrId;
		this.mbr_pwd = mbr_pwd;
		this.mbr_nm = mbr_nm;
		this.tel_no = tel_no;
		this.mbr_role = mbr_role;
	}
	
}
