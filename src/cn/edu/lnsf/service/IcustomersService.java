package cn.edu.lnsf.service;

import java.util.Vector;

import cn.edu.lnsf.model.Customers;

public interface IcustomersService {

	// ���ݸ��ݹ˿����֤���ҹ˿���Ϣ
	public Vector<Customers> findCustomersBycustomerIDCard(String customerIDCard);
	
	// ���ݹ˿�ID�ж��Ƿ����
	public boolean findCustomersByID(String customerID);

	// ����ȫ���˿���Ϣ
	public Vector<Customers> findAllCustomers();

	// ����˿���Ϣ
	public boolean insertintofoCustomers(Customers r);

	// ���¹˿���Ϣ
	public boolean updateCustomers(Customers r);

	// ɾ��һ���˿���Ϣ
	public boolean deleteCustomers(String customerIDCard);
}
