package cn.edu.lnsf.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.lnsf.dao.IcustomersDao;
import cn.edu.lnsf.dbutils.DataAccess;
import cn.edu.lnsf.model.Customers;

public class CustomersDaoImpl implements IcustomersDao {

	// -----------------根据顾客身份证查找顾客-------------------------
	public Vector<Customers> findCustomersBycustomerIDCard(String customerIDCard) {

		Vector<Customers> v1 = new Vector<Customers>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select * from customers where customerIDCard=?");
			prep.setString(1, customerIDCard);
			rs = prep.executeQuery();
			while (rs.next()) {
				Customers c1 = new Customers();
				c1.setCustomerIDCard(rs.getString("customerIDCard"));
				c1.setCustomerGender(rs.getString("customerGender"));
				c1.setCustomerName(rs.getString("customerName"));
				c1.setCustomerBirthday(rs.getDate("customerBirthday"));
				c1.setCustomerPhone(rs.getString("customerPhone"));
				c1.setRemarks(rs.getString("remarks"));
				v1.add(c1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return v1;
	}

	public boolean findCustomersByID(String customerIDCard) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select * from customers where customerIDCard=?");
			prep.setString(1, customerIDCard);
			rs = prep.executeQuery();
			while(rs.next()){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return flag;
	}

	// ---------------------------查找全部顾客信息------------------------------
	public Vector<Customers> findAllCustomers() {
		Vector<Customers> v = new Vector<Customers>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("select * from customers");
			rs = prep.executeQuery();
			while (rs.next()) {
				Customers c = new Customers();
				c.setCustomerIDCard(rs.getString("customerIDCard"));
				c.setCustomerGender(rs.getString("customerGender"));
				c.setCustomerName(rs.getString("customerName"));
				c.setCustomerBirthday(rs.getDate("customerBirthday"));
				c.setCustomerPhone(rs.getString("customerPhone"));
				c.setRemarks(rs.getString("remarks"));
				v.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return v;
	}

	// ------------------------插入顾客信息------------------------------------
	public boolean insertintofoCustomers(Customers c) {
		boolean flag = false;
		String customerIDCard = c.getCustomerIDCard();
		String customerGender = c.getCustomerGender();
		String customerName = c.getCustomerName();
		Date customerBirthday = c.getCustomerBirthday();
		String customerPhone = c.getCustomerPhone();
		String remarks = c.getRemarks();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("insert into customers values(?,?,?,?,?,?)");
			prep.setString(1, customerIDCard);
			prep.setString(2, customerGender);
			prep.setString(3, customerName);
			prep.setDate(4, new java.sql.Date(customerBirthday.getTime()));
			prep.setString(5, customerPhone);
			prep.setString(6, remarks);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return flag;
	}

	// ------------------------------更新顾客信息-----------------------------------
	public boolean updateCustomers(Customers c) {
		boolean flag = false;
		String customerIDCard = c.getCustomerIDCard();
		String customerGender = c.getCustomerGender();
		String customerName = c.getCustomerName();
		Date customerBirthday = (Date) c.getCustomerBirthday();
		String customerPhone = c.getCustomerPhone();
		String remarks = c.getRemarks();
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("update customers set customerGender = ? ,customerName = ?, customerBirthday = ?,customerPhone = ?,remarks = ? where customerIDCard = ?");
			prep.setString(1, customerGender);
			prep.setString(2, customerName);
			prep.setDate(3, (java.sql.Date) customerBirthday);
			prep.setString(4, customerPhone);
			prep.setString(5, remarks);
			prep.setString(6, customerIDCard);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}

	// ------------------------删除一条顾客信息----------------------------
	public boolean deleteCustomers(String customerIDCard) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("delete from customers where customerIDCard = ?");
			prep.setString(1, customerIDCard);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}

	// -----------------根据顾客身份证查找顾客-------------------------
	public boolean customersByID(String ID) {

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select * from customers where customerIDCard=?");
			prep.setString(1, ID);
			rs = prep.executeQuery();

			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return flag;
	}

}
