package org.helpdesk.webservice.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType
public class DeviceDetail
{

    private boolean isCoveredInSNTC;
    private String hostName;
    private String ipAddress;
    private String inventoryName;
    private String productFamily;
    private String productId;
    private String deviceId;
    private String rawSerialNumber;
    private String validatedSerialNumber;
    private String sysLocation;
    private String companyName;
    private String endOfLastDateOfSupport;
    private String productDescr;
    
    @XmlElement
    public String getHostName()
    {
        return hostName;
    }
    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }
    
    @XmlElement
    public String getIpAddress()
    {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }
    
    @XmlElement
    public String getInventoryName()
    {
        return inventoryName;
    }
    public void setInventoryName(String inventoryName)
    {
        this.inventoryName = inventoryName;
    }
    
    @XmlElement
    public String getProductFamily()
    {
        return productFamily;
    }
    public void setProductFamily(String productFamily)
    {
        this.productFamily = productFamily;
    }
    
    @XmlElement
    public String getProductId()
    {
        return productId;
    }
    public void setProductId(String productId)
    {
        this.productId = productId;
    }
    
    @XmlElement
    public String getDeviceId()
    {
        return deviceId;
    }
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }
    
    @XmlElement
    public String getRawSerialNumber()
    {
        return rawSerialNumber;
    }
    public void setRawSerialNumber(String rawSerialNumber)
    {
        this.rawSerialNumber = rawSerialNumber;
    }
    
    @XmlElement
    public String getValidatedSerialNumber()
    {
        return validatedSerialNumber;
    }
    public void setValidatedSerialNumber(String validatedSerialNumber)
    {
        this.validatedSerialNumber = validatedSerialNumber;
    }
    
    @XmlElement
    public String getSysLocation()
    {
        return sysLocation;
    }
    public void setSysLocation(String sysLocation)
    {
        this.sysLocation = sysLocation;
    }
    
    @XmlElement
    public String getCompanyName()
    {
        return companyName;
    }
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }
    
    @XmlElement
    public boolean isCoveredInSNTC()
    {
        return isCoveredInSNTC;
    }
    
    public void setCoveredInSNTC(boolean isCoveredInSNTC)
    {
        this.isCoveredInSNTC = isCoveredInSNTC;
    }    
    
    
    
    /**
	 * @return the productDescr
	 */
    @XmlElement
	public String getProductDescr() {
		return productDescr;
	}
	/**
	 * @param productDescr the productDescr to set
	 */
	public void setProductDescr(String productDescr) {
		this.productDescr = productDescr;
	}
	public String toString()
    {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);

    }
    /**
     * @return the endOfLastDateOfSupport
     */
    @XmlElement
    public String getEndOfLastDateOfSupport()
    {
        return endOfLastDateOfSupport;
    }
    
    
    /**
     * @param endOfLastDateOfSupport the endOfLastDateOfSupport to set
     */
    public void setEndOfLastDateOfSupport(String endOfLastDateOfSupport)
    {
        this.endOfLastDateOfSupport = endOfLastDateOfSupport;
    }
    
    
    
}
