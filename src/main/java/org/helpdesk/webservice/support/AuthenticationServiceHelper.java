package org.helpdesk.webservice.support;

import org.helpdesk.db.dao.AuthenticateDao;
import org.helpdesk.webservice.request.AuthenticationRequest;
import org.helpdesk.webservice.response.AuthenticationResponse;

public class AuthenticationServiceHelper {

	public AuthenticateDao getDao() {
		return dao;
	}

	public void setDao(AuthenticateDao dao) {
		this.dao = dao;
	}

	AuthenticateDao dao = null;

	public AuthenticationResponse validate(AuthenticationRequest request) {
		AuthenticationResponse response = new AuthenticationResponse();
		if (request.getPassword()!=null || request.getUserName()!=null) {

			if (request.getPassword().equalsIgnoreCase("") || request.getUserName().equalsIgnoreCase("")) {
				response.setStatus("Authentication Failed");
				response.setErrorMessage("Password or UserName cannot be empty");
			}

			if (!request.getPassword().equalsIgnoreCase(dao.getPassword(request.getUserName()))) {
				response.setStatus("Authentication Failed");
				response.setErrorMessage("Password not matched");
			}
			else  {
				response.setStatus("Authentication Successfull");
				response.setErrorMessage("");
			}
		} else {
			response.setStatus("Authentication Failed");
			response.setErrorMessage("Issue with Authentication");

		}

		return response;

	}

}
