package net.wanho.util;

import java.util.List;

public class PageBean<T> {
	
	//当前页所有的内容
	private List<T> list;
	//当前页码	
	private int currentPage;
	//每页显示的个数
	private int pageSize;
	//总条数 	
	private int totalCount;
	//总页数
	private int totalPage;
	public PageBean() {
		super();
	}
	public PageBean(List<T> list, int currentPage, int pageSize, int totalCount, int totalPage) {
		super();
		this.list = list;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	@Override
	public String toString() {
		return "PageBean [list=" + list + ", currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount="
				+ totalCount + ", totalPage=" + totalPage + "]";
	}
	
}
