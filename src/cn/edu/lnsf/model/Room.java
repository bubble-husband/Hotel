package cn.edu.lnsf.model;

public class Room {

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String roomNumber;
	private String roomType;
	private String roomStatus;
	private int roomPrice;
	private String remarks;
	private int roomCount;//–¬‘ˆ Ù–‘
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getroomCount() {
		return roomCount;
	}
	public void setroomCount(int roomCount) {
		this.roomCount = roomCount;
	}
	public Room(String roomNumber, String roomType, String roomStatus,
			int roomPrice, String remarks, int roomCount) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.roomStatus = roomStatus;
		this.roomPrice = roomPrice;
		this.remarks = remarks;
		this.roomCount = roomCount;
	}
	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", roomType=" + roomType
				+ ", roomStatus=" + roomStatus + ", roomPrice=" + roomPrice
				+ ", remarks=" + remarks + ", roomCount="+roomCount+"]";
	}

	
	
	
	
}
