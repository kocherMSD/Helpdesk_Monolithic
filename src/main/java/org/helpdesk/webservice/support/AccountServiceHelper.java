package org.helpdesk.webservice.support;

import org.helpdesk.db.dao.AccountDao;
import org.helpdesk.webservice.request.AccountRequest;
import org.helpdesk.webservice.response.AccountResponse;
import org.helpdesk.webservice.response.AccountViewResponse;


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

}
