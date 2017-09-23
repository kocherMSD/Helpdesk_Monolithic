package org.helpdesk.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ReferenceEntity")
public class ReferenceEntity  extends BaseBusinessObject {
	
	  
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id", nullable=false)
	private String  id;	
	  
    @Column(name="tablename")
	 private String  tablename;	
	  
    @Column(name="columnname")
	 private String  columnname;	
	  
    @Column(name="referencetablename")
	 private String  referencetablename;	
	  
    @Column(name="referencetableclomnname")
	 private String  referencetableclomnname;	
	  
    @Column(name="created_date")
	 private String  created_date;	
	  
    @Column(name="updated_date")
	 private String  updated_date;	
	  
    @Column(name="version")
	 private String  version;

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
	 * @return the tablename
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * @param tablename the tablename to set
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * @return the columnname
	 */
	public String getColumnname() {
		return columnname;
	}

	/**
	 * @param columnname the columnname to set
	 */
	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}

	/**
	 * @return the referencetablename
	 */
	public String getReferencetablename() {
		return referencetablename;
	}

	/**
	 * @param referencetablename the referencetablename to set
	 */
	public void setReferencetablename(String referencetablename) {
		this.referencetablename = referencetablename;
	}

	/**
	 * @return the referencetableclomnname
	 */
	public String getReferencetableclomnname() {
		return referencetableclomnname;
	}

	/**
	 * @param referencetableclomnname the referencetableclomnname to set
	 */
	public void setReferencetableclomnname(String referencetableclomnname) {
		this.referencetableclomnname = referencetableclomnname;
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
	 * @return the updated_date
	 */
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
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}


}
