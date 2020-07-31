package cn.edu.lnsf.service.impl;

import java.util.Scanner;
import java.util.Vector;


import cn.edu.lnsf.dao.IuserDao;
import cn.edu.lnsf.dao.impl.UserDaoImpl;
import cn.edu.lnsf.model.User;
import cn.edu.lnsf.service.IuserService;

public class UserServiceImpl implements IuserService {
	//����dao�л�ȡ��ԭʼ���ݣ�����Ҫʵ�ֵĹ��ܷ��ڴ˴���ҵ���߼�����
	//ҵ��ģ����߼�Ӧ�����
	@SuppressWarnings("unused")
	private IuserDao userdao;
	public void setIuserDao(IuserDao dao){
		this.userdao = dao;
	}
	IuserDao dao = new UserDaoImpl();
	User u = new User();
	Scanner scanner=new Scanner(System.in);
//--------------------------------��½�û�---------------------------------
	public int login(String userID, String userPassword){
	int userSuper = dao.login(userID, userPassword);
	
	return userSuper;
}

//--------------------------------����ȫ���û���Ϣ---------------------------------
	
	public Vector<User> findAllUser() {
		Vector<User> v= dao.findAllUser();//�õ�ԭʼ����
		return v;
				
	}
	
	
//--------------------------------����һ���û���Ϣ---------------------------------	
	public boolean insertinfotoUser(User u) {				
		
		boolean ok = dao.insertinfotoUser(u);
		return ok;
	}


	
//--------------------------------ɾ��һ���û���Ϣ---------------------------------	
	public boolean deleteUser(String userID){
		boolean ok=dao.deleteUser(userID);		
		return ok;
	}
//--------------------------------����һ���û���Ϣ---------------------------------	

	public boolean updateUser(User u) {

	    boolean ok=dao.updateUser(u);
		return ok;
	}
	
	//ע��
		public boolean register(User u){
			boolean flag = dao.register(u);
			return flag;		
		}
		@Override
		public int findUserByuserID(String userID) {
			
			return dao.findUserByuserID(userID);
		}

		@Override
		public boolean updateNumber(User u) {
			return dao.updateNumber(u);
		}
	
	
}
