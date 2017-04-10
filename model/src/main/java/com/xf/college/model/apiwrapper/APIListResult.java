package com.xf.college.model.apiwrapper;

/**
 * Created by wangyue1 on 2014/10/8.
 */
public class APIListResult<T> extends APIResult<ListPackage<T>> {
	public APIListResult(){
	}

	public APIListResult(Integer code , String message, ListPackage<T> data){
		super(code,message,data);
	}

}
