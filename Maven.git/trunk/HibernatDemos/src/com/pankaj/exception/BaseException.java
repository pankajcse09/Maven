package com.pankaj.exception;

public abstract class BaseException extends Exception{
	
	private String msg;
	
	public BaseException(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return this.msg;
	}
}
