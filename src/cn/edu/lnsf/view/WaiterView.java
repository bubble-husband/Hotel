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
	    System.out.println("***************************服务员信息表********************************");
		System.out.println("*1、查看服务员信息  2、添加服务员  3、修改服务员信息   4、删除服务员  0、退出*");
		System.out.println("***********************************************************************");
		System.out.print("请选择：");
		int choose = in.nextInt();
		switch(choose){
		case 1:	
			int d = 1;
			while(d!=0){
			System.out.println("*****************查看服务员*****************");
			System.out.println("*1、查看个别服务员  2、查看所有服务员  0、退出 *");
			System.out.println("********************************************");
			System.out.print("请选择：");		
			int c = in.nextInt();
			switch(c){
			case 1:wc.findWaiter();
			break;
			case 2:wc.findAllWaiter();
			break;
			case 0:d=0;break;
			default: System.out.println("请正确输入：");		
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
		    System.out.println("退出成功！");
		    break;
		default: System.out.println("请正确输入:");	
		}
		
		}
		
		
	}

}
