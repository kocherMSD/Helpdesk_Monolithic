package org.helpdesk.common.exception;


public class ApplicationException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
		// TODO Auto-generated constructor stub
	}

	public ApplicationException(String errorMesage) {
		super(errorMesage);
		// TODO Auto-generated constructor stub
	}
	
	
	 public ApplicationException(String errorCode, String errorMessage ,Throwable t) {
			super(errorCode, errorMessage,t);
			// TODO Auto-generated constructor stub
		}
	
}
