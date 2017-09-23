package org.helpdesk.webservice.extension;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.webservice.request.AuthenticationRequest;
import org.helpdesk.webservice.response.AuthenticationResponse;

public interface AuthenticationService {
	
	public  AuthenticationResponse authenticate(@Context HttpHeaders headers,AuthenticationRequest request) throws ServiceInvocationException;


}
