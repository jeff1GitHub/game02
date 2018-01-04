package com.sf.account.controller;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.account.bean.ResultInfo;
import com.sf.account.bean.User;
import com.sf.account.service.UserService;

@RestController
public class UserController {
	@Resource
	private UserService userService;

	@RequestMapping(value = "/register")
	public ResultInfo<Object> registerUser(@Validated User user) {
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
	public ResultInfo<Object> login(@RequestParam String name) {
		User user = userService.login(name);
		
		ResultInfo<Object> resultInfo;
		if(user == null){
			resultInfo = new ResultInfo<>(11, "账号或密码错误!");
		}else{
			resultInfo = new ResultInfo<>(1, "success", user);
		}
		return resultInfo;
	}
	
	@RequestMapping(value = "/user")
	public ResultInfo<Object> user(@RequestParam String name) {
		User user = userService.getUserByName(name);
		
		ResultInfo<Object> resultInfo;
		if(user == null){
			resultInfo = new ResultInfo<>(11, "账号不存在!");
		}else{
			resultInfo = new ResultInfo<>(1, "success", user);
		}
		return resultInfo;
	}
	
}
