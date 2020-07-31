package cn.edu.lnsf.dao;

import java.util.Vector;

import cn.edu.lnsf.model.User;


public interface IuserDao {
	
	//��½�û�
	int login(String _userID, String _userPassword);
	
	//�����û�
	Vector<User> findAllUser();
	
	//��������
	boolean insertinfotoUser(User u);
	
	//ɾ���û�
	boolean deleteUser(String _userID);
	
	//�����û�
	boolean updateUser(User u);
	
	//�����û���Ų����û���Ϣ
	public int findUserByuserID(String userID);
	
	//���µ�¼����
	boolean updateNumber(User u);
    
	//ע��
	public boolean register(User u);
	
}
