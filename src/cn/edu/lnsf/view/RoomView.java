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
    System.out.println("***************************房间信息表**************************");
	System.out.println("*1、查看房间信息  2、添加房间  3、修改房间信息   4、删除房间  0、退出*");
	System.out.println("***************************************************************");
	System.out.print("请选择：");
	int choose = in.nextInt();
	switch(choose){
	case 1:
		int d = 1;
		while(d!=0){
		System.out.println("****************查看房间*****************");
		System.out.println("*1、查看个别房间  2、查看所有房间   0、退出 *");
		System.out.println("*****************************************");
		System.out.print("请选择：");		
		int c = in.nextInt();
		switch(c){
		case 1:a.findRoomByroomNumber(null);
		break;
		case 2:a.findAllRoom();
		break;
		case 0:d=0;break;
		default: System.out.println("请正确输入：");		
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
	    System.out.println("退出成功！");
	    break;
	default: System.out.println("请正确输入:");	
	}
	
	}
	
	}

}
	
	
	
	
	
	