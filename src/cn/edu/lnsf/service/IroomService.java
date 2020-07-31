package cn.edu.lnsf.service;

import java.util.Vector;

import cn.edu.lnsf.model.Room;

public interface IroomService {

	// 根据房间号查找房间信息
	public Vector<Room> findRoomByroomNumber(String roomNumber);

	// 根据房间号查找价格
	public int findPriceByroomNumber(String roomNumber);

	// 根据房间类型查找房间信息
	public Vector<Room> findRoomByroomType(String roomType);

	// 根据房间号查找价格
	public int findRoomMoneyByroomNumber(String roomNumber);

	// 根据房间类型、房间状态为空时随机分配房间
	public String findRoomNumberByroomType(String roomType);

	// 统计房间类型空房量
	public Vector<Room> CountRoomType();

	// 查找全部房间信息
	public Vector<Room> findAllRoom();

	// 插入房间信息
	public boolean insertintofoRoom(Room r);

	// 更新房间信息
	public boolean updateRoom(Room r);

	// 删除一条房间信息
	public boolean deleteRoom(String roomNumber);

}
