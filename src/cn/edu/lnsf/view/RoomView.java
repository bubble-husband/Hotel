package cn.edu.lnsf.view;

import java.util.Scanner;
import java.util.Vector;

import cn.edu.lnsf.controller.RoomController;
import cn.edu.lnsf.dao.IroomDao;
import cn.edu.lnsf.dbutils.OrderFactory;
import cn.edu.lnsf.model.Room;


public class RoomView{

	public static void main(String[] args) {		
	RoomController a = new RoomController();
	Scanner in = new Scanner(System.in);
	Room r = new Room();
	int b =1;
	while(b!=0){
    System.out.println("***************************������Ϣ��**************************");
	System.out.println("*1���鿴������Ϣ  2����ӷ���  3���޸ķ�����Ϣ   4��ɾ������  0���˳�*");
	System.out.println("***************************************************************");
	System.out.print("��ѡ��");
	int choose = in.nextInt();
	switch(choose){
	case 1:
		int d = 1;
		while(d!=0){
		System.out.println("****************�鿴����*****************");
		System.out.println("*1���鿴���𷿼�  2���鿴���з���   0���˳� *");
		System.out.println("*****************************************");
		System.out.print("��ѡ��");		
		int c = in.nextInt();
		switch(c){
		case 1:a.findRoomByroomNumber(null);
		break;
		case 2:a.findAllRoom();
		break;
		case 0:d=0;break;
		default: System.out.println("����ȷ���룺");		
		}
		}
		break;
	case 2:
		a.insertintofoRoom();
		break;
	case 3:
		a.updateRoom();
	    break;
	case 4:
		a.deleteRoom(null);
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
	
	
	
	
	
	