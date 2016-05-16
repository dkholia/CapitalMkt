package com.dcsoft.capmkt.util.errors;

/**
 * 
 * @author Deep
 *
 */
public class CustomError {

	private String name;
	private String message;

	public CustomError(String name, String message) {
		this.message= message;
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
