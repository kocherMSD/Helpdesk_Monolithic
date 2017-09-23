package org.helpdesk.webservice.extension;


import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.webservice.request.TicketRequest;
import org.helpdesk.webservice.response.RestResponse;
import org.helpdesk.webservice.response.TicketResponse;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContextAware;


public interface HelpDeskTicketService extends BeanFactoryAware,ApplicationContextAware {
	
	public TicketResponse createHdTicket(@Context HttpHeaders headers,TicketRequest ticketRequest) throws ServiceInvocationException;
	

	public RestResponse getUser(@Context HttpHeaders headers, @PathParam("param") String ccoid );	
}