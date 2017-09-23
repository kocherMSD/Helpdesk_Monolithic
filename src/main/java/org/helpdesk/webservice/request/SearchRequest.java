package org.helpdesk.webservice.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "SearchRequest")
public class SearchRequest extends BaseRequest implements RestServiceRequest {
	
	private String query;

	@XmlElement(name="query")
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	

}
