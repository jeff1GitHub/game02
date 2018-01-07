package com.sf.account.bean;

import com.sf.account.entity.EntityBase;
import com.sf.account.entity.UserEntity;

public class User extends BeanBase {
	private static final long serialVersionUID = 1L;
	/** 唯一编号 */
	private long id;
	/** 账号 */
	private String account;
	/** 密码 */
	private String pwd;

	public void init(long id, String account, String pwd){
		this.id = id;
		this.account = account;
		this.pwd = pwd;
	}

	public long getId() {
		return id;
	}

	public String getAccount() {
		return account;
	}

	public String getPwd() {
		return pwd;
	}

	@Override
	public EntityBase toEntity() {
		UserEntity entity = new UserEntity();
		entity.setId(id);
		entity.setAccount(account);
		entity.setPwd(pwd);
		return entity;
	}

}
