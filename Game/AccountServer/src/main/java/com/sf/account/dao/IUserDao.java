package com.sf.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sf.account.entity.UserEntity;

public interface IUserDao {

	@Insert("insert into t_user(f_account, f_pwd) values(#{account}, #{pwd})")
	Integer addUser(UserEntity user);
	
	UserEntity selectUser(String account);
	
	@Select("SELECT f_id as id, f_account account, f_pwd pwd FROM t_user order by f_id")
	List<UserEntity> selectUserPage();
	
}
