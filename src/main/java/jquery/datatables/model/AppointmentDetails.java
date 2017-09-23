package jquery.datatables.model;

import java.util.List;

public class AppointmentDetails {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ApointmentSlot == null) ? 0 : ApointmentSlot.hashCode());
		result = prime * result
				+ ((AppointmentDate == null) ? 0 : AppointmentDate.hashCode());
		result = prime * result + AvailableCount;
		result = prime * result + TotalCount;
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppointmentDetails other = (AppointmentDetails) obj;
		if (ApointmentSlot == null) {
			if (other.ApointmentSlot != null)
				return false;
		} else if (!ApointmentSlot.equals(other.ApointmentSlot))
			return false;
		if (AppointmentDate == null) {
			if (other.AppointmentDate != null)
				return false;
		} else if (!AppointmentDate.equals(other.AppointmentDate))
			return false;
		if (AvailableCount != other.AvailableCount)
			return false;
		if (TotalCount != other.TotalCount)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}






	 static int nextID = 1;

    public AppointmentDetails(String productName, String AppointmentDate, String ApointmentSlot, int TotalCount,int AvailableCount)
    {
        this.id = nextID++;
        this.productName = productName;
        this.AppointmentDate = AppointmentDate;
        this.ApointmentSlot = ApointmentSlot;
        this.AvailableCount = AvailableCount; 
        this.TotalCount = TotalCount; 
    }
    





	private int id;
    private String productName;
    private String AppointmentDate;
    private String ApointmentSlot;
    private int AvailableCount;
    private int TotalCount;

	public int getId() {
		return id;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the appointmentDate
	 */
	public String getAppointmentDate() {
		return AppointmentDate;
	}

	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(String appointmentDate) {
		AppointmentDate = appointmentDate;
	}

	/**
	 * @return the apointmentSlot
	 */
	public String getApointmentSlot() {
		return ApointmentSlot;
	}

	/**
	 * @param apointmentSlot the apointmentSlot to set
	 */
	public void setApointmentSlot(String apointmentSlot) {
		ApointmentSlot = apointmentSlot;
	}

	/**
	 * @return the availableCount
	 */
	public int getAvailableCount() {
		return AvailableCount;
	}

	/**
	 * @param availableCount the availableCount to set
	 */
	public void setAvailableCount(int availableCount) {
		AvailableCount = availableCount;
	}
	
	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return TotalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		TotalCount = totalCount;
	}

	/**
	 * @return the nextID
	 */
	public static int getNextID() {
		return nextID;
	}

	/**
	 * @param nextID the nextID to set
	 */
	public static void setNextID(int nextID) {
		AppointmentDetails.nextID = nextID;
	}

	
}
