package cn.edu.lnsf.service;

import java.util.Vector;

import cn.edu.lnsf.model.User;

public interface IuserService {
	// �����û�
	public Vector<User> findAllUser();

	// ��������
	public boolean insertinfotoUser(User u);

	// ɾ���û�
	public boolean deleteUser(String _userID);

	// �����û�
	public boolean updateUser(User u);

	// �����û���Ų����û���Ϣ
	public int findUserByuserID(String userID);

	// ��½�û�
	public int login(String userID, String userPassword);

	// ���µ�¼�Ĵ���
	public boolean updateNumber(User u);

	// ע��
	public boolean register(User u);
}
