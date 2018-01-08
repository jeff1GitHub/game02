package com.sf.lottery.bean;

import java.io.Serializable;

import com.sf.lottery.entity.EntityBase;

/**
 * Bean的基类
 */
public abstract class BeanBase implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 将此Bean类转成对应的Entity类
	 * @return Entity类
	 */
	public abstract EntityBase toEntity();
	
}
