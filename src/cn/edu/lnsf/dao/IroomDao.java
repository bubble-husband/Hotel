package cn.edu.lnsf.dao;

import java.util.List;
import java.util.Vector;

import cn.edu.lnsf.model.Room;

public interface IroomDao {

	//根据房间号查找房间信息
	public Vector<Room> findRoomByroomNumber(String roomNumber);
	
	public Vector<Room> findRoomByroomType(String roomType);
	
	public int findRoomMoneyByroomNumber(String roomNumber);
	
	//查找全部房间信息
	public Vector<Room> findAllRoom();
	
	//插入房间信息
	public boolean insertintofoRoom(Room r);
	
	//更新房间信息
	public boolean updateRoom(Room r);
	
	//删除一条房间信息
	public boolean deleteRoom(String roomNumber);
	//统计房间类型空房量
	public Vector<Room> CountRoomType();
	//根据房间类型、房间状态为空时随机分配房间
	public List<String> findRoomNumberByroomType(String roomType);
	//根据房间号查找房间价格
	public int findPriceByroomNumber(String roomNumber);
	
}
