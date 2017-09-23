package org.helpdesk.webservice.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "CategorizerFeedbackRequest")
public class CategorizerFeedbackRequest {
            
	@XmlElement
	private String feedBack;
	
	@XmlElement
	private String feedBackComment;

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public String getFeedBackComment() {
		return feedBackComment;
	}

	public void setFeedBackComment(String feedBackComment) {
		this.feedBackComment = feedBackComment;
	}
}
