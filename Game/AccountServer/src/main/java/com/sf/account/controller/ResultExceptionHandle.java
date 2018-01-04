package com.sf.account.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sf.account.bean.ResultInfo;

@RestControllerAdvice
public class ResultExceptionHandle {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultInfo<Object> MethodArgumentNotValidHandler(HttpServletRequest request, Exception e) throws Exception {
		if(e instanceof BindException){
			BindException exc = (BindException)e;
			String errMsg = exc.getBindingResult().getFieldError().getDefaultMessage();
			return new ResultInfo<>(-2, errMsg);
		}else{
			e.printStackTrace();
			return new ResultInfo<>(-1, "未知错误");
		}
	}
	
}
