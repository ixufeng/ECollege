package com.xf.college.common.utils;

/**
 * Created by Yorkart on 14-10-4.
 */
public class StringUtil {

	public static String convert(Object obj){
		return convert(obj,null);
	}

	public static String convert(Object obj,String defaultVal){
		if(obj == null){
			return defaultVal;
		}
		return obj.toString();
	}


	public static int convert(Object obj,int defaultVal){
		String val = convert(obj);
		if(val == null){
			return defaultVal;
		}else {
			try {
				return Integer.parseInt(val);
			}catch(Exception ex){
				return defaultVal;
			}
		}
	}

	public static String substring(String str, int maxLength){
		return str == null ?
				null :
				str.length() <= maxLength ?
						str :
						str.substring(0, maxLength);
	}

}
