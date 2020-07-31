package cn.edu.lnsf.dao;

import java.util.List;

public interface IordertrackingDao {
	
	// 今天入住的数量
	public List<Object> countTodayInfo();
	
	// 今天退房的数量
	public List<Object> countTodayOutfo();

}
