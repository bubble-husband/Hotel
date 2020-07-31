package cn.edu.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import cn.edu.lnsf.dao.ItimeextensionDao;
import cn.edu.lnsf.dbutils.DataAccess;
import cn.edu.lnsf.model.Orders;
import cn.edu.lnsf.model.TimeExtension;

public class TimeExtensionDaoImpl implements ItimeextensionDao<Integer> {

	// 根据顾客ID、房间号，查询出订单
	public List<Orders> ordersByRoomCuid(String customerID, String roomNumber) {
		List<Orders> listOrders = new ArrayList<Orders>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select o.orderNumber,r.roomPrice from orders o,room r where r.roomNumber = o.roomNumber and o.customerIDCard = ? and o.roomNumber = ?;");
			prep.setString(1, customerID);
			prep.setString(2, roomNumber);
			rs = prep.executeQuery();
			while (rs.next()) {
				Orders o = new Orders();
				o.setOrderNumber(rs.getString("o.orderNumber"));
				o.setTotalMoney(rs.getInt("r.roomPrice"));
				listOrders.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return listOrders;
	}

	// 根据顾客身份证号和房间号查找订单
	public List<Orders> findOrdersByRoomAndID(String customerID,
			String roomNumber) {
		List<Orders> listOrders = new ArrayList<Orders>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String customers = customerID;
		String room = roomNumber;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select * from orders where customerIDCard = ? and roomNumber = ? and orderStatus = '已入住'");
			prep.setString(1, customers);
			prep.setString(2, room);
			rs = prep.executeQuery();
			while (rs.next()) {
				Orders s = new Orders();
				s.setOrderNumber(rs.getString("orderNumber"));
				s.setOrderStatus(rs.getString("orderStatus"));
				s.setCustomerIDCard(rs.getString("customerIDCard"));
				s.setRoomNumber(rs.getString("roomNumber"));
				s.setCheckInTime(rs.getDate("checkInTime"));
				s.setCheckOutTime(rs.getDate("checkOutTime"));
				s.setTotalMoney(rs.getInt("totalMoney"));
				s.setWaiterID(rs.getString("waiterID"));
				s.setRemarks(rs.getString("remarks"));
				s.setOrderTime(rs.getDate("orderTime"));
				listOrders.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return listOrders;

	}

	// //int自增
	// private AtomicInteger id;
	// public TimeExtensionDaoImpl(){
	// id = new AtomicInteger();
	// }
	// public TimeExtensionDaoImpl(int operatingID){
	// id = new AtomicInteger(operatingID);
	// }
	// @Override
	// public Integer next(){
	// return id.incrementAndGet();
	// }

	// 新增续费表
	public boolean insertTimeExtension(TimeExtension t) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		Date utildate = new java.util.Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
		String util = formatter.format(utildate);
		int operatingID = Integer.valueOf(util).intValue();
		String orderNumber = t.getOrderNumber();
		Date oldExpiryDate = t.getOldExpiryDate();
		Date newExpiryDate = t.getNewExpiryDate();
		int addedMoney = t.getAddedMoney();
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("insert into timeExtension values(?,?,?,?,?)");
			prep.setInt(1, operatingID);
			prep.setString(2, orderNumber);
			prep.setDate(3, new java.sql.Date(oldExpiryDate.getTime()));
			prep.setDate(4, new java.sql.Date(newExpiryDate.getTime()));
			prep.setInt(5, addedMoney);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			DataAccess.closeConnection(rs, prep, conn);
		}
		return flag;
	}

	// 根据续费编号，删除续费表
	public boolean deleteTimeExtension(int operatingID) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("delete from timeExtension where operatingID = ?");
			prep.setInt(1, operatingID);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}

	// 根据订单号，删除续费表
	public boolean deleteTimeExtensionByorderNumber(String orderNumber) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("delete from timeExtension where orderNumber = ?");
			prep.setString(1, orderNumber);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}

	// 查询续费表
	public Vector<TimeExtension> findAllTimeExtension() {
		Vector<TimeExtension> v = new Vector<TimeExtension>();
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		try {
			conn = DataAccess.getConnection();
			stat = conn.createStatement();
			String sql = "select * from timeExtension";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				TimeExtension t = new TimeExtension();
				t.setOperatingID(rs.getInt("operatingID"));
				t.setOrderNumber(rs.getString("orderNumber"));
				t.setOldExpiryDate(rs.getDate("oldExpiryDate"));
				t.setNewExpiryDate(rs.getDate("newExpiryDate"));
				t.setAddedMoney(rs.getInt("addedMoney"));
				v.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, stat, conn);
		}
		return v;
	}

	// 根据订单号查询续费信息
	public Vector<TimeExtension> findTimeExtensionByorderNumber(TimeExtension t1) {
		Vector<TimeExtension> v = new Vector<TimeExtension>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String orderNumber = t1.getOrderNumber();
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select * from timeExtension where orderNumber = ?");
			prep.setString(1, orderNumber);
			rs = prep.executeQuery();
			while (rs.next()) {
				TimeExtension t = new TimeExtension();
				t.setOperatingID(rs.getInt("operatingID"));
				t.setOrderNumber(rs.getString("orderNumber"));
				t.setOldExpiryDate(rs.getDate("oldExpiryDate"));
				t.setNewExpiryDate(rs.getDate("newExpiryDate"));
				t.setAddedMoney(rs.getInt("addedMoney"));
				v.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return v;
	}

	// 根据续费单号查询续费信息
	public Vector<TimeExtension> findTimeExtensionByoperatingID(TimeExtension t1) {
		Vector<TimeExtension> v = new Vector<TimeExtension>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		int operatingID = t1.getOperatingID();
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select * from timeExtension where operatingID = ?");
			prep.setInt(1, operatingID);
			rs = prep.executeQuery();
			while (rs.next()) {
				TimeExtension t = new TimeExtension();
				t.setOperatingID(rs.getInt("operatingID"));
				t.setOrderNumber(rs.getString("orderNumber"));
				t.setOldExpiryDate(rs.getDate("oldExpiryDate"));
				t.setNewExpiryDate(rs.getDate("newExpiryDate"));
				t.setAddedMoney(rs.getInt("addedMoney"));
				v.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return v;
	}

}
