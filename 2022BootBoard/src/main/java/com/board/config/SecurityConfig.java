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
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.board.handler.MyLoginSuccessHandler;
import com.board.service.LogInService;

import lombok.AllArgsConstructor;

@EnableWebSecurity // Security filter가 등록
@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private LogInService logInService; // 로그인 서비스 사용을 위해 선언
	private AuthenticationFailureHandler authenticationFailureHandler;
	
	// 사용자 비밀번호를 RAW 데이터가 아닌 Hashing(+Salt)이 완료된 비밀번호 값으로 저장
	// PasswordEncoder 인터페이스
	@Bean // Service에서 비밀번호를 암호화 할 수 있도록 Bean으로 등록
	public PasswordEncoder passwordEncoder () {
		System.out.println("SecurityConfig - PasswordEncoder 확인 @@@@@");
		// *BCryptPasswordEncoder 
		// 스프링 시큐리티(Spring Seurity) 프레임워크에서 제공하는 클래스 중 하나로 비밀번호를 암호화하는 데 사용할 수 있는 메서드를 가진 클래스
		return new BCryptPasswordEncoder();
	} // PasswordEncoder End
	
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
			// csrf 토큰 비활성화(테스트시 해놓는게 편함), Security는 csrf토큰이 있어야 접근가능
			.csrf().disable() 
			.authorizeRequests() // ########## (경로) 권한 설정 ##########
//				.antMatchers("/admin/**").hasRole("ADMIN") // admin 으로 시작하는 경로는 ADMIN 롤을 가진 사용자만 접근 가능
				.antMatchers("/**").permitAll() // 모든 경로에 대해 권한 없이 접근 가능
				
			.and().formLogin() // ########## 로그인 설정 ##########
				.usernameParameter("mbrEmail") // 아이디 파라미터 [기본 값 "username"] -> "mbrEmail" 변경
				.passwordParameter("mbrPassword") // 비밀번호 파라미터 [기본 값 "password"] -> "mbrPassword" 변경
				.loginPage("/") // 로그인 URL 
				.loginProcessingUrl("/securityLogIn") //Spring Security 가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인해줌(서비스의 loadUserByUsername로 알아서)
//				.defaultSuccessUrl("/", true) // 로그인 성공시 이동하게 되는 URL *컨트롤러에 해당 URL 맵핑 되어 있어야함 '/'가 첫 페이지인 postListPage로 맵핑되어있음
				.successHandler(new MyLoginSuccessHandler())
				.failureHandler(authenticationFailureHandler)
//				.failureUrl("/signUpPage") // 로그인 실패시 이동하게 되는 URL
				.permitAll() // 로그인,로그아웃시 이동하게 되는 URL 은 권한 없이 접근 가능
				
			.and().logout() // ########## 로그아웃 설정 ##########
				.logoutRequestMatcher(new AntPathRequestMatcher("/securityLogOut")) // 로그아웃 URL 설정 , Controller로 가지 않고 가로 챔
				.logoutSuccessUrl("/") // 로그아웃 성공시 이동하게 되는 URL *마찬가지로 컨트롤러에 해당 URL 맵핑 되어 있어야함
				.invalidateHttpSession(true); // 로그아웃시 HTTP 세션을 초기화
	
		//중복 로그인 체크
		http.sessionManagement()
			.maximumSessions(1) // 세션 최대 허용 수
			.maxSessionsPreventsLogin(false); // false : 중복 로그인하면 이전 로그인이 풀림
	
	
	} // configure(HttpSecurity http) End
	
	
	// * Spring Security에서 모든 인증은 AuthenticationManager를 통해 이루어짐
	// * AuthenticationManager를 생성하기 위해 AuthenticationManagerBuilder를 사용
	// 1. 로그인 인증을 위해 UserDetailService를 통해 필요한 정보드를 가져오는데 서비스 클래스(logInService)에서 처리
	// 2. 서비스 클래스(logInService)에서는 UserDetailsService인터페이스를 implements하여 loadUserByUsername() 메서드 구현
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("SecurityConfig - AuthenticationManager : 확인 @@@@@");
		auth.userDetailsService(logInService);
//        auth.userDetailsService(logInService).passwordEncoder(passwordEncoder());
    }
}
