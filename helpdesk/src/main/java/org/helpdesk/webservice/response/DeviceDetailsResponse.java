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
@XmlRootElement(name = "DeviceDetailsResponse")
public class DeviceDetailsResponse extends StatusResponse implements RestServiceResponse
{

    //DeviceDetail deviceDetail;
    List<DeviceDetail> deviceDetailList;

   /* @XmlElement
    public DeviceDetail getDeviceDetail()
    {
        return deviceDetail;
    }
    
    public void setDeviceDetail(DeviceDetail deviceDetail)
    {
        this.deviceDetail = deviceDetail;
    }
    
    */
    
    
   
    /**
     * @return the deviceDetailList
     */
    @XmlElement
    public List<DeviceDetail> getDeviceDetailList()
    {
        return deviceDetailList;
    }

    /**
     * @param deviceDetailList the deviceDetailList to set
     */
    public void setDeviceDetailList(List<DeviceDetail> deviceDetailList)
    {
        this.deviceDetailList = deviceDetailList;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }


}
