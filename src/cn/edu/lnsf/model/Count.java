package cn.edu.lnsf.model;

public class Count {

	public Count() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String countYear;
	private String countMonth;
	private String countWeek;
	private String countDay;
	private String countRoomType;
	private String countRoomStatus;
	private String countWaiter;
	private float countOrders;
	private int countNumber;
	private long countWaiterPro;
	private double countMoney;
	public String getCountYear() {
		return countYear;
	}
	public void setCountYear(String countYear) {
		this.countYear = countYear;
	}


	public String getCountMonth() {
		return countMonth;
	}
	public void setCountMonth(String countMonths) {
		this.countMonth = countMonths;
	}
	public String getCountWeek() {
		return countWeek;
	}
	public void setCountWeek(String countWeek) {
		this.countWeek = countWeek;
	}
	public String getCountDay() {
		return countDay;
	}
	public void setCountDay(String countDay) {
		this.countDay = countDay;
	}
	public String getCountRoomType() {
		return countRoomType;
	}
	public void setCountRoomType(String countRoomType) {
		this.countRoomType = countRoomType;
	}
	public String getCountRoomStatus() {
		return countRoomStatus;
	}
	public void setCountRoomStatus(String countRoomStatus) {
		this.countRoomStatus = countRoomStatus;
	}
	public String getCountWaiter() {
		return countWaiter;
	}
	public void setCountWaiter(String countWaiter) {
		this.countWaiter = countWaiter;
	}
	public long getCountWaiterPro() {
		return countWaiterPro;
	}
	public void setCountWaiterPro(long countWaiterPro) {
		this.countWaiterPro = countWaiterPro;
	}
	public double getCountMoney() {
		return countMoney;
	}
	public void setCountMoney(double countMoney) {
		this.countMoney = countMoney;
	}
	@Override
	public String toString() {
		return "Count [countYear=" + countYear + ", countMonth=" + countMonth
				+ ", countWeek=" + countWeek + ", countDay=" + countDay
				+ ", countRoomType=" + countRoomType + ", countRoomStatus="
				+ countRoomStatus + ", countWaiter=" + countWaiter
				+ ", countOrders=" + countOrders + ", countNumber="
				+ countNumber + ", countWaiterPro=" + countWaiterPro
				+ ", countMoney=" + countMoney + "]";
	}
	public int getCountNumber() {
		return countNumber;
	}
	public void setCountNumber(int countNumber) {
		this.countNumber = countNumber;
	}
	public float getCountOrders() {
		return countOrders;
	}
	public void setCountOrders(float countOrders) {
		this.countOrders = countOrders;
	}
	
}
