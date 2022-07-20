package com.board.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

//########## 데이터 조작 시 자동으로 날짜를 수정해주는 JPA의 Auditing 기능을 사용

@Getter
@MappedSuperclass // Table로 매핑하지 않고, 자식 클래스(엔티티)에게 매핑 정보를 상속 하기 위한 어노테이션
@EntityListeners(AuditingEntityListener.class) // JPA에게 해당 엔티티(PostTimeEntity) 는 Auditing 기능을 사용 한다는 것을 알리는 어노테이션
public abstract class MemberTimeEntity {
	
	@CreatedDate
	@Column(name = "signupDate", updatable = false)
	private LocalDateTime signupDate;

}
