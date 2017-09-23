/**
 * 
 */
package org.helpdesk.webservice.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.helpdesk.webservice.request.BaseRequest;
import org.helpdesk.webservice.request.RestServiceRequest;



@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "ContractDetailsRequest")
public class ContractDetailsRequest extends BaseRequest implements RestServiceRequest
{

    String serialNumber;
    String accessToken;

    @XmlElement
    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }
    
    @XmlElement
    public String getAccessToken()
    {
        return accessToken;
    }

    public void setAccessToken(String accessToken)
    {
        this.accessToken = accessToken;
    }
    public String toString()
    {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);

    }

   

}
