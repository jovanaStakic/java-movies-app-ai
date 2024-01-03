package org.java.movies.app.common.communication;

public class MyException {
	private String message;
	private String type;
	
	
	public MyException(String message, String type) {
		super();
		this.message = message;
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "MyException [message=" + message + ", type=" + type + "]";
	}
	
	
}
