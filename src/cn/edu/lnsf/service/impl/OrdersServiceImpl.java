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

	// ͳ�ƽ��
	public long totalAllMoney(Orders o) {
		Date stateTime = o.getCheckInTime();
		Date endTime = o.getCheckOutTime();
		long stateTimeLong = stateTime.getTime();
		long endTimeLong = endTime.getTime();
		// ����ʱ��-��ʼʱ�� = ����
		long day = (endTimeLong - stateTimeLong) / (24 * 60 * 60 * 1000);
		System.out.println(day);
		return day;
	}

	// �걨��
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

	// ���ɶ���
	public boolean insertOrders(Orders o) {
		boolean flag;
		flag = dao.insertOrders(o);
		return flag;
	}

	// ���ݶ����ţ�ɾ������
	public boolean deleteOrders(String ordersID){
		boolean flag;
		flag = dao.deleteOrders(ordersID);
		return flag;
	}

	// ��ѯ����
	public Vector<Orders> findAllOrders(){
		Vector<Orders> v =new Vector<Orders>();
		v = dao.findAllOrders();
		return v;
	}

	// ���ݶ����Ų�ѯ������Ϣ
	public Vector<Orders> findOrdersByID(Orders record){
		Vector<Orders> v =new Vector<Orders>();
		v = dao.findOrdersByID(record);
		return v;
	}

	// ��ס
	public boolean updateOrderInfo(Orders record){
		return dao.updateOrderInfo(record);
	}

	// �˷�
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
