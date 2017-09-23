package org.helpdesk.webservice.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * @author dethakku
 * Response wrapper for available time slots
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "AppointmentAvailableTimeSlotResponse")
public class AppointmentAvailableTimeSlotResponse extends StatusResponse
		implements RestServiceResponse {
	
	@XmlElement
	private List<String> timeSlots;

	public List<String> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(List<String> timeSlots) {
		this.timeSlots = timeSlots;
	}
}
