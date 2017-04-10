package com.xf.college.model.apiwrapper;

/**
 * Created by Yorkart on 14-10-1.
 */
public class APIResult<T> {

	private Integer code ;
	private String message ;
	private T result ;

	public APIResult(){
	}

	public APIResult(Integer code , String message, T data){
		this.setCode(code);
		this.setMessage(message);
		this.setResult(data);
	}

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String toJson(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append('{');
		stringBuilder.append("\"code\": \"").append(code).append("\",");
		stringBuilder.append("\"message\": \"").append(message).append("\",");
		stringBuilder.append("\"data\": \"").append(result).append("\"}");

		return stringBuilder.toString();
	}
}
