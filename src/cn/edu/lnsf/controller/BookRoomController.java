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
			System.out.println("========��ѡ�����������========");
			System.out.println("	1��������ﳵ 				");
			System.out.println("	2��Ԥ������ 				");
			System.out.println("	3��ɾ������Ԥ������ 			");
			System.out.println("	4����չ��ﳵ 				");
			System.out.println("	0���ύ 				 	");
			System.out.println("������Ҫ���������֣�");
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
					
					System.out.println("��������סʱ�䣺");
					checkInTime = scanner.next();
					System.out.println("�������˷�ʱ�䣺");
					checkOutTime = scanner.next();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date Indate = format.parse(checkInTime);
						o1.setCheckInTime(Indate);
						Date Outdate = format.parse(checkOutTime);
						o1.setCheckOutTime(Outdate);
					} catch (ParseException e) {
						System.out.println("���Ϸ�������");
						e.printStackTrace();
					}
					System.out.println();
					System.out.println("========�����ṩ�ķ����У�========");
					rservice.CountRoomType();
					System.out.println("��������Ҫѡ��ķ������ͣ�");
					System.out.println("����Ʒ���˷�����Ʒ˫�˷��������׷���");
					roomType = scanner.next();
					System.out.println("����ķ���ţ�");					
					roomNumber = roomcon.findRoomNumberByroomType(roomType);
					System.out.println("\t"+roomNumber);
					r.setRoomNumber(roomNumber);
					o1.setRoomNumber(roomNumber);
					System.out.print("��ס������Ϊ��");
					int day = (int) priceService.totalAllMoney(o1);
//					totalMoney = roomService.findRoomMoneyByroomNumber(roomNumber) * day;
//					System.out.println("�ܽ��Ϊ��");
//					System.out.println(totalMoney);
					
					System.out.println("����۸�");
					System.out.println("\t"+roomcon.findPriceByroomNumber(roomNumber)* day);
					r.setRoomPrice(roomcon.findPriceByroomNumber(roomNumber)* day);
					o1.setTotalMoney(roomcon.findPriceByroomNumber(roomNumber)* day);
					
					
					
					service.add(r);	
					list2.add(o1);				
				}																																	
					break;
				case 3:
					System.out.println("��ѡ��Ҫɾ���ķ���ţ�");
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
					System.out.println("���ѳɹ�Ԥ���Ƶ꣡");
					System.out.println("����֧��"+service.getTotalPrice()+"Ԫ");
					break;
				default:
					System.out.println("û�д���ѡ��");
					break;
			}
		}
		
	}	
	
} 
