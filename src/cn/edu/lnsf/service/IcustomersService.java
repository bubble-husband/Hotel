package cn.edu.lnsf.service;

import java.util.Vector;

import cn.edu.lnsf.model.Customers;

public interface IcustomersService {

	// 根据根据顾客身份证查找顾客信息
	public Vector<Customers> findCustomersBycustomerIDCard(String customerIDCard);
	
	// 根据顾客ID判断是否存在
	public boolean findCustomersByID(String customerID);

	// 查找全部顾客信息
	public Vector<Customers> findAllCustomers();

	// 插入顾客信息
	public boolean insertintofoCustomers(Customers r);

	// 更新顾客信息
	public boolean updateCustomers(Customers r);

	// 删除一条顾客信息
	public boolean deleteCustomers(String customerIDCard);
}
