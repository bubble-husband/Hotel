package cn.edu.lnsf.view;

import java.util.Scanner;
import java.util.Vector;

import cn.edu.lnsf.controller.WaiterController;
import cn.edu.lnsf.model.Room;
import cn.edu.lnsf.model.Waiter;

public class WaiterView {

	public static void main(String[] args) {
		WaiterController wc = new WaiterController();
		Waiter w = new Waiter();
		Scanner in = new Scanner(System.in);
		int b =1;
		while(b!=0){
	    System.out.println("***************************����Ա��Ϣ��********************************");
		System.out.println("*1���鿴����Ա��Ϣ  2����ӷ���Ա  3���޸ķ���Ա��Ϣ   4��ɾ������Ա  0���˳�*");
		System.out.println("***********************************************************************");
		System.out.print("��ѡ��");
		int choose = in.nextInt();
		switch(choose){
		case 1:	
			int d = 1;
			while(d!=0){
			System.out.println("*****************�鿴����Ա*****************");
			System.out.println("*1���鿴�������Ա  2���鿴���з���Ա  0���˳� *");
			System.out.println("********************************************");
			System.out.print("��ѡ��");		
			int c = in.nextInt();
			switch(c){
			case 1:wc.findWaiter();
			break;
			case 2:wc.findAllWaiter();
			break;
			case 0:d=0;break;
			default: System.out.println("����ȷ���룺");		
			}
			}
			break;
		case 2:
			wc.insertWaiter();
			break;
		case 3:
			wc.updateWaiter(w);
		    break;
		case 4:
			wc.deleteWaiter(null);
			break;
		case 0:
			b=0;
		    System.out.println("�˳��ɹ���");
		    break;
		default: System.out.println("����ȷ����:");	
		}
		
		}
		
		
	}

}
