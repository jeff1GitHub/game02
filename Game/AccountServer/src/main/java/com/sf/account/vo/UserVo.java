package com.sf.account.vo;

import org.hibernate.validator.constraints.NotBlank;

public class UserVo {
	/** 唯一编号 */
	private long id;
	/** 账号 */
	@NotBlank(message = "账号不能为空!")
	private String account;
	/** 密码 */
	@NotBlank(message = "密码不能为空!")
	private String pwd;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
