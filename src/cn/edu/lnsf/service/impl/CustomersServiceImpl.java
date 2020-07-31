package cn.edu.lnsf.service.impl;


import java.util.Vector;

import cn.edu.lnsf.dao.IcustomersDao;
import cn.edu.lnsf.dao.impl.CustomersDaoImpl;
import cn.edu.lnsf.model.Customers;
import cn.edu.lnsf.service.IcustomersService;

public class CustomersServiceImpl implements IcustomersService{

	//ע��service Dao
	@SuppressWarnings("unused")
	private IcustomersDao customersDao;
	public void setIcustomersDao(IcustomersDao customersDao){
		this.customersDao = customersDao;
	}
	public IcustomersDao customersDao1 = new CustomersDaoImpl();
//-------------------���ݹ˿����֤���ҹ˿���Ϣ-------------------------------	
	@SuppressWarnings("unused")
	public  Vector<Customers> findCustomersBycustomerIDCard(String customerIDCard){
	   
	   Vector<Customers> v = new Vector<Customers>();	  
	   v = customersDao1.findCustomersBycustomerIDCard(customerIDCard);
	   for(Customers c : v)
		   System.out.println("�˿����֤�ţ�"+c.getCustomerIDCard()+"  "+"�Ա�"+c.getCustomerGender()+"  "+"������"+c.getCustomerName()+"  "+"�������ڣ�"+c.getCustomerBirthday()+"  "+"�绰���룺"+c.getCustomerPhone()+"  "+"��ע��"+c.getRemarks());
	   if(v==null){
		   System.out.println("�÷��䲻����...");
	   }
	   return v;   
	}
	
	public boolean findCustomersByID(String ID){
		boolean flag = false;
		flag = customersDao1.findCustomersByID(ID); 			
		return flag;
	}
//------------------�������й˿���Ϣ---------------------------------------
	public Vector<Customers> findAllCustomers(){
		   
		   Vector<Customers> v1 = new Vector<Customers>();
		   v1 = customersDao1.findAllCustomers();
		   for(Customers c : v1)
			   System.out.println("�˿����֤�ţ�"+c.getCustomerIDCard()+"  "+"�Ա�"+c.getCustomerGender()+"  "+"������"+c.getCustomerName()+"  "+"�������ڣ�"+c.getCustomerBirthday()+"  "+"�绰���룺"+c.getCustomerPhone()+"  "+"��ע��"+c.getRemarks());
			  
		   return v1;   
		}

//-----------------����˿���Ϣ-------------------------------------------
		public boolean insertintofoCustomers(Customers c){
			boolean flag = false;
			flag = customersDao1.insertintofoCustomers(c); 			
			return flag;
		}
		
//------------------���¹˿���Ϣ------------------------------------------
		public boolean updateCustomers(Customers c){
			boolean flag = false;
			flag = customersDao1.updateCustomers(c); 			
			return flag;
		}
		
//------------------ɾ��һ���˿���Ϣ--------------------------------------
		public boolean deleteCustomers(String roomNumber){
			boolean flag = false;
			flag = customersDao1.deleteCustomers(roomNumber); 			
			return flag;
		}
}
