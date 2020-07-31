package cn.edu.lnsf.service;

import java.util.Vector;

import cn.edu.lnsf.model.Waiter;

public interface IwaiterService {

	// �������еķ���Ա��Ϣ
	public Vector<Waiter> findAllWaiter();

	// �ж�ID
	public boolean findWaiterID(String ID);
	
	//���ݷ���ԱID���ҷ���Ա
	public Vector<Waiter> findWaiter(String waiterID);

	// ����
	public boolean insertWaiter(Waiter w);

	// ҵ��ͳ��
	public void countProportion();
	
	//���·���Ա��Ϣ
	public boolean updateWaiter(Waiter w);
	
	//ɾ������Ա��Ϣ
	public boolean deleteWaiter(String waiterID);

}
