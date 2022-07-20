package com.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.board.domain.entity.MemberEntity;
import com.board.domain.entity.MemberRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LogInService implements UserDetailsService{
	private final MemberRepository memberRepository;
	
	
	// loadUserByUsername : 상세 정보 조회 메소드
	// 사용자의 계정정보와 권한을 갖는 UserDetails 인터페이스를 반환하여야 함
	@Override
	public UserDetails loadUserByUsername(String mbrEmail) throws UsernameNotFoundException { // mbrEmail 사용
	    
		MemberEntity memberEntity = memberRepository.findByMbrEmail(mbrEmail);

	    List<GrantedAuthority> authorities = new ArrayList<>();
	    authorities.add(new SimpleGrantedAuthority("AuthorityTest")); //Granted Authorities = admin 으로 임시 설정
		
		if(memberEntity == null) {
			throw new UsernameNotFoundException("User Null 임");
		}
		
		return new User(memberEntity.getMbrEmail(), memberEntity.getMbrPassword(), authorities ); // UserDetails 인터페이스를 반환, authorities 권한 임시 부여
	} // loadUserByUsername End

	
} //LogInService End	
	

	//loadUserByUsername : 상세 정보 조회 메소드
	// 사용자의 계정정보와 권한을 갖는 UserDetails 인터페이스를 반환하여야 함
//	@Override
//	public UserDetails loadUserByUsername(String mbrEmail) throws UsernameNotFoundException { // mbrEmail 사용
//	    Optional<MemberEntity> memberEntityWrapper = memberRepository.findByMbrEmail(mbrEmail);
//	    MemberEntity memberEntity = memberEntityWrapper.get();
//	    
//	    List<GrantedAuthority> authorities = new ArrayList<>();
//	    authorities.add(new SimpleGrantedAuthority("AuthorityTest")); //Granted Authorities = admin 으로 임시 설정
//		System.out.println("LogInService : 여기 까지 오는지 @@@@@");
//		
//		System.out.println("AAAAAAA : "+new User(memberEntity.getMbrId(), memberEntity.getMbr_pwd(),  authorities )); // ,authorities
//		
////		try{ new User(memberEntity.getMbrId(), memberEntity.getMbr_pwd(), authorities);
////		throw new Exception(); //강제 에러 출력 
////		 }catch(Exception e){ 
////		e.printStackTrace(); 
////		}
//		
//		return new User(memberEntity.getMbrId(), memberEntity.getMbr_pwd(), authorities );  //UserDetails 인터페이스를 반환
//	} // loadUserByUsername End
//
//	
//} //LogInService End
