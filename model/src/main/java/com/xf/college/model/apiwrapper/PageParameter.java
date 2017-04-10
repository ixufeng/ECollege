package com.xf.college.model.apiwrapper;

import java.util.Map;

/**
 * Created by Yorkart on 14-10-4.
 */
public class PageParameter {

	private int offset;
	private int limit;
	private Map<String,Boolean> sort;
	private String[] columns;

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Map<String, Boolean> getSort() {
		return sort;
	}

	public void setSort(Map<String, Boolean> sort) {
		this.sort = sort;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

}
