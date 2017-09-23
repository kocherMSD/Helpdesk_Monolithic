package org.helpdesk.webservice.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author anujsin
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "SearchResponse")
public class SearchResponse extends StatusResponse implements RestServiceResponse {
	
	private ProductDetailsResponse catalogue;
	private ViewAllTicketResponse tickets;
	private MessageViewAllResponse messages;
	private DeviceDetailResponse device;
	
	@XmlElement(name="catalogue")
	public ProductDetailsResponse getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(ProductDetailsResponse catalogue) {
		this.catalogue = catalogue;
	}
	@XmlElement(name="Tickets")
	public ViewAllTicketResponse getTickets() {
		return tickets;
	}
	public void setTickets(ViewAllTicketResponse tickets) {
		this.tickets = tickets;
	}
	@XmlElement(name="messages")
	public MessageViewAllResponse getMessages() {
		return messages;
	}
	public void setMessages(MessageViewAllResponse messages) {
		this.messages = messages;
	}
	@XmlElement(name="devices")
	public DeviceDetailResponse getDevice() {
		return device;
	}
	public void setDevice(DeviceDetailResponse device) {
		this.device = device;
	}
	
	
	
	

}
