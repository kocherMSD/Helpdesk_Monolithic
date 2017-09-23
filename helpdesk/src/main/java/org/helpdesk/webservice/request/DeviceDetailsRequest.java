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
 * @author vveerala
 * 
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "DeviceDetailsRequest")
public class DeviceDetailsRequest extends BaseRequest implements RestServiceRequest
{

    String serialNumber;
    String productId;

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
    public String getProductId()
    {
        return productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    public String toString()
    {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);

    }
}
