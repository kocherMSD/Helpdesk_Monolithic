package org.helpdesk.common.dao;

import java.util.ArrayList;
import java.util.List;

import org.helpdesk.common.model.CatalogueRequest;
import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.Products;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CatalogueDao extends FastTrackDataService{
	
	
	public boolean saveUpdate(CatalogueRequest request)
	{
		Products prd=new Products();
		
		if(getProduct(request.getPid()).getPid()!=null)
			prd.setId(getProduct(request.getPid()).getId());
			
		prd.setPid(request.getPid());
		prd.setProductdesc(request.getProductdesc());
		prd.setProductfamily(request.getProductfamily());
		prd.setSolution_products_flag(request.getSolution_products_flag());
		prd.setSolutiontechnology(request.getSolutiontechnology());
		prd.setUpdated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
		prd.setCreated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
		prd.setVersion(""+0);
		saveOrUpdate(prd);
		evict(prd);
		return true;
	}
	
	
	
	
	 private Products getProduct(String productId)
     {
    	 List<Products> products=new ArrayList<Products>();
   		
   		
			DetachedCriteria criteria = DetachedCriteria.forClass(Products.class);
			criteria.add(Restrictions.eq("pid",productId));
			criteria.addOrder(Order.asc("pid"));
			List<BaseBusinessObject> retObj = findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				products.add(((Products)bo));
			}
		
		
		return products.size()==0?new Products():products.get(0); 
     }
     



	public boolean delete(CatalogueRequest request)
	{
		Products prd=new Products();
		if(getProduct(request.getPid()).getPid()!=null)
			prd.setId(getProduct(request.getPid()).getId());
			
		prd.setPid(request.getPid());
		prd.setProductdesc(request.getProductdesc());
		prd.setProductfamily(request.getProductfamily());
		prd.setSolution_products_flag(request.getSolution_products_flag());
		prd.setSolutiontechnology(request.getSolutiontechnology());
		prd.setUpdated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
		prd.setCreated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
		prd.setVersion(""+0);
		
		delete(prd);
		evict(prd);
		return true;	
	}
	
	
	

}
