package org.helpdesk.webservice.implementation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.webservice.extension.MessageService;
import org.helpdesk.webservice.request.MessageRequest;
import org.helpdesk.webservice.response.MessageViewAllResponse;
import org.helpdesk.webservice.response.MessageViewResponse;
import org.helpdesk.webservice.response.RestResponse;
import org.helpdesk.webservice.support.MessageServiceHelper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Path("/MessageService")
public class MessageServiceImpl implements MessageService {

	
	MessageServiceHelper helper=null;

	@Override
	@GET
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/getMessage/{title}")
	public MessageViewResponse getMessage(@Context HttpHeaders headers, @PathParam("title")String  title)
			throws ServiceInvocationException {
		
		MessageViewResponse response=new MessageViewResponse();
		response=helper.getMessageById(title);
		
		return response;
	}

	@Override
	@GET
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/getAllMessage/")
	public MessageViewAllResponse getAllMessage(@Context HttpHeaders headers)
			throws ServiceInvocationException {
		MessageViewAllResponse response=new MessageViewAllResponse();
		response=helper.getAllMessage();
		return response;
	}

	@Override
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/createMessage/")
	public RestResponse createMessage(@Context HttpHeaders headers, MessageRequest req)
			throws ServiceInvocationException {
		RestResponse response=new RestResponse();
		response=helper.createMessage(req);
		response.setResponseStatus("SUCCESS");
		return response;
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the helper
	 */
	public MessageServiceHelper getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(MessageServiceHelper helper) {
		this.helper = helper;
	}

}
