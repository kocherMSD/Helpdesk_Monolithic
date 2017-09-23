package org.helpdesk.commons.exception;


public class RestCommunicationException extends SystemException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int httpResponseStatus;

	public RestCommunicationException()
	{
		super();
	}
	
	public RestCommunicationException(String message)
	{
		super(message);
	}
	
	public RestCommunicationException(String errorCode, String message)
	{
		super(errorCode,message);		
	}
	public RestCommunicationException(String errorCode, int httpResponseStatus, String message)
    {
        super(errorCode,message);      
        this.httpResponseStatus = httpResponseStatus;
    }

    public int getHttpResponseStatus()
    {
        return httpResponseStatus;
    }

    public void setHttpResponseStatus(int httpResponseStatus)
    {
        this.httpResponseStatus = httpResponseStatus;
    }

	


}
