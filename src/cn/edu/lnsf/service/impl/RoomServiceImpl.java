package cn.edu.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import cn.edu.lnsf.dao.IroomDao;
import cn.edu.lnsf.dao.impl.RoomDaoImpl;
import cn.edu.lnsf.model.Room;
import cn.edu.lnsf.service.IroomService;

public class RoomServiceImpl implements IroomService {

	// 注入service Dao
	@SuppressWarnings("unused")
	private IroomDao roomDao;

	public void setIroomDao(IroomDao roomDao) {
		this.roomDao = roomDao;
	}

	IroomDao roomDao1 = new RoomDaoImpl();

	// -------------------根据房间号查找房间信息-------------------------------

	@SuppressWarnings("unused")
	public Vector<Room> findRoomByroomNumber(String roomNumber) {

		Vector<Room> v = new Vector<Room>();
		v = roomDao1.findRoomByroomNumber(roomNumber);
		for (Room r : v)
			System.out.println("房间号：" + r.getRoomNumber() + "  " + "房间类型："
					+ r.getRoomType() + "  " + "房间价格：" + r.getRoomPrice()
					+ "  " + "房间状态：" + r.getRoomStatus() + "  " + "备注："
					+ r.getRemarks());
		if (v == null)
			System.out.println("该房间不存在...");
		return v;
	}
	
	public int findRoomMoneyByroomNumber(String roomNumber){
		int n =  roomDao1.findRoomMoneyByroomNumber(roomNumber);
		return n;
	}
	
	// -------------------根据房间号查找价格-------------------------------

	public int findPriceByroomNumber(String roomNumber){
		int roomPrice = roomDao1.findPriceByroomNumber(roomNumber);
		return roomPrice;
	}

	// -------------------根据房间类型查找房间信息-------------------------------
	@SuppressWarnings("unused")
	public Vector<Room> findRoomByroomType(String roomType) {
		Vector<Room> v2 = new Vector<Room>();
		v2 = roomDao1.findRoomByroomType(roomType);
		for (Room r1 : v2)
			System.out.println("房间号：" + r1.getRoomNumber() + "  " + "房间类型："
					+ r1.getRoomType() + "  " + "房间价格：" + r1.getRoomPrice()
					+ "  " + "房间状态：" + r1.getRoomStatus() + "  " + "备注："
					+ r1.getRemarks());
		if (v2 == null)
			System.out.println("该房间类型不存在...");
		return v2;
	}
	
	// -------------------根据房间类型、房间状态为空时随机分配房间-------------------
	public String findRoomNumberByroomType(String roomType){
		List<String> list1 = new ArrayList<>();
		list1 = roomDao1.findRoomNumberByroomType(roomType);
		Random random = new Random();		
	    int a[] = new int[list1.size()];
	    for(int i = 0;i<a.length;i++){
	    	a[i] = random.nextInt(list1.size());	    	
	    	for(int j = 1; j<i ; j++){
	    		while (a[i] == a[j]){
	    			i--;
	    			a[0]=a[i];
	    		}
	    	}
	    }
	    
	    String roomNumber = list1.get(a[0]);
	    return roomNumber;
	}
	
	
	// ------------------统计房间类型空房量------------------
	public Vector<Room> CountRoomType(){
		Vector<Room> v3 = new Vector<Room>();
		v3 = roomDao1.CountRoomType();
		for(Room r : v3){
			System.out.println("房间类型："+r.getRoomType()+"  "+
					"空房数量："+"  "+r.getroomCount());
		}
		return v3;
	}

	// ------------------查找所有房间信息---------------------------------------
	public Vector<Room> findAllRoom() {

		Vector<Room> v1 = new Vector<Room>();
		v1 = roomDao1.findAllRoom();
		for (Room r : v1)
			System.out.println("房间号：" + r.getRoomNumber() + "  " + "房间类型："
					+ r.getRoomType() + "  " + "房间价格：" + r.getRoomPrice()
					+ "  " + "房间状态：" + r.getRoomStatus() + "  " + "备注："
					+ r.getRemarks());
		return v1;
	}

	// -----------------插入房间信息-------------------------------------------
	public boolean insertintofoRoom(Room r) {
		boolean flag = false;
		flag = roomDao1.insertintofoRoom(r);
		return flag;
	}

	// ------------------更新房间信息------------------------------------------
	public boolean updateRoom(Room r) {
		boolean flag = false;
		flag = roomDao1.updateRoom(r);
		return flag;
	}

	// ------------------删除一条房间信息--------------------------------------
	public boolean deleteRoom(String roomNumber) {
		boolean flag = false;
		flag = roomDao1.deleteRoom(roomNumber);
		return flag;
	}

}
