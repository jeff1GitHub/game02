package com.sf.account.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sf.account.bean.PageInfo;
import com.sf.account.bean.User;
import com.sf.account.dao.IUserDao;
import com.sf.account.entity.UserEntity;

@Service
public class UserService {
	@Resource
	private IUserDao userDao;
	
	public boolean registerUser(User user) {
		UserEntity entity = (UserEntity)user.toEntity();
		Integer result = userDao.addUser(entity);
		return result != null && result  == 1;
	}
	
	public User login(String account, String pwd) {
		UserEntity entity = userDao.selectUser(account);
		if(entity == null){
			return null;
		}else if(entity.getPwd().equals(pwd)){
			User user = new User();
			user.init(entity.getId(), entity.getAccount(), entity.getPwd());
			return user;
		}else{
			return null;
		}
	}
	
	public PageInfo getUsers(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<UserEntity> page = (Page<UserEntity>)userDao.selectUserPage();
		PageInfo pageInfo = new PageInfo(page);
		return pageInfo;
	}
	
}
