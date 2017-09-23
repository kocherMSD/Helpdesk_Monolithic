package org.helpdesk.common.exception;


public class GoogleGeoCodingServiceException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GoogleGeoCodingServiceException() {
		super();
	}

	public GoogleGeoCodingServiceException(String message)
	{
		super(message);
	}
	
	public GoogleGeoCodingServiceException(String errorCode, String message)
	{
		super(errorCode, message);
	}
	
	
	
}
