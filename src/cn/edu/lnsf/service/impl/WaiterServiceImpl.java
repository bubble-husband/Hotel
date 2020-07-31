package cn.edu.lnsf.service.impl;

import java.text.NumberFormat;
import java.util.Vector;


import cn.edu.lnsf.dao.IwaiterDao;
import cn.edu.lnsf.dao.impl.WaiterDaoImpl;
import cn.edu.lnsf.model.Count;
import cn.edu.lnsf.model.Waiter;
import cn.edu.lnsf.service.IordersService;
import cn.edu.lnsf.service.IwaiterService;

public class WaiterServiceImpl implements IwaiterService {

	public IwaiterDao dao = new WaiterDaoImpl();
	public Waiter w = new Waiter();

	// ��ѯ
//	public Vector<Waiter> findAllWaiter() {
//		Vector<Waiter> v = new Vector<Waiter>();
//		return v;
//	}
	//�������еķ���Ա��Ϣ
	public Vector<Waiter> findAllWaiter(){
		Vector<Waiter> v = new Vector<Waiter>();
		v = dao.findAllWaiter();
		for(Waiter w : v){
			System.out.println("��ţ�"+w.getWaiterID()+"  "+"������"+w.getWaiterName()+"  "
					+"���գ�"+w.getWaiterBirthday()+"  "+"���֤�ţ�"+w.getWaiterIDCard()+"  "
					+"��ְ���ڣ�"+w.getWaiterJoinDate()+"  "+"�绰���룺"+w.getWaiterPhone()
					+"  "+"��ע��"+w.getRemarks());
		}
		return v;
	}
	
	//���ݷ���ԱID���ҷ���Ա
	public Vector<Waiter> findWaiter(String waiterID){
		Vector<Waiter> v1 = new Vector<Waiter>(); 
		v1 = dao.findWaiter(waiterID);
		if(v1==null)System.out.println("�÷���Ա�����ڣ�");
		else
		for(Waiter w : v1){
			System.out.println("��ţ�"+w.getWaiterID()+"  "+"������"+w.getWaiterName()+"  "
					+"���գ�"+w.getWaiterBirthday()+"  "+"���֤�ţ�"+w.getWaiterIDCard()+"  "
					+"��ְ���ڣ�"+w.getWaiterJoinDate()+"  "+"�绰���룺"+w.getWaiterPhone()
					+"  "+"��ע��"+w.getRemarks());
		}
		return v1;
	}
	

	// �ж�ID
	public boolean findWaiterID(String waiterID) {
		return dao.findWaiterID(waiterID);
	}

	// ����
	public boolean insertWaiter(Waiter w) {
		return dao.insertWaiter(w);
	}

	// ҵ��ͳ��
	public void countProportion() {
		NumberFormat nt = NumberFormat.getPercentInstance();
		// ���ðٷ�����ȷ��2��������λС��
		nt.setMinimumFractionDigits(0);
		IordersService Iorder = new OrdersServiceImpl();
		for (Count co : Iorder.countOrders()) {
			float n = co.getCountOrders();
			for (Count c : dao.countProportion()) {
				float Proportion = (float) c.getCountWaiterPro() / n;
				System.out.println("Ա����" + c.getCountWaiter() + "     "
						+ "Ա��ҵ����ռ��:" + nt.format(Proportion) + "   " + "�����ܶ"
						+ c.getCountMoney());
			}
		}
	}
	
	//���·���Ա��Ϣ
	public boolean updateWaiter(Waiter w){
		return dao.updateWaiter(w);
	}
		
	//ɾ������Ա��Ϣ
	public boolean deleteWaiter(String waiterID){
		return dao.deleteWaiter(waiterID);		
	}

}
