package org.helpdesk.webservice.extension;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.helpdesk.webservice.response.AuthorizationResponse;


public interface AuthorizationService extends RestService{

	AuthorizationResponse getAuthorization(@Context HttpHeaders headers);

}
