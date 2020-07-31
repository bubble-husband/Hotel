package cn.edu.lnsf.controller;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cn.edu.lnsf.model.Waiter;
import cn.edu.lnsf.service.IwaiterService;
import cn.edu.lnsf.service.impl.WaiterServiceImpl;

public class WaiterController {

	private static List<String> listWaiter;
	private IwaiterService service = new WaiterServiceImpl();
	public Waiter w = new Waiter();
	public Scanner scanner = new Scanner(System.in);
	public String waiterID,waiterName,waiterIDCard,waiterPhone,remarks,waiterJoinDate,waiterBirthday;
	
	//判断ID
	public String findWaiterID(){
		System.out.println("请输入你的服务员ID：");
		waiterID = scanner.next();
		List<String> listWaiter = new ArrayList<String>();
		listWaiter.add(waiterID);
		String id = listWaiter.get(0);
		if(service.findWaiterID(waiterID)==true){
			id = listWaiter.get(0);
			System.out.println(id);
		}else{
			System.out.println("服务员ID输入错误...");
		}
		return id;
	}
	
	//根据服务员ID查找服务员
	public void findWaiter(){
		System.out.println("请输入需要查找的服务员ID：");
		waiterID = scanner.next();
		service.findWaiter(waiterID);
	}
	
	 //插入服务员信息
	public void insertWaiter(){		
		String waiterID,waiterName,waiterBirthday,waiterIDCard,waiterJoinDate,waiterPhone,remarks;
		System.out.println("请输入服务员编号：");
		waiterID = scanner.next();
		System.out.println("姓名：");
		waiterName = scanner.next();
		System.out.println("生日：");
		waiterBirthday = scanner.next();
		System.out.println("身份证号：");
		waiterIDCard = scanner.next();
		System.out.println("入职日期：");
        waiterJoinDate = scanner.next();
        System.out.println("电话号码：");
        waiterPhone = scanner.next();
        System.out.println("备注：");
        remarks = scanner.next();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date Bdate = (Date) format.parse(waiterBirthday);
            w.setWaiterBirthday(Bdate);
            Date Jdate = (Date) format.parse(waiterJoinDate);
            w.setWaiterJoinDate(Jdate);
        } catch (ParseException e) {
            System.out.println("不合法的输入");
            e.printStackTrace();
        }
        w.setWaiterID(waiterID);
        w.setWaiterName(waiterName);
        w.setWaiterIDCard(waiterIDCard);
        w.setWaiterPhone(waiterPhone);
        w.setRemarks(remarks);
        service.insertWaiter(w);        
        System.out.println("插入成功！");
	}
	
	//查找所有的服务员信息
	public void findAllWaiter(){
		service.findAllWaiter();		
	}
	
	//更新服务员信息
	public void updateWaiter(Waiter w){
		System.out.println("请输入需要修改的服务员编号：");
		waiterID = scanner.next();
		System.out.println("请输入修改后服务员的信息：");
		System.out.println("姓名：");
		waiterName = scanner.next();
		System.out.println("生日：");
		waiterBirthday = scanner.next();
		System.out.println("身份证号：");
		waiterIDCard = scanner.next();
		System.out.println("入职日期：");
        waiterJoinDate = scanner.next();
        System.out.println("电话号码：");
        waiterPhone = scanner.next();
        System.out.println("备注：");
        remarks = scanner.next();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date Bdate = (Date) format.parse(waiterBirthday);
            w.setWaiterBirthday(Bdate);
            Date Jdate = (Date) format.parse(waiterJoinDate);
            w.setWaiterJoinDate(Jdate);
        } catch (ParseException e) {
            System.out.println("不合法的输入");
            e.printStackTrace();
        }
        w.setWaiterID(waiterID);
        w.setWaiterName(waiterName);
        w.setWaiterIDCard(waiterIDCard);
        w.setWaiterPhone(waiterPhone);
        w.setRemarks(remarks);
        service.updateWaiter(w); 
        System.out.println("更新成功！");
	}
		
	//删除服务员信息
	public void deleteWaiter(String waiterID){
		System.out.println("请输入需删除服务员的编号：");
		waiterID = scanner.next();
		service.deleteWaiter(waiterID);
		System.out.println("删除成功！");
	}
	
	
	public void countProportion(){
		service.countProportion();
	}
	

	public static List<String> getListWaiter() {
		return listWaiter;
	}

	public static void setListWaiter(List<String> listWaiter) {
		WaiterController.listWaiter = listWaiter;
	}
}
