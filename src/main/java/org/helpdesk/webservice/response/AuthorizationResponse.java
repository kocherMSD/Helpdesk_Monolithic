package org.helpdesk.webservice.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "AuthorizationResponse")
public class AuthorizationResponse extends StatusResponse implements
RestServiceResponse {
	
	private String privilege_level;
	private String access_level;
	private String fs_app_version;
	
	private String smart_suggest_enabled;
	private String case_creation_restriction_enabled;
	private String user_business_hours;
	private String AppointmentCapability;
	
	
	
	public String toString()
	{
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		
	}

	/**
	 * @return the privilege_level
	 */
	@XmlElement
	public String getPrivilege_level() {
		return privilege_level;
	}

	/**
	 * @param privilege_level the privilege_level to set
	 */
	public void setPrivilege_level(String privilege_level) {
		this.privilege_level = privilege_level;
	}
	/**
	 * @return access_level
	 */
	@XmlElement
	public String getAccess_level() {
		return access_level;
	}
	/**
	 * 
	 * @param access_level access level to set
	 */
	public void setAccess_level(String access_level) {
		this.access_level = access_level;
	}

	/**
	 * @return the fs_app_version
	 */
	@XmlElement
	public String getFs_app_version() {
		return fs_app_version;
	}

	/**
	 * @param fs_app_version the fs_app_version to set
	 */
	public void setFs_app_version(String fs_app_version) {
		this.fs_app_version = fs_app_version;
	}

	/**
	 * @return the smart_suggest_enabled
	 */
	@XmlElement
	public String getSmart_suggest_enabled() {
		return smart_suggest_enabled;
	}

	/**
	 * @param smart_suggest_enabled the smart_suggest_enabled to set
	 */
	public void setSmart_suggest_enabled(String smart_suggest_enabled) {
		this.smart_suggest_enabled = smart_suggest_enabled;
	}

	/**
	 * @return the case_creation_restriction_enabled
	 */
	@XmlElement
	public String getCase_creation_restriction_enabled() {
		return case_creation_restriction_enabled;
	}

	/**
	 * @param case_creation_restriction_enabled the case_creation_restriction_enabled to set
	 */
	public void setCase_creation_restriction_enabled(
			String case_creation_restriction_enabled) {
		this.case_creation_restriction_enabled = case_creation_restriction_enabled;
	}



	/**
	 * @return the user_business_hours
	 */
	@XmlElement
	public String getUser_business_hours() {
		return user_business_hours;
	}

	/**
	 * @param user_business_hours the user_business_hours to set
	 */
	public void setUser_business_hours(String user_business_hours) {
		this.user_business_hours = user_business_hours;
	}

	/**
	 * @return the appointmentCapability
	 */
	@XmlElement
	public String getAppointmentCapability() {
		return AppointmentCapability;
	}

	/**
	 * @param appointmentCapability the appointmentCapability to set
	 */

	public void setAppointmentCapability(String appointmentCapability) {
		AppointmentCapability = appointmentCapability;
	}

}
