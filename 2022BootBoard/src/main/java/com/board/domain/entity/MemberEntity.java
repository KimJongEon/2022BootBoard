package com.board.domain.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@GeneratedValue(strategy= GenerationType.IDENTITY) // Auto Increment 적용
	@Column(name = "mbrIdx") // memberRepository 에서 findBy~컬럼명 할 때 _(언더바) 인식을 못해서 Column annotation으로 컬럼명 지정함
	private Long mbrIdx; //PK
	
	@Column(name = "mbrEmail")
	private String mbrEmail; // 아이디 겸 이메일
	
	@Column(name = "mbrPassword")
	private String mbrPassword; // 비밀번호
	
	@Column(name = "mbrNickName")
	private String mbrNickName; // 회원 닉네임
	
	@Column(name = "mbrRole")
	private String mbrRole; // 회원, 관리자, 소셜 회원 구분
	
	@Builder
	public MemberEntity(Long mbrIdx, String mbrEmail, String mbrPassword, String mbrNickName, String mbrRole) {
		this.mbrIdx = mbrIdx;
		this.mbrEmail = mbrEmail;
		this.mbrPassword = mbrPassword;
		this.mbrNickName = mbrNickName;
		this.mbrRole = mbrRole;
	}
	
//	@Id // PK 지정 Annotation
//	@GeneratedValue(strategy= GenerationType.IDENTITY) // Auto Increment 적용
//	@Column(name = "mbrId") // memberRepository 에서 findBy~컬럼명 할 때 _(언더바) 인식을 못해서 Column annotation으로 컬럼명 지정함
//	private Long mbrId; // pk
//	
//	@Column(name = "mbrEmail")
//	private String mbrEmail; // 실제 아이디 겸 이메일
//	
//	@Column(name = "mbrPassword")
//	private String mbrPassword; // 비밀번호
//	
//	@Column(name = "mbrName")
//	private String mbrName; // 이름
//	
//	@Column(name = "telNumber")
//	private String telNumber; // 전화번호 (휴대폰번호)
//	
//	@Column(name = "mbrRole")
//	private String mbrRole; // 회원 유형
//	
////	@OneToMany(mappedBy ="memberEntity")
////	private List<MemberEntity> memberEntity = new ArrayList<MemberEntity>();
//	
//	@Builder
//	public MemberEntity(Long mbrId, String mbrEmail, String mbrPassword, String mbrName, String telNumber, String mbrRole) {
//		this.mbrId = mbrId;
//		this.mbrEmail = mbrEmail;
//		this.mbrPassword = mbrPassword;
//		this.mbrName = mbrName;
//		this.telNumber = telNumber;
//		this.mbrRole = mbrRole;
//	}
	
}
