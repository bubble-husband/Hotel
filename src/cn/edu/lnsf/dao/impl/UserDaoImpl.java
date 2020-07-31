package cn.edu.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import cn.edu.lnsf.dao.IuserDao;
import cn.edu.lnsf.dbutils.DataAccess;
import cn.edu.lnsf.model.User;

public class UserDaoImpl implements IuserDao {
	// private Connection conn;
	// --------------------登陆系统用户，根据用户编号，密码判断用户是否存在，存在返回true，不存在返回false--------------------
	public int login(String _userID, String _userPassword) {
		int flag = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select * from sysuser where userID = ? and userPassword = ? ");
			prep.setString(1, _userID);
			prep.setString(2, _userPassword);
			rs = prep.executeQuery();
			if (rs.next()) {
				flag = rs.getInt("userSuper");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return flag;
	}

	// 根据用户编号查找用户信息
	public int findUserByuserID(String userID) {
		int flag1 = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select * from sysuser where userID = ?");
			prep.setString(1, userID);
			rs = prep.executeQuery();
			if (rs.next()) {
				flag1 = rs.getInt("loginNumber");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return flag1;
	}

	// 根据用户编号查找用户姓名
	public String findUserNameByuserID(String userID) {
		String flag = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select * from sysuser where userID=?");
			prep.setString(1, userID);
			rs = prep.executeQuery();
			if (rs.next()) {
				flag = rs.getString("userNumber");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return flag;
	}

	// --------------------查找全部用户记录，返回一个对象数组--------------------
	public Vector<User> findAllUser() {

		Vector<User> v = new Vector<User>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			stat = conn.createStatement();
			String sql = "select * from sysuser";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				User u = new User();
				u.setUserID(rs.getString("userID"));
				u.setUserName(rs.getString("userName"));
				u.setUserPassword(rs.getString("userPassword"));
				u.setUserSuper(rs.getInt("userSuper"));
				u.setRegisterTime(rs.getDate("registerTime"));
				u.setLoginNumber(rs.getInt("loginNumber"));
				u.setLastTime(rs.getDate("lastTime"));
				v.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, stat, conn);
		}
		return v;
	}

	// ------------------------------插入会员------------------------------
	public boolean insertinfotoUser(User u) {
		boolean flag = false;
		String userID = u.getUserID();
		String userName = u.getUserName();
		String userPassword = u.getUserPassword();
		int userSuper = u.getUserSuper();
		Date registerTime = u.getRegisterTime();
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("insert into sysuser values(?,?,?,?,?,?,?)");
			prep.setString(1, userID);
			prep.setString(2, userName);
			prep.setString(3, userPassword);
			prep.setInt(4, userSuper);
			prep.setDate(5, new java.sql.Date(registerTime.getTime()));
			prep.setInt(6, 0);
			prep.setDate(7, null);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}

	// ------------------------------注册------------------------------
	public boolean register(User u) {
		boolean flag = false;
		String userID = u.getUserID();
		String userName = u.getUserName();
		String userPassword = u.getUserPassword();
		Date registerTime = u.getRegisterTime();
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("insert into sysuser values(?,?,?,?,?,?,?)");
			prep.setString(1, userID);
			prep.setString(2, userName);
			prep.setString(3, userPassword);
			prep.setInt(4, 1);
			prep.setDate(5, new java.sql.Date(registerTime.getTime()));
			prep.setInt(6, 0);
			prep.setDate(7, null);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}

	// --------------------------------------删除一个用户--------------------------------------
	public boolean deleteUser(String _userID) {
		boolean flag = true;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			conn.setAutoCommit(false);

			// 根据用户id删除用户
			prep = conn.prepareStatement("delete from sysuser where userID=?");
			prep.setString(1, _userID);
			prep.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
			flag = true;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}

	// --------------------------------------更新会员表（修改）--------------------------------------
	public boolean updateUser(User u) {
		boolean flag = false;
		String userID = u.getUserID();
		String userName = u.getUserName();
		String userPassword = u.getUserPassword();
		int userSuper = u.getUserSuper();
		Date registerTime = u.getRegisterTime();
		int loginNumber = u.getLoginNumber();
		Date lastTime = u.getLastTime();
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("update sysuser set userName = ?, userPassword = ?,"
							+ " userSuper = ?,registerTime = ?,loginNumber = ?,lastTime = ? where userID = ?");
			prep.setString(1, userName);
			prep.setString(2, userPassword);
			prep.setInt(3, userSuper);
			prep.setDate(4, new java.sql.Date(registerTime.getTime()));
			prep.setInt(5, loginNumber);
			prep.setDate(6, new java.sql.Date(lastTime.getTime()));
			prep.setString(7, userID);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}

	// -----------------更新登录次数和最后登录时间----------------------
	public boolean updateNumber(User u) {
		boolean flag = false;
		String userID = u.getUserID();
		int loginNumber = u.getLoginNumber();
		Date lastTime = u.getLastTime();
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("update sysuser set loginNumber = ?,lastTime = ? where userID = ?");

			prep.setInt(1, loginNumber);
			prep.setDate(2, new java.sql.Date(lastTime.getTime()));
			prep.setString(3, userID);
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
