package org.helpdesk.webservice.support;

import java.util.List;

import org.helpdesk.db.dao.AccountDao;
import org.helpdesk.webservice.request.AccountRequest;
import org.helpdesk.webservice.request.DeviceRequest;
import org.helpdesk.webservice.response.AccountResponse;
import org.helpdesk.webservice.response.AccountViewResponse;
import org.helpdesk.webservice.response.DeviceResponse;
import org.helpdesk.webservice.response.ProductFamilyResponse;
import org.helpdesk.webservice.response.ProductResponse;


public class AccountServiceHelper {

	AccountDao dao=null;

	public  AccountViewResponse getAccount(String UserId) {
		
		AccountViewResponse response =new AccountViewResponse();
		response=dao.findAcountRequest(UserId);
		
		return response;
	}

	public  AccountResponse updateAccount(AccountRequest req) {
		
		      dao.saveUpdate(req);
              AccountResponse response =new AccountResponse();
		
		
		return response;
		
	}

	public  AccountResponse addAccount(AccountRequest req) {
		   dao.saveUpdate(req);
           AccountResponse response =new AccountResponse();
		
		
		return response;
		
	}
	public  DeviceResponse addDevice(DeviceRequest req) {
		   dao.saveDevice(req);
		   DeviceResponse response =new DeviceResponse();
		
		
		return response;
		
	}

	public  AccountResponse deleteAccount(AccountRequest req) {
		  dao.delete(req);
        AccountResponse response =new AccountResponse();
		
		return response;
		
	}

	/**
	 * @return the dao
	 */
	public AccountDao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(AccountDao dao) {
		this.dao = dao;
	}

	public ProductFamilyResponse getProductFamily() {
		ProductFamilyResponse response=new ProductFamilyResponse();
		List<String> pfList=dao.getProductFamily();
		response.setProductFamily(pfList);
		return response;
	}

	public ProductResponse getProducts(String productFamily) {
		ProductResponse response=new ProductResponse();
		List<String> pList=dao.getProduct(productFamily);
		response.setProducts(pList);
		return response;
	}

}
