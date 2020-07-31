package cn.edu.lnsf.service.impl;

import java.util.Scanner;
import java.util.Vector;


import cn.edu.lnsf.dao.IuserDao;
import cn.edu.lnsf.dao.impl.UserDaoImpl;
import cn.edu.lnsf.model.User;
import cn.edu.lnsf.service.IuserService;

public class UserServiceImpl implements IuserService {
	//将从dao中获取的原始数据，将需要实现的功能放在此处做业务逻辑处理。
	//业务模块的逻辑应用设计
	@SuppressWarnings("unused")
	private IuserDao userdao;
	public void setIuserDao(IuserDao dao){
		this.userdao = dao;
	}
	IuserDao dao = new UserDaoImpl();
	User u = new User();
	Scanner scanner=new Scanner(System.in);
//--------------------------------登陆用户---------------------------------
	public int login(String userID, String userPassword){
	int userSuper = dao.login(userID, userPassword);
	
	return userSuper;
}

//--------------------------------查找全部用户信息---------------------------------
	
	public Vector<User> findAllUser() {
		Vector<User> v= dao.findAllUser();//得到原始数据
		return v;
				
	}
	
	
//--------------------------------插入一个用户信息---------------------------------	
	public boolean insertinfotoUser(User u) {				
		
		boolean ok = dao.insertinfotoUser(u);
		return ok;
	}


	
//--------------------------------删除一个用户信息---------------------------------	
	public boolean deleteUser(String userID){
		boolean ok=dao.deleteUser(userID);		
		return ok;
	}
//--------------------------------更新一个用户信息---------------------------------	

	public boolean updateUser(User u) {

	    boolean ok=dao.updateUser(u);
		return ok;
	}
	
	//注册
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
