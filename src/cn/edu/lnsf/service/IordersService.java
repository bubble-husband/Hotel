package cn.edu.lnsf.service;

import java.util.List;
import java.util.Vector;

import cn.edu.lnsf.model.Count;
import cn.edu.lnsf.model.Orders;

public interface IordersService {

	// 生成订单
	public boolean insertOrders(Orders o);

	// 统计金额
	public long totalAllMoney(Orders o);

	// 根据订单号，删除订单
	public boolean deleteOrders(String ordersID);

	// 查询订单
	public Vector<Orders> findAllOrders();

	// 根据订单号查询订单信息
	public Vector<Orders> findOrdersByID(Orders record);

	// 入住
	public boolean updateOrderInfo(Orders record);

	// 退房
	public boolean updateOrderOutfo(Orders record);

	//年报表
	public List<Count> countYearOrders();

	//月报表
	public List<Count> countMonthOrders();

	//周报表
	public List<Count> countWeekOrders();

	//天报表
	public List<Count> countDayOrders();
	
	//订单报表
	public List<Count> countOrders();
	

}
