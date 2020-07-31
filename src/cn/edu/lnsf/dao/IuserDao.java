package cn.edu.lnsf.dao;

import java.util.Vector;

import cn.edu.lnsf.model.User;


public interface IuserDao {
	
	//登陆用户
	int login(String _userID, String _userPassword);
	
	//查找用户
	Vector<User> findAllUser();
	
	//插入数据
	boolean insertinfotoUser(User u);
	
	//删除用户
	boolean deleteUser(String _userID);
	
	//更新用户
	boolean updateUser(User u);
	
	//根据用户编号查找用户信息
	public int findUserByuserID(String userID);
	
	//更新登录次数
	boolean updateNumber(User u);
    
	//注册
	public boolean register(User u);
	
}
