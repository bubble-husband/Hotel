package cn.edu.lnsf.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lnsf.dao.IwaiterDao;
import cn.edu.lnsf.dbutils.DataAccess;
import cn.edu.lnsf.model.Count;
import cn.edu.lnsf.model.Waiter;

public class WaiterDaoImpl implements IwaiterDao{
	
	//
	public Vector<Waiter> findAllWaiter(){
		Vector<Waiter> v = new Vector<Waiter>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stat = conn.createStatement();
			String sql = "select * from waiter";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Waiter u = new Waiter();
				u.setWaiterID(rs.getString("waiterID"));
				u.setWaiterName(rs.getString("waiterName"));
				u.setWaiterBirthday(rs.getDate("waiterBirthday"));
				u.setWaiterIDCard(rs.getString("waiterIDCard"));
				u.setWaiterJoinDate(rs.getDate("waiterHoinDate"));
				u.setWaiterPhone(rs.getString("waiterPhone"));
				u.setRemarks(rs.getString("remarks"));
				v.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, stat, conn);
		}
		return v;
	}
	
	//判断ID
	public boolean findWaiterID(String ID){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("select * from waiter where waiterID = ?");
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
	
	//根据服务员ID查找服务员
	public Vector<Waiter> findWaiter(String waiterID) {
		Vector<Waiter> v1 = new Vector<Waiter>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("select * from waiter where waiterID = ?");
			prep.setString(1, waiterID);
			rs = prep.executeQuery();
			while (rs.next()) {
				Waiter u = new Waiter();
				u.setWaiterID(rs.getString("waiterID"));
				u.setWaiterName(rs.getString("waiterName"));
				u.setWaiterBirthday(rs.getDate("waiterBirthday"));
				u.setWaiterIDCard(rs.getString("waiterIDCard"));
				u.setWaiterJoinDate(rs.getDate("waiterJoinDate"));
				u.setWaiterPhone(rs.getString("waiterPhone"));
				u.setRemarks(rs.getString("remarks"));
				v1.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return v1;
	}

	 //插入服务员信息
	public boolean insertWaiter(Waiter w){
	    boolean flag = false;
	    String waiterID = w.getWaiterID();
		String waiterName = w.getWaiterName();
		Date waiterBirthdy = w.getWaiterBirthday();
		String waiterIDCard = w.getWaiterIDCard();
		Date waiterJoinDate = w.getWaiterJoinDate();
		String waiterPhone= w.getWaiterPhone();
		Connection conn = null;
		PreparedStatement prep = null;
	    try {
	    	conn = DataAccess.getConnection();
			prep = conn.prepareStatement("insert into waiter values(?,?,?,?,?,?)");
			prep.setString(1, waiterID);
			prep.setString(2, waiterName);
			prep.setDate(3, new java.sql.Date (waiterBirthdy.getTime()));
			prep.setString(4, waiterIDCard);
			prep.setDate(5, new java.sql.Date (waiterJoinDate.getTime()));
			prep.setString(6, waiterPhone);
			prep.executeUpdate();
	    	flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DataAccess.closeConnection(prep, conn);
		}
	return flag;
	}
	
	public List<Count> countProportion(){
		List<Count> list = new ArrayList<Count>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select w.waiterName as Name,count(o.waiterID) as Proportion ,sum(o.totalMoney) as totalMoney from waiter w,orders o where w.waiterID = o.waiterID group by w.waiterName;");
			rs = prep.executeQuery();
			while(rs.next()){
				Count c = new Count();
				c.setCountWaiter(rs.getString("Name"));
				c.setCountWaiterPro(rs.getLong("Proportion"));
				c.setCountMoney(rs.getDouble("totalMoney"));
				list.add(c);
			}
		}catch (SQLException e) {
			e.printStackTrace();		
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;
	}
	
	//更新服务员信息
	public boolean updateWaiter(Waiter w){
		boolean flag = false;
		String waiterID = w.getWaiterID();
		String waiterName = w.getWaiterName();
		Date waiterBirthday = w.getWaiterBirthday();
		String waiterIDCard = w.getWaiterIDCard();
		Date waiterJoinDate = w.getWaiterJoinDate();
		String waiterPhone= w.getWaiterPhone();
		String remarks= w.getRemarks();
		Connection conn = null;
		PreparedStatement prep = null;
		try {
	    	conn = DataAccess.getConnection();
			prep = conn.prepareStatement("update waiter set waiterName = ?,waiterBirthday = ?,waiterIDCard = ?,waiterJoinDate = ?,waiterPhone = ?,remarks = ? where waiterID = ?");
			prep.setString(1, waiterName);
			prep.setDate(2, new java.sql.Date (waiterBirthday.getTime()));
			prep.setString(3, waiterIDCard);
			prep.setDate(4, new java.sql.Date (waiterJoinDate.getTime()));
			prep.setString(5, waiterPhone);
			prep.setString(6, remarks);
			prep.setString(7,waiterID);
			prep.executeUpdate();
	    	flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
	//删除服务员信息
	public boolean deleteWaiter(String waiterID){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("delete from waiter where waiterID = ?");
			prep.setString(1, waiterID);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
	
}

