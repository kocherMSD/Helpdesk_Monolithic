package org.helpdesk.webservice.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.NONE)
public class AppointmentRequest  implements
RestServiceRequest {
	
	@XmlElement
	private String date ;
	
	@XmlElement
	private String ccoid;
	
	@XmlElement
	private String pid;
	
	@XmlElement
	private String slot;
	
	@XmlElement
	private String srNo;
	
	@XmlElement
	private String TimeZone;
	
	/**
	 * @return the date
	 */
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
	 * @return the ccoid
	 */
	public String getCcoid() {
		return ccoid;
	}
	/**
	 * @param ccoid the ccoid to set
	 */
	public void setCcoid(String ccoid) {
		this.ccoid = ccoid;
	}
	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * @return the slot
	 */
	public String getSlot() {
		return slot;
	}
	/**
	 * @param slot the slot to set
	 */
	public void setSlot(String slot) {
		this.slot = slot;
	}
	/**
	 * @return the srNo
	 */
	public String getSrNo() {
		return srNo;
	}
	/**
	 * @param srNo the srNo to set
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	/**
	 * @return the timeZone
	 */
	public String getTimeZone() {
		return TimeZone;
	}
	/**
	 * @param timeZone the timeZone to set
	 */
	public void setTimeZone(String timeZone) {
		TimeZone = timeZone;
	}
	

}
