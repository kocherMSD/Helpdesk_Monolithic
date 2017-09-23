/**
 * 
 */
package org.helpdesk.webservice.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author anuj
 *
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "DeviceDetailResponse")
public class DeviceDetailResponse extends StatusResponse implements RestServiceResponse {
	
	DeviceData device;
	
	

	/**
	 * @return the device
	 */
    @XmlElement
	public DeviceData getDeviceData() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDeviceData(DeviceData device) {
		this.device = device;
	}

	
	

}
