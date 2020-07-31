package cn.edu.lnsf.dao;

import java.util.List;
import java.util.Vector;

import cn.edu.lnsf.model.Count;
import cn.edu.lnsf.model.Waiter;

public interface IwaiterDao {
	
	// ��ѯ
	public Vector<Waiter> findAllWaiter();
	
	// �ж�ID
	public boolean findWaiterID(String ID);
	
	//���ݷ���ԱID���ҷ���Ա
	public Vector<Waiter> findWaiter(String waiterID);
	
	// ����
	public boolean insertWaiter(Waiter w);
	
	//ҵ��ͳ��
	public List<Count> countProportion();
	
	//���·���Ա��Ϣ
	public boolean updateWaiter(Waiter w);
	
	//ɾ������Ա��Ϣ
	public boolean deleteWaiter(String waiterID);

}
