package com.pointwest.utility;

public class ExceptionsClass extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// public
	public String ExceptionEncountered(String excMsg) {
		String constantExcMsg  = "An error was encountered";
		excMsg = constantExcMsg + excMsg;
		return excMsg;
	}

}
