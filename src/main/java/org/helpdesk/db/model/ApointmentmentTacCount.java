package org.helpdesk.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APPOINTMENT_TAC_COUNTS")
public class ApointmentmentTacCount	 extends BaseBusinessObject implements Serializable{

			
			/**
	 * 
	 */
	         private static final long serialVersionUID = 1L;



			@Id
			@GeneratedValue(strategy=GenerationType.TABLE)
			@Column(name = "id", nullable=false)
			private String  id;
			
		    

		    @Column(name="productId")
		    private String  productId;
		    

		    @Column(name="slotId")
		    private String  slotId;

		    @Column(name="totalSlot")
		    private String  totalSlot;

		    @Column(name="availableSlotsCount")
		    private String  availableSlotsCount;
		    
		    @Column(name="slotDate")
		    private String  slotDate;
		    
			/**
			 * @return the id
			 */
			public String getId() {
				return id;
			}

			/**
			 * @param id the id to set
			 */
			public void setId(String id) {
				this.id = id;
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
			 * @return the totalSlot
			 */
			public String getTotalSlot() {
				return totalSlot;
			}

			/**
			 * @param totalSlot the totalSlot to set
			 */
			public void setTotalSlot(String totalSlot) {
				this.totalSlot = totalSlot;
			}

			/**
			 * @return the availableSlotsCount
			 */
			public String getAvailableSlotsCount() {
				return availableSlotsCount;
			}

			/**
			 * @param availableSlotsCount the availableSlotsCount to set
			 */
			public void setAvailableSlotsCount(String availableSlotsCount) {
				this.availableSlotsCount = availableSlotsCount;
			}

			/**
			 * @return the slotDate
			 */
			public String getSlotDate() {
				return slotDate;
			}

			/**
			 * @param slotDate the slotDate to set
			 */
			public void setSlotDate(String slotDate) {
				this.slotDate = slotDate;
			}

			/**
			 * @return the serialversionuid
			 */
			public static long getSerialversionuid() {
				return serialVersionUID;
			}

			

		    

}
