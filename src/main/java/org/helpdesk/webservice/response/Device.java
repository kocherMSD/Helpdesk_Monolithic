package org.helpdesk.webservice.response;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Device")
public class Device {
	
	  
	private String PID;	
	  
	private String contractnumber;	
	  
	private String serialnumber;	
	  
	private String product_id;	
	  
	private String created_date;	
	  
	private String updated_date;	
	  
	private String version;
    
    private String supported;
    
    private String servicelineID;

	/**
	 * @return the pID
	 */
	@XmlElement  public String getPID() {
		return PID;
	}

	/**
	 * @param pID the pID to set
	 */
	public void setPID(String pID) {
		PID = pID;
	}

	/**
	 * @return the contractnumber
	 */
	@XmlElement  public String getContractnumber() {
		return contractnumber;
	}

	/**
	 * @param contractnumber the contractnumber to set
	 */
	public void setContractnumber(String contractnumber) {
		this.contractnumber = contractnumber;
	}

	/**
	 * @return the serialnumber
	 */
	@XmlElement  public String getSerialnumber() {
		return serialnumber;
	}

	/**
	 * @param serialnumber the serialnumber to set
	 */
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	/**
	 * @return the product_id
	 */
	@XmlElement  public String getProduct_id() {
		return product_id;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	/**
	 * @return the created_date
	 */
	@XmlElement  public String getCreated_date() {
		return created_date;
	}

	/**
	 * @param created_date the created_date to set
	 */
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	/**
	 * @return the updated_date
	 */
	@XmlElement  public String getUpdated_date() {
		return updated_date;
	}

	/**
	 * @param updated_date the updated_date to set
	 */
	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}

	/**
	 * @return the version
	 */
	@XmlElement  public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the supported
	 */
	@XmlElement  public String getSupported() {
		return supported;
	}

	/**
	 * @param supported the supported to set
	 */
	public void setSupported(String supported) {
		this.supported = supported;
	}

	/**
	 * @return the servicelineID
	 */
	@XmlElement  public String getServicelineID() {
		return servicelineID;
	}

	/**
	 * @param servicelineID the servicelineID to set
	 */
	public void setServicelineID(String servicelineID) {
		this.servicelineID = servicelineID;
	}

}
