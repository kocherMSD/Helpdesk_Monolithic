package org.helpdesk.webservice.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MessageViewAllResponse")
public class MessageViewResponse {
	
	private String messageId;
	private String title;
	private List<String> messages;
	private List<String> date;
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
	 * @return the date
	 */
	@XmlElement
	public List<String> getDate() {
		return date;
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
	 * @param date the date to set
	 */
	public void setDate(List<String> date) {
		this.date = date;
	}
	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}
	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	

}
