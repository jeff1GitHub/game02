package com.sf.account.vo;

public class ResultInfo<T> {
	private int code;
	private String msg;
	private T data;
	
	public ResultInfo(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResultInfo(int code, String msg, T data) {
		this(code, msg);
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}
	
}
