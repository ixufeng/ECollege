package com.xf.college.model.apiwrapper;

import java.util.List;

/**
 * Created by Yorkart on 14-10-2.
 */
public class ListPackage<T> {
	/**
	 * 总记录数
	 */
	private Number count;

	private List<T> list;

	public Number getCount() {
		return count;
	}

	public void setCount(Number count) {
		this.count = count;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
