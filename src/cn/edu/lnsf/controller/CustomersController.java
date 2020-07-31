package cn.edu.lnsf.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


import cn.edu.lnsf.model.Customers;
import cn.edu.lnsf.model.Orders;
import cn.edu.lnsf.service.IcustomersService;
import cn.edu.lnsf.service.impl.CustomersServiceImpl;


public class CustomersController {

	// 注入controller Service
	@SuppressWarnings("unused")
	private IcustomersService customersService;

	public void setIcustomersService(IcustomersService customersService) {
		this.customersService = customersService;
	}

	Customers c = new Customers();
	Scanner scanner = new Scanner(System.in);
	IcustomersService Service = new CustomersServiceImpl();

	// ----------------------------根据顾客身份证查找顾客信息------------------------
	public void findCustomersBycustomerIDCard(String customerID) {

//		Vector<Customers> v = new Vector<Customers>();

		System.out.print("请输入查找的顾客身份证号：");
		String customerIDCard = scanner.next();
		c.setCustomerIDCard(customerIDCard);
		Service.findCustomersBycustomerIDCard(customerIDCard);
//		v = Service.findCustomersBycustomerIDCard(customerIDCard);

	}

	// ----------------------------查找所有顾客信息------------------------

	public void findAllCustomers() {
//		Vector<Customers> v = new Vector<Customers>();
//		v = Service.findAllCustomers();
		Service.findAllCustomers();
	}

	// ------------------------------插入顾客信息-------------------------------------------
	public void insertintofoCustomers() {
        Orders o = new Orders();
        OrdersController ordersCon = new OrdersController();
		System.out.println("请输入身份证号：");
		String customerIDCard = scanner.next();
		if(Service.findCustomersByID(customerIDCard)==true){
			System.out.println("该住客信息已经存在...");
			o.setCustomerIDCard(customerIDCard);
			ordersCon.insertOrders(o);
			
//			Vector<Customers> v = new Vector<Customers>();
//			v = Service.findCustomersBycustomerIDCard(customerIDCard);
//			for(Customers c : v){
//				String customerGender = c.getCustomerGender();
//				String customerName = c.getCustomerName();
//				Date customerBirthday = c.getCustomerBirthday();
//				String customerPhone = c.getCustomerPhone();
//				String remarks = c.getRemarks();
//				c.setCustomerIDCard(customerIDCard);
//				c.setCustomerBirthday(customerBirthday);
//				c.setCustomerGender(customerGender);
//				c.setCustomerName(customerName);
//				c.setCustomerPhone(customerPhone);
//				c.setRemarks(remarks);
//			}
		}
		else{
			System.out.println("请输入性别：");
			String customerGender = scanner.next();
			System.out.println("请输入姓名：");
			String customerName = scanner.next();
			System.out.println("请输入顾客生日：");
			String customerBirthday = scanner.next();
			System.out.println("请输入联系方式:");
			String customerPhone = scanner.next();
			System.out.println("备注:");
			String remarks = scanner.next();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = format.parse(customerBirthday);
				System.out.println(date.getTime());
				c.setCustomerBirthday(date);
			} catch (ParseException e) {
				System.out.println("不合法的输入");
				e.printStackTrace();
			}
			c.setCustomerIDCard(customerIDCard);
			c.setCustomerGender(customerGender);
			c.setCustomerName(customerName);
			c.setCustomerPhone(customerPhone);
			c.setRemarks(remarks);
			if (Service.insertintofoCustomers(c) == true)
				System.out.println("插入成功！");
			else
				System.out.println("请重新输入!");
			o.setCustomerIDCard(customerIDCard);
			ordersCon.insertOrders(o);
		}	
	}

	// ---------------------------------更新顾客信息------------------------------------------
	public void updateCustomers(Customers c) {
		System.out.println("请输入需更新的顾客身份证号：");
		String customerIDCard = scanner.next();
		System.out.println("请依次输入修改后的顾客性别、姓名、出生日期、电话号码和备注：");
		String customerGender = scanner.next();
		String customerName = scanner.next();
		String customerBirthday = scanner.next();
		String customerPhone = scanner.next();
		String remarks = scanner.next();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(customerBirthday);
			c.setCustomerBirthday(date);
		} catch (ParseException e) {
			System.out.println("不合法的输入");
			e.printStackTrace();
		}
		
		c.setCustomerIDCard(customerIDCard);
		c.setCustomerGender(customerGender);
		c.setCustomerName(customerName);
		c.setCustomerPhone(customerPhone);
		c.setRemarks(remarks);
		if (Service.updateCustomers(c) == true)
			System.out.println("更新成功！");
		else
			System.out.println("请重新输入!");

	}

	// -----------------------------------删除一条顾客信息--------------------------------------
	public void deleteCustomers(String customerID) {

		System.out.println("请输入需要删除的房间号：");
		String customerIDCard = scanner.next();
		c.setCustomerIDCard(customerIDCard);
		if (Service.deleteCustomers(customerIDCard) == true)
			System.out.println("删除成功！");
		else
			System.out.println("请重新输入！");

	}

}
