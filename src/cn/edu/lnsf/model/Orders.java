package cn.edu.lnsf.model;


import java.util.Date;

public class Orders {

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String orderNumber;
	private String orderStatus;
	private String customerIDCard;
	private String roomNumber;
	private Date checkInTime;
	private Date checkOutTime;
	private int totalMoney;
	private String waiterID ;
	private String remarks;
	private Date orderTime;
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getCustomerIDCard() {
		return customerIDCard;
	}
	public void setCustomerIDCard(String customerIDCard) {
		this.customerIDCard = customerIDCard;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getWaiterID() {
		return waiterID;
	}
	public void setWaiterID(String waiterID) {
		this.waiterID = waiterID;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Orders(String orderNumber, String orderStatus,
			String customerIDCard, String roomNumber, Date checkInTime,
			Date checkOutTime, int totalMoney, String waiterID, String remarks,
			Date orderTime) {
		super();
		this.orderNumber = orderNumber;
		this.orderStatus = orderStatus;
		this.customerIDCard = customerIDCard;
		this.roomNumber = roomNumber;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.totalMoney = totalMoney;
		this.waiterID = waiterID;
		this.remarks = remarks;
		this.orderTime = orderTime;
	}
	@Override
	public String toString() {
		return "Orders [orderNumber=" + orderNumber + ", orderStatus="
				+ orderStatus + ", customerIDCard=" + customerIDCard
				+ ", roomNumber=" + roomNumber + ", checkInTime=" + checkInTime
				+ ", checkOutTime=" + checkOutTime + ", totalMoney="
				+ totalMoney + ", waiterID=" + waiterID + ", remarks="
				+ remarks + ", orderTime=" + orderTime + "]";
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public Date getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	
	
}
