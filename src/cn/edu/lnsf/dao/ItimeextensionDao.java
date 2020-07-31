package cn.edu.lnsf.dao;

import java.util.List;
import java.util.Vector;

import cn.edu.lnsf.model.Orders;
import cn.edu.lnsf.model.TimeExtension;

public interface ItimeextensionDao<T> {
    
	//根据顾客身份证号和房间号查找订单
	public List<Orders> findOrdersByRoomAndID(String customerID, String roomNumber);
	
	// 根据顾客ID、房间号，查询出订单
	public List<Orders> ordersByRoomCuid(String customerID, String roomNumber);
	
	//
	public boolean insertTimeExtension(TimeExtension t);

	//根据续费编号，删除续费表
	public boolean deleteTimeExtension(int operatingID);
		
	//根据订单号，删除续费表
	public boolean deleteTimeExtensionByorderNumber(String orderNumber);
	
	//查询续费表
	public Vector<TimeExtension> findAllTimeExtension();
	
	//根据订单号查询续费信息
	public Vector<TimeExtension> findTimeExtensionByorderNumber(TimeExtension t);
	
	//根据续费单号查询续费信息
	public Vector<TimeExtension> findTimeExtensionByoperatingID(TimeExtension t);
	
}
