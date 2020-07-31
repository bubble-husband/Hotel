package cn.edu.lnsf.model;

import java.util.Date;

public class User {
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String userID;
	private String userName;
	private String userPassword;
	private int userSuper;
	private Date registerTime;
	private int loginNumber;
	private Date lastTime;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserSuper() {
		return userSuper;
	}
	public void setUserSuper(int userSuper) {
		this.userSuper = userSuper;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public int getLoginNumber() {
		return loginNumber;
	}
	public void setLoginNumber(int loginNumber) {
		this.loginNumber = loginNumber;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userSuper=" + userSuper + ",loginNumber=" + loginNumber + ",lastTime=" + lastTime
				+ ",registerTime=" + registerTime + "]";
	}


}
