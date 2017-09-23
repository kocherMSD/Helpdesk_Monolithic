package org.helpdesk.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.MessageBoard;
import org.helpdesk.db.model.ProductEntity;
import org.helpdesk.webservice.request.MessageRequest;
import org.helpdesk.webservice.response.MessageViewAllResponse;
import org.helpdesk.webservice.response.MessageViewResponse;
import org.helpdesk.webservice.response.RestResponse;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

public class MessageBoardDao extends DataService{

	public MessageViewResponse getMessage(String messageId) {
		// TODO Auto-generated method stub
		MessageViewResponse response=new MessageViewResponse();
		
		String title="";
		List<String> msgList=new ArrayList<String>();
		List<String> dateList=new ArrayList<String>();
        try
        {
		DetachedCriteria criteria = DetachedCriteria.forClass(MessageBoard.class);
		criteria.add(Restrictions.eq("title", messageId));
		criteria.addOrder(Order.asc("title"));
		List<BaseBusinessObject> retObj = findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			title=((MessageBoard) bo).getTitle();
			msgList.add("" + ((MessageBoard) bo).getMessage());
			dateList.add("" + ((MessageBoard) bo).getCreated_date());

		}
		response.setTitle(title);
		response.setDate(dateList);
		response.setMessages(msgList);
	}
	catch(Exception e)
	{
		
	}
		return response;
	}

	public MessageViewAllResponse getAllMessage() {
		
		MessageViewAllResponse response=new MessageViewAllResponse();
		List<MessageRequest> msgList=new ArrayList<MessageRequest>();
		try
		{
		    DetachedCriteria criteria = DetachedCriteria.forClass(MessageBoard.class);
		    criteria .setProjection(Projections.projectionList()
			        .add(Projections.groupProperty("title"), "title")
			        .add(Projections.property("created_date"), "created_date"))
			        .setResultTransformer(Transformers.aliasToBean(MessageBoard.class));
			List<BaseBusinessObject> retObj = findByCriteria(criteria);
			for (BaseBusinessObject bo : retObj) {
				MessageRequest msg=new MessageRequest();
				msg.setTitle(((MessageBoard) bo).getTitle());
				msg.setDate(((MessageBoard) bo).getCreated_date());
				msgList.add(msg);
			}
			response.setMessages(msgList);;
		}
		catch(Exception e)
		{
			
		}
			return response;
	}

	public RestResponse CreateMessage(MessageRequest req) {
		RestResponse response=new RestResponse();
		try
		{
		
		MessageBoard msg=new MessageBoard();
		// TODO Auto-generated method stub
		msg.setMessage(req.getMessage());
		msg.setTitle(req.getTitle());
		msg.setUser(req.getUserId());
		msg.setCreated_date(""+new java.util.Date());
		saveOrUpdate(msg);
		response.setResponseStatus("success");
		}
		catch(Exception e)
		{
			
		}
		return response;

	}

}
