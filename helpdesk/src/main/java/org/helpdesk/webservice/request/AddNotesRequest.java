/**
 * 
 */
package org.helpdesk.webservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;



/**
 * @author atandel
 *
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "AddNotesRequest")
public class AddNotesRequest implements RestServiceRequest {

	SRNote srNote;

	/**
	 * @return the srNote
	 */
	@XmlElement
	public SRNote getSrNote() {
		return srNote;
	}

	/**
	 * @param srNote the srNote to set
	 */
	public void setSrNote(SRNote srNote) {
		this.srNote = srNote;
	}
	
	public String toString()
	{
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		
	}
	

}
