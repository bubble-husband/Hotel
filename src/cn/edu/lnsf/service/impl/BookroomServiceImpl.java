package cn.edu.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.lnsf.model.Orders;
import cn.edu.lnsf.model.Room;
import cn.edu.lnsf.service.IbookroomService;

public class BookroomServiceImpl implements IbookroomService {	
//这里的List必须是同一个而不是新的,用一个对象且只实例化一次，即单例，
//	这样list就只有一个，也不会再次实例化变成	
	public BookroomServiceImpl(){
		
	}
	
	//模拟现实中的购物车
	public List<Room> list = new ArrayList<Room>();
	public List<Orders> list2 = new ArrayList<Orders>();
	
	public List<Room> getList() {		
		if(list.size() != 0){
			for(Room room : list){
				System.out.println("房间编号："+room.getRoomNumber()+" 价格："+room.getRoomPrice());
			}						
		}
		else System.out.println("购物车为空");
		return list;
	}
	
	
	//购物车添加房间
	public void add(Room room) {
		boolean isOnly = true;
		for(Room room2 : list){
//			System.out.println(room == room2);
			if(room.getRoomNumber().equals(room2.getRoomNumber()) ){					
				isOnly = false;
				System.out.println("只有一间房！请勿重复预订！");
				break;
			}
		}
		if(isOnly){		
			System.out.println("添加成功");
			list.add(room);
		}		
}

	//删除购物车中的房间
	public void delete(String roomNumber) {
		boolean isexit = true;
		for(Room room : list){
			if(room.getRoomNumber().equals(roomNumber)){
				list.remove(room);
				System.out.println("删除成功！");
				isexit = false;
				return;
			}
		}
		if(isexit){
				System.out.println("不存在这项商品！");
		}
		
	}

	//清空购物车
	public void clear() {
		list.clear();
		System.out.println("已清空购物车！");
		
	}

	//获取总价格
	public int getTotalPrice() {
		int totalPrice = 0;
		for(Room room : list){
			totalPrice =totalPrice + room.getRoomPrice();
		}
		return totalPrice;
	}
	
	
}
