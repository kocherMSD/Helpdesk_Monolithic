package org.helpdesk.common.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.IssUesrMapping;
import org.helpdesk.db.model.IssueType;
import org.helpdesk.db.model.Products;
import org.helpdesk.db.model.SmartSuggestIssueScope;
import org.helpdesk.db.model.SmartSuggestIssueType;
import org.helpdesk.webservice.model.CategorizerIssueScope;
import org.helpdesk.webservice.model.CategorizerIssueTypeDetails;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
/**
 * 
 * @author dethakku
 *
 */
public class ProductDetailsDAO {

	private FastTrackDataService dataService;
	private Map<String,String> fastStartDefaultValueMap;
	private static Logger logger = Logger.getLogger(ProductDetailsDAO.class);

	/**
	 * To fetch the number of technical solution for product Id
	 * 
	 * @param ccoId
	 * @return
	 */

	public String getProductID(String productFamily) {
		List<String> products = new ArrayList<String>();

		DetachedCriteria criteria = DetachedCriteria.forClass(Products.class);
		criteria.add(Restrictions.eq("productfamily", productFamily));
		criteria.addOrder(Order.asc("pid"));
		List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			products.add("" + ((Products) bo).getId());
		}
		return products.get(0);
	}

	public List<Products> getProductsList(String productFamily) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Products.class);
		criteria.add(Restrictions.like("productfamily", productFamily,
				MatchMode.ANYWHERE));
		criteria.addOrder(Order.asc("pid"));
		return dataService.findEntityByCriteria(criteria);		
	}

	/**
	 * 
	 * @return
	 */
	public List<String> getExistingProductFamily() {
		List<String> pfList = new ArrayList<String>();

		DetachedCriteria criteria = DetachedCriteria.forClass(Products.class);
		criteria.addOrder(Order.asc("pid"));
		List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			pfList.add("" + ((Products) bo).getProductfamily());
		}

		return pfList;
	}
	

	
	public List<CategorizerIssueTypeDetails> getAssociatedIssueTypesAndScopes(
			String productId) {			
		List<CategorizerIssueTypeDetails> categorizerIssueTypeDetails = new ArrayList<CategorizerIssueTypeDetails>();
		List<SmartSuggestIssueType> issuetypes = getIssueTypes(productId);
		for (SmartSuggestIssueType issueType : issuetypes) {
			CategorizerIssueTypeDetails issueTypeDetails = new CategorizerIssueTypeDetails();
			issueTypeDetails.setIssueType(issueType.getIssuetype());
			List<SmartSuggestIssueScope> issueScopes = getIssueScopes(issueType);
			List<CategorizerIssueScope> categorizerIssueScopes = new ArrayList<CategorizerIssueScope>();
			for (SmartSuggestIssueScope isMapping : issueScopes) {
				CategorizerIssueScope issueScope = new CategorizerIssueScope();
				issueScope.setName(isMapping.getIssuescope());
				/*issueScope.setIssueTypeId(String.valueOf(isMapping
						.getIssuetype_id()));*/
				categorizerIssueScopes.add(issueScope);
			}

			issueTypeDetails.setIssueScopeList(categorizerIssueScopes);
			categorizerIssueTypeDetails.add(issueTypeDetails);
		}
		return categorizerIssueTypeDetails;
	}
	
	
	/**
	 * To fetch the number of issue types for products
	 * 
	 * @param ccoId
	 * @return
	 */
	public List<SmartSuggestIssueType> getIssueTypes(String productId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SmartSuggestIssueType.class);
		criteria.add(Restrictions.eq("product_id", Integer.parseInt(productId)));
		criteria.addOrder(Order.asc("issuetype"));
		return dataService.findEntityByCriteria(criteria);
	}

	/**
	 * To fetch the number of issue scopes tech,subtec,prob code for issue type
	 * 
	 * @param ccoId
	 * @return
	 */
	public List<SmartSuggestIssueScope> getIssueScopes(SmartSuggestIssueType issueType) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SmartSuggestIssueScope.class);
		criteria.add(Restrictions.eq("issuetype_id", issueType.getId()));
		criteria.addOrder(Order.asc("issuescope"));
		return dataService.findEntityByCriteria(criteria);
	}
	
	public SmartSuggestIssueType getIssueTypeByName(String issueType, String productId){
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SmartSuggestIssueType.class);
		criteria.add(Restrictions.eq("issuetype", issueType));
		criteria.add(Restrictions.eq("product_id", Integer.valueOf(productId)));
		List<SmartSuggestIssueType> issueTypes = dataService.findEntityByCriteria(criteria);
		logger.debug("No of issue types fetched : " + issueTypes.size() + " for " + issueType + " : " + productId);
		return issueTypes.get(0);
		//return (IssueType)(dataService.findEntityByCriteria(criteria).get(0));
	}
	
	public SmartSuggestIssueScope getIssueScopeByName(SmartSuggestIssueType issueType, String name){
		DetachedCriteria criteria = DetachedCriteria
				.forClass(SmartSuggestIssueScope.class);
		criteria.add(Restrictions.eq("issuescope", name));
		criteria.add(Restrictions.eq("issuetype_id", Integer.valueOf(issueType.getId())));
		List<SmartSuggestIssueScope> issScopes = dataService.findEntityByCriteria(criteria);
		logger.debug("No of issue scope fetched : " + issScopes.size() + " for " + name + " : " + issueType.getId());
		if(!issScopes.isEmpty())
		  return issScopes.get(0);
		else 
		  return null;
		//return (IssUesrMapping)(dataService.findEntityByCriteria(criteria).get(0));
	}
    

	public FastTrackDataService getDataService() {
		return dataService;
	}

	public void setDataService(FastTrackDataService dataService) {
		this.dataService = dataService;
	}

	public Map<String, String> getFastStartDefaultValueMap() {
		return fastStartDefaultValueMap;
	}

	public void setFastStartDefaultValueMap(
			Map<String, String> fastStartDefaultValueMap) {
		this.fastStartDefaultValueMap = fastStartDefaultValueMap;
	}

}
