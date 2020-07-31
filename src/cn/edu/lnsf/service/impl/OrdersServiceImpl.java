package cn.edu.lnsf.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import cn.edu.lnsf.dao.IordersDao;
import cn.edu.lnsf.dao.impl.OrdersDaoImpl;
import cn.edu.lnsf.model.Count;
import cn.edu.lnsf.model.Orders;
import cn.edu.lnsf.service.IordersService;

public class OrdersServiceImpl implements IordersService {

	public IordersDao dao = new OrdersDaoImpl();

	// 统计金额
	public long totalAllMoney(Orders o) {
		Date stateTime = o.getCheckInTime();
		Date endTime = o.getCheckOutTime();
		long stateTimeLong = stateTime.getTime();
		long endTimeLong = endTime.getTime();
		// 结束时间-开始时间 = 天数
		long day = (endTimeLong - stateTimeLong) / (24 * 60 * 60 * 1000);
		System.out.println(day);
		return day;
	}

	// 年报表
	public List<Count> countYearOrders() {
		return dao.countYearOrders();
	}
	
	// 
	public List<Count> countMonthOrders(){
		return dao.countMonthOrders();
	}
	
	//
	public List<Count> countWeekOrders(){
		return dao.countWeekOrders();
	}
	
	//
	public List<Count> countDayOrders(){
		return dao.countDayOrders();
	}

	// 生成订单
	public boolean insertOrders(Orders o) {
		boolean flag;
		flag = dao.insertOrders(o);
		return flag;
	}

	// 根据订单号，删除订单
	public boolean deleteOrders(String ordersID){
		boolean flag;
		flag = dao.deleteOrders(ordersID);
		return flag;
	}

	// 查询订单
	public Vector<Orders> findAllOrders(){
		Vector<Orders> v =new Vector<Orders>();
		v = dao.findAllOrders();
		return v;
	}

	// 根据订单号查询订单信息
	public Vector<Orders> findOrdersByID(Orders record){
		Vector<Orders> v =new Vector<Orders>();
		v = dao.findOrdersByID(record);
		return v;
	}

	// 入住
	public boolean updateOrderInfo(Orders record){
		return dao.updateOrderInfo(record);
	}

	// 退房
	public boolean updateOrderOutfo(Orders record){
		return dao.updateOrderOutfo(record);
	}
	
	public List<Count> countOrders(){
		return dao.countOrders();
	}

//	public void findViewOrders(){
//		dao.findViewOrders();
//	}
	
}
