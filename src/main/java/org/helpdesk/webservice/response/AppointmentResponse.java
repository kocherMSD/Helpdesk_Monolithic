package org.helpdesk.webservice.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "AppointmentResponse")
public class AppointmentResponse extends StatusResponse implements
RestServiceResponse{

}
