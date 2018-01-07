package com.sf.account.controller;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.account.bean.PageInfo;
import com.sf.account.bean.User;
import com.sf.account.service.RedisServiceImpl;
import com.sf.account.service.UserService;
import com.sf.account.vo.ResultInfo;
import com.sf.account.vo.UserVo;

@RestController
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private RedisServiceImpl redisServiceImpl;

	@RequestMapping(value = "/register")
	public ResultInfo<Object> registerUser(@Validated UserVo vo) {
		User user = new User();
		user.init(0, vo.getAccount(), vo.getPwd());
		boolean res = userService.registerUser(user);
		
		ResultInfo<Object> resultInfo;
		if(res){
			resultInfo = new ResultInfo<>(1, "register success.");
		}else{
			resultInfo = new ResultInfo<>(11, "register failed.");
		}
		return resultInfo;
	}
	
	@RequestMapping(value = "/login")
	public ResultInfo<Object> login(String account, String pwd) {
		User user = userService.login(account, pwd);
		
		ResultInfo<Object> resultInfo;
		if(user == null){
			resultInfo = new ResultInfo<>(11, "账号或密码错误!");
		}else{
			redisServiceImpl.set("aa", user);
			resultInfo = new ResultInfo<>(1, "success", user);
		}
		return resultInfo;
	}
	
	@RequestMapping(value = "/users")
	public ResultInfo<PageInfo<User>> users(int pageNum) {
		User user = (User)redisServiceImpl.get("aa");
		if(user == null){
			ResultInfo<PageInfo<User>> resultInfo = new ResultInfo<>(-1, "error.");
			return resultInfo;
		}
		PageInfo<User> pageInfo = userService.getUsers(pageNum, 2);
		ResultInfo<PageInfo<User>> resultInfo = new ResultInfo<PageInfo<User>>(1, "success", pageInfo);
		return resultInfo;
	}
	
}
