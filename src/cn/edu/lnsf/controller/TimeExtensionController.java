package cn.edu.lnsf.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import cn.edu.lnsf.dbutils.OrderFactory;
import cn.edu.lnsf.model.Orders;
import cn.edu.lnsf.model.TimeExtension;
import cn.edu.lnsf.service.IordersService;
import cn.edu.lnsf.service.ItimeextensionService;
import cn.edu.lnsf.service.impl.OrdersServiceImpl;
import cn.edu.lnsf.service.impl.TimeextensionServiceImpl;

public class TimeExtensionController {

	// ע��controller Service
	@SuppressWarnings("unused")
	private ItimeextensionService extensionService;

	public void setItimeextensionService(
			ItimeextensionService timeextensionService) {
		this.extensionService = timeextensionService;
	}

	@SuppressWarnings("unused")
	private IordersService orderService = new OrdersServiceImpl();

	TimeExtension t = new TimeExtension();
	Scanner scanner = new Scanner(System.in);
	ItimeextensionService Service = new TimeextensionServiceImpl();

	//
	public void insertExtension() {
		Orders input = new Orders();
		TimeExtension timeEx = new TimeExtension();
		List<Orders> list = new ArrayList<Orders>();
		List<Orders> listTime = new ArrayList<Orders>();
		System.out.println("���������֤�ţ�");
		String customerID = scanner.next();
		System.out.println("��������Ҫ���ѵķ���ţ�");
		String roomNumber = scanner.next();
		long t = OrderFactory.exchangeID(customerID);
		System.out.println(OrderFactory.getOrderRe(t));
		String Number = OrderFactory.getOrderRe(t);
		timeEx.setOrderNumber(Number);
		input.setOrderNumber(Number);
		input.setCustomerIDCard(customerID);
		input.setRoomNumber(roomNumber);
		System.out.println(customerID);
		System.out.println(roomNumber);
		list = Service.findOrdersByRoomAndID(customerID, roomNumber);
		listTime = Service.ordersByRoomCuid(customerID, roomNumber);
		System.out.println("��������Ҫ���ѵ�������");
		int day = scanner.nextInt();

		for (Orders ol : list) {
			Calendar calendar = new GregorianCalendar();
			Date checkOuttime = ol.getCheckOutTime();
			timeEx.setOldExpiryDate(checkOuttime);
			calendar.setTime(checkOuttime);
			calendar.add(Calendar.DATE,day);
			checkOuttime = calendar.getTime();
			timeEx.setNewExpiryDate(checkOuttime);
			input.setCheckInTime(ol.getCheckOutTime());
			input.setCheckOutTime(checkOuttime);
			input.setOrderStatus(ol.getOrderStatus());
			input.setWaiterID(ol.getWaiterID());
			input.setRemarks(ol.getRemarks());
		}
		for (Orders ot : listTime) {
			int money = ot.getTotalMoney();
			int roomMoney = day * money;
			timeEx.setAddedMoney(roomMoney);
			input.setTotalMoney(roomMoney);
		}
		IordersService in = new OrdersServiceImpl();
		in.insertOrders(input);
		Service.insertTimeExtension(timeEx);
	}

	// �������ѱ�ţ�ɾ�����ѱ�
	public void deleteTimeExtension() {
		System.out.println("��������Ҫɾ����������ţ�");
		int operatingID = scanner.nextInt();
		t.setOperatingID(operatingID);
		if (Service.deleteTimeExtension(operatingID) == true)
			System.out.println("ɾ���ɹ���");
		else
			System.out.println("���������룡");
	}

	// ���ݶ����ţ�ɾ�����ѱ�
	public void deleteTimeExtensionByorderNumber() {
		System.out.println("��������Ҫɾ�����������ţ�");
		String orderNumber1 = scanner.next();
		t.setOrderNumber(orderNumber1);
		if (Service.deleteTimeExtensionByorderNumber(orderNumber1) == true)
			System.out.println("ɾ���ɹ���");
		else
			System.out.println("���������룡");

	}

	// ��ѯ���ѱ�
	public void findAllTimeExtension() {
		Service.findAllTimeExtension();
	}

	// ���ݶ����Ų�ѯ������Ϣ
	public void findTimeExtensionByorderNumber() {
		System.out.print("��������ҵ��������ţ�");
		String orderNumber = scanner.next();
		t.setOrderNumber(orderNumber);
		Service.findTimeExtensionByorderNumber(t);
	}

	// �������ѱ�Ų�ѯ������Ϣ
	public void findTimeExtensionByoperatingID() {
		System.out.print("��������ҵ�������ţ�");
		int operatingID = scanner.nextInt();
		t.setOperatingID(operatingID);
		Service.findTimeExtensionByoperatingID(t);
	}
}
