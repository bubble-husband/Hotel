package cn.edu.lnsf.model;

import java.util.Date;

public class TimeExtension {

	public TimeExtension() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int operatingID;
	private String orderNumber;
	private Date oldExpiryDate;
	private Date newExpiryDate;
	private int addedMoney;
	public int getOperatingID() {
		return operatingID;
	}
	public void setOperatingID(int operatingID) {
		this.operatingID = operatingID;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getOldExpiryDate() {
		return oldExpiryDate;
	}
	public void setOldExpiryDate(Date oldExpiryDate) {
		this.oldExpiryDate = oldExpiryDate;
	}

	public int getAddedMoney() {
		return addedMoney;
	}
	public void setAddedMoney(int addedMoney) {
		this.addedMoney = addedMoney;
	}
	public TimeExtension(int operatingID, String orderNumber,
			Date oldExpiryDate, Date newExpiryDat, int addedMoney) {
		super();
		this.operatingID = operatingID;
		this.orderNumber = orderNumber;
		this.oldExpiryDate = oldExpiryDate;
		this.newExpiryDate = newExpiryDat;
		this.addedMoney = addedMoney;
	}
	@Override
	public String toString() {
		return "TimeExtension [Ðø·ÑºÅ£º" + operatingID + ", orderNumber="
				+ orderNumber + ", oldExpiryDate=" + oldExpiryDate
				+ ", newExpiryDat=" + newExpiryDate + ", addedMoney="
				+ addedMoney + "]";
	}
	public Date getNewExpiryDate() {
		return newExpiryDate;
	}
	public void setNewExpiryDate(Date newExpiryDate) {
		this.newExpiryDate = newExpiryDate;
	}

	
	
}
