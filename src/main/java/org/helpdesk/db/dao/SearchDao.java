package org.helpdesk.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.MessageBoard;
import org.helpdesk.db.model.ProductEntity;
import org.helpdesk.db.model.TicketRequestEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class SearchDao {
	
	 private DataService dataservice=null;

	
	

	public DataService getDataservice() {
		return dataservice;
	}

	public void setDataservice(DataService dataservice) {
		this.dataservice = dataservice;
	}

	/**
	 * To fetch the number of technical solution for product Id
	 * 
	 * @param ccoId
	 * @return
	 */

      public List<MessageBoard> getAllMessage(String query) {
		List<MessageBoard> msgList=new ArrayList<MessageBoard>();
		try
		{
		    DetachedCriteria criteria = DetachedCriteria.forClass(MessageBoard.class);
 			criteria.add(Restrictions.like("title",query)); 
			List<BaseBusinessObject> retObj = dataservice.findByCriteria(criteria);
			for (BaseBusinessObject bo : retObj) {
				msgList.add(((MessageBoard)bo));

			}
			
		}
		catch(Exception e)
		{
			
		}
			return msgList;
	}

      public List<ProductEntity> getProduct(String query)
      {

     	 List<ProductEntity> products=new ArrayList<ProductEntity>();
    		
    		
 			DetachedCriteria criteria = DetachedCriteria.forClass(ProductEntity.class);
 			criteria.add(Restrictions.like("pid",query));
 			List<BaseBusinessObject> retObj = dataservice.findByCriteria(criteria);
 			for(BaseBusinessObject bo :retObj)
 			{
 				products.add(((ProductEntity)bo));
 			}
 		
 		
 		return products; 
      }
      
	public List<TicketRequestEntity> findUserTicket(String query) {

		List<TicketRequestEntity> ticketRequestEntities = new ArrayList<TicketRequestEntity>();

		DetachedCriteria criteria = DetachedCriteria.forClass(TicketRequestEntity.class);
		criteria.add(Restrictions.like("descriptiveSummary", query));
		List<BaseBusinessObject> retObj = dataservice.findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			ticketRequestEntities.add((TicketRequestEntity) bo);
		}
		return ticketRequestEntities;
	}
       
     

}
