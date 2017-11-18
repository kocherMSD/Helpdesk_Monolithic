package org.helpdesk.webservice.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "ProductFamilyResponse")
public class ProductFamilyResponse {
	
	private List<String> productFamily;

	@XmlElement
	public List<String> getProductFamily() {
		return productFamily;
	}

	public void setProductFamily(List<String> productFamily) {
		this.productFamily = productFamily;
	}
	

}
