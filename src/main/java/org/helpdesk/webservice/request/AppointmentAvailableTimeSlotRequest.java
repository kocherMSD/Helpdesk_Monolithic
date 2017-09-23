package org.helpdesk.webservice.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.NONE)
public class AppointmentAvailableTimeSlotRequest {
	
	public AppointmentAvailableTimeSlotRequest()
	{
		
	}
	private String date;
	
	private String pid;
	
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
	private String clientTimeZone;
	/**
	 * @return the date
	 */
	@XmlElement
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the pid
	 */
	@XmlElement
	public String getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	
}
