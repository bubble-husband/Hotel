package cn.edu.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.lnsf.dao.IordertrackingDao;
import cn.edu.lnsf.dbutils.DataAccess;

public class OrderTrackingDaoImpl implements IordertrackingDao{
	
	public List<Object> countTodayInfo(){
		List<Object> list = new ArrayList<Object>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select date_format(now(),'%j') as Today ,count(checkInTime) as roomInfo from ordertracking group by date_format(now(),'%j');");
			rs = prep.executeQuery();
			while(rs.next()){
				list.add(rs.getDouble("Today"));
			}
		}catch (SQLException e) {
			e.printStackTrace();		
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;
	}
	
	public List<Object> countTodayOutfo(){
		List<Object> list = new ArrayList<Object>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prep = conn.prepareStatement
					("select date_format(now(),'%j') as Today ,count(checkOutTime) as roomOutfo from ordertracking group by date_format(now(),'%j');");
			rs = prep.executeQuery();
			while(rs.next()){
				list.add(rs.getDouble("Today"));
			}
		}catch (SQLException e) {
			e.printStackTrace();		
		}finally{
			DataAccess.closeConnection(rs, prep, conn);
		}
		return list;
	}

}
