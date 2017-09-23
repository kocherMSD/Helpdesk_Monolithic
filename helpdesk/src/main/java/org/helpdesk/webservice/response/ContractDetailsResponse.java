/**
 * 
 */
package org.helpdesk.webservice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author vveerala
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "ContractDetailsResponse")
public class ContractDetailsResponse extends StatusResponse implements RestServiceResponse
{

    List<ContractDetail> contractDetails;

    @XmlElement
    public List<ContractDetail> getContractDetails()
    {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails)
    {
        this.contractDetails = contractDetails;
    }

    @Override
    public String toString()
    {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);

    }

}
