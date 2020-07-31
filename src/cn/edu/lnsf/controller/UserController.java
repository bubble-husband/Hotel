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

	// ����service�Ľӿ�������ҵ�����̣��������ҵ��ģ������̿���
	public IuserService service = new UserServiceImpl();
	User u = new User();
	Scanner scanner = new Scanner(System.in);
	WaiterController waiterCon = new WaiterController();
	
	// --------------------------------��½�û�---------------------------------
	public void login() {
		String userID, userPassword;
		System.out.println("=====��½�û�=====");
		System.out.println("�������û���ţ�");
		userID = scanner.next();
		u.setUserID(userID);
		System.out.println("�������û����룺");
		userPassword = scanner.next();
		u.setUserPassword(userPassword);
		int userSuper = service.login(userID, userPassword);

		if (userSuper != 0) {
			if (userSuper == 1) {
				System.out.println("��½����Աϵͳ");
				waiterCon.findWaiterID();
			} else if (userSuper == 2) {
				System.out.println("��½����Աϵͳ");
			}
		} else {
			System.out.println("�����ڴ��û���");
		}

		if (userSuper == 1 || userSuper == 2) {
			// ��¼�ɹ��͵�¼������һ
			int loginNumber1 = service.findUserByuserID(userID) + 1;
			// String userName1 = service.findUserNameByuserID(userID);
			// u.setUserName(userName1);
			// u.setUserSuper(userSuper);
			u.setLoginNumber(loginNumber1);
			// ��ȡϵͳ��ǰʱ��
			Date date = new Date(new java.util.Date().getTime());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String lastTime = formatter.format(date);
			// ת��lastTime
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date ldate = format.parse(lastTime);
				u.setLastTime(ldate);
			} catch (ParseException e) {
				System.out.println("���Ϸ�������");
				e.printStackTrace();
			}
			service.updateNumber(u);
			System.out.println("��½�ɹ���");
		}
	}

	// --------------------------------����ȫ���û���Ϣ---------------------------------

	public void findAllUser() {
		Vector<User> v = new Vector<User>();
		v = service.findAllUser();// �õ�ԭʼ����
		for (User u : v) {
			System.out
					.println("�û���ţ�" + u.getUserID() + "    " + "�û�����"
							+ u.getUserName() + "    " + "�û����룺"
							+ u.getUserPassword() + "    " + "�û�Ȩ�ޣ�"
							+ u.getUserSuper() + "  " + "ע��ʱ�䣺"
							+ u.getRegisterTime() + "    " + "�û���¼������"
							+ u.getLoginNumber() + "    " + "����¼ʱ�䣺"
							+ u.getLastTime());
		}
	}

	// --------------------------------�����û���Ϣ---------------------------------

	public void insertinfotoUser() {
		String userID, userName, userPassword;
		int userSuper, loginNumber = 0;
		Date lastTime = null;
		System.out.println("=====�����û�=====");
		System.out.println("�������û���ţ�");
		userID = scanner.next();
		u.setUserID(userID);
		System.out.println("�������û�����");
		userName = scanner.next();
		u.setUserName(userName);
		System.out.println("���������룺");
		userPassword = scanner.next();
		u.setUserPassword(userPassword);
		System.out.println("������Ȩ�ޣ�");
		userSuper = scanner.nextInt();
		// ��ȡϵͳ��ǰʱ��
		Date date = new Date(new java.util.Date().getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String registerTime = formatter.format(date);
		// ת��regsterTime
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date rdate = format.parse(registerTime);
			u.setRegisterTime(rdate);
		} catch (ParseException e) {
			System.out.println("���Ϸ�������");
			e.printStackTrace();
		}
		u.setUserSuper(userSuper);
		u.setLoginNumber(loginNumber);
		u.setLastTime(lastTime);
		boolean flag = service.insertinfotoUser(u);
		if (flag == true) {
			System.out.println("�����û��ɹ�!");
		} else {
			System.out.println("�����û�ʧ��!");
		}
	}

	// ------------ע��-------------------
	public void register() {
		String userID, userName, userPassword;
		int userSuper = 1, loginNumber = 0;
		Date lastTime = null;
		System.out.println("=====�����û�=====");
		System.out.println("�������û���ţ�");
		userID = scanner.next();
		u.setUserID(userID);
		System.out.println("�������û�����");
		userName = scanner.next();
		u.setUserName(userName);
		System.out.println("���������룺");
		userPassword = scanner.next();
		u.setUserPassword(userPassword);
		u.setUserSuper(userSuper);
		// ��ȡϵͳ��ǰʱ��
		Date date = new Date(new java.util.Date().getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String registerTime = formatter.format(date);
		// ת��regsterTime
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date rdate = format.parse(registerTime);
			u.setRegisterTime(rdate);
		} catch (ParseException e) {
			System.out.println("���Ϸ�������");
			e.printStackTrace();
		}
		u.setLoginNumber(loginNumber);
		u.setLastTime(lastTime);
		boolean flag = service.insertinfotoUser(u);
		if (flag == true) {
			System.out.println("ע��ɹ�!");
		} else {
			System.out.println("ע��ʧ��!");
		}
	}

	// --------------------------------ɾ���û���Ϣ---------------------------------

	public void deleteUser() {
		System.out.println("=====ɾ���û�=====");
		System.out.println("������Ҫɾ�����û���ţ�");
		String userID;
		userID = scanner.next();
		u.setUserID(userID);

		boolean ok = service.deleteUser(userID);
		if (ok) {
			System.out.println("ɾ���ɹ���");
		} else {
			System.out.println("ɾ��ʧ�ܣ�");
		}
	}

	// --------------------------------�����û���Ϣ---------------------------------
	public void updateUser() {
		String userID, userName, userPassword, lastTime,registerTime;
		int userSuper, loginNumber;
		System.out.println("=====�����û�=====");
		System.out.println("������Ҫ���µ��û���ţ�");
		userID = scanner.next();
		u.setUserID(userID);
		System.out.println("��������µ��û���Ϣ��");
		System.out.println("�û�����");
		userName = scanner.next();
		u.setUserName(userName);
		System.out.println("�û����룺");
		userPassword = scanner.next();
		u.setUserPassword(userPassword);
		System.out.println("Ȩ�ޣ�");
		userSuper = scanner.nextInt();
		u.setUserSuper(userSuper);
		System.out.println("ע��ʱ�䣺");
		registerTime = scanner.next();
		System.out.println("��¼������");
		loginNumber = scanner.nextInt();
		u.setLoginNumber(loginNumber);
		System.out.println("����¼ʱ�䣺");
		lastTime = scanner.next();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(lastTime);
			u.setLastTime(date);
			Date rdate = format.parse(registerTime);
			u.setRegisterTime(rdate);
		} catch (ParseException e) {
			System.out.println("���Ϸ�������");
			e.printStackTrace();
		}
		boolean ok = service.updateUser(u);
		if (ok) {
			System.out.println("���³ɹ���");
		} else {
			System.out.println("����ʧ�ܣ�");
		}
	}

}
