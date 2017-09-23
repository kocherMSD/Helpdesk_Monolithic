package org.helpdesk.webservice.support;

import org.helpdesk.db.dao.MessageBoardDao;
import org.helpdesk.webservice.request.MessageRequest;
import org.helpdesk.webservice.response.MessageViewAllResponse;
import org.helpdesk.webservice.response.MessageViewResponse;
import org.helpdesk.webservice.response.RestResponse;

public class MessageServiceHelper {

	
	private MessageBoardDao dao=null;
	
	public MessageViewResponse getMessageById(String title) {
		MessageViewResponse response=dao.getMessage(title);
		return response;
	}

	public MessageViewAllResponse getAllMessage() {
		
		MessageViewAllResponse response=dao.getAllMessage();
		return response;
	}

	public RestResponse createMessage(MessageRequest req)  {
		RestResponse response=dao.CreateMessage(req);
		return response;
	}

	/**
	 * @return the dao
	 */
	public MessageBoardDao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(MessageBoardDao dao) {
		this.dao = dao;
	}

}
