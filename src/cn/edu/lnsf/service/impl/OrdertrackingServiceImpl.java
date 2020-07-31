package cn.edu.lnsf.service.impl;


import java.util.List;

import cn.edu.lnsf.dao.IordertrackingDao;
import cn.edu.lnsf.dao.impl.OrderTrackingDaoImpl;
import cn.edu.lnsf.service.IordertrackingService;

public class OrdertrackingServiceImpl implements IordertrackingService{
	
	IordertrackingDao trackingDao = new OrderTrackingDaoImpl();
	
	// 今天入住的数量
	public List<Object> countTodayInfo(){
		return trackingDao.countTodayInfo();
	}
	
	// 今天退房的数量
	public List<Object> countTodayOutfo(){
		return trackingDao.countTodayOutfo();
	}

}
