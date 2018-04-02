package com.security.gurume365.security;



import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.security.gurume365.vo.Users;


//인증을 하기 위해서 UserDetailService를 이용해서 디비에서 유저정보를 읽어온다.
//이러한 정보를 입력한 정보와 비교해서 인증에 성공하면 Authentication을 돌려준다. 아니면 exception
@Component
public class CustomAuthenticationProvider 
implements AuthenticationProvider{
	
	@Autowired(required=true)
	private CustomUserDetailsService customUserDetailsService;
	
	public CustomAuthenticationProvider() {
        super();
    }
	
	@Override
	public Authentication authenticate(Authentication authentication)
	throws AuthenticationException{
		//유저정보 + 아이디 비밀번호 토큰
		UsernamePasswordAuthenticationToken authToken = 
				(UsernamePasswordAuthenticationToken) authentication;
		//UserDetailsService에서 디비를 거쳐서 유저정보를 불러옴
		Users userInfo = customUserDetailsService.loadUserByUsername(authToken.getName());
		if(userInfo == null){
			throw new UsernameNotFoundException(authToken.getName());
		}
		
		if (!matchPassword(userInfo.getPassword(), authToken.getCredentials())) {  
			throw new BadCredentialsException("not matching username or password");
		}
		//유저가 가진 권한을 읽어온다.
		List<GrantedAuthority> authorities = (List<GrantedAuthority>)userInfo.getAuthorities();
		
		return new UsernamePasswordAuthenticationToken(userInfo, null, authorities);
		
		/*ㄴㅇㅇㅇ
		final String name = authentication.getName();
		final String password = authentication.getCredentials().toString();
		if(name.equals("admin") && password.equals("system")){
			final List<GrantedAuthority> grantedAuths =new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
			final UserDetails principal = new User(name,password,grantedAuths);
			final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
			return auth;
		}else {
			return null;
		}*/
		
		
	}
	private boolean matchPassword(String password, Object credentials) {
		return password.equals(credentials);
	}
	 @Override
	    public boolean supports(Class<?> authentication) {
	        return authentication.equals(
	          UsernamePasswordAuthenticationToken.class);
	    }
}