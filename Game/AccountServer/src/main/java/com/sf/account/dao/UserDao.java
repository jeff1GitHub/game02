package com.sf.account.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sf.account.bean.User;

public interface UserDao {

	@Insert("insert into t_user(f_name, f_pwd) values(#{name}, #{pwd})")
	Integer addUser(User user);
	
	User selectUser(String name);
	
	@Select("SELECT f_id as id, f_name as name, f_pwd as pwd FROM t_user WHERE f_name = #{name}")
	User selectUserByName(String name);
	
}
