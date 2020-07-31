package cn.edu.lnsf.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import cn.edu.lnsf.model.User;
import cn.edu.lnsf.service.IuserService;
import cn.edu.lnsf.service.impl.UserServiceImpl;

public class UserController {

	// 调用service的接口来控制业务流程，负责具体业务模块的流程控制
	public IuserService service = new UserServiceImpl();
	User u = new User();
	Scanner scanner = new Scanner(System.in);
	WaiterController waiterCon = new WaiterController();
	
	// --------------------------------登陆用户---------------------------------
	public void login() {
		String userID, userPassword;
		System.out.println("=====登陆用户=====");
		System.out.println("请输入用户编号：");
		userID = scanner.next();
		u.setUserID(userID);
		System.out.println("请输入用户密码：");
		userPassword = scanner.next();
		u.setUserPassword(userPassword);
		int userSuper = service.login(userID, userPassword);

		if (userSuper != 0) {
			if (userSuper == 1) {
				System.out.println("登陆服务员系统");
				waiterCon.findWaiterID();
			} else if (userSuper == 2) {
				System.out.println("登陆管理员系统");
			}
		} else {
			System.out.println("不存在此用户！");
		}

		if (userSuper == 1 || userSuper == 2) {
			// 登录成功就登录次数加一
			int loginNumber1 = service.findUserByuserID(userID) + 1;
			// String userName1 = service.findUserNameByuserID(userID);
			// u.setUserName(userName1);
			// u.setUserSuper(userSuper);
			u.setLoginNumber(loginNumber1);
			// 获取系统当前时间
			Date date = new Date(new java.util.Date().getTime());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String lastTime = formatter.format(date);
			// 转换lastTime
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date ldate = format.parse(lastTime);
				u.setLastTime(ldate);
			} catch (ParseException e) {
				System.out.println("不合法的输入");
				e.printStackTrace();
			}
			service.updateNumber(u);
			System.out.println("登陆成功！");
		}
	}

	// --------------------------------查找全部用户信息---------------------------------

	public void findAllUser() {
		Vector<User> v = new Vector<User>();
		v = service.findAllUser();// 得到原始数据
		for (User u : v) {
			System.out
					.println("用户编号：" + u.getUserID() + "    " + "用户名："
							+ u.getUserName() + "    " + "用户密码："
							+ u.getUserPassword() + "    " + "用户权限："
							+ u.getUserSuper() + "  " + "注册时间："
							+ u.getRegisterTime() + "    " + "用户登录次数："
							+ u.getLoginNumber() + "    " + "最后登录时间："
							+ u.getLastTime());
		}
	}

	// --------------------------------插入用户信息---------------------------------

	public void insertinfotoUser() {
		String userID, userName, userPassword;
		int userSuper, loginNumber = 0;
		Date lastTime = null;
		System.out.println("=====新增用户=====");
		System.out.println("请输入用户编号：");
		userID = scanner.next();
		u.setUserID(userID);
		System.out.println("请输入用户名：");
		userName = scanner.next();
		u.setUserName(userName);
		System.out.println("请输入密码：");
		userPassword = scanner.next();
		u.setUserPassword(userPassword);
		System.out.println("请输入权限：");
		userSuper = scanner.nextInt();
		// 获取系统当前时间
		Date date = new Date(new java.util.Date().getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String registerTime = formatter.format(date);
		// 转换regsterTime
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date rdate = format.parse(registerTime);
			u.setRegisterTime(rdate);
		} catch (ParseException e) {
			System.out.println("不合法的输入");
			e.printStackTrace();
		}
		u.setUserSuper(userSuper);
		u.setLoginNumber(loginNumber);
		u.setLastTime(lastTime);
		boolean flag = service.insertinfotoUser(u);
		if (flag == true) {
			System.out.println("插入用户成功!");
		} else {
			System.out.println("插入用户失败!");
		}
	}

	// ------------注册-------------------
	public void register() {
		String userID, userName, userPassword;
		int userSuper = 1, loginNumber = 0;
		Date lastTime = null;
		System.out.println("=====新增用户=====");
		System.out.println("请输入用户编号：");
		userID = scanner.next();
		u.setUserID(userID);
		System.out.println("请输入用户名：");
		userName = scanner.next();
		u.setUserName(userName);
		System.out.println("请输入密码：");
		userPassword = scanner.next();
		u.setUserPassword(userPassword);
		u.setUserSuper(userSuper);
		// 获取系统当前时间
		Date date = new Date(new java.util.Date().getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String registerTime = formatter.format(date);
		// 转换regsterTime
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date rdate = format.parse(registerTime);
			u.setRegisterTime(rdate);
		} catch (ParseException e) {
			System.out.println("不合法的输入");
			e.printStackTrace();
		}
		u.setLoginNumber(loginNumber);
		u.setLastTime(lastTime);
		boolean flag = service.insertinfotoUser(u);
		if (flag == true) {
			System.out.println("注册成功!");
		} else {
			System.out.println("注册失败!");
		}
	}

	// --------------------------------删除用户信息---------------------------------

	public void deleteUser() {
		System.out.println("=====删除用户=====");
		System.out.println("请输入要删除的用户编号：");
		String userID;
		userID = scanner.next();
		u.setUserID(userID);

		boolean ok = service.deleteUser(userID);
		if (ok) {
			System.out.println("删除成功！");
		} else {
			System.out.println("删除失败！");
		}
	}

	// --------------------------------更新用户信息---------------------------------
	public void updateUser() {
		String userID, userName, userPassword, lastTime,registerTime;
		int userSuper, loginNumber;
		System.out.println("=====更新用户=====");
		System.out.println("请输入要更新的用户编号：");
		userID = scanner.next();
		u.setUserID(userID);
		System.out.println("请输入更新的用户信息：");
		System.out.println("用户名：");
		userName = scanner.next();
		u.setUserName(userName);
		System.out.println("用户密码：");
		userPassword = scanner.next();
		u.setUserPassword(userPassword);
		System.out.println("权限：");
		userSuper = scanner.nextInt();
		u.setUserSuper(userSuper);
		System.out.println("注册时间：");
		registerTime = scanner.next();
		System.out.println("登录次数：");
		loginNumber = scanner.nextInt();
		u.setLoginNumber(loginNumber);
		System.out.println("最后登录时间：");
		lastTime = scanner.next();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(lastTime);
			u.setLastTime(date);
			Date rdate = format.parse(registerTime);
			u.setRegisterTime(rdate);
		} catch (ParseException e) {
			System.out.println("不合法的输入");
			e.printStackTrace();
		}
		boolean ok = service.updateUser(u);
		if (ok) {
			System.out.println("更新成功！");
		} else {
			System.out.println("更新失败！");
		}
	}

}
