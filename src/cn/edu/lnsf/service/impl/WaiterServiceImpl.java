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

	// 查询
//	public Vector<Waiter> findAllWaiter() {
//		Vector<Waiter> v = new Vector<Waiter>();
//		return v;
//	}
	//查找所有的服务员信息
	public Vector<Waiter> findAllWaiter(){
		Vector<Waiter> v = new Vector<Waiter>();
		v = dao.findAllWaiter();
		for(Waiter w : v){
			System.out.println("编号："+w.getWaiterID()+"  "+"姓名："+w.getWaiterName()+"  "
					+"生日："+w.getWaiterBirthday()+"  "+"身份证号："+w.getWaiterIDCard()+"  "
					+"入职日期："+w.getWaiterJoinDate()+"  "+"电话号码："+w.getWaiterPhone()
					+"  "+"备注："+w.getRemarks());
		}
		return v;
	}
	
	//根据服务员ID查找服务员
	public Vector<Waiter> findWaiter(String waiterID){
		Vector<Waiter> v1 = new Vector<Waiter>(); 
		v1 = dao.findWaiter(waiterID);
		if(v1==null)System.out.println("该服务员不存在！");
		else
		for(Waiter w : v1){
			System.out.println("编号："+w.getWaiterID()+"  "+"姓名："+w.getWaiterName()+"  "
					+"生日："+w.getWaiterBirthday()+"  "+"身份证号："+w.getWaiterIDCard()+"  "
					+"入职日期："+w.getWaiterJoinDate()+"  "+"电话号码："+w.getWaiterPhone()
					+"  "+"备注："+w.getRemarks());
		}
		return v1;
	}
	

	// 判断ID
	public boolean findWaiterID(String waiterID) {
		return dao.findWaiterID(waiterID);
	}

	// 插入
	public boolean insertWaiter(Waiter w) {
		return dao.insertWaiter(w);
	}

	// 业绩统计
	public void countProportion() {
		NumberFormat nt = NumberFormat.getPercentInstance();
		// 设置百分数精确度2即保留两位小数
		nt.setMinimumFractionDigits(0);
		IordersService Iorder = new OrdersServiceImpl();
		for (Count co : Iorder.countOrders()) {
			float n = co.getCountOrders();
			for (Count c : dao.countProportion()) {
				float Proportion = (float) c.getCountWaiterPro() / n;
				System.out.println("员工：" + c.getCountWaiter() + "     "
						+ "员工业绩所占比:" + nt.format(Proportion) + "   " + "订单总额："
						+ c.getCountMoney());
			}
		}
	}
	
	//更新服务员信息
	public boolean updateWaiter(Waiter w){
		return dao.updateWaiter(w);
	}
		
	//删除服务员信息
	public boolean deleteWaiter(String waiterID){
		return dao.deleteWaiter(waiterID);		
	}

}
