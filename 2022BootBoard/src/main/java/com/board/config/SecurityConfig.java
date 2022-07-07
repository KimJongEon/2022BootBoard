package com.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.board.service.SignUpService;

import lombok.AllArgsConstructor;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private SignUpService signUpService; // 비밀번호 암호화를 위해 선언
	
	// 사용자 비밀번호를 RAW 데이터가 아닌 Hashing(+Salt)이 완료된 비밀번호 값으로 저장
	// PasswordEncoder 인터페이스
//	@Bean
//	public PasswordEncoder passwordEncoder () {
//		System.out.println("PasswordEncoder 확인@@@@@@@@");
//		// *BCryptPasswordEncoder 
//		// 스프링 시큐리티(Spring Seurity) 프레임워크에서 제공하는 클래스 중 하나로 비밀번호를 암호화하는 데 사용할 수 있는 메서드를 가진 클래스
//		return new BCryptPasswordEncoder();
//	} // PasswordEncoder End
	
	// WebSecurity는 FilterChainProxy를 생성하는 필터
	// 해당 경로의 파일들은 Spring Security가 무시할 수 있도록 설정
	@Override //web ignore를 위해 configure(WebSecurity web) 메소드 오버라이드
	public void configure(WebSecurity web) throws Exception { // 예외처리
		// permitAll은 FilterSecurityInterceptor를 거쳐 DispatcherServlet으로 넘어간다
		// 똑같이 인증이 필요 없지만 Spring Security 가 제공하는 보안필터를 거친다.
		// 반대로 web ignore는 Spring Security 가 제공하는 Filter를 거치지 않는다. 
		
		// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**"); // resources/static 아래 하위 폴더 기준
	} // onfigure(WebSecurity web) End
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf().disable()
			.authorizeRequests() // ########## (경로) 권한 설정 ##########
//				.antMatchers("/admin/**").hasRole("ADMIN") // admin 으로 시작하는 경로는 ADMIN 롤을 가진 사용자만 접근 가능
				.antMatchers("/**").permitAll() // 모든 경로에 대해 권한 없이 접근 가능
				
			.and().formLogin() // ########## 로그인 설정 ##########
				.loginPage("/board/login/logInPage") // 로그인 URL
				.defaultSuccessUrl("/") // 로그인 성공시 이동하게 되는 URL *컨트롤러에 해당 URL 맵핑 되어 있어야함 '/'가 첫 페이지인 postListPage로 맵핑되어있음
				.permitAll() // 로그인,로그아웃시 이동하게 되는 URL 은 권한 없이 접근 가능
				
			.and().logout() // ########## 로그아웃 설정 ##########
				.logoutRequestMatcher(new AntPathRequestMatcher("/logOut")) // 로그아웃 URL 설정
				.logoutSuccessUrl("/") // 로그아웃 성공시 이동하게 되는 URL *마찬가지로 컨트롤러에 해당 URL 맵핑 되어 있어야함
				.invalidateHttpSession(true); // 로그아웃시 HTTP 세션을 초기화
	} // configure(HttpSecurity http) End
	
	
//	@Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(signUpService).passwordEncoder(passwordEncoder());
//    }
}
