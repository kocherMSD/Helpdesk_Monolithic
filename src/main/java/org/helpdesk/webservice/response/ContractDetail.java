package org.helpdesk.webservice.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType
public class ContractDetail 
{

    private String serialNumber;
    private String contractNumber;
    private String contractStatus;
    private String contractType;
    private String installGuId;
    private String billtoCSEName;
    private String installGuName;
    private String installSiteCscId;

    // <SERVICE_LINE_START_DATE>01-APR-04</SERVICE_LINE_START_DATE>
    private String contractStartDay;

    // SERVICE_LINE_END_DATE>31-AUG-14</SERVICE_LINE_END_DATE>
    private String contractLastDay;

    // <CONTRACT_SITE_CUSTOMER_NAME>FORD REGIONAL HUB</CONTRACT_SITE_CUSTOMER_NAME>
    private String ctrctSiteCustName;

    // <INSTALL_SITE_CSC_NAME>ITENOS INTERNATIONAL TELECOM NETWORK OPERATION SERVICES
    // GMBH</INSTALL_SITE_CSC_NAME>
    private String installSiteCustName;
    
    //BILL_TO_CSC_NAME
    private String partnerName;

    // <INSTALL_GU_NAME>DEUTSCHE TELEKOM AG</INSTALL_GU_NAME>
    private String installGlobalUltimateName;

    // SERVICE_LINE_DESCRIPTION
    private String serviceLineDescription;

    // <IS_COVERED>T</IS_COVERED>
    private String isCoveredUnderContract;

    private Location location;

    private String productId;

    public String toString()
    {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);

    }

    @XmlElement
    public String getContractNumber()
    {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber)
    {
        this.contractNumber = contractNumber;
    }

    @XmlElement
    public String getContractStatus()
    {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus)
    {
        this.contractStatus = contractStatus;
    }

    @XmlElement
    public String getContractType()
    {
        return contractType;
    }

    public void setContractType(String contractType)
    {
        this.contractType = contractType;
    }

    @XmlElement
    public String getContractStartDay()
    {
        return contractStartDay;
    }

    public void setContractStartDay(String contractStartDay)
    {
        this.contractStartDay = contractStartDay;
    }

    @XmlElement
    public String getContractLastDay()
    {
        return contractLastDay;
    }

    public void setContractLastDay(String contractLastDay)
    {
        this.contractLastDay = contractLastDay;
    }

    @XmlElement
    public String getCtrctSiteCustName()
    {
        return ctrctSiteCustName;
    }

    public void setCtrctSiteCustName(String ctrctSiteCustName)
    {
        this.ctrctSiteCustName = ctrctSiteCustName;
    }

    @XmlElement
    public String getInstallSiteCustName()
    {
        return installSiteCustName;
    }

    public void setInstallSiteCustName(String installSiteCustName)
    {
        this.installSiteCustName = installSiteCustName;
    }

    @XmlElement
    public String getInstallGlobalUltimateName()
    {
        return installGlobalUltimateName;
    }

    public void setInstallGlobalUltimateName(String installGlobalUltimateName)
    {
        this.installGlobalUltimateName = installGlobalUltimateName;
    }

    @XmlElement
    public String getServiceLineDescription()
    {
        return serviceLineDescription;
    }

    public void setServiceLineDescription(String serviceLineDescription)
    {
        this.serviceLineDescription = serviceLineDescription;
    }

    @XmlElement
    public String getIsCoveredUnderContract()
    {
        return isCoveredUnderContract;
    }

    public void setIsCoveredUnderContract(String isCoveredUnderContract)
    {
        this.isCoveredUnderContract = isCoveredUnderContract;
    }

    @XmlElement
    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
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
    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    /**
     * @return the entitle_flag
     */
  
    /**
     * @return the installGuId
     */
    @XmlElement
    public String getInstallGuId()
    {
        return installGuId;
    }

    /**
     * @param installGuId the installGuId to set
     */
    public void setInstallGuId(String installGuId)
    {
        this.installGuId = installGuId;
    }

    @XmlElement
    public String getPartnerName()
    {
        return partnerName;
    }

    public void setPartnerName(String partnerName)
    {
        this.partnerName = partnerName;
    }

	/**
	 * @return the billtoCSEName
	 */
    @XmlElement
	public String getBilltoCSEName() {
		return billtoCSEName;
	}

	/**
	 * @param billtoCSEName the billtoCSEName to set
	 */
	public void setBilltoCSEName(String billtoCSEName) {
		this.billtoCSEName = billtoCSEName;
	}

	/**
	 * @return the installGuName
	 */
	@XmlElement
	public String getInstallGuName() {
		return installGuName;
	}

	/**
	 * @param installGuName the installGuName to set
	 */
	public void setInstallGuName(String installGuName) {
		this.installGuName = installGuName;
	}

	/**
	 * @return the installSiteCscId
	 */
	@XmlElement
	public String getInstallSiteCscId() {
		return installSiteCscId;
	}

	/**
	 * @param installSiteCscId the installSiteCscId to set
	 */
	public void setInstallSiteCscId(String installSiteCscId) {
		this.installSiteCscId = installSiteCscId;
	} 
	
	
    
    
}
