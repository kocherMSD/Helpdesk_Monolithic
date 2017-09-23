package org.helpdesk.common.dao;

import java.util.ArrayList;
import java.util.List;

import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.Note;
import org.helpdesk.db.model.TicketRequest;
import org.helpdesk.webservice.model.NoteRequest;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class ViewTicketDao extends FastTrackDataService{
	
	public TicketRequest findUserTicket(String userId,String ticketId) {
		
		List<TicketRequest> ticketRequests = new ArrayList<TicketRequest>();

		DetachedCriteria criteria = DetachedCriteria.forClass(TicketRequest.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("id", Integer.parseInt(ticketId)));
		List<BaseBusinessObject> retObj = findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			ticketRequests.add((TicketRequest) bo);
		}
		return ticketRequests.get(0);
	}
       public List<TicketRequest> findUserTicket() {
		
		List<TicketRequest> ticketRequests = new ArrayList<TicketRequest>();

		DetachedCriteria criteria = DetachedCriteria.forClass(TicketRequest.class);
		List<BaseBusinessObject> retObj = findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			ticketRequests.add((TicketRequest) bo);
		}
		return ticketRequests;
	}
       
       public List<Note> getnotes(String ticketId) {
   		
   		List<Note> notes = new ArrayList<Note>();

   		DetachedCriteria criteria = DetachedCriteria.forClass(Note.class);
   		criteria.add(Restrictions.eq("ticket_id", ticketId));
   		List<BaseBusinessObject> retObj = findByCriteria(criteria);
   		for (BaseBusinessObject bo : retObj) {
   			notes.add((Note) bo);
   		}
   		return notes;
   	}
       
	public void addnote(NoteRequest request) {
		
		Note note=new Note();
		note.setNoteText(request.getNotetext());
		note.setTicket_id(request.getTicketId());
		note.setDateTime(""+new java.util.Date());
		note.setNotesType(request.getNoteType());
		getHibernateTemplate().save(note);
		
		
	}

}
