package org.helpdesk.webservice.implementation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.helpdesk.webservice.request.SearchRequest;
import org.helpdesk.webservice.response.SearchResponse;
import org.helpdesk.webservice.support.SearchHelper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Path("/SerachService")
public class HelpDeskBasicSearchImp implements  ApplicationContextAware {
	
	public SearchHelper getHelper() {
		return helper;
	}

	public void setHelper(SearchHelper helper) {
		this.helper = helper;
	}

	SearchHelper helper=null;
	
	
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/search")
	public SearchResponse serach(@Context HttpHeaders headers,SearchRequest request)
	{
		
		try
		{
		SearchResponse response=helper.search(request.getQuery());
		
		return response;
		}
		catch(Exception e)
		{
			
		}
		return new SearchResponse();
		
	}

	
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/solrSearch")
	public QueryResponse search(@Context HttpHeaders headers,SearchRequest request)
	{
		
		try
		{
		     HttpSolrServer solr = new HttpSolrServer("http://host:8983/solr/helpdesk");

		     SolrQuery query = new SolrQuery();
		     query.setQuery(request.getQuery());
		     query.setStart(0);    

		     QueryResponse response = solr.query(query);		
		return response;
		}
		catch(Exception e)
		{
			
		}
		return new QueryResponse();
		
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		
	}

}
