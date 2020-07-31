package cn.edu.lnsf.service.impl;


import java.util.List;

import cn.edu.lnsf.dao.IordertrackingDao;
import cn.edu.lnsf.dao.impl.OrderTrackingDaoImpl;
import cn.edu.lnsf.service.IordertrackingService;

public class OrdertrackingServiceImpl implements IordertrackingService{
	
	IordertrackingDao trackingDao = new OrderTrackingDaoImpl();
	
	// ������ס������
	public List<Object> countTodayInfo(){
		return trackingDao.countTodayInfo();
	}
	
	// �����˷�������
	public List<Object> countTodayOutfo(){
		return trackingDao.countTodayOutfo();
	}

}
