package org.helpdesk.webservice.extension;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.webservice.request.NoteRequest;
import org.helpdesk.webservice.response.NoteResponse;
import org.helpdesk.webservice.response.ViewAllTicketResponse;
import org.helpdesk.webservice.response.ViewTicketResponse;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContextAware;

public interface  HelpDeskViewTicket extends BeanFactoryAware, ApplicationContextAware {
	
	public abstract ViewTicketResponse viewTicket(@Context HttpHeaders headers,String userId,String ticketId) throws ServiceInvocationException;
	public abstract ViewAllTicketResponse viewAllTicket(@Context HttpHeaders headers) throws ServiceInvocationException;
	public abstract NoteResponse addNote( @Context HttpHeaders headers, NoteRequest request) throws ServiceInvocationException;

	
	

}
