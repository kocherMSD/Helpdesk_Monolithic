package org.helpdesk.webservice.extension;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;






import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.webservice.request.CatalogueRequest;
import org.helpdesk.webservice.response.CatalogueResponse;
import org.helpdesk.webservice.response.ProductDetailsResponse;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContextAware;

public interface CatalogueService extends BeanFactoryAware, ApplicationContextAware {
	
	public abstract ProductDetailsResponse getCatalogue(@Context HttpHeaders headers,String userId) throws ServiceInvocationException;
	public abstract CatalogueResponse addCatalogue(@Context HttpHeaders headers,CatalogueRequest req) throws ServiceInvocationException;
	public abstract CatalogueResponse updateCatalogue(@Context HttpHeaders headers,CatalogueRequest req) throws ServiceInvocationException;
	public abstract CatalogueResponse deleteCatalogue(@Context HttpHeaders headers,CatalogueRequest req) throws ServiceInvocationException;


}
