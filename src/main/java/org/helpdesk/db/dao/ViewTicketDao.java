package org.helpdesk.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.ContractEntity;
import org.helpdesk.db.model.NoteEntity;
import org.helpdesk.db.model.TicketRequestEntity;
import org.helpdesk.webservice.request.NoteRequest;
import org.helpdesk.webservice.request.ResolveRequest;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class ViewTicketDao extends DataService{
	
	public String getContract(String userId)
	{
		String contractNmer="";
		List<ContractEntity> contracttEntities = new ArrayList<ContractEntity>();
		DetachedCriteria criteria = DetachedCriteria.forClass(ContractEntity.class);
		criteria.add(Restrictions.eq("ccoid", userId));
		List<BaseBusinessObject> retObj = findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			contracttEntities.add((ContractEntity) bo);
		}
		contractNmer=contracttEntities.get(0).getContractnumber();
		
		return contractNmer;
	}
	
	public TicketRequestEntity findUsersTicket(String ticketId) {
		
		List<TicketRequestEntity> ticketRequestEntities = new ArrayList<TicketRequestEntity>();

		DetachedCriteria criteria = DetachedCriteria.forClass(TicketRequestEntity.class);
		//criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("id", Integer.parseInt(ticketId)));
		List<BaseBusinessObject> retObj = findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			ticketRequestEntities.add((TicketRequestEntity) bo);
		}
		return ticketRequestEntities.get(0);
	}
	
       public List<TicketRequestEntity> findUserTicket() {
		
		List<TicketRequestEntity> ticketRequestEntities = new ArrayList<TicketRequestEntity>();

		DetachedCriteria criteria = DetachedCriteria.forClass(TicketRequestEntity.class);
		List<BaseBusinessObject> retObj = findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			ticketRequestEntities.add((TicketRequestEntity) bo);
		}
		return ticketRequestEntities;
	}
       public List<TicketRequestEntity> findUserTicket(String user) {
   		
   		List<TicketRequestEntity> ticketRequestEntities = new ArrayList<TicketRequestEntity>();

   		DetachedCriteria criteria = DetachedCriteria.forClass(TicketRequestEntity.class);
   		criteria.add(Restrictions.eq("userId", user));
   		List<BaseBusinessObject> retObj = findByCriteria(criteria);
   		for (BaseBusinessObject bo : retObj) {
   			ticketRequestEntities.add((TicketRequestEntity) bo);
   		}
   		return ticketRequestEntities;
   	}
       
       public List<NoteEntity> getnotes(String ticketId) {
   		
   		List<NoteEntity> notes = new ArrayList<NoteEntity>();

   		DetachedCriteria criteria = DetachedCriteria.forClass(NoteEntity.class);
   		criteria.add(Restrictions.eq("ticket_id", ticketId));
   		List<BaseBusinessObject> retObj = findByCriteria(criteria);
   		for (BaseBusinessObject bo : retObj) {
   			notes.add((NoteEntity) bo);
   		}
   		return notes;
   	}
       
	public void addnote(NoteRequest request) {
		
		NoteEntity note=new NoteEntity();
		note.setNoteText(request.getNotetext());
		note.setTicket_id(request.getTicketId());
		note.setDateTime(""+new java.util.Date());
		note.setNotesType(request.getNoteType());
		getHibernateTemplate().save(note);
		
		
	}
	
	public void resolveTicket(ResolveRequest request)
	{
		List<TicketRequestEntity> ticketRequestEntities = new ArrayList<TicketRequestEntity>();

		DetachedCriteria criteria = DetachedCriteria.forClass(TicketRequestEntity.class);
   		criteria.add(Restrictions.eq("ticket_id", request.getId()));
   		List<BaseBusinessObject> retObj = findByCriteria(criteria);
   		for (BaseBusinessObject bo : retObj) {
			ticketRequestEntities.add((TicketRequestEntity) bo);
		}
   		TicketRequestEntity entity=ticketRequestEntities.get(0);
   		if(entity!=null)
   		{
   			entity.setResolution(request.getResotution());
   		}
   		getHibernateTemplate().save(entity);
	}

}
