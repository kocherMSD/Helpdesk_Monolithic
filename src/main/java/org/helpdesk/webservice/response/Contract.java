package org.helpdesk.webservice.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Contract")
public class Contract {
	
	private String  ccoid;  
    
	private String  contractnumber;
    
	private String  contractexpdate;
    
	private String  contractstatus;
    
	private String  contracttype;
    
	private String  servicelinedesc;
    
	private String  servicelinestatus;
    
	private String  servicelinestartdate;
    
	private String  servicelineenddate;
    
	private String  billtositeuse_id;
    
	private String  billtoparty_id;
    
	private String  created_date;
    
	private String  updated_date;
    
	private String  version;
    
    private String entitlementKey;

	/**
	 * @return the ccoid
	 */
	@XmlElement  public String getCcoid() {
		return ccoid;
	}

	/**
	 * @param ccoid the ccoid to set
	 */
	public void setCcoid(String ccoid) {
		this.ccoid = ccoid;
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
	 * @return the contractexpdate
	 */
	@XmlElement  public String getContractexpdate() {
		return contractexpdate;
	}

	/**
	 * @param contractexpdate the contractexpdate to set
	 */
	public void setContractexpdate(String contractexpdate) {
		this.contractexpdate = contractexpdate;
	}

	/**
	 * @return the contractstatus
	 */
	@XmlElement  public String getContractstatus() {
		return contractstatus;
	}

	/**
	 * @param contractstatus the contractstatus to set
	 */
	public void setContractstatus(String contractstatus) {
		this.contractstatus = contractstatus;
	}

	/**
	 * @return the contracttype
	 */
	@XmlElement  public String getContracttype() {
		return contracttype;
	}

	/**
	 * @param contracttype the contracttype to set
	 */
	public void setContracttype(String contracttype) {
		this.contracttype = contracttype;
	}

	/**
	 * @return the servicelinedesc
	 */
	@XmlElement  public String getServicelinedesc() {
		return servicelinedesc;
	}

	/**
	 * @param servicelinedesc the servicelinedesc to set
	 */
	public void setServicelinedesc(String servicelinedesc) {
		this.servicelinedesc = servicelinedesc;
	}

	/**
	 * @return the servicelinestatus
	 */
	@XmlElement  public String getServicelinestatus() {
		return servicelinestatus;
	}

	/**
	 * @param servicelinestatus the servicelinestatus to set
	 */
	public void setServicelinestatus(String servicelinestatus) {
		this.servicelinestatus = servicelinestatus;
	}

	/**
	 * @return the servicelinestartdate
	 */
	@XmlElement  public String getServicelinestartdate() {
		return servicelinestartdate;
	}

	/**
	 * @param servicelinestartdate the servicelinestartdate to set
	 */
	public void setServicelinestartdate(String servicelinestartdate) {
		this.servicelinestartdate = servicelinestartdate;
	}

	/**
	 * @return the servicelineenddate
	 */
	@XmlElement  public String getServicelineenddate() {
		return servicelineenddate;
	}

	/**
	 * @param servicelineenddate the servicelineenddate to set
	 */
	public void setServicelineenddate(String servicelineenddate) {
		this.servicelineenddate = servicelineenddate;
	}

	/**
	 * @return the billtositeuse_id
	 */
	@XmlElement  public String getBilltositeuse_id() {
		return billtositeuse_id;
	}

	/**
	 * @param billtositeuse_id the billtositeuse_id to set
	 */
	public void setBilltositeuse_id(String billtositeuse_id) {
		this.billtositeuse_id = billtositeuse_id;
	}

	/**
	 * @return the billtoparty_id
	 */
	@XmlElement  public String getBilltoparty_id() {
		return billtoparty_id;
	}

	/**
	 * @param billtoparty_id the billtoparty_id to set
	 */
	public void setBilltoparty_id(String billtoparty_id) {
		this.billtoparty_id = billtoparty_id;
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
	 * @return the entitlementKey
	 */
	@XmlElement  public String getEntitlementKey() {
		return entitlementKey;
	}

	/**
	 * @param entitlementKey the entitlementKey to set
	 */
	public void setEntitlementKey(String entitlementKey) {
		this.entitlementKey = entitlementKey;
	}	

}
