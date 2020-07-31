package cn.edu.lnsf.model;

import java.util.Date;

public class Customers {

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String customerIDCard;
	private String customerGender;
	private String customerName;
	private Date customerBirthday;
	private String customerPhone;
	private String remarks;
	public String getCustomerIDCard() {
		return customerIDCard;
	}
	public void setCustomerIDCard(String customerIDCard) {
		this.customerIDCard = customerIDCard;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Customers(String customerIDCard, String customerGender,
			String customerName, Date customerBirthday, String customerPhone,
			String remarks) {
		super();
		this.customerIDCard = customerIDCard;
		this.customerGender = customerGender;
		this.customerName = customerName;
		this.customerBirthday = customerBirthday;
		this.customerPhone = customerPhone;
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Customers [customerIDCard=" + customerIDCard
				+ ", customerGender=" + customerGender + ", customerName="
				+ customerName + ", customerBirthday=" + customerBirthday
				+ ", customerPhone=" + customerPhone + ", remarks=" + remarks
				+ "]";
	}
	public Date getCustomerBirthday() {
		return customerBirthday;
	}
	public void setCustomerBirthday(Date customerBirthday) {
		this.customerBirthday = customerBirthday;
	}

	
	
}
