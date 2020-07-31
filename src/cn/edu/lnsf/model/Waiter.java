package cn.edu.lnsf.model;

import java.util.Date;

public class Waiter {

	public Waiter() {
		super();
		// TODO Auto-generated constructor stub
	}


	private String waiterID;
	private String waiterName;
	private Date waiterBirthday;
	private String waiterIDCard;
	private Date waiterJoinDate;
	private String waiterPhone;
	private String remarks;
	public String getWaiterID() {
		return waiterID;
	}
	public void setWaiterID(String waiterID) {
		this.waiterID = waiterID;
	}
	public String getWaiterName() {
		return waiterName;
	}
	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}
	public Date getWaiterBirthday() {
		return waiterBirthday;
	}
	public void setWaiterBirthday(Date bdate) {
		this.waiterBirthday = bdate;
	}
	public String getWaiterIDCard() {
		return waiterIDCard;
	}
	public void setWaiterIDCard(String waiterIDCard) {
		this.waiterIDCard = waiterIDCard;
	}
	public Date getWaiterJoinDate() {
		return waiterJoinDate;
	}
	public void setWaiterJoinDate(Date date) {
		this.waiterJoinDate = date;
	}
	public String getWaiterPhone() {
		return waiterPhone;
	}
	public void setWaiterPhone(String waiterPhone) {
		this.waiterPhone = waiterPhone;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Waiter(String waiterID, String waiterName, Date waiterBirthday,
			String waiterIDCard, Date waiterJoinDate, String waiterPhone,
			String remarks) {
		super();
		this.waiterID = waiterID;
		this.waiterName = waiterName;
		this.waiterBirthday = waiterBirthday;
		this.waiterIDCard = waiterIDCard;
		this.waiterJoinDate = waiterJoinDate;
		this.waiterPhone = waiterPhone;
		this.remarks = remarks;
	}

	
	@Override
	public String toString() {
		return "Waiter [waiterID=" + waiterID + ", waiterName=" + waiterName
				+ ", waiterBirthday=" + waiterBirthday + ", waiterIDCard="
				+ waiterIDCard + ", waiterJoinDate=" + waiterJoinDate
				+ ", waiterPhone=" + waiterPhone + ", remarks=" + remarks + "]";
	}
	
	
	
}
