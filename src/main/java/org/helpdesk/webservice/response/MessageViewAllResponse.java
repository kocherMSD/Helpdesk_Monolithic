package org.helpdesk.webservice.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.helpdesk.webservice.request.MessageRequest;


@XmlRootElement(name = "MessageViewAllResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class MessageViewAllResponse {

	private List<MessageRequest> messages;

	/**
	 * @return the messages
	 */
	@XmlElement
	public List<MessageRequest> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<MessageRequest> messages) {
		this.messages = messages;
	}
		
}
