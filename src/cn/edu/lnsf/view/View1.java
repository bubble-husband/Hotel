package cn.edu.lnsf.view;

import cn.edu.lnsf.controller.CustomersController;

import java.util.Scanner;

import cn.edu.lnsf.controller.BookRoomController;
import cn.edu.lnsf.controller.CustomersController;
import cn.edu.lnsf.controller.OnlineCsController;
import cn.edu.lnsf.controller.OrdersController;
import cn.edu.lnsf.controller.UserController;
import cn.edu.lnsf.dbutils.OrderFactory;
import cn.edu.lnsf.model.Orders;

public class View1 {
	public static void main(String[] args) {
		OnlineCsController oc = new OnlineCsController();
		Scanner scanner = new Scanner(System.in);
		BookRoomController bookroom = new BookRoomController();
		UserController user = new UserController();
		CustomersController cs = new CustomersController();		
		System.out.println("��ѡ��Ԥ�����䷽ʽ��");
		System.out.println("1������Ԥ��		2������Ԥ��");
		int choose = -1;
		while(choose!=0){
			choose = scanner.nextInt();
			switch(choose){
				case 1:
					oc.insertintofoCustomers();
					break;
				case 2:
					user.login();
					break;
			}
		}
		
	}

}
