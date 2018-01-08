package com.sf.account.bean;

import java.sql.Date;

/**
 * 管理员信息类
 */
public class Manager {
	/** 唯一编号 */
	private long id;
	/** 密码 */
	private String pwd;
	/** 名称 */
	private String name;
	/** 登陆IP地址 */
	private String loginIp;
	/** 登陆时间 */
	private Date loginTime;
	/** 创建IP地址 */
	private String createIp;
	/** 创建时间 */
	private Date createTime;
}
