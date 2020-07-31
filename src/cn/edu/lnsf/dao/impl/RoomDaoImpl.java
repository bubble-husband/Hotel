package cn.edu.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import cn.edu.lnsf.dao.IroomDao;
import cn.edu.lnsf.dbutils.DataAccess;
import cn.edu.lnsf.model.Count;
import cn.edu.lnsf.model.Room;

public class RoomDaoImpl implements IroomDao {

	// -----------------���ݷ���Ų��ҷ�����Ϣ-------------------------
	public Vector<Room> findRoomByroomNumber(String roomNumber) {
		Vector<Room> v1 = new Vector<Room>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select * from room where roomNumber=?");
			prep.setString(1, roomNumber);
			rs = prep.executeQuery();
			while (rs.next()) {
				Room r1 = new Room();
				r1.setRoomNumber(rs.getString("roomNumber"));
				r1.setRoomType(rs.getString("roomType"));
				r1.setRoomPrice(rs.getInt("roomPrice"));
				r1.setRoomStatus(rs.getString("roomStatus"));
				r1.setRemarks(rs.getString("remarks"));
				v1.add(r1);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return v1;
	}
	
	// -----------------���ݷ���Ų��Ҽ۸�-------------------------
	public int findPriceByroomNumber(String roomNumber) {
		Room r1 = new Room();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		int roomPrice = 0;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select roomPrice from room where roomNumber=?");
			prep.setString(1, roomNumber);
			rs = prep.executeQuery();
			while (rs.next()) {
				r1.setRoomPrice(rs.getInt("roomPrice"));
				roomPrice = r1.getRoomPrice();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return roomPrice;
	}
	
	public int findRoomMoneyByroomNumber(String roomNumber) {
		int n = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select roomPrice from room where roomNumber=?");
			prep.setString(1, roomNumber);
			rs = prep.executeQuery();
			while(rs.next()){
				n = rs.getInt("roomPrice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return n;
	}
	
	// -----------------���ݷ������Ͳ��ҷ�����Ϣ-------------------------
	public Vector<Room> findRoomByroomType(String roomType) {

		Vector<Room> v2 = new Vector<Room>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;

		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("select * from room where roomType = ?");
			prep.setString(1, roomType);
			rs = prep.executeQuery();
			while (rs.next()) {
				Room r2 = new Room();
				r2.setRoomNumber(rs.getString("roomNumber"));
				r2.setRoomType(rs.getString("roomType"));
				r2.setRoomPrice(rs.getInt("roomPrice"));
				r2.setRoomStatus(rs.getString("roomStatus"));
				r2.setRemarks(rs.getString("remarks"));
				v2.add(r2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return v2;
	}
	
	// -----------------ͳ�ƿշ���-------------------------
	public Vector<Room> CountRoomType() {
		
		Vector<Room> v3 = new Vector<Room>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;

		try {
			conn = DataAccess.getConnection();
			prep = conn.
					prepareStatement("SELECT r.roomType, COUNT(r.roomNumber) as count FROM room r "
							+ "WHERE r.roomStatus = '��' and r.roomNumber NOT IN (SELECT o.roomNumber FROM orders o "
							+ "WHERE o.orderStatus IN('Ԥ����','����ס')) GROUP BY r.roomType");
			rs = prep.executeQuery();
			while (rs.next()) {
				Room r2 = new Room();
				r2.setroomCount(rs.getInt("count"));
				r2.setRoomType(rs.getString("roomType"));
				v3.add(r2);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return v3;
	}
	// -----------------���ݷ������͡�����״̬Ϊ��ʱ������䷿��-------------------------
	public List<String> findRoomNumberByroomType(String roomType) {
		
		List<String> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;

		try {
			conn = DataAccess.getConnection();
//			prep = conn.prepareStatement("select roomNumber from room where roomType=? and roomStatus ='��'");
			prep = conn.
					prepareStatement("SELECT r.roomNumber FROM room r "
							+ "WHERE r.roomType = ? AND r.roomStatus = '��' AND r.roomNumber NOT IN"
							+ "( SELECT o.roomNumber FROM orders o WHERE orderStatus = 'Ԥ����')");
			prep.setString(1, roomType);
			rs = prep.executeQuery();
			while (rs.next()) {
				Room r2 = new Room();
				r2.setRoomNumber(rs.getString("roomNumber"));
				list.add(r2.getRoomNumber());
//				Random random = new Random();
//				int n = random.nextInt(list.size());					
//				String roonNumber = list.get(n);					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;
	}

	// ---------------------------����ȫ��������Ϣ------------------------------
	public Vector<Room> findAllRoom() {
		Vector<Room> v = new Vector<Room>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("select * from room");
			rs = prep.executeQuery();
			while (rs.next()) {
				Room r = new Room();
				r.setRoomNumber(rs.getString("roomNumber"));
				r.setRoomType(rs.getString("roomType"));
				r.setRoomPrice(rs.getInt("roomPrice"));
				r.setRoomStatus(rs.getString("roomStatus"));
				r.setRemarks(rs.getString("remarks"));
				v.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return v;
	}

	// ------------------------���뷿����Ϣ------------------------------------
	public boolean insertintofoRoom(Room r) {
		boolean flag = false;
		String roomNumber = r.getRoomNumber();
		String roomType = r.getRoomType();
		String roomStatus = r.getRoomStatus();
		int roomPrice = r.getRoomPrice();
		String remarks = r.getRemarks();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement("insert into room values(?,?,?,?,?)");
			prep.setString(1, roomNumber);
			prep.setString(2, roomType);
			prep.setInt(3, roomPrice);
			prep.setString(4, roomStatus);
			prep.setString(5, remarks);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return flag;
	}

	// ------------------------------���·�����Ϣ-----------------------------------
	public boolean updateRoom(Room r) {
		boolean flag = false;
		String roomNumber = r.getRoomNumber();
		String roomType = r.getRoomType();
		String roomStatus = r.getRoomStatus();
		int roomPrice = r.getRoomPrice();
		String remarks = r.getRemarks();
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("update room set roomType = ? ,roomPrice = ?, roomStatus = ?,remarks = ? where roomNumber = ?");
			prep.setString(1, roomType);
			prep.setInt(2, roomPrice);
			prep.setString(3, roomStatus);
			prep.setString(4, remarks);
			prep.setString(5, roomNumber);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}

	// ------------------------ɾ��һ��������Ϣ----------------------------
	public boolean deleteRoom(String roomNumber) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn
					.prepareStatement("delete from room where roomNumber = ?");
			prep.setString(1, roomNumber);
			prep.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
	
	public List<Count> coumtRoomNotempty(){
		List<Count> list = new ArrayList<Count>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select roomType,count(roomStatus) as Number from room where roomStatus = '�ǿ�' group by roomType;");
			rs = prep.executeQuery();
			while(rs.next()){
				Count c = new Count();
				c.setCountRoomType(rs.getString("roomType"));
				c.setCountNumber(rs.getInt("Number"));
				list.add(c);
			}
		}catch (SQLException e) {
			e.printStackTrace();		
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;
	}
	
	
	public List<Count> coumtRoomEmpty(){
		List<Count> list = new ArrayList<Count>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select roomType,count(roomStatus) as Number from room where roomStatus = '��' group by roomType;");
			rs = prep.executeQuery();
			while(rs.next()){
				Count c = new Count();
				c.setCountRoomType(rs.getString("roomType"));
				c.setCountNumber(rs.getInt("Number"));
				list.add(c);
			}
		}catch (SQLException e) {
			e.printStackTrace();		
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;
	}
	
	
	public List<Count> coumtRoomTurnover(){
		List<Count> list = new ArrayList<Count>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select r.roomType as Type ,sum(o.totalMoney) as Turnover from orders o,room r where o.roomNumber = r.roomNumber group by r.roomType;");
			rs = prep.executeQuery();
			while(rs.next()){
				Count c = new Count();
				c.setCountRoomType(rs.getString("Type"));
				c.setCountMoney(rs.getDouble("Turnover"));
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
