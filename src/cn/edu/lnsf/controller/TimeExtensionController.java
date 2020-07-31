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

	// 注入controller Service
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
		System.out.println("请输入身份证号：");
		String customerID = scanner.next();
		System.out.println("请输入需要续费的房间号：");
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
		System.out.println("请输入需要续费的天数：");
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

	// 根据续费编号，删除续费表
	public void deleteTimeExtension() {
		System.out.println("请输入需要删除的续订编号：");
		int operatingID = scanner.nextInt();
		t.setOperatingID(operatingID);
		if (Service.deleteTimeExtension(operatingID) == true)
			System.out.println("删除成功！");
		else
			System.out.println("请重新输入！");
	}

	// 根据订单号，删除续费表
	public void deleteTimeExtensionByorderNumber() {
		System.out.println("请输入需要删除的续订单号：");
		String orderNumber1 = scanner.next();
		t.setOrderNumber(orderNumber1);
		if (Service.deleteTimeExtensionByorderNumber(orderNumber1) == true)
			System.out.println("删除成功！");
		else
			System.out.println("请重新输入！");

	}

	// 查询续费表
	public void findAllTimeExtension() {
		Service.findAllTimeExtension();
	}

	// 根据订单号查询续费信息
	public void findTimeExtensionByorderNumber() {
		System.out.print("请输入查找的续订单号：");
		String orderNumber = scanner.next();
		t.setOrderNumber(orderNumber);
		Service.findTimeExtensionByorderNumber(t);
	}

	// 根据续费编号查询续费信息
	public void findTimeExtensionByoperatingID() {
		System.out.print("请输入查找的续订编号：");
		int operatingID = scanner.nextInt();
		t.setOperatingID(operatingID);
		Service.findTimeExtensionByoperatingID(t);
	}
}
