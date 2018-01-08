package com.sf.account.entity;

import java.sql.Date;

import com.sf.account.bean.BeanBase;
import com.sf.account.bean.User;

/**
 * 用户实体类
 */
public class UserEntity extends EntityBase {
	/** 唯一编号 */
	private long id;
	/** 账号 */
	private String account;
	/** 密码 */
	private String pwd;
	/** 名称 */
	private String name;
	/** 余额 */
	private float balance;
	/** 账号状态 */
	private byte status;
	/** 邮箱 */
	private String email;
	/** 登陆IP地址 */
	private String loginIp;
	/** 登陆时间 */
	private Date loginTime;
	/** 创建IP地址 */
	private String createIp;
	/** 创建时间 */
	private Date createTime;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getCreateIp() {
		return createIp;
	}

	public void setCreateIp(String createIp) {
		this.createIp = createIp;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public BeanBase toBean() {
		User user = new User();
		user.init(id, account, pwd);
		return user;
	}

}
