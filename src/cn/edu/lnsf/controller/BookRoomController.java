package cn.edu.lnsf.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import cn.edu.lnsf.model.Orders;
import cn.edu.lnsf.model.Room;
import cn.edu.lnsf.service.IbookroomService;
import cn.edu.lnsf.service.IordersService;
import cn.edu.lnsf.service.IroomService;
import cn.edu.lnsf.service.impl.BookroomServiceImpl;
import cn.edu.lnsf.service.impl.OrdersServiceImpl;
import cn.edu.lnsf.service.impl.RoomServiceImpl;

public class BookRoomController {	
	public IbookroomService service= new BookroomServiceImpl();
	public IroomService rservice = new RoomServiceImpl();
	public Scanner scanner = new Scanner(System.in);
	public OnlineCsController oc = new OnlineCsController();
	public OnlineOrdersController onlineod = new OnlineOrdersController();
	public RoomController roomcon = new RoomController();
	private IordersService priceService = new OrdersServiceImpl();
	
	Orders ot = new Orders();
	public void bookroom(Orders ot) {		
		List<Orders> list2 = new ArrayList<Orders>();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choose = -1;
		while(choose!=0){
			System.out.println();
			System.out.println("========请选择操作的数字========");
			System.out.println("	1、浏览购物车 				");
			System.out.println("	2、预订房间 				");
			System.out.println("	3、删除单个预订房间 			");
			System.out.println("	4、清空购物车 				");
			System.out.println("	0、提交 				 	");
			System.out.println("请输入要操作的数字：");
			choose = scanner.nextInt();
			switch(choose){
				case 1:
					service.getList();
					break;
				case 2:		
				{				
					Room r = new Room();
					String roomType = null;
					String roomNumber = null;
					String checkOutTime = null, checkInTime = null;
					Orders o1 = new Orders();
					
					System.out.println("请输入入住时间：");
					checkInTime = scanner.next();
					System.out.println("请输入退房时间：");
					checkOutTime = scanner.next();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date Indate = format.parse(checkInTime);
						o1.setCheckInTime(Indate);
						Date Outdate = format.parse(checkOutTime);
						o1.setCheckOutTime(Outdate);
					} catch (ParseException e) {
						System.out.println("不合法的输入");
						e.printStackTrace();
					}
					System.out.println();
					System.out.println("========我们提供的房间有：========");
					rservice.CountRoomType();
					System.out.println("请输入您要选择的房间类型：");
					System.out.println("（优品单人房、优品双人房、豪华套房）");
					roomType = scanner.next();
					System.out.println("分配的房间号：");					
					roomNumber = roomcon.findRoomNumberByroomType(roomType);
					System.out.println("\t"+roomNumber);
					r.setRoomNumber(roomNumber);
					o1.setRoomNumber(roomNumber);
					System.out.print("总住宿天数为：");
					int day = (int) priceService.totalAllMoney(o1);
//					totalMoney = roomService.findRoomMoneyByroomNumber(roomNumber) * day;
//					System.out.println("总金额为：");
//					System.out.println(totalMoney);
					
					System.out.println("房间价格：");
					System.out.println("\t"+roomcon.findPriceByroomNumber(roomNumber)* day);
					r.setRoomPrice(roomcon.findPriceByroomNumber(roomNumber)* day);
					o1.setTotalMoney(roomcon.findPriceByroomNumber(roomNumber)* day);
					
					
					
					service.add(r);	
					list2.add(o1);				
				}																																	
					break;
				case 3:
					System.out.println("请选择要删除的房间号：");
					String roomNumber1 = scanner.next();
					service.delete(roomNumber1);
					for (Iterator<Orders> iter =  list2.iterator(); iter.hasNext();) {
						Orders o1 = iter.next();
						if (o1.getRoomNumber().equals(roomNumber1)) {
							iter.remove();
						}
					}
					break;
				case 4:
					service.clear();
					list2.clear();
					break;
				case 0:					
					System.out.println();
					for(Orders orders : list2){
						orders.setCustomerIDCard(ot.getCustomerIDCard());
						onlineod.insertOrders(orders);
					}	
					System.out.println("您已成功预订酒店！");
					System.out.println("共需支付"+service.getTotalPrice()+"元");
					break;
				default:
					System.out.println("没有此项选择！");
					break;
			}
		}
		
	}	
	
} 
