package org.helpdesk.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.UsersEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class AuthenticateDao extends DataService{
	
	 public String getPassword(String user_id)
     {
    	 List<UsersEntity> users=new ArrayList<UsersEntity>();
   		
   		
			DetachedCriteria criteria = DetachedCriteria.forClass(UsersEntity.class);
			criteria.add(Restrictions.eq("ccoid",user_id));
			List<BaseBusinessObject> retObj = findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				users.add(((UsersEntity)bo));
			}
		
		
		return users.get(0).getPassword(); 
     }
	 
	 public String getAccessLevel(String ccoId){
			String accessLevel = "NA";
			try
			{
			       
			    DetachedCriteria criteria = DetachedCriteria.forClass(UsersEntity.class);
			    criteria.add(Restrictions.eq("ccoid", ccoId));
				criteria.addOrder(Order.asc("ccoid"));
				List<BaseBusinessObject> retObj = findByCriteria(criteria);
				for(BaseBusinessObject bo :retObj)
				{
					accessLevel=	((UsersEntity)bo).getAccesslevel();
				}
			}
			catch(Exception e)
			{
				accessLevel ="NA";
			}

			return accessLevel;
		}

}
