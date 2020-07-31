package cn.edu.lnsf.controller;

import java.util.Scanner;

import cn.edu.lnsf.model.Room;
import cn.edu.lnsf.service.IroomService;
import cn.edu.lnsf.service.impl.RoomServiceImpl;

public class RoomController {

	// ע��controller Service
	@SuppressWarnings("unused")
	private IroomService roomService;

	public void setIroomService(IroomService roomService) {
		this.roomService = roomService;
	}

	Room r = new Room();
	Scanner scanner = new Scanner(System.in);
	IroomService Service = new RoomServiceImpl();

	// ----------------------------���ݷ���Ų��ҷ�����Ϣ------------------------

	public void findRoomByroomNumber(String roomNumber1) {

		// Vector<Room> v = new Vector<Room>();

		System.out.print("��������ҵķ���ţ�");
		roomNumber1 = scanner.next();
		r.setRoomNumber(roomNumber1);
		Service.findRoomByroomNumber(roomNumber1);

	}

	// ----------------------------���ݷ���Ų��ҷ�����Ϣ------------------------

	public int findPriceByroomNumber(String roomNumber) {
		int roomPrice = Service.findPriceByroomNumber(roomNumber);
		return roomPrice;

	}

	// ----------------------------�������з�����Ϣ------------------------
	public void findAllRoom() {
		// Vector<Room> v1 = new Vector<Room>();
		Service.findAllRoom();
	}

	// ----------------------------���ݷ������͡�����״̬Ϊ��ʱ������䷿��------------------------
	public String findRoomNumberByroomType(String roomType) {
		return Service.findRoomNumberByroomType(roomType);
	}

	// ------------------------------���뷿����Ϣ-------------------------------------------
	public void insertintofoRoom() {
		System.out.println("���������뷿��š��������͡�����۸񡢷���״̬�ͱ�ע��");
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
			System.out.println("����ɹ���");
		else
			System.out.println("����������!");
	}

	// ---------------------------------���·�����Ϣ------------------------------------------
	public void updateRoom() {
		System.out.println("����������µķ���ţ�");
		String roomNumber3 = scanner.next();
		System.out.println("�����������޸ĺ�ķ������͡�����۸񡢷���״̬�ͱ�ע��");
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
			System.out.println("���³ɹ���");
		else
			System.out.println("����������!");

	}

	// -----------------------------------ɾ��һ��������Ϣ--------------------------------------
	public void deleteRoom(String roomNumber4) {
		System.out.println("��������Ҫɾ���ķ���ţ�");
		roomNumber4 = scanner.next();
		r.setRoomNumber(roomNumber4);
		if (Service.deleteRoom(roomNumber4) == true)
			System.out.println("ɾ���ɹ���");
		else
			System.out.println("���������룡");

	}

}
