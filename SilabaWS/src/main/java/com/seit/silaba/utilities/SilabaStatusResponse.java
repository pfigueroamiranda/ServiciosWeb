package com.seit.silaba.utilities;

/**
 *  
 */
public enum SilabaStatusResponse {
	SUCCESS("SUCCESS"), FAILURE("FAILURE"), EMPTY("EMPTY"), DUPLICATE("DUPLICATE"), ACTIVES("DATAS ACTIVES"), ERROR(
			"ERROR");

	private String name;

	SilabaStatusResponse(String name) {
		this.setName(name);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name - the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
