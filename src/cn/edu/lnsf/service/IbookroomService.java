package cn.edu.lnsf.service;

import java.util.List;

import cn.edu.lnsf.model.Room;

public interface IbookroomService {
	
	// �ṩget������ҳ���el���ʽ��
	public List<Room> getList();

	// ��ӷ���
	public void add(Room room);

	// ɾ�����ﳵ�еķ���
	public void delete(String roomNumber);

	// ��չ��ﳵ
	public void clear();

	// Ԥ�������ܶ�
	public int getTotalPrice();

}
