package com.strom.util;

public class Page {

	//关键词
	private String key;
	//当前页
	private int currPage;
	//页面大小
	private int pageSize;
	//起始页
	private int starPage;
	
	public Page() {
		super();
	}
	public Page(String key, int currPage, int pageSize) {
		super();
		this.key = key;
		this.currPage = currPage;
		this.pageSize = pageSize;
	}
	public String getKey() {
		return StringUtils.instance().isNotEmpty(key)?key:"%%";
	}
	public void setKey(String key) {
		this.key = "%"+key+"%";
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStarPage() {
		return (currPage-1)*pageSize;
	}
	@Override
	public String toString() {
		return "Page [currPage=" + currPage + ", key=" + key + ", pageSize="
				+ pageSize + ", starPage=" + starPage + "]";
	}
	
}
