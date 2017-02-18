package com.pankaj.exception;


public class ApplicationException extends Exception{

	private static final long serialVersionUID = 7308826530975245517L;

	public static class AppException extends BaseException{
		public AppException(String msg){
			super(msg);
		}
	}
	    
}
