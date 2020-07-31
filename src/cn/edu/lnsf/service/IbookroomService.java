package cn.edu.lnsf.service;

import java.util.List;

import cn.edu.lnsf.model.Room;

public interface IbookroomService {
	
	// 提供get方法给页面的el表达式用
	public List<Room> getList();

	// 添加房间
	public void add(Room room);

	// 删除购物车中的房间
	public void delete(String roomNumber);

	// 清空购物车
	public void clear();

	// 预订房间总额
	public int getTotalPrice();

}
