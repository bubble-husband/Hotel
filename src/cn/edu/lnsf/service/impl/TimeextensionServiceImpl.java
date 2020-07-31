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

	// ���ݹ˿����֤�źͷ���Ų��Ҷ���
	@SuppressWarnings("unchecked")
	public List<Orders> findOrdersByRoomAndID(String customerID, String roomNumber) {
		List<Orders> flag;
		flag = timeDao.findOrdersByRoomAndID(customerID, roomNumber);
		return flag;
		
	}

	// �������ѱ�ţ�ɾ�����ѱ�
	public boolean deleteTimeExtension(int operatingID) {
		boolean flag;
		flag = timeDao.deleteTimeExtension(operatingID);
		return flag;
	}

	// ���ݶ����ţ�ɾ�����ѱ�
	public boolean deleteTimeExtensionByorderNumber(String orderNumber) {
		boolean flag;
		flag = timeDao.deleteTimeExtensionByorderNumber(orderNumber);
		return flag;
	}

	// ��ѯ���ѱ�
	@SuppressWarnings("unchecked")
	public Vector<TimeExtension> findAllTimeExtension() {
		Vector<TimeExtension> v = new Vector<TimeExtension>();
		v = timeDao.findAllTimeExtension();
		for (TimeExtension t : v)
			System.out
					.println("���ѵ��ţ�" + t.getOperatingID() + "  " + "�����ţ�"
							+ t.getOrderNumber() + "  " + "ԭ��ס���ڣ�"
							+ t.getOldExpiryDate() + "  " + "���˷����ڣ�"
							+ t.getNewExpiryDate() + "  " + "���ѽ�"
							+ t.getAddedMoney());
		return v;
	}

	// ���ݶ����Ų�ѯ������Ϣ
	@SuppressWarnings("unchecked")
	public Vector<TimeExtension> findTimeExtensionByorderNumber(
			TimeExtension record) {
		Vector<TimeExtension> v = new Vector<TimeExtension>();
		v = timeDao.findTimeExtensionByorderNumber(record);
		for (TimeExtension t : v)
			System.out
					.println("���ѵ��ţ�" + t.getOperatingID() + "  " + "�����ţ�"
							+ t.getOrderNumber() + "  " + "ԭ��ס���ڣ�"
							+ t.getOldExpiryDate() + "  " + "���˷����ڣ�"
							+ t.getNewExpiryDate() + "  " + "���ѽ�"
							+ t.getAddedMoney());
		return v;
	}

	// �������ѵ��Ų�ѯ������Ϣ
	@SuppressWarnings("unchecked")
	public Vector<TimeExtension> findTimeExtensionByoperatingID(TimeExtension t1) {
		Vector<TimeExtension> v = new Vector<TimeExtension>();
		v = timeDao.findTimeExtensionByoperatingID(t1);
		for (TimeExtension t : v)
			System.out
					.println("���ѵ��ţ�" + t.getOperatingID() + "  " + "�����ţ�"
							+ t.getOrderNumber() + "  " + "ԭ��ס���ڣ�"
							+ t.getOldExpiryDate() + "  " + "���˷����ڣ�"
							+ t.getNewExpiryDate() + "  " + "���ѽ�"
							+ t.getAddedMoney());
		return v;
	}

}
