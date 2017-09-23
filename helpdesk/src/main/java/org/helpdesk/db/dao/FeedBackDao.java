package org.helpdesk.common.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.FeedBack;
import org.helpdesk.webservice.model.FeedBackRequest;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;



public class FeedBackDao  extends FastTrackDataService{
	
	private static Logger logger = Logger.getLogger("FastTrackDataService");

    
    public boolean save(FeedBackRequest request)
    {
    	
    	FeedBack fb=new FeedBack();
    	  	
    	fb.setFeedback(request.getFeedBack());
    	fb.setRating(request.getRating());
    	fb.setProduct_id(request.getProduct_id());
    	fb.setCase_id(request.getCaseId());
    	fb.setCcoid(request.getCcoId());
    	fb.setCreated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
    	
    	
    	saveOrUpdate(fb);
    	return true;
    }
    
    public FeedBack getFeedBack(String pr_id)
    {
    	List<FeedBack> feedbacks = new ArrayList<FeedBack>();
    	DetachedCriteria criteria = DetachedCriteria.forClass(FeedBack.class);
		criteria.add(Restrictions.eq("product_id", pr_id));
		List<BaseBusinessObject> retObj = findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			feedbacks.add ((FeedBack) bo);
		}
		return feedbacks.get(0);
    	
    }
 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
