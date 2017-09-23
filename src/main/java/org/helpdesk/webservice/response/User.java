package org.helpdesk.webservice.response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Column;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "User")
public class User {
	
		private String ccoid;	
		  
		private String firstname;	
		  
		private String middlename;	
		  
		private String lastname;	
		  
		private String erpparty_id;	
		  
		private String companyname;	
		  
		private String accesslevel;	
		  
		private String emailaddress;	
		  
		private String crparty_id;	
		  
		private String phonenumber;	
		  
		private String gu_id;	
		  
		private String created_date;	
		  
		private String updated_date;	
	    
	    /**
		 * @return the ccoid
		 */
		@XmlElement
		public String getCcoid() {
			return ccoid;
		}

		/**
		 * @param ccoid the ccoid to set
		 */
		public void setCcoid(String ccoid) {
			this.ccoid = ccoid;
		}

		/**
		 * @return the firstname
		 */
		@XmlElement
		public String getFirstname() {
			return firstname;
		}

		/**
		 * @param firstname the firstname to set
		 */
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		/**
		 * @return the middlename
		 */
		@XmlElement
		public String getMiddlename() {
			return middlename;
		}

		/**
		 * @param middlename the middlename to set
		 */
		public void setMiddlename(String middlename) {
			this.middlename = middlename;
		}

		/**
		 * @return the lastname
		 */
		@XmlElement
		public String getLastname() {
			return lastname;
		}

		/**
		 * @param lastname the lastname to set
		 */
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		/**
		 * @return the erpparty_id
		 */
		@XmlElement
		public String getErpparty_id() {
			return erpparty_id;
		}

		/**
		 * @param erpparty_id the erpparty_id to set
		 */
		public void setErpparty_id(String erpparty_id) {
			this.erpparty_id = erpparty_id;
		}

		/**
		 * @return the companyname
		 */
		@XmlElement
		public String getCompanyname() {
			return companyname;
		}

		/**
		 * @param companyname the companyname to set
		 */
		public void setCompanyname(String companyname) {
			this.companyname = companyname;
		}

		/**
		 * @return the accesslevel
		 */
		@XmlElement
		public String getAccesslevel() {
			return accesslevel;
		}

		/**
		 * @param accesslevel the accesslevel to set
		 */
		public void setAccesslevel(String accesslevel) {
			this.accesslevel = accesslevel;
		}

		/**
		 * @return the emailaddress
		 */
		@XmlElement
		public String getEmailaddress() {
			return emailaddress;
		}

		/**
		 * @param emailaddress the emailaddress to set
		 */
		public void setEmailaddress(String emailaddress) {
			this.emailaddress = emailaddress;
		}

		/**
		 * @return the crparty_id
		 */
		@XmlElement
		public String getCrparty_id() {
			return crparty_id;
		}

		/**
		 * @param crparty_id the crparty_id to set
		 */
		public void setCrparty_id(String crparty_id) {
			this.crparty_id = crparty_id;
		}

		/**
		 * @return the phonenumber
		 */
		@XmlElement
		public String getPhonenumber() {
			return phonenumber;
		}

		/**
		 * @param phonenumber the phonenumber to set
		 */
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}

		/**
		 * @return the gu_id
		 */
		@XmlElement
		public String getGu_id() {
			return gu_id;
		}

		/**
		 * @param gu_id the gu_id to set
		 */
		public void setGu_id(String gu_id) {
			this.gu_id = gu_id;
		}

		/**
		 * @return the created_date
		 */
		@XmlElement
		public String getCreated_date() {
			return created_date;
		}

		/**
		 * @param created_date the created_date to set
		 */
		public void setCreated_date(String created_date) {
			this.created_date = created_date;
		}

		/**
		 * @return the updated_date
		 */
		@XmlElement
		public String getUpdated_date() {
			return updated_date;
		}

		/**
		 * @param updated_date the updated_date to set
		 */
		public void setUpdated_date(String updated_date) {
			this.updated_date = updated_date;
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

		private String  AppointmentCapability;
		  

}
