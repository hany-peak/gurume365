package com.security.gurume365.mapper;

import com.security.gurume365.vo.Users;

public interface UsersMapper {
	public void insertUsers(Users users);
	
	public Users selectUsers(String id);
}
