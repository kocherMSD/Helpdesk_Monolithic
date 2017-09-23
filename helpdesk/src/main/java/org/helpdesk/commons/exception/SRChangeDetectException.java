package org.helpdesk.common.exception;

public class SRChangeDetectException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SRChangeDetectException() {
		super();
	}

	public SRChangeDetectException(String message)
	{
		super(message);
	}
	
	public SRChangeDetectException(String errorCode, String message)
	{
		super(errorCode, message);
	}
	
	
	
}
