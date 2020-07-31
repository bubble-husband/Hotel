package cn.edu.lnsf.controller;

import java.util.Scanner;
import java.util.Date;

import cn.edu.lnsf.dbutils.OrderFactory;
import cn.edu.lnsf.model.Orders;
import cn.edu.lnsf.model.Room;
import cn.edu.lnsf.service.IbookroomService;
import cn.edu.lnsf.service.IordersService;
import cn.edu.lnsf.service.IroomService;
import cn.edu.lnsf.service.impl.BookroomServiceImpl;
import cn.edu.lnsf.service.impl.OrdersServiceImpl;
import cn.edu.lnsf.service.impl.RoomServiceImpl;

public class OnlineOrdersController {

	public IbookroomService brservice= new BookroomServiceImpl();
	@SuppressWarnings("unused")
	private IroomService rservice = new RoomServiceImpl();
	private IordersService service = new OrdersServiceImpl();
	public Orders o = new Orders();
	public Scanner scanner = new Scanner(System.in);
	

	//���ɶ���
	public void insertOrders(Orders ox){
		@SuppressWarnings("unused")
		Room r = new Room();
		@SuppressWarnings("unused")
		BookRoomController bookroomcon = new BookRoomController();
		@SuppressWarnings("unused")
		String customerIDCard,orderStatus,roomType,roomNumber,waiterID,remarks,orderTime;
		Date checkInTime,checkOutTime;
		int totalMoney;
		long t = OrderFactory.exchangeID(ox.getCustomerIDCard());
		System.out.println("===================�Զ����ɶ�����Ϣ===================");
		System.out.println("�����ţ�"+OrderFactory.getOrderLinu(t));	
		String orderNumber = OrderFactory.getOrderLinu(t);
		String orderStayus = "Ԥ����";
		o.setOrderNumber(orderNumber);
		o.setOrderStatus(orderStayus);
		System.out.println("����״̬��");
		System.out.println(orderStayus);
		o.setCustomerIDCard(ox.getCustomerIDCard()); 
		System.out.println("����ţ�");
		roomNumber = ox.getRoomNumber();
		System.out.println(roomNumber);						
		System.out.println("��סʱ�䣺");
		checkInTime = ox.getCheckInTime();
		o.setCheckInTime(checkInTime);
		System.out.println(new java.sql.Date(checkInTime.getTime()));		
		System.out.println("�˷�ʱ�䣺");
		checkOutTime = ox.getCheckOutTime();
		o.setCheckOutTime(checkOutTime);
		System.out.println(new java.sql.Date(checkOutTime.getTime()));
		System.out.println("�ܽ�");		
		totalMoney = ox.getTotalMoney();
		System.out.println(totalMoney);
		System.out.println("��ע��");
		remarks = scanner.next();
		o.setRoomNumber(roomNumber);
		o.setTotalMoney(totalMoney);
		o.setRemarks(remarks);
		service.insertOrders(o);
				
	}
}
