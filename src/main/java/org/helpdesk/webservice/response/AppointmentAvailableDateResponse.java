package org.helpdesk.webservice.response;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * @author Anuj
 * Response wrapper for available dates
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "AppointmentAvailableDateResponse")
public class AppointmentAvailableDateResponse extends StatusResponse implements
		RestServiceResponse {
	@XmlElement
    private List<String> availableDates;

	public List<String> getAvailableDates() {
		return availableDates;
	}

	public void setAvailableDates(List<String> availableDates) {
		this.availableDates = availableDates;
	}
}
