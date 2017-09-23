package org.helpdesk.webservice.request;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.NONE)
public class MessageRequest {
	
	private String messageId;
	private String title;
	private String message;
	private String userId;
	private String date;

	/**
	 * @return the messageId
	 */
	@XmlElement
	public String getMessageId() {
		return messageId;
	}
	/**
	 * @return the title
	 */
	@XmlElement
	public String getTitle() {
		return title;
	}
	/**
	 * @return the message
	 */
	@XmlElement
	public String getMessage() {
		return message;
	}
	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the userId
	 */
	@XmlElement
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
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

	

}
