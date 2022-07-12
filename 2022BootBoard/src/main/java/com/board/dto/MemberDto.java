package com.board.dto;

import java.time.LocalDateTime;

import com.board.domain.entity.MemberEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class MemberDto {
	//inner class
	
	@Getter
	@Setter
	@Builder
	public static class SignUpDto{ // 회원가입 Dto
		private String mbrId; // pk
		private String mbr_pwd; // 비밀번호
		private String mbr_nm; // 이름
		private String tel_no; // 전화번호 (휴대폰번호)
//		private String mbr_role; // 회원 권한
		private LocalDateTime signup_dt; // 회원가입 일시
	
		//toEntity()는 전달받은 객체를 Entity로 간편하게 바꿔주는 메서드
        //JPA를 이용해서 객체를 저장할때 Entity의 형태로 저장해줘야 되므로
		//변환용 메서드를 만듦
		public MemberEntity toEntity(){
			MemberEntity memberEntity = MemberEntity.builder()
//			return MemberEntity.builder()
				.mbrId(mbrId)
				.mbr_pwd(mbr_pwd)
				.mbr_nm(mbr_nm)
				.tel_no(tel_no)
//				.mbr_role(mbr_role)
				.build();
			return memberEntity;
			
		} // Member toEntity() End
	} // SignUpDto End
	
}
