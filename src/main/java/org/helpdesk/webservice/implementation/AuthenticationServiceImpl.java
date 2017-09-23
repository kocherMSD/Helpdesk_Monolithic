package org.helpdesk.webservice.implementation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.webservice.extension.AuthenticationService;
import org.helpdesk.webservice.request.AuthenticationRequest;
import org.helpdesk.webservice.response.AuthenticationResponse;
import org.helpdesk.webservice.support.AuthenticationServiceHelper;
import org.springframework.stereotype.Component;

@Component
@Path("/Authentication")
public class AuthenticationServiceImpl implements AuthenticationService {

	
	AuthenticationServiceHelper helper;
	
	public AuthenticationServiceHelper getHelper() {
		return helper;
	}

	public void setHelper(AuthenticationServiceHelper helper) {
		this.helper = helper;
	}

	@Override
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/authenticate/")
	public AuthenticationResponse authenticate(@Context HttpHeaders headers, AuthenticationRequest request)
			throws ServiceInvocationException {
		AuthenticationResponse response=helper.validate(request);
		return response;
	}

}
