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
import org.helpdesk.webservice.extension.AccountService;
import org.helpdesk.webservice.support.AccountServiceHelper;
import org.helpdesk.webservice.request.AccountRequest;
import org.helpdesk.webservice.response.AccountResponse;
import org.helpdesk.webservice.response.AccountViewResponse;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Path("/AccountService")
public class AccountServiceImpl implements AccountService {

	
	AccountServiceHelper helper=null;

	@Override
	@GET
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/getAccount/{customerId}")
	public AccountViewResponse getAccount(@Context HttpHeaders headers, @PathParam("customerId")String  customerId)
			throws ServiceInvocationException {
		
		AccountViewResponse response=new AccountViewResponse();
		response=helper.getAccount(customerId);
		
		return response;
	}

	@Override
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/updateAccount/")
	public AccountResponse updateAccount(@Context HttpHeaders headers, AccountRequest req)
			throws ServiceInvocationException {
		AccountResponse response=new AccountResponse();
		response=helper.updateAccount(req);
		return response;
	}

	@Override
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/addAccount/")
	public AccountResponse addAccount(@Context HttpHeaders headers, AccountRequest req)
			throws ServiceInvocationException {
		AccountResponse response=new AccountResponse();
		response=helper.addAccount(req);
		response.setResponseStatus("SUCCESS");
		return response;
	}

	@Override
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/deleteAccount/")
	public AccountResponse deleteAccount(HttpHeaders headers, AccountRequest req)
			throws ServiceInvocationException {
		AccountResponse response=new AccountResponse();
		response=helper.deleteAccount(req);
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
	public AccountServiceHelper getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(AccountServiceHelper helper) {
		this.helper = helper;
	}

}
