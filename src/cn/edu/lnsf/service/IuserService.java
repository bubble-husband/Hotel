package cn.edu.lnsf.service;

import java.util.Vector;

import cn.edu.lnsf.model.User;

public interface IuserService {
	// 查找用户
	public Vector<User> findAllUser();

	// 插入数据
	public boolean insertinfotoUser(User u);

	// 删除用户
	public boolean deleteUser(String _userID);

	// 更新用户
	public boolean updateUser(User u);

	// 根据用户编号查找用户信息
	public int findUserByuserID(String userID);

	// 登陆用户
	public int login(String userID, String userPassword);

	// 更新登录的次数
	public boolean updateNumber(User u);

	// 注册
	public boolean register(User u);
}
