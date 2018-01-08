package com.sf.lottery.entity;

import com.sf.lottery.bean.BeanBase;

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
