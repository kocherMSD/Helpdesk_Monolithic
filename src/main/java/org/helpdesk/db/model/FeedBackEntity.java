package org.helpdesk.db.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name="feedback")
public class FeedBackEntity extends BaseBusinessObject implements Serializable{
	
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id", nullable=false)
	private long  id;
    
    
    @Column(name="ccoid")
	private String  ccoid;  
    
    @Column(name="case_id")
	private String  case_id;
    
    @Column(name="product_id")
	private String  product_id;
    
    @Column(name="rating")
	private String  rating;
    
    @Column(name="feedback")
	private String  feedback;
    
   
    @Column(name="created_date")
	private String  created_date;
    
   
	
    /**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the ccoid
	 */
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
	 * @return the created_date
	 */
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
	 * @return the case_id
	 */
	public String getCase_id() {
		return case_id;
	}


	/**
	 * @param case_id the case_id to set
	 */
	public void setCase_id(String case_id) {
		this.case_id = case_id;
	}



	/**
	 * @return the product_id
	 */
	public String getProduct_id() {
		return product_id;
	}


	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}


	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}


	/**
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}


	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	@Override
    public String toString()
    {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);

    }
	
	
}
