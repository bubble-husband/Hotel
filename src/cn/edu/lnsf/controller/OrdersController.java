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

	// ���ɶ���
	public void insertOrders(Orders ot) {

		@SuppressWarnings("unused")
		String customerIDCard, roomNumber, waiterID, remarks, checkOutTime, checkInTime, orderTime;
		int totalMoney;
		long t = OrderFactory.exchangeID(ot.getCustomerIDCard());
		System.out.println(OrderFactory.getOrderCode(t));
		String orderNumber = OrderFactory.getOrderCode(t);
		String orderStayus = "Ԥ����";
		o.setOrderNumber(orderNumber);
		o.setOrderStatus(orderStayus);
		o.setCustomerIDCard(ot.getCustomerIDCard());
		System.out.println("��������Ҫѡ��ķ������ͣ������ͣ���Ʒ���˷�����Ʒ˫�˷��������׷�����ͳ�׷���");
		// ���ݷ������ͣ���ѯ�Ƿ��и÷���ţ����ͣ���Ʒ���˷�����Ʒ˫�˷��������׷���
		String roomType = scanner.nextLine();
		roomService.findRoomByroomType(roomType);
		//
		System.out.println("�����뷿��ţ�");
		roomNumber = scanner.next();

		System.out.println("��סʱ�䣺");
		checkInTime = scanner.next();
		System.out.println("�˷�ʱ�䣺");
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
			System.out.println("���Ϸ�������");
			e.printStackTrace();
		}
		System.out.print("��ס������Ϊ��");
		int day = (int) service.totalAllMoney(ot);
		totalMoney = roomService.findRoomMoneyByroomNumber(roomNumber) * day;
		System.out.println("�ܽ��Ϊ��");
		System.out.println(totalMoney);
		System.out.println("����ԱID��");
		waiterID = scanner.next();
		System.out.println("��ע��");
		remarks = scanner.next();
		o.setRoomNumber(roomNumber);
		o.setTotalMoney(totalMoney);
		o.setWaiterID(waiterID);
		o.setRemarks(remarks);
		if (service.insertOrders(o) == true) {
			System.out.println("�������Ѿ�����..");
		} else {
			System.out.println("��������ʧ�ܣ�����������...");
		}

	}

	//
	public void coumtYearOrders() {
		for (Count c : service.countYearOrders()) {
			System.out.println("��ݣ�" + c.getCountYear() + "  " + "��Ӫ�"
					+ c.getCountMoney());
		}

	}

	//
	public void coumtMonthOrders() {
		// System.out.println(service.coumtMonthOrders());
		for (Count c : service.countMonthOrders()) {
			System.out.println("�·ݣ�" + c.getCountMonth() + "  " + "��Ӫ�"
					+ c.getCountMoney());
		}
	}

	//
	public void coumtWeekOrders() {
		for (Count c : service.countWeekOrders()) {
			System.out.println("�ܣ�" + c.getCountWeek() + "  " + "��Ӫ�"
					+ c.getCountMoney());
		}
	}

	//
	public void coumtDayOrders() {
		for (Count c : service.countDayOrders()) {
			System.out.println("�գ�" + c.getCountDay() + "  " + "��Ӫ�"
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

	// ɾ������

}
