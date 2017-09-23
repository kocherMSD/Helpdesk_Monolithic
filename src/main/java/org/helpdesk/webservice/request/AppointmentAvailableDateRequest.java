package org.helpdesk.webservice.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.NONE)
public class AppointmentAvailableDateRequest {
	
	
	public AppointmentAvailableDateRequest()
	{
		
	}
	private String product_id;
	
	/*@XmlElement
	private String ccoId;*/
	
	
	private String clientTimeZone ;
	
	/**
	 * @return the product_id
	 */
	@XmlElement
	public String getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	/**
	 * @return the ccoId
	 */
	/*public String getCcoId() {
		return ccoId;
	}*/
	/**
	 * @param ccoId the ccoId to set
	 */
	/*public void setCcoId(String ccoId) {
		this.ccoId = ccoId;
	}*/
	/**
	 * @return the clientTimeZone
	 */
	@XmlElement
	public String getClientTimeZone() {
		return clientTimeZone;
	}
	/**
	 * @param clientTimeZone the clientTimeZone to set
	 */
	public void setClientTimeZone(String clientTimeZone) {
		this.clientTimeZone = clientTimeZone;
	}

}
