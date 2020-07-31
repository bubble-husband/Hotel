package cn.edu.lnsf.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

import cn.edu.lnsf.dbutils.OrderFactory;
import cn.edu.lnsf.model.Count;
import cn.edu.lnsf.model.Orders;
import cn.edu.lnsf.service.IordersService;
import cn.edu.lnsf.service.IroomService;
import cn.edu.lnsf.service.impl.OrdersServiceImpl;
import cn.edu.lnsf.service.impl.RoomServiceImpl;

public class OrdersController {

	private IordersService service = new OrdersServiceImpl();
	private IroomService roomService = new RoomServiceImpl();
	public Orders o = new Orders();
	public Scanner scanner = new Scanner(System.in);
	WaiterController wCon = new WaiterController();

	// 生成订单
	public void insertOrders(Orders ot) {

		@SuppressWarnings("unused")
		String customerIDCard, roomNumber, waiterID, remarks, checkOutTime, checkInTime, orderTime;
		int totalMoney;
		long t = OrderFactory.exchangeID(ot.getCustomerIDCard());
		System.out.println(OrderFactory.getOrderCode(t));
		String orderNumber = OrderFactory.getOrderCode(t);
		String orderStayus = "预定中";
		o.setOrderNumber(orderNumber);
		o.setOrderStatus(orderStayus);
		o.setCustomerIDCard(ot.getCustomerIDCard());
		System.out.println("请输入您要选择的房间类型：（类型：优品单人房、优品双人房、豪华套房、总统套房）");
		// 根据房间类型，查询是否有该房间号（类型：优品单人房、优品双人房、豪华套房）
		String roomType = scanner.nextLine();
		roomService.findRoomByroomType(roomType);
		//
		System.out.println("请输入房间号：");
		roomNumber = scanner.next();

		System.out.println("入住时间：");
		checkInTime = scanner.next();
		System.out.println("退房时间：");
		checkOutTime = scanner.next();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date Indate = format.parse(checkInTime);
			o.setCheckInTime(Indate);
			Date Outdate = format.parse(checkOutTime);
			o.setCheckOutTime(Outdate);
			ot.setCheckInTime(Indate);
			ot.setCheckOutTime(Outdate);
		} catch (ParseException e) {
			System.out.println("不合法的输入");
			e.printStackTrace();
		}
		System.out.print("总住宿天数为：");
		int day = (int) service.totalAllMoney(ot);
		totalMoney = roomService.findRoomMoneyByroomNumber(roomNumber) * day;
		System.out.println("总金额为：");
		System.out.println(totalMoney);
		System.out.println("服务员ID：");
		waiterID = scanner.next();
		System.out.println("备注：");
		remarks = scanner.next();
		o.setRoomNumber(roomNumber);
		o.setTotalMoney(totalMoney);
		o.setWaiterID(waiterID);
		o.setRemarks(remarks);
		if (service.insertOrders(o) == true) {
			System.out.println("订单号已经生成..");
		} else {
			System.out.println("订单生成失败，请重新申请...");
		}

	}

	//
	public void coumtYearOrders() {
		for (Count c : service.countYearOrders()) {
			System.out.println("年份：" + c.getCountYear() + "  " + "经营额："
					+ c.getCountMoney());
		}

	}

	//
	public void coumtMonthOrders() {
		// System.out.println(service.coumtMonthOrders());
		for (Count c : service.countMonthOrders()) {
			System.out.println("月份：" + c.getCountMonth() + "  " + "经营额："
					+ c.getCountMoney());
		}
	}

	//
	public void coumtWeekOrders() {
		for (Count c : service.countWeekOrders()) {
			System.out.println("周：" + c.getCountWeek() + "  " + "经营额："
					+ c.getCountMoney());
		}
	}

	//
	public void coumtDayOrders() {
		for (Count c : service.countDayOrders()) {
			System.out.println("日：" + c.getCountDay() + "  " + "经营额："
					+ c.getCountMoney());
		}
	}

	public void findAllOrders() {

		for (Orders os : service.findAllOrders()) {
			System.out.println(os.getOrderNumber());
			System.out.println(os.getOrderStatus() + ","
					+ os.getCustomerIDCard() + "," + os.getRoomNumber() + ","
					+ os.getCheckInTime() + "," + os.getCheckOutTime() + ","
					+ os.getTotalMoney() + "," + os.getWaiterID() + ","
					+ os.getRemarks() + "," + os.getOrderTime());
		}
	}

	// 删除订单

}
