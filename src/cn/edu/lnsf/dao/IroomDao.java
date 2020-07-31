package cn.edu.lnsf.dao;

import java.util.List;
import java.util.Vector;

import cn.edu.lnsf.model.Room;

public interface IroomDao {

	//���ݷ���Ų��ҷ�����Ϣ
	public Vector<Room> findRoomByroomNumber(String roomNumber);
	
	public Vector<Room> findRoomByroomType(String roomType);
	
	public int findRoomMoneyByroomNumber(String roomNumber);
	
	//����ȫ��������Ϣ
	public Vector<Room> findAllRoom();
	
	//���뷿����Ϣ
	public boolean insertintofoRoom(Room r);
	
	//���·�����Ϣ
	public boolean updateRoom(Room r);
	
	//ɾ��һ��������Ϣ
	public boolean deleteRoom(String roomNumber);
	//ͳ�Ʒ������Ϳշ���
	public Vector<Room> CountRoomType();
	//���ݷ������͡�����״̬Ϊ��ʱ������䷿��
	public List<String> findRoomNumberByroomType(String roomType);
	//���ݷ���Ų��ҷ���۸�
	public int findPriceByroomNumber(String roomNumber);
	
}
