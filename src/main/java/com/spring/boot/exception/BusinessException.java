package com.spring.boot.exception;

public class BusinessException extends Exception{

	private static final long serialVersionUID = 1L;
	
	static int ErrorCode = 99999;
	
	public BusinessException(int errorCode, String emessage, Throwable exception) {
		super(emessage, exception);
		this.ErrorCode = errorCode;
	}
	
	public BusinessException(String emessage, Throwable exception) {
		super(emessage, exception);
	}
	
	public BusinessException(String emessage) {
		super(emessage);
	}
	
	public BusinessException(Throwable exception) {
		super(exception);
	}	
	

}
