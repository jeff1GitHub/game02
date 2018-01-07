package com.sf.account.bean;

import java.io.Serializable;

import com.sf.account.entity.EntityBase;

public abstract class BeanBase implements Serializable {
	private static final long serialVersionUID = 1L;

	public abstract EntityBase toEntity();
	
}
