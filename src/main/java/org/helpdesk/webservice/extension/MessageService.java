package org.helpdesk.webservice.extension;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.webservice.request.MessageRequest;
import org.helpdesk.webservice.response.MessageViewAllResponse;
import org.helpdesk.webservice.response.MessageViewResponse;
import org.helpdesk.webservice.response.RestResponse;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContextAware;

public interface MessageService extends BeanFactoryAware, ApplicationContextAware {
	
	public MessageViewResponse getMessage(@Context HttpHeaders headers, @PathParam("customerId")String  customerId) throws ServiceInvocationException;
	public MessageViewAllResponse getAllMessage(@Context HttpHeaders headers) throws ServiceInvocationException;
	public RestResponse createMessage(@Context HttpHeaders headers, MessageRequest req) throws ServiceInvocationException;




}
