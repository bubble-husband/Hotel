package cn.edu.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import cn.edu.lnsf.dao.IordersDao;
import cn.edu.lnsf.dbutils.DataAccess;
import cn.edu.lnsf.model.Count;
import cn.edu.lnsf.model.Orders;

public class OrdersDaoImpl implements IordersDao{
	
	//新增订单
	public boolean insertOrders(Orders o){
		boolean flag = false;
		Connection conn = null;
		Date utildate = new java.util.Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String util = formatter.format(utildate);
		PreparedStatement prep = null;
		ResultSet rs = null;
		String orderNumber = o.getOrderNumber();
		String orderStatus = o.getOrderStatus();
		String customerIDCard = o.getCustomerIDCard();
		String roomNumber = o.getRoomNumber();
		Date checkInTime = o.getCheckInTime();
		Date checkOutTime = o.getCheckOutTime();
		int totalMoney = o.getTotalMoney();
		String waiterID = o.getWaiterID();
		String remarks = o.getRemarks();
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("insert into orders values(?,?,?,?,?,?,?,?,?,?)");
			prep.setString(1,orderNumber);
			prep.setString(2,orderStatus);
			prep.setString(3,customerIDCard);
			prep.setString(4,roomNumber);
			prep.setDate(5,new java.sql.Date(checkInTime.getTime()));
			prep.setDate(6,new java.sql.Date(checkOutTime.getTime()));
			prep.setInt(7, totalMoney);
			prep.setString(8,waiterID);
			prep.setString(9,remarks);
			try {
				Date utilDate = formatter.parse(util);
				prep.setDate(10,new java.sql.Date(utilDate.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			prep.executeUpdate();
			flag = true;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			DataAccess.closeConnection(rs, prep, conn);
		}

		return flag;
	}
	
	//年报表
	//select sum(mymoney) as totalmoney, count(*) as sheets from mytable group by date_format(col, '%Y');
	//SELECT action, COUNT(id) count FROM apilog WHERE DATE_FORMAT(`timestamp`,'%Y') = DATE_FORMAT(now(),'%Y') ORDER BY count desc;
	public List<Count> countYearOrders(){
		List<Count> list = new ArrayList<Count>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select date_format(orderTime, '%Y') as Year , sum(totalMoney) as YearTotal from orders where date_format(orderTime, '%Y') = date_format(now(), '%Y') group by date_format(orderTime, '%Y');");
			rs = prep.executeQuery();
			while(rs.next()){
				Count c = new Count();
				c.setCountYear(rs.getString("Year"));
				c.setCountMoney(rs.getDouble("YearTotal"));
				list.add(c);

			}
		}catch (SQLException e) {
			e.printStackTrace();		
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;

	}
	
	public List<Count> countMonthsOrders(){
		List<Count> list = new ArrayList<Count>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select date_format(orderTime, '%M') as Year , sum(totalMoney) as YearTotal from orders  group by date_format(orderTime, '%M');");
			rs = prep.executeQuery();
			while(rs.next()){
				Count c = new Count();
				c.setCountYear(rs.getString("Year"));
				c.setCountMoney(rs.getDouble("YearTotal"));
				list.add(c);

			}
		}catch (SQLException e) {
			e.printStackTrace();		
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;

	}
	
	//月报表
	public List<Count> countMonthOrders(){
		List<Count> list = new ArrayList<Count>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select date_format(orderTime, '%M') as Month , sum(totalMoney) as MonthTotal from orders  group by date_format(orderTime, '%M');");
			rs = prep.executeQuery();
			while(rs.next()){
				Count c = new Count();
				c.setCountMonth(rs.getString("Month"));
				c.setCountMoney(rs.getDouble("MonthTotal"));
				list.add(c);

			}
		}catch (SQLException e) {
			e.printStackTrace();		
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;
	}
	
	public List<Count> countNowmonthOrders(){
		List<Count> list = new ArrayList<Count>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select date_format(now(), '%M') as Month , sum(totalMoney) as MonthTotal from orders where date_format(orderTime, '%M') = date_format(now(), '%M');");
			rs = prep.executeQuery();
			while(rs.next()){
				Count c = new Count();
				c.setCountMonth(rs.getString("Month"));
				c.setCountMoney(rs.getDouble("MonthTotal"));
				list.add(c);

			}
		}catch (SQLException e) {
			e.printStackTrace();		
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;
	}
	
	
	
	//周报表
	public List<Count> countWeekOrders(){
		List<Count> list = new ArrayList<Count>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select date_format(orderTime, '%U') as Week , sum(totalMoney) as MonthTotal from orders  group by date_format(orderTime, '%U');");
			rs = prep.executeQuery();
			while(rs.next()){
				Count c = new Count();
				c.setCountWeek(rs.getString("Week"));
				c.setCountMoney(rs.getDouble("MonthTotal"));
				list.add(c);
			}
		}catch (SQLException e) {
			e.printStackTrace();		
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;
	}
	
	
	public List<Count> countDayOrders(){
		List<Count> list = new ArrayList<Count>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select date_format(orderTime, '%j') as Day , sum(totalMoney) as MonthTotal from orders group by date_format(orderTime, '%j');");
			rs = prep.executeQuery();
			while(rs.next()){
				Count c = new Count();
				c.setCountDay(rs.getString("Day"));
				c.setCountMoney(rs.getDouble("MonthTotal"));
				list.add(c);
			}
		}catch (SQLException e) {
			e.printStackTrace();		
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;
	}
	
	public List<Count> countNowdayOrders(){
		List<Count> list = new ArrayList<Count>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select date_format(now(),'%j') as Day , sum(totalMoney) as MonthTotal from orders  where date_format(orderTime,'%j') = date_format(now(),'%j');");
			rs = prep.executeQuery();
			while(rs.next()){
				Count c = new Count();
				c.setCountDay(rs.getString("Day"));
				c.setCountMoney(rs.getDouble("MonthTotal"));
				list.add(c);
			}
		}catch (SQLException e) {
			e.printStackTrace();		
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;
	}
	


	//根据订单号，删除订单
	public boolean deleteOrders(String orderNumber) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		PreparedStatement prep1 = null;
		PreparedStatement prep2 = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("delete from ordertracking where orderNumber = ?");
			prep.setString(1, orderNumber);
			prep2 = conn.prepareStatement("delete from timeextension where orderNumber = ?");
			prep2.setString(1, orderNumber);
			prep1 =conn.prepareStatement("delete from orders where orderNumber = ?");
			prep1.setString(1, orderNumber);
			prep.executeUpdate();
			prep1.executeUpdate();
			prep2.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	

	//查询订单
	public Vector<Orders> findAllOrders(){
		Vector<Orders> v = new Vector<Orders>();
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		try {
			conn = DataAccess.getConnection();
			stat = conn.createStatement();
			String sql = "select * from orders";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				Orders s =new Orders();
				s.setOrderNumber(rs.getString("orderNumber"));
				s.setCustomerIDCard(rs.getString("customerIDCard"));
				s.setOrderStatus(rs.getString("orderStatus"));
				s.setRoomNumber(rs.getString("roomNumber"));
				s.setCheckInTime(rs.getDate("checkInTime"));
				s.setCheckOutTime(rs.getDate("checkOutTime"));
				s.setTotalMoney(rs.getInt("totalMoney"));
				s.setWaiterID(rs.getString("waiterID"));
				s.setRemarks(rs.getString("remarks"));
				s.setOrderTime(rs.getDate("orderTime"));
				v.add(s);
			}
		}catch (SQLException e) {

			e.printStackTrace();
			
		}finally{
			DataAccess.closeConnection(rs, stat, conn);
		}
		return v;

	}
	

	
	
	//根据订单号查询订单信息
	public Vector<Orders> findOrdersByID(Orders record){
		Vector<Orders> v = new Vector<Orders>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		String orderNumber = record.getOrderNumber();
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("select * from orders where orderNumber = ?");
			prep.setString(1, orderNumber);
			rs = prep.executeQuery();
			while(rs.next()){
				Orders s =new Orders();
				s.setOrderNumber(rs.getString("orderNumber"));
				s.setCustomerIDCard(rs.getString("customerIDCard"));
				s.setRoomNumber(rs.getString("roomNumber"));
				s.setCheckInTime(rs.getDate("checkInTime"));
				s.setCheckOutTime(rs.getDate("checkOutTime"));
				s.setTotalMoney(rs.getInt("totalMoney"));
				s.setWaiterID(rs.getString("waiterID"));
				s.setRemarks(rs.getString("remarks"));
				s.setOrderTime(rs.getDate("orderTime"));
				v.add(s);
			}
		}catch (SQLException e) {

			e.printStackTrace();
			
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return v;

	}
	
	//入住
	public boolean updateOrderInfo(Orders record) {
		boolean flag = false;
		String orderNumber = record.getRoomNumber();
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("update orders set orderStatus = ? where orderNumber = ?");
			prep.setString(1, "已入住");
			prep.setString(2, orderNumber);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
	//退房
	public boolean updateOrderOutfo(Orders record) {
		boolean flag = false;
		String orderNumber = record.getRoomNumber();
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("update orders set orderStatus = ? where orderNumber = ?");
			prep.setString(1, "已退房");
			prep.setString(2, orderNumber);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}

	public List<Count> countOrders(){
		List<Count> list = new ArrayList<Count>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select count(orderNumber) as OrdersNumber from orders;");
			rs = prep.executeQuery();
			while(rs.next()){
				Count c = new Count();
				c.setCountOrders(rs.getFloat("OrdersNumber"));
				list.add(c);
			}
		}catch (SQLException e) {
			e.printStackTrace();		
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;
	}
	

	
}


