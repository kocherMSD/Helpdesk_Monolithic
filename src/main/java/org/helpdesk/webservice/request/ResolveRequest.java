package org.helpdesk.webservice.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "ResolveRequest")
public class ResolveRequest {
	
	private String id;
	private String Resotution;
	
	@XmlElement
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlElement
	public String getResotution() {
		return Resotution;
	}
	public void setResotution(String resotution) {
		Resotution = resotution;
	}
	
	

}
