package org.helpdesk.webservice.request;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.helpdesk.webservice.response.Contract;
import org.helpdesk.webservice.response.Device;
import org.helpdesk.webservice.response.User;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "AccountRequest")
public class AccountRequest {
	
	
	private User user;
	private Contract contract;
	private List<Device> devices;
	
	
	/**
	 * @return the user
	 */
	@XmlElement
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the contract
	 */
	@XmlElement
	public Contract getContract() {
		return contract;
	}
	/**
	 * @param contract the contract to set
	 */
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	/**
	 * @return the devices
	 */
	@XmlElement(name="devices")
	public List<Device> getDevices() {
		return devices;
	}
	/**
	 * @param devices the devices to set
	 */
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	

}
