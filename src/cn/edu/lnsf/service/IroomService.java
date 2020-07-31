package cn.edu.lnsf.service;

import java.util.Vector;

import cn.edu.lnsf.model.Room;

public interface IroomService {

	// ���ݷ���Ų��ҷ�����Ϣ
	public Vector<Room> findRoomByroomNumber(String roomNumber);

	// ���ݷ���Ų��Ҽ۸�
	public int findPriceByroomNumber(String roomNumber);

	// ���ݷ������Ͳ��ҷ�����Ϣ
	public Vector<Room> findRoomByroomType(String roomType);

	// ���ݷ���Ų��Ҽ۸�
	public int findRoomMoneyByroomNumber(String roomNumber);

	// ���ݷ������͡�����״̬Ϊ��ʱ������䷿��
	public String findRoomNumberByroomType(String roomType);

	// ͳ�Ʒ������Ϳշ���
	public Vector<Room> CountRoomType();

	// ����ȫ��������Ϣ
	public Vector<Room> findAllRoom();

	// ���뷿����Ϣ
	public boolean insertintofoRoom(Room r);

	// ���·�����Ϣ
	public boolean updateRoom(Room r);

	// ɾ��һ��������Ϣ
	public boolean deleteRoom(String roomNumber);

}
