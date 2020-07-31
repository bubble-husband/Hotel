package cn.edu.lnsf.controller;

import java.util.Scanner;

import cn.edu.lnsf.model.Room;
import cn.edu.lnsf.service.IroomService;
import cn.edu.lnsf.service.impl.RoomServiceImpl;

public class RoomController {

	// 注入controller Service
	@SuppressWarnings("unused")
	private IroomService roomService;

	public void setIroomService(IroomService roomService) {
		this.roomService = roomService;
	}

	Room r = new Room();
	Scanner scanner = new Scanner(System.in);
	IroomService Service = new RoomServiceImpl();

	// ----------------------------根据房间号查找房间信息------------------------

	public void findRoomByroomNumber(String roomNumber1) {

		// Vector<Room> v = new Vector<Room>();

		System.out.print("请输入查找的房间号：");
		roomNumber1 = scanner.next();
		r.setRoomNumber(roomNumber1);
		Service.findRoomByroomNumber(roomNumber1);

	}

	// ----------------------------根据房间号查找房间信息------------------------

	public int findPriceByroomNumber(String roomNumber) {
		int roomPrice = Service.findPriceByroomNumber(roomNumber);
		return roomPrice;

	}

	// ----------------------------查找所有房间信息------------------------
	public void findAllRoom() {
		// Vector<Room> v1 = new Vector<Room>();
		Service.findAllRoom();
	}

	// ----------------------------根据房间类型、房间状态为空时随机分配房间------------------------
	public String findRoomNumberByroomType(String roomType) {
		return Service.findRoomNumberByroomType(roomType);
	}

	// ------------------------------插入房间信息-------------------------------------------
	public void insertintofoRoom() {
		System.out.println("请依次输入房间号、房间类型、房间价格、房间状态和备注：");
		String roomNumber2 = scanner.next();
		String roomType2 = scanner.next();
		int roomPrice2 = scanner.nextInt();
		String roomStatus2 = scanner.next();
		String remarks2 = scanner.next();
		r.setRoomNumber(roomNumber2);
		r.setRoomType(roomType2);
		r.setRoomPrice(roomPrice2);
		r.setRoomStatus(roomStatus2);
		r.setRemarks(remarks2);
		if (Service.insertintofoRoom(r) == true)
			System.out.println("插入成功！");
		else
			System.out.println("请重新输入!");
	}

	// ---------------------------------更新房间信息------------------------------------------
	public void updateRoom() {
		System.out.println("请输入需更新的房间号：");
		String roomNumber3 = scanner.next();
		System.out.println("请依次输入修改后的房间类型、房间价格、房间状态和备注：");
		String roomType3 = scanner.next();
		int roomPrice3 = scanner.nextInt();
		String roomStatus3 = scanner.next();
		String remarks3 = scanner.next();
		r.setRoomNumber(roomNumber3);
		r.setRoomType(roomType3);
		r.setRoomPrice(roomPrice3);
		r.setRoomStatus(roomStatus3);
		r.setRemarks(remarks3);
		if (Service.updateRoom(r) == true)
			System.out.println("更新成功！");
		else
			System.out.println("请重新输入!");

	}

	// -----------------------------------删除一条房间信息--------------------------------------
	public void deleteRoom(String roomNumber4) {
		System.out.println("请输入需要删除的房间号：");
		roomNumber4 = scanner.next();
		r.setRoomNumber(roomNumber4);
		if (Service.deleteRoom(roomNumber4) == true)
			System.out.println("删除成功！");
		else
			System.out.println("请重新输入！");

	}

}
