package cn.edu.lnsf.service;

import java.util.List;
import java.util.Vector;

import cn.edu.lnsf.model.Count;
import cn.edu.lnsf.model.Orders;

public interface IordersService {

	// ���ɶ���
	public boolean insertOrders(Orders o);

	// ͳ�ƽ��
	public long totalAllMoney(Orders o);

	// ���ݶ����ţ�ɾ������
	public boolean deleteOrders(String ordersID);

	// ��ѯ����
	public Vector<Orders> findAllOrders();

	// ���ݶ����Ų�ѯ������Ϣ
	public Vector<Orders> findOrdersByID(Orders record);

	// ��ס
	public boolean updateOrderInfo(Orders record);

	// �˷�
	public boolean updateOrderOutfo(Orders record);

	//�걨��
	public List<Count> countYearOrders();

	//�±���
	public List<Count> countMonthOrders();

	//�ܱ���
	public List<Count> countWeekOrders();

	//�챨��
	public List<Count> countDayOrders();
	
	//��������
	public List<Count> countOrders();
	

}
