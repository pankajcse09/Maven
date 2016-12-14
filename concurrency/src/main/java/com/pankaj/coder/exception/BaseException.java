package com.pankaj.coder.exception;
/**
 * Copyright 2010-2017 pankajbharti.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The class {@code BaseException} and its subclasses are a form of
 * {@code Exception} that indicates conditions that a reasonable
 * application might want to catch.
 *
 * <p>The class {@code BaseException} and any subclasses that are not also
 * subclasses of {@link Exception} are <em>checked
 * exceptions</em>.  Checked exceptions need to be declared in a
 * method or constructor's {@code Exception} clause if they can be thrown
 * by the execution of the method or constructor and propagate outside
 * the method or constructor boundary.
 * 
 * @version 1.0
 * @author 	pankajbharti
 */
public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	
	/**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     * later retrieval by the {@link #getMessage()} method.
     */
	public BaseException(String msg) {
		this.message = msg;
	}
	
	public String getMessage() {
        return message;
    }
}
