package cn.edu.lnsf.service;

import java.util.List;
import java.util.Vector;

import cn.edu.lnsf.model.Orders;
import cn.edu.lnsf.model.TimeExtension;

public interface ItimeextensionService {

	// ���ݹ˿�����֤�źͷ���Ų��Ҷ���
	public List<Orders> findOrdersByRoomAndID(String customerID,
			String roomNumber);

	// ���ݹ˿�����֤�źͷ���Ų��ҷ���۸�
	public List<Orders> ordersByRoomCuid(String customerID, String roomNumber);

	// �������ѱ�
	public boolean insertTimeExtension(TimeExtension t);

	// �������ѱ�ţ�ɾ�����ѱ�
	public boolean deleteTimeExtension(int operatingID);

	// ���ݶ����ţ�ɾ�����ѱ�
	public boolean deleteTimeExtensionByorderNumber(String orderNumber);

	// ��ѯ���ѱ�
	public Vector<TimeExtension> findAllTimeExtension();

	// ���ݶ����Ų�ѯ������Ϣ
	public Vector<TimeExtension> findTimeExtensionByorderNumber(TimeExtension t1);

	// �������ѵ��Ų�ѯ������Ϣ
	public Vector<TimeExtension> findTimeExtensionByoperatingID(TimeExtension t1);
}