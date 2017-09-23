package org.helpdesk.webservice.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "CategorizerRequest")
public class CategorizerRequest {
	@XmlElement
	private String caseTitle;
	@XmlElement
	private String caseDescription;
	
	@XmlElement
	private String userId;
	
	/**
	 * @return the caseTitle
	 */
	public String getCaseTitle() {
		return caseTitle;
	}
	/**
	 * @param caseTitle the caseTitle to set
	 */
	public void setCaseTitle(String caseTitle) {
		this.caseTitle = caseTitle;
	}
	/**
	 * @return the caseDescription
	 */
	public String getCaseDescription() {
		return caseDescription;
	}
	/**
	 * @param caseDescription the caseDescription to set
	 */
	public void setCaseDescription(String caseDescription) {
		this.caseDescription = caseDescription;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
