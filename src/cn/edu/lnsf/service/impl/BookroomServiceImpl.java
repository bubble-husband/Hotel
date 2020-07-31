package cn.edu.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.lnsf.model.Orders;
import cn.edu.lnsf.model.Room;
import cn.edu.lnsf.service.IbookroomService;

public class BookroomServiceImpl implements IbookroomService {	
//�����List������ͬһ���������µ�,��һ��������ֻʵ����һ�Σ���������
//	����list��ֻ��һ����Ҳ�����ٴ�ʵ�������	
	public BookroomServiceImpl(){
		
	}
	
	//ģ����ʵ�еĹ��ﳵ
	public List<Room> list = new ArrayList<Room>();
	public List<Orders> list2 = new ArrayList<Orders>();
	
	public List<Room> getList() {		
		if(list.size() != 0){
			for(Room room : list){
				System.out.println("�����ţ�"+room.getRoomNumber()+" �۸�"+room.getRoomPrice());
			}						
		}
		else System.out.println("���ﳵΪ��");
		return list;
	}
	
	
	//���ﳵ��ӷ���
	public void add(Room room) {
		boolean isOnly = true;
		for(Room room2 : list){
//			System.out.println(room == room2);
			if(room.getRoomNumber().equals(room2.getRoomNumber()) ){					
				isOnly = false;
				System.out.println("ֻ��һ�䷿�������ظ�Ԥ����");
				break;
			}
		}
		if(isOnly){		
			System.out.println("��ӳɹ�");
			list.add(room);
		}		
}

	//ɾ�����ﳵ�еķ���
	public void delete(String roomNumber) {
		boolean isexit = true;
		for(Room room : list){
			if(room.getRoomNumber().equals(roomNumber)){
				list.remove(room);
				System.out.println("ɾ���ɹ���");
				isexit = false;
				return;
			}
		}
		if(isexit){
				System.out.println("������������Ʒ��");
		}
		
	}

	//��չ��ﳵ
	public void clear() {
		list.clear();
		System.out.println("����չ��ﳵ��");
		
	}

	//��ȡ�ܼ۸�
	public int getTotalPrice() {
		int totalPrice = 0;
		for(Room room : list){
			totalPrice =totalPrice + room.getRoomPrice();
		}
		return totalPrice;
	}
	
	
}
