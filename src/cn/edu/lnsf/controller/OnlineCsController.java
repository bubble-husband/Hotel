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
	
	// ------------------------------����˿���Ϣ-------------------------------------------
	public void insertintofoCustomers() {
        Orders o = new Orders();
        BookRoomController bookroom = new BookRoomController();
        System.out.println("===================����д�˿���Ϣ====================");
		System.out.println("���������֤�ţ�");
		String customerIDCard = scanner.next();
		
		if(Service.findCustomersByID(customerIDCard)==true){
			System.out.println("�˿��Ѵ��ڣ���ֱ��Ԥ�����䣡");			
			Vector<Customers> v = new Vector<Customers>();
			v = Service.findCustomersBycustomerIDCard(customerIDCard);
			for(Customers c : v){
				System.out.println("�Ա�");	
				String customerGender = c.getCustomerGender();
				System.out.println(customerGender);
				
				System.out.println("������");
				String customerName = c.getCustomerName();
				System.out.println(customerName);
				
				System.out.println("�˿����գ�");
				Date customerBirthday = c.getCustomerBirthday();
				System.out.println(customerBirthday);
				
				System.out.println("��������ϵ��ʽ:");
				String customerPhone = c.getCustomerPhone();
				System.out.println(customerPhone);
				
				System.out.println("��ע:");
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
			System.out.println("��δע�ᣡ����д�����Ϣ��");
			System.out.println("�Ա�");
			String customerGender;
			if(Integer.parseInt(customerIDCard.substring(16,17)) % 2 == 0){
				customerGender = "Ů";
			}else{
				customerGender = "��";
			}		
			System.out.println(customerGender);
			System.out.println("�˿����գ�");
			String customerBirthday = customerIDCard.substring(6, 10)+"-"+
					customerIDCard.substring(10, 12)+"-"+customerIDCard.substring(12, 14);
			System.out.println(customerBirthday);
			System.out.println("������������");
			String customerName = scanner.next();	
			System.out.println("��������ϵ��ʽ:");
			String customerPhone = scanner.next();
			System.out.println("��ע:");
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
			
			if (Service.insertintofoCustomers(c) == true)
				System.out.println("�ѳɹ���д���ϣ�");
			else
				System.out.println("����������!");
			System.out.println();
			o.setCustomerIDCard(customerIDCard);
			bookroom.bookroom(o);
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
	
	// ----------------------------���ݹ˿����֤���ҹ˿���Ϣ------------------------
	public void findCustomersBycustomerIDCard(String customerID) {

//		Vector<Customers> v = new Vector<Customers>();

		System.out.print("���������֤�ţ�");
		String customerIDCard = scanner.next();
		c.setCustomerIDCard(customerIDCard);
		Service.findCustomersBycustomerIDCard(customerIDCard);
//		v = Service.findCustomersBycustomerIDCard(customerIDCard);

	}
	
}
