package org.helpdesk.webservice.response;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;



/**
 * @author Gogs
 *
 */
/**
 * @author Gogs
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType
public class DeviceData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String companyName;
	String deviceId;
	String hostname;
	String ipAddress;
	String productFamily;
	String inventoryName;
	String rawSerialNumber;
	String validatedSerialNumber;
	String sysLocation;
	
	/**
	 * @return the companyName
	 */
	@XmlElement
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the deviceId
	 */
	@XmlElement
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * @param deviceId the deviceId to set
	 */
	
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * @return the hostname
	 */
	@XmlElement
	public String getHostname() {
		return hostname;
	}
	/**
	 * @param hostname the hostname to set
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	/**
	 * @return the ipAddress
	 */
	@XmlElement
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * @return the productFamily
	 */
	@XmlElement
	public String getProductFamily() {
		return productFamily;
	}
	/**
	 * @param productFamily the productFamily to set
	 */
	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}
	/**
	 * @return the serialversionuid
	 */
	@XmlElement
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the inventoryName
	 */
	
	@XmlElement
	public String getInventoryName() {
		return inventoryName;
	}
	/**
	 * @param inventoryName the inventoryName to set
	 */
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	/**
	 * @return the rawSerialNumber
	 */
	
	@XmlElement
	public String getRawSerialNumber() {
		return rawSerialNumber;
	}
	/**
	 * @param rawSerialNumber the rawSerialNumber to set
	 */
	public void setRawSerialNumber(String rawSerialNumber) {
		this.rawSerialNumber = rawSerialNumber;
	}
	/**
	 * @return the validatedSerialNumber
	 */
	
	@XmlElement
	public String getValidatedSerialNumber() {
		return validatedSerialNumber;
	}
	/**
	 * @param validatedSerialNumber the validatedSerialNumber to set
	 */
	public void setValidatedSerialNumber(String validatedSerialNumber) {
		this.validatedSerialNumber = validatedSerialNumber;
	}
	/**
	 * @return the sysLocation
	 */
	
	@XmlElement
	public String getSysLocation() {
		return sysLocation;
	}
	/**
	 * @param sysLocation the sysLocation to set
	 */
	public void setSysLocation(String sysLocation) {
		this.sysLocation = sysLocation;
	}
	
	
	@Override
	public String toString()
	{
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		
	}
	

}
