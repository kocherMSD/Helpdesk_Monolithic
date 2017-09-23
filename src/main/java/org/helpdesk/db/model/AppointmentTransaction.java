package org.helpdesk.db.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APPOINTMENT_SLOTS_TRANSACTION")
public class AppointmentTransaction extends BaseBusinessObject implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id", nullable=false)
	private int  id;
	
    @Column(name="appointmentDate")
    private Date  appointmentDate;
    

    @Column(name="productId")
    private String  productId;
    

    @Column(name="createdDate")
    private String  createdDate;
    

    @Column(name="updatedDate")
    private String  updatedDate;
    
    

    @Column(name="ccoId")
    private String  ccoId;
    

    @Column(name="slotId")
    private String  slotId;
    
    @Column(name="srNo")
    private String  srNo;
    
    

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the appointmentDate
	 */
	public Date getAppointmentDate() {
		return appointmentDate;
	}


	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}


	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}


	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}


	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}


	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}


	/**
	 * @return the ccoId
	 */
	public String getCcoId() {
		return ccoId;
	}


	/**
	 * @param ccoId the ccoId to set
	 */
	public void setCcoId(String ccoId) {
		this.ccoId = ccoId;
	}


	/**
	 * @return the slotId
	 */
	public String getSlotId() {
		return slotId;
	}


	/**
	 * @param slotId the slotId to set
	 */
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}


	/**
	 * @return the srNo
	 */
	public String getSrNo() {
		return srNo;
	}


	/**
	 * @param srNo the srNo to set
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}


	
    	
}
