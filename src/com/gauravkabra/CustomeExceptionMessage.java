package com.gauravkabra;

public class CustomeExceptionMessage extends Throwable{
	private String exceptionMsg;
	
	public CustomeExceptionMessage(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	
	public String getExceptionMessage() {
		return this.exceptionMsg;
	}
}
