package com.board.dto;

import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
		private Long mbrIdx; // pk
		private String mbrEmail; // 실제 아이디 겸 이메일
		private String mbrPassword; // 비밀번호
		private String mbrNickName; // 닉네임
		private String mbrRole; // 회원 권한
		private LocalDateTime signupDate; // 회원가입 일시
		
//		toEntity()는 전달받은 객체를 Entity로 간편하게 바꿔주는 메서드
//        JPA를 이용해서 객체를 저장할때 Entity의 형태로 저장해줘야 되므로
//		변환용 메서드를 만듦
		public MemberEntity toEntity(){
			MemberEntity memberEntity = MemberEntity.builder()
//			return MemberEntity.builder()
				.mbrIdx(mbrIdx)
				.mbrEmail(mbrEmail)
				.mbrPassword(new BCryptPasswordEncoder().encode(mbrPassword)) // SpringSecurity 에서 제공하는 BCryptPasswordEncoder를 이용하여 비밀번호 암호화
				.mbrNickName(mbrNickName)
				.mbrRole(mbrRole)
				.build();
			return memberEntity;
		} // Member toEntity() End
	} // SignUpDto End
		
//		private Long mbrId; // pk
//		private String mbrEmail; // 실제 아이디 겸 이메일
//		private String mbrPassword; // 비밀번호
//		private String mbrName; // 이름
////		private String telNumber; // 전화번호 (휴대폰번호)
////		private String mbrRole; // 회원 권한
//		private LocalDateTime signupDate; // 회원가입 일시
	
		//toEntity()는 전달받은 객체를 Entity로 간편하게 바꿔주는 메서드
        //JPA를 이용해서 객체를 저장할때 Entity의 형태로 저장해줘야 되므로
		//변환용 메서드를 만듦
//		public MemberEntity toEntity(){
//			MemberEntity memberEntity = MemberEntity.builder()
////			return MemberEntity.builder()
//				.mbrId(mbrId)
//				.mbrEmail(mbrEmail)
//				.mbrPassword(mbrPassword)
//				.mbrName(mbrName)
//				.telNumber(telNumber)
////				.mbrRole(mbrRole)
//				.build();
//			return memberEntity;
//			
//		} // Member toEntity() End
//	} // SignUpDto End
	
}
