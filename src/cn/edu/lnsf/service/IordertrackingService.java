package cn.edu.lnsf.service;

import java.util.List;

public interface IordertrackingService {
	
	// 今天入住的数量
	public List<Object> countTodayInfo();
	
	// 今天退房的数量
	public List<Object> countTodayOutfo();


}
