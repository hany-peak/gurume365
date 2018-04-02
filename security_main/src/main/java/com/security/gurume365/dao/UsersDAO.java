package com.security.gurume365.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.gurume365.mapper.UsersMapper;
import com.security.gurume365.vo.Users;

@Repository
public class UsersDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public void insertUsers(Users users){
		UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
		try{
			usersMapper.insertUsers(users);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Users selectUsers(String id){
		UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
		Users users = new Users();
		try{
			users = mapper.selectUsers(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return users;
	}
}
