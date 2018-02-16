package com.seit.silaba.utilities;

/**
 * Created by andy410 on 08/01/2016.
 */
public enum SilabaErrorCodes {
	USER_BLOCKED("The account has been blocked due 3 failed authentication attempts", "105"),

	LOGIN_FAIL("Please,check your username and password and try again ", "101"),
	FAIL_CREATING_SILABER("FAIL_CREATING_SILABER", "319"),

	USER_NOT_ACTIVE("USER_NOT_ACTIVE", "102");

	String name;
	String code;

	SilabaErrorCodes(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
