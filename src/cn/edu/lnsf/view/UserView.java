package cn.edu.lnsf.view;

import java.util.Scanner;

import cn.edu.lnsf.controller.UserController;
import cn.edu.lnsf.model.User;
import cn.edu.lnsf.service.IuserService;
import cn.edu.lnsf.service.impl.UserServiceImpl;


public class UserView {	
	static UserController ct = new UserController();
	public static void main(String[] args) {
		//����ǰ̨JSPҳ����ʾ����controller����ܽ��			
		Scanner s = new Scanner(System.in);
		int choice = -1;
		User u = new User();
		while(choice!=0){
			System.out.println("=======================�û���=======================");
			System.out.print("1������ȫ���û���Ϣ");
			System.out.print("2�������Ա��Ϣ");
			System.out.print("3��ɾ���û���Ϣ");
			System.out.print("4�������û���Ϣ");
			System.out.print("5����½�û�");
			System.out.print("6��ע���û�");
			System.out.println("0���˳�");
			System.out.println("��ѡ����Ӧ�����ֽ��в�����");
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
					System.out.println("�����˳��û����棡");
					break;
				default:
					System.out.println("û�д���ѡ��������ѡ��");
					break;
			}
		}
		
	}
}
