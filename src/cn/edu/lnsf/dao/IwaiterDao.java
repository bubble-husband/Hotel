package cn.edu.lnsf.dao;

import java.util.List;
import java.util.Vector;

import cn.edu.lnsf.model.Count;
import cn.edu.lnsf.model.Waiter;

public interface IwaiterDao {
	
	// 查询
	public Vector<Waiter> findAllWaiter();
	
	// 判断ID
	public boolean findWaiterID(String ID);
	
	//根据服务员ID查找服务员
	public Vector<Waiter> findWaiter(String waiterID);
	
	// 插入
	public boolean insertWaiter(Waiter w);
	
	//业绩统计
	public List<Count> countProportion();
	
	//更新服务员信息
	public boolean updateWaiter(Waiter w);
	
	//删除服务员信息
	public boolean deleteWaiter(String waiterID);

}
