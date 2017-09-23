package org.helpdesk.db.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name="faststartRequest")
public class TicketTrackEntity  extends BaseBusinessObject{
	
	  

    
    @Transient
	private static final long serialVersionUID = 1L;
	
	@Version
	protected Integer version;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id", nullable=false)
	protected long id;
	

	
	

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, updatable=false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private Date updated;

	

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

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}
	  
    @Column(name="ccoid")
	 private String  ccoid;	
	  
    @Column(name="technology")
	 private String  technology;	
	  
    @Column(name="subTechnology")
	 private String  subTechnology;	
	  
    @Column(name="product")
	 private String  product;	
	  
    @Column(name="productFamily")
	 private String  productFamily;;	
	  
	    @Column(name="issuetype")
	 private String  issuetype;	
		  
	    @Column(name="issuescope")
	 private String  issuescope;	
		  
	    @Column(name="casetitle")
	 private String  casetitle;	
		  
	    @Column(name="status")
	 private String  status;	
		  
	    @Column(name="srno")
	 private String  srno;	
		  
	    @Column(name="phoneno")
	 private String  phoneno;	
	    
	  @Column(name="isPartner")
	 private String isPartner;
	  
	  @Column(name="customer_name")
	 private String customerName;
	  
	  @Column(name="prefered_time")
	  private String  preferedTime;
	  
	  @Column(name="severity")
	  private String  severity;
	  
	  @Column(name="accesslevel")
	  private String accesslevel;


	@Column(name="descriptiveSummary")
	  private String descriptiveSummary;
	
	@Column(name="contract_no")
	  private String contract_no;
	
	@Column(name="serial_no")
	  private String serial_no;
	  @Column(name="serviceLineId")
	  private String serviceLineId;
	
	  /**
	 * @return the preferedTime
	 */
	public String getPreferedTime() {
		return preferedTime;
	}

	/**
	 * @param preferedTime the preferedTime to set
	 */
	public void setPreferedTime(String preferedTime) {
		this.preferedTime = preferedTime;
	}

	/**
	 * @return the preferedMethod
	 */
	public String getPreferedMethod() {
		return preferedMethod;
	}

	/**
	 * @param preferedMethod the preferedMethod to set
	 */
	public void setPreferedMethod(String preferedMethod) {
		this.preferedMethod = preferedMethod;
	}

	@Column(name="prefered_method")
	  private String   preferedMethod;
		  
	
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
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	/**
	 * @return the subTechnology
	 */
	public String getSubTechnology() {
		return subTechnology;
	}
	/**
	 * @param subTechnology the subTechnology to set
	 */
	public void setSubTechnology(String subTechnology) {
		this.subTechnology = subTechnology;
	}
	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	/**
	 * @return the productFamily
	 */
	public String getProductFamily() {
		return productFamily;
	}
	/**
	 * @param productFamily the productFamily to set
	 */
	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}
	/**
	 * @return the issuetype
	 */
	public String getIssuetype() {
		return issuetype;
	}
	/**
	 * @param issuetype the issuetype to set
	 */
	public void setIssuetype(String issuetype) {
		this.issuetype = issuetype;
	}
	/**
	 * @return the issuescope
	 */
	public String getIssuescope() {
		return issuescope;
	}
	/**
	 * @param issuescope the issuescope to set
	 */
	public void setIssuescope(String issuescope) {
		this.issuescope = issuescope;
	}
	/**
	 * @return the casetitle
	 */
	public String getCasetitle() {
		return casetitle;
	}
	/**
	 * @param casetitle the casetitle to set
	 */
	public void setCasetitle(String casetitle) {
		this.casetitle = casetitle;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the srno
	 */
	public String getSrno() {
		return srno;
	}
	/**
	 * @param srno the srno to set
	 */
	public void setSrno(String srno) {
		this.srno = srno;
	}
	/**
	 * @return the phoneno
	 */
	public String getPhoneno() {
		return phoneno;
	}
	/**
	 * @param phoneno the phoneno to set
	 */
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the serviceLineId
	 */
	public String getServiceLineId() {
		return serviceLineId;
	}

	/**
	 * @param serviceLineId the serviceLineId to set
	 */
	public void setServiceLineId(String serviceLineId) {
		this.serviceLineId = serviceLineId;
	}

	/**
	 * @return the descriptiveSummary
	 */
	public String getDescriptiveSummary() {
		return descriptiveSummary;
	}

	/**
	 * @param descriptiveSummary the descriptiveSummary to set
	 */
	public void setDescriptiveSummary(String descriptiveSummary) {
		this.descriptiveSummary = descriptiveSummary;
	}

	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * @return the isPartner
	 */
	public String getIsPartner() {
		return isPartner;
	}

	/**
	 * @param isPartner the isPartner to set
	 */
	public void setIsPartner(String isPartner) {
		this.isPartner = isPartner;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	  /**
	 * @return the accesslevel
	 */
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
	 * @return the contract_no
	 */
	public String getContract_no() {
		return contract_no;
	}

	/**
	 * @param contract_no the contract_no to set
	 */
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}

	/**
	 * @return the serial_no
	 */
	public String getSerial_no() {
		return serial_no;
	}

	/**
	 * @param serial_no the serial_no to set
	 */
	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	
}
