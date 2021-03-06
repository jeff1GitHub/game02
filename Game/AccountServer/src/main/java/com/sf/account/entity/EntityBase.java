package com.sf.account.entity;

import com.sf.account.bean.BeanBase;

/**
 * Entity的基类
 */
public abstract class EntityBase {

	/**
	 * 将此Entity类转成对应的Bean类
	 * @return Bean类
	 */
	public abstract BeanBase toBean();
	
}
