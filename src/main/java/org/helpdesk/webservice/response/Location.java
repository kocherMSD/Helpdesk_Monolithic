package org.helpdesk.webservice.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


@XmlRootElement(name = "Location")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType
public class Location  {
	
	String address;
	String city;
	String state;
	String country;
	boolean isBasedOnSerialNumber;
	String latitude;
	String longitude;

	@XmlElement(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@XmlElement(name="state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@XmlElement(name="country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

	/*@Override
	public String toString()
	{
		return "address " + address + " " +
		"city "+ city + " " +
		"state "+ state + " " +
		"country "+ country;
	}*/
	
	/**
	 * @return the isBasedOnSerialNumber
	 */
	@XmlElement
	public boolean isBasedOnSerialNumber() {
		return isBasedOnSerialNumber;
	}

	/**
	 * @param isBasedOnSerialNumber the isBasedOnSerialNumber to set
	 */
	public void setBasedOnSerialNumber(boolean isBasedOnSerialNumber) {
		this.isBasedOnSerialNumber = isBasedOnSerialNumber;
	}

	public String toString()
	{
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		
	}

	@XmlElement(name="latitude")
    public String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    @XmlElement(name="longitude")
    public String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }
}
