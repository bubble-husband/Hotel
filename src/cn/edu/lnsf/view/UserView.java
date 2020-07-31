package cn.edu.lnsf.view;

import java.util.Scanner;

import cn.edu.lnsf.controller.UserController;
import cn.edu.lnsf.model.User;
import cn.edu.lnsf.service.IuserService;
import cn.edu.lnsf.service.impl.UserServiceImpl;


public class UserView {	
	static UserController ct = new UserController();
	public static void main(String[] args) {
		//负责前台JSP页面显示，与controller层紧密结合			
		Scanner s = new Scanner(System.in);
		int choice = -1;
		User u = new User();
		while(choice!=0){
			System.out.println("=======================用户表=======================");
			System.out.print("1、查找全部用户信息");
			System.out.print("2、插入会员信息");
			System.out.print("3、删除用户信息");
			System.out.print("4、更新用户信息");
			System.out.print("5、登陆用户");
			System.out.print("6、注册用户");
			System.out.println("0、退出");
			System.out.println("请选择相应的数字进行操作：");
			choice = s.nextInt();

			switch(choice){
				case 1:
					ct.findAllUser();
					System.out.println();
					break;
				case 2:								
					ct.insertinfotoUser();
					break;
				case 3:
					ct.deleteUser();
					break;
				case 4:
					ct.updateUser();
					break;
				case 5:
					ct.login();
					break;
				case 6:
					ct.register();
					break;
				case 0:
					System.out.println("您已退出用户界面！");
					break;
				default:
					System.out.println("没有此项选择！请重新选择：");
					break;
			}
		}
		
	}
}
