package org.helpdesk.webservice.support;

import java.util.ArrayList;
import java.util.List;

import org.helpdesk.db.dao.ViewTicketDao;
import org.helpdesk.db.model.TicketRequestEntity;
import org.helpdesk.webservice.request.NoteRequest;
import org.helpdesk.webservice.request.ResolveRequest;
import org.helpdesk.webservice.response.NoteResponse;
import org.helpdesk.webservice.response.ResolveResponse;
import org.helpdesk.webservice.response.ViewAllTicketResponse;
import org.helpdesk.webservice.response.ViewTicketResponse;

public class HelpDeskViewTicketHelper {
	
	ViewTicketDao dao=null;

	public  ViewTicketResponse getTicket( String ticketId) {
		// TODO Auto-generated method stub
		TicketRequestEntity ticketRequestEntity=	dao.findUsersTicket(ticketId);
			ViewTicketResponse trw=new ViewTicketResponse();
			trw.setId(""+ticketRequestEntity.getTicketId());
			trw.setCustomer_name(ticketRequestEntity.getCustomer_name());
			trw.setDescriptiveSummary(ticketRequestEntity.getDescriptiveSummary());
			trw.setEmailAddress(ticketRequestEntity.getEmailAddress());
			trw.setIssueScope(ticketRequestEntity.getIssueScope());
			trw.setIssueType(ticketRequestEntity.getIssueType());
			trw.setOutage(ticketRequestEntity.getOutage());
			trw.setProduct(ticketRequestEntity.getProduct());
			trw.setProductFamily(ticketRequestEntity.getProductFamily());
			trw.setSeverityId(ticketRequestEntity.getSeverityId());
			trw.setStatusName(ticketRequestEntity.getStatusName());
			trw.setSummary(ticketRequestEntity.getSummary());
			trw.setUserId(ticketRequestEntity.getUserId());
			trw.setResolution(ticketRequestEntity.getResolution()!=null?ticketRequestEntity.getResolution():"Please be patient. Resolution is in progress.");
			trw.setContractNumber(dao.getContract(ticketRequestEntity.getUserId()));
	
		
		return trw;
	}

	public ViewAllTicketResponse getAllTicket() {
		ViewAllTicketResponse res=new ViewAllTicketResponse();
		// TODO Auto-generated method stub
		List<TicketRequestEntity> ticketRequestEntities=	dao.findUserTicket();
		List<ViewTicketResponse> ticketRequestsWS=	new ArrayList<ViewTicketResponse>();
		for(TicketRequestEntity ticketRequestEntity:ticketRequestEntities)
		{
			ViewTicketResponse trw=new ViewTicketResponse();
			trw.setCustomer_name(ticketRequestEntity.getCustomer_name());
			trw.setDescriptiveSummary(ticketRequestEntity.getDescriptiveSummary());
			trw.setEmailAddress(ticketRequestEntity.getEmailAddress());
			trw.setIssueScope(ticketRequestEntity.getIssueScope());
			trw.setIssueType(ticketRequestEntity.getIssueType());
			trw.setOutage(ticketRequestEntity.getOutage());
			trw.setProduct(ticketRequestEntity.getProduct());
			trw.setProductFamily(ticketRequestEntity.getProductFamily());
			trw.setSeverityId(ticketRequestEntity.getSeverityId());
			trw.setStatusName(ticketRequestEntity.getStatusName());
			trw.setSummary(ticketRequestEntity.getSummary());
			trw.setUserId(ticketRequestEntity.getUserId());
			trw.setId(""+ticketRequestEntity.getTicketId());
			trw.setContractNumber(dao.getContract(ticketRequestEntity.getUserId()));


			ticketRequestsWS.add(trw);

			
		}
		res.setViewTicketResponses(ticketRequestsWS);
		
		return res;
	}
	
	public ViewAllTicketResponse getAllTicket(String User) {
		ViewAllTicketResponse res=new ViewAllTicketResponse();
		// TODO Auto-generated method stub
		List<TicketRequestEntity> ticketRequestEntities=	dao.findUserTicket(User);
		List<ViewTicketResponse> ticketRequestsWS=	new ArrayList<ViewTicketResponse>();
		for(TicketRequestEntity ticketRequestEntity:ticketRequestEntities)
		{
			ViewTicketResponse trw=new ViewTicketResponse();
			trw.setCustomer_name(ticketRequestEntity.getCustomer_name());
			trw.setDescriptiveSummary(ticketRequestEntity.getDescriptiveSummary());
			trw.setEmailAddress(ticketRequestEntity.getEmailAddress());
			trw.setIssueScope(ticketRequestEntity.getIssueScope());
			trw.setIssueType(ticketRequestEntity.getIssueType());
			trw.setOutage(ticketRequestEntity.getOutage());
			trw.setProduct(ticketRequestEntity.getProduct());
			trw.setProductFamily(ticketRequestEntity.getProductFamily());
			trw.setSeverityId(ticketRequestEntity.getSeverityId());
			trw.setStatusName(ticketRequestEntity.getStatusName());
			trw.setSummary(ticketRequestEntity.getSummary());
			trw.setUserId(ticketRequestEntity.getUserId());
			trw.setId(""+ticketRequestEntity.getTicketId());
			trw.setContractNumber(dao.getContract(ticketRequestEntity.getUserId()));
			ticketRequestsWS.add(trw);
			
			
		}
		res.setViewTicketResponses(ticketRequestsWS);
		
		return res;
	}
	
	
	public  NoteResponse addnote(NoteRequest request)
	{
		NoteResponse res=new NoteResponse();
		try
		{
		dao.addnote(request);	
		}
		catch(Exception e)
		{
			
			
		}
		return res;
	}
	
	public  ResolveResponse  resolveTicket(ResolveRequest request)
	{
		ResolveResponse response=new ResolveResponse();
		try
		{
		dao.resolveTicket(request);	
		}
		catch(Exception e)
		{
			
			
		}
		return response;
		
	}

	/**
	 * @return the dao
	 */
	public ViewTicketDao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(ViewTicketDao dao) {
		this.dao = dao;
	}
	
	
	
	

}
