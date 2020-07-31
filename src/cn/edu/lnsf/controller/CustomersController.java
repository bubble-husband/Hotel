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

	// ע��controller Service
	@SuppressWarnings("unused")
	private IcustomersService customersService;

	public void setIcustomersService(IcustomersService customersService) {
		this.customersService = customersService;
	}

	Customers c = new Customers();
	Scanner scanner = new Scanner(System.in);
	IcustomersService Service = new CustomersServiceImpl();

	// ----------------------------���ݹ˿����֤���ҹ˿���Ϣ------------------------
	public void findCustomersBycustomerIDCard(String customerID) {

//		Vector<Customers> v = new Vector<Customers>();

		System.out.print("��������ҵĹ˿����֤�ţ�");
		String customerIDCard = scanner.next();
		c.setCustomerIDCard(customerIDCard);
		Service.findCustomersBycustomerIDCard(customerIDCard);
//		v = Service.findCustomersBycustomerIDCard(customerIDCard);

	}

	// ----------------------------�������й˿���Ϣ------------------------

	public void findAllCustomers() {
//		Vector<Customers> v = new Vector<Customers>();
//		v = Service.findAllCustomers();
		Service.findAllCustomers();
	}

	// ------------------------------����˿���Ϣ-------------------------------------------
	public void insertintofoCustomers() {
        Orders o = new Orders();
        OrdersController ordersCon = new OrdersController();
		System.out.println("���������֤�ţ�");
		String customerIDCard = scanner.next();
		if(Service.findCustomersByID(customerIDCard)==true){
			System.out.println("��ס����Ϣ�Ѿ�����...");
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
			System.out.println("�������Ա�");
			String customerGender = scanner.next();
			System.out.println("������������");
			String customerName = scanner.next();
			System.out.println("������˿����գ�");
			String customerBirthday = scanner.next();
			System.out.println("��������ϵ��ʽ:");
			String customerPhone = scanner.next();
			System.out.println("��ע:");
			String remarks = scanner.next();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = format.parse(customerBirthday);
				System.out.println(date.getTime());
				c.setCustomerBirthday(date);
			} catch (ParseException e) {
				System.out.println("���Ϸ�������");
				e.printStackTrace();
			}
			c.setCustomerIDCard(customerIDCard);
			c.setCustomerGender(customerGender);
			c.setCustomerName(customerName);
			c.setCustomerPhone(customerPhone);
			c.setRemarks(remarks);
			if (Service.insertintofoCustomers(c) == true)
				System.out.println("����ɹ���");
			else
				System.out.println("����������!");
			o.setCustomerIDCard(customerIDCard);
			ordersCon.insertOrders(o);
		}	
	}

	// ---------------------------------���¹˿���Ϣ------------------------------------------
	public void updateCustomers(Customers c) {
		System.out.println("����������µĹ˿����֤�ţ�");
		String customerIDCard = scanner.next();
		System.out.println("�����������޸ĺ�Ĺ˿��Ա��������������ڡ��绰����ͱ�ע��");
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
			System.out.println("���Ϸ�������");
			e.printStackTrace();
		}
		
		c.setCustomerIDCard(customerIDCard);
		c.setCustomerGender(customerGender);
		c.setCustomerName(customerName);
		c.setCustomerPhone(customerPhone);
		c.setRemarks(remarks);
		if (Service.updateCustomers(c) == true)
			System.out.println("���³ɹ���");
		else
			System.out.println("����������!");

	}

	// -----------------------------------ɾ��һ���˿���Ϣ--------------------------------------
	public void deleteCustomers(String customerID) {

		System.out.println("��������Ҫɾ���ķ���ţ�");
		String customerIDCard = scanner.next();
		c.setCustomerIDCard(customerIDCard);
		if (Service.deleteCustomers(customerIDCard) == true)
			System.out.println("ɾ���ɹ���");
		else
			System.out.println("���������룡");

	}

}
