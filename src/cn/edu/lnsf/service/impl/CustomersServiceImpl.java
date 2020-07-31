package cn.edu.lnsf.service.impl;


import java.util.Vector;

import cn.edu.lnsf.dao.IcustomersDao;
import cn.edu.lnsf.dao.impl.CustomersDaoImpl;
import cn.edu.lnsf.model.Customers;
import cn.edu.lnsf.service.IcustomersService;

public class CustomersServiceImpl implements IcustomersService{

	//注入service Dao
	@SuppressWarnings("unused")
	private IcustomersDao customersDao;
	public void setIcustomersDao(IcustomersDao customersDao){
		this.customersDao = customersDao;
	}
	public IcustomersDao customersDao1 = new CustomersDaoImpl();
//-------------------根据顾客身份证查找顾客信息-------------------------------	
	@SuppressWarnings("unused")
	public  Vector<Customers> findCustomersBycustomerIDCard(String customerIDCard){
	   
	   Vector<Customers> v = new Vector<Customers>();	  
	   v = customersDao1.findCustomersBycustomerIDCard(customerIDCard);
	   for(Customers c : v)
		   System.out.println("顾客身份证号："+c.getCustomerIDCard()+"  "+"性别："+c.getCustomerGender()+"  "+"姓名："+c.getCustomerName()+"  "+"出生日期："+c.getCustomerBirthday()+"  "+"电话号码："+c.getCustomerPhone()+"  "+"备注："+c.getRemarks());
	   if(v==null){
		   System.out.println("该房间不存在...");
	   }
	   return v;   
	}
	
	public boolean findCustomersByID(String ID){
		boolean flag = false;
		flag = customersDao1.findCustomersByID(ID); 			
		return flag;
	}
//------------------查找所有顾客信息---------------------------------------
	public Vector<Customers> findAllCustomers(){
		   
		   Vector<Customers> v1 = new Vector<Customers>();
		   v1 = customersDao1.findAllCustomers();
		   for(Customers c : v1)
			   System.out.println("顾客身份证号："+c.getCustomerIDCard()+"  "+"性别："+c.getCustomerGender()+"  "+"姓名："+c.getCustomerName()+"  "+"出生日期："+c.getCustomerBirthday()+"  "+"电话号码："+c.getCustomerPhone()+"  "+"备注："+c.getRemarks());
			  
		   return v1;   
		}

//-----------------插入顾客信息-------------------------------------------
		public boolean insertintofoCustomers(Customers c){
			boolean flag = false;
			flag = customersDao1.insertintofoCustomers(c); 			
			return flag;
		}
		
//------------------更新顾客信息------------------------------------------
		public boolean updateCustomers(Customers c){
			boolean flag = false;
			flag = customersDao1.updateCustomers(c); 			
			return flag;
		}
		
//------------------删除一条顾客信息--------------------------------------
		public boolean deleteCustomers(String roomNumber){
			boolean flag = false;
			flag = customersDao1.deleteCustomers(roomNumber); 			
			return flag;
		}
}
