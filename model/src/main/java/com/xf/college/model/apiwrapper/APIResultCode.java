package com.xf.college.model.apiwrapper;

/**
 * Created by Yorkart on 14-10-1.
 */
public enum APIResultCode {

	SUCCESS (200),
	ERROR(500),
    NOTFOUND(404),
    BADREQUEST(400),
    UNLOGIN(414),
	UNAUTHORITY(401);

    private int code;

	APIResultCode(int code) {
        this.code = code;
	}

    public int getValue() {
        return code;
    }
}
