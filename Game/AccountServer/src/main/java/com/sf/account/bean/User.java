package com.sf.account.bean;

import org.hibernate.validator.constraints.NotBlank;

public class User {
	private int id;
	@NotBlank(message = "账号不能为空!")
	private String name;
	@NotBlank(message = "密码不能为空!")
	private String pwd;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
