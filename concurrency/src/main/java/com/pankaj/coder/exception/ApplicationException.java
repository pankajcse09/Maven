package com.pankaj.coder.exception;

/**
 * Copyright 2010-2017 pankajbharti.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The class {@code ApplicationException} and its subclasses are a form of
 * {@code BaseException} that indicates conditions that a reasonable application
 * might want to catch.
 *
 * <p>
 * The class {@code ApplicationException} and any subclasses that are not also
 * subclasses of {@link BaseException} are <em>checked exceptions</em>. Checked
 * exceptions need to be declared in a method or constructor's
 * {@code BaseException} clause if they can be thrown by the execution of the
 * method or constructor and propagate outside the method or constructor
 * boundary.
 * 
 * @version 1.0
 * @author pankajbharti
 */

public class ApplicationException {

	/**
	 * The class {@code DAOException} and its subclasses are a form of
	 * {@code BaseException} that indicates conditions that a reasonable
	 * application might want to catch.
	 *
	 * <p>
	 * The class {@code ApplicationException} and any subclasses that are not
	 * also subclasses of {@link BaseException} are <em>checked exceptions</em>.
	 * Checked exceptions need to be declared in a method or constructor's
	 * {@code BaseException} clause if they can be thrown by the execution of
	 * the method or constructor and propagate outside the method or constructor
	 * boundary.
	 * 
	 * @version 1.0
	 * @author pankajbharti
	 */

	public static class DAOException extends BaseException {
		private static final long serialVersionUID = 1L;

		public DAOException(String msg) {
			super(msg);
		}
	}

	/**
	 * The class {@code ManagerException} and its subclasses are a form of
	 * {@code BaseException} that indicates conditions that a reasonable
	 * application might want to catch.
	 *
	 * <p>
	 * The class {@code ApplicationException} and any subclasses that are not
	 * also subclasses of {@link BaseException} are <em>checked exceptions</em>.
	 * Checked exceptions need to be declared in a method or constructor's
	 * {@code BaseException} clause if they can be thrown by the execution of
	 * the method or constructor and propagate outside the method or constructor
	 * boundary.
	 * 
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static class ManagerException extends BaseException {
		private static final long serialVersionUID = 1L;

		public ManagerException(String msg) {
			super(msg);
		}
	}

	/**
	 * The class {@code ConfigurationException} and its subclasses are a form of
	 * {@code BaseException} that indicates conditions that a reasonable
	 * application might want to catch.
	 *
	 * <p>
	 * The class {@code ApplicationException} and any subclasses that are not
	 * also subclasses of {@link BaseException} are <em>checked exceptions</em>.
	 * Checked exceptions need to be declared in a method or constructor's
	 * {@code BaseException} clause if they can be thrown by the execution of
	 * the method or constructor and propagate outside the method or constructor
	 * boundary.
	 * 
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static class ConfigurationException extends BaseException {
		private static final long serialVersionUID = 1L;

		public ConfigurationException(String msg) {
			super(msg);
		}
	}
}
