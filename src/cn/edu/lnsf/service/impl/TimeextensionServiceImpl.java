package cn.edu.lnsf.service.impl;

import java.util.List;
import java.util.Vector;

import cn.edu.lnsf.dao.ItimeextensionDao;
import cn.edu.lnsf.dao.impl.TimeExtensionDaoImpl;
import cn.edu.lnsf.model.Orders;
import cn.edu.lnsf.model.TimeExtension;
import cn.edu.lnsf.service.ItimeextensionService;

public class TimeextensionServiceImpl implements ItimeextensionService {

	@SuppressWarnings("rawtypes")
	ItimeextensionDao timeDao = new TimeExtensionDaoImpl();

	//
	@SuppressWarnings("unchecked")
	public List<Orders> ordersByRoomCuid(String customerID, String roomNumber){
		return timeDao.ordersByRoomCuid(customerID, roomNumber);
	}
	
	public boolean insertTimeExtension(TimeExtension t){
		boolean flag;
		flag = timeDao.insertTimeExtension(t);
		return flag;
	}

	// 根据顾客身份证号和房间号查找订单
	@SuppressWarnings("unchecked")
	public List<Orders> findOrdersByRoomAndID(String customerID, String roomNumber) {
		List<Orders> flag;
		flag = timeDao.findOrdersByRoomAndID(customerID, roomNumber);
		return flag;
		
	}

	// 根据续费编号，删除续费表
	public boolean deleteTimeExtension(int operatingID) {
		boolean flag;
		flag = timeDao.deleteTimeExtension(operatingID);
		return flag;
	}

	// 根据订单号，删除续费表
	public boolean deleteTimeExtensionByorderNumber(String orderNumber) {
		boolean flag;
		flag = timeDao.deleteTimeExtensionByorderNumber(orderNumber);
		return flag;
	}

	// 查询续费表
	@SuppressWarnings("unchecked")
	public Vector<TimeExtension> findAllTimeExtension() {
		Vector<TimeExtension> v = new Vector<TimeExtension>();
		v = timeDao.findAllTimeExtension();
		for (TimeExtension t : v)
			System.out
					.println("续费单号：" + t.getOperatingID() + "  " + "订单号："
							+ t.getOrderNumber() + "  " + "原入住日期："
							+ t.getOldExpiryDate() + "  " + "现退房日期："
							+ t.getNewExpiryDate() + "  " + "续费金额："
							+ t.getAddedMoney());
		return v;
	}

	// 根据订单号查询续费信息
	@SuppressWarnings("unchecked")
	public Vector<TimeExtension> findTimeExtensionByorderNumber(
			TimeExtension record) {
		Vector<TimeExtension> v = new Vector<TimeExtension>();
		v = timeDao.findTimeExtensionByorderNumber(record);
		for (TimeExtension t : v)
			System.out
					.println("续费单号：" + t.getOperatingID() + "  " + "订单号："
							+ t.getOrderNumber() + "  " + "原入住日期："
							+ t.getOldExpiryDate() + "  " + "现退房日期："
							+ t.getNewExpiryDate() + "  " + "续费金额："
							+ t.getAddedMoney());
		return v;
	}

	// 根据续费单号查询续费信息
	@SuppressWarnings("unchecked")
	public Vector<TimeExtension> findTimeExtensionByoperatingID(TimeExtension t1) {
		Vector<TimeExtension> v = new Vector<TimeExtension>();
		v = timeDao.findTimeExtensionByoperatingID(t1);
		for (TimeExtension t : v)
			System.out
					.println("续费单号：" + t.getOperatingID() + "  " + "订单号："
							+ t.getOrderNumber() + "  " + "原入住日期："
							+ t.getOldExpiryDate() + "  " + "现退房日期："
							+ t.getNewExpiryDate() + "  " + "续费金额："
							+ t.getAddedMoney());
		return v;
	}

}
