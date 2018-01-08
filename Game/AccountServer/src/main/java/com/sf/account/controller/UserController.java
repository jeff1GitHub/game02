package com.sf.account.controller;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.account.bean.PageInfo;
import com.sf.account.bean.User;
import com.sf.account.service.IRedisService;
import com.sf.account.service.UserService;
import com.sf.account.vo.ResultInfo;
import com.sf.account.vo.UserVo;

@RestController
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private IRedisService redisService;

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
			redisService.set("aa", user, -1);
			resultInfo = new ResultInfo<>(1, "success", user);
		}
		return resultInfo;
	}
	
	@RequestMapping(value = "/users")
	public ResultInfo<PageInfo> users(int pageNum) {
		User user = (User)redisService.get("aa");
		if(user == null){
			ResultInfo<PageInfo> resultInfo = new ResultInfo<>(-1, "error.");
			return resultInfo;
		}
		PageInfo pageInfo = userService.getUsers(pageNum, 2);
		ResultInfo<PageInfo> resultInfo = new ResultInfo<PageInfo>(1, "success", pageInfo);
		return resultInfo;
	}
	
}
