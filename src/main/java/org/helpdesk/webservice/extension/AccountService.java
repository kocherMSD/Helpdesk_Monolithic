package org.helpdesk.webservice.extension;


import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.webservice.request.AccountRequest;
import org.helpdesk.webservice.request.DeviceRequest;
import org.helpdesk.webservice.response.AccountResponse;
import org.helpdesk.webservice.response.AccountViewResponse;
import org.helpdesk.webservice.response.DeviceResponse;
import org.helpdesk.webservice.response.ProductFamilyResponse;
import org.helpdesk.webservice.response.ProductResponse;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContextAware;

public interface AccountService extends BeanFactoryAware, ApplicationContextAware {
	
	public abstract AccountViewResponse getAccount(@Context HttpHeaders headers,String user_id) throws ServiceInvocationException;
	public abstract AccountResponse updateAccount(@Context HttpHeaders headers,AccountRequest req) throws ServiceInvocationException;
	public abstract AccountResponse addAccount(@Context HttpHeaders headers,AccountRequest req) throws ServiceInvocationException;
	public abstract AccountResponse deleteAccount(@Context HttpHeaders headers,AccountRequest req) throws ServiceInvocationException;
	public abstract DeviceResponse addDevice(@Context HttpHeaders headers, DeviceRequest req)throws ServiceInvocationException;;
	public abstract ProductFamilyResponse getProductFamily(@Context HttpHeaders headers) throws ServiceInvocationException;
	public abstract ProductResponse getProducts(@Context HttpHeaders headers, @PathParam("productFamily")String  productFamily) throws ServiceInvocationException;
}