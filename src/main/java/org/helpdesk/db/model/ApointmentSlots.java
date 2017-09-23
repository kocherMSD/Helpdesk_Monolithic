package org.helpdesk.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APPOINTMENT_SLOTS")
public class ApointmentSlots extends BaseBusinessObject implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id", nullable=false)
	private int  id;
	
    

    @Column(name="pid")
    private String  pid;
    

    @Column(name="slots")
    private String  slots;


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
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}


	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}


	/**
	 * @return the slots
	 */
	public String getSlots() {
		return slots;
	}


	/**
	 * @param slots the slots to set
	 */
	public void setSlots(String slots) {
		this.slots = slots;
	}
    


}
