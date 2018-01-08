package com.sf.lottery.bean;

import com.github.pagehelper.Page;
import com.sf.lottery.entity.EntityBase;

/**
 * 分页信息类
 */
public class PageInfo {
	/** 当前页 */
	private int pageNum;
	/** 每页的数量 */
	private int pageSize;
	/** 总记录数 */
	private long total;
	/** 总页数 */
	private int pages;
	/** 结果集 */
	private Object[] result;

	public PageInfo(Page<? extends EntityBase> page) {
		this.pageNum = page.getPageNum();
		this.pageSize = page.getPageSize();
		this.total = page.getTotal();
		this.pages = page.getPages();
		this.result = new Object[page.size()];
		
		int index = -1;
		for(EntityBase e : page){
			result[++index] = e.toBean();
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public long getTotal() {
		return total;
	}

	public int getPages() {
		return pages;
	}

	public Object[] getResult() {
		return result;
	}

}
