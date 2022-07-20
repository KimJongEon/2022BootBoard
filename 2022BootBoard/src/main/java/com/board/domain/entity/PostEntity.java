package com.board.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class PostEntity extends PostTimeEntity {
	
	@Id // PK 지정 Annotation
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동 증가(auto increment) 지원 Annotation -> auto_increment 사용을 위해 선언필요
	@Column(name = "postNumber")
	private Long postNumber; // PK
	
	@Column(name = "mbrIdx")
	private Long mbrIdx; // id ( auto increment)
	
	@Column(name = "postTitle")
	private String postTitle; // 제목
	
	@Column(name = "postContent")
	private String postContent; // 내용
	
	@Column(name = "postReadCount")
	private Long postReadCount; // 조회수
	
	
	@ManyToOne(targetEntity = MemberEntity.class, fetch = FetchType.LAZY)
	@JoinColumn(name="mbrIdx", referencedColumnName="mbrIdx", insertable=false, updatable=false)
//	// join시 해당 옵션 선언 하지 않으면 오류 발생 * insertable=false, updatable=false
//	// name과 referencedColumnName이 같으면 referencedColumnName 생략가능
	private  MemberEntity memberEntity;
	
	@Column(name = "mbrNickName")
	private String mbrNickName; // 닉네임
	
	@Builder
	public PostEntity(Long postNumber, Long mbrIdx, String postTitle, String postContent, Long postReadCount, String mbrNickName) {
		this.postNumber = postNumber;
		this.mbrIdx = mbrIdx;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postReadCount = postReadCount;
		this.mbrNickName = mbrNickName;
	}
	
}
