package com.security.gurume365.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.security.gurume365.dao.UsersDAO;
import com.security.gurume365.vo.Users;

@Service

public class CustomUserDetailsService implements UserDetailsService {

	@Inject
	UsersDAO dao;
//시작ㅇㅇㅇ
	@Override
	public Users loadUserByUsername(String username) throws UsernameNotFoundException {
		// 디비에서 유저정보를 불러오는 메소드. 이것을 AutenticationProvider에서 인증을 통함
		Users userInfo = null;
		try {
			// userInfo = dao.selectUsers(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}
}
