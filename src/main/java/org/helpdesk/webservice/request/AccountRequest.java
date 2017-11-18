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
	
	

}
