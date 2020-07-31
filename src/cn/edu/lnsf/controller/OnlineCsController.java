package cn.edu.lnsf.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import cn.edu.lnsf.model.Customers;
import cn.edu.lnsf.model.Orders;
import cn.edu.lnsf.service.IcustomersService;
import cn.edu.lnsf.service.impl.CustomersServiceImpl;

public class OnlineCsController {
	@SuppressWarnings("unused")
	private IcustomersService customersService;

	public void setIcustomersService(IcustomersService customersService) {
		this.customersService = customersService;
	}

	Customers c = new Customers();
	Scanner scanner = new Scanner(System.in);
	IcustomersService Service = new CustomersServiceImpl();
	
	// ------------------------------插入顾客信息-------------------------------------------
	public void insertintofoCustomers() {
        Orders o = new Orders();
        BookRoomController bookroom = new BookRoomController();
        System.out.println("===================请填写顾客信息====================");
		System.out.println("请输入身份证号：");
		String customerIDCard = scanner.next();
		
		if(Service.findCustomersByID(customerIDCard)==true){
			System.out.println("顾客已存在！可直接预订房间！");			
			Vector<Customers> v = new Vector<Customers>();
			v = Service.findCustomersBycustomerIDCard(customerIDCard);
			for(Customers c : v){
				System.out.println("性别：");	
				String customerGender = c.getCustomerGender();
				System.out.println(customerGender);
				
				System.out.println("姓名：");
				String customerName = c.getCustomerName();
				System.out.println(customerName);
				
				System.out.println("顾客生日：");
				Date customerBirthday = c.getCustomerBirthday();
				System.out.println(customerBirthday);
				
				System.out.println("请输入联系方式:");
				String customerPhone = c.getCustomerPhone();
				System.out.println(customerPhone);
				
				System.out.println("备注:");
				String remarks = c.getRemarks();
				System.out.println(remarks);
				
				c.setCustomerIDCard(customerIDCard);
				c.setCustomerBirthday(customerBirthday);
				c.setCustomerGender(customerGender);
				c.setCustomerName(customerName);
				c.setCustomerPhone(customerPhone);
				c.setRemarks(remarks);
			}		
			o.setCustomerIDCard(customerIDCard);
			bookroom.bookroom(o);
		}
		
		else{
			System.out.println("还未注册！请填写相关信息！");
			System.out.println("性别：");
			String customerGender;
			if(Integer.parseInt(customerIDCard.substring(16,17)) % 2 == 0){
				customerGender = "女";
			}else{
				customerGender = "男";
			}		
			System.out.println(customerGender);
			System.out.println("顾客生日：");
			String customerBirthday = customerIDCard.substring(6, 10)+"-"+
					customerIDCard.substring(10, 12)+"-"+customerIDCard.substring(12, 14);
			System.out.println(customerBirthday);
			System.out.println("请输入姓名：");
			String customerName = scanner.next();	
			System.out.println("请输入联系方式:");
			String customerPhone = scanner.next();
			System.out.println("备注:");
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
			
			if (Service.insertintofoCustomers(c) == true)
				System.out.println("已成功填写资料！");
			else
				System.out.println("请重新输入!");
			System.out.println();
			o.setCustomerIDCard(customerIDCard);
			bookroom.bookroom(o);
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
	
	// ----------------------------根据顾客身份证查找顾客信息------------------------
	public void findCustomersBycustomerIDCard(String customerID) {

//		Vector<Customers> v = new Vector<Customers>();

		System.out.print("请输入身份证号：");
		String customerIDCard = scanner.next();
		c.setCustomerIDCard(customerIDCard);
		Service.findCustomersBycustomerIDCard(customerIDCard);
//		v = Service.findCustomersBycustomerIDCard(customerIDCard);

	}
	
}
