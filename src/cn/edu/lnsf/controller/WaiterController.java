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
	
	//�ж�ID
	public String findWaiterID(){
		System.out.println("��������ķ���ԱID��");
		waiterID = scanner.next();
		List<String> listWaiter = new ArrayList<String>();
		listWaiter.add(waiterID);
		String id = listWaiter.get(0);
		if(service.findWaiterID(waiterID)==true){
			id = listWaiter.get(0);
			System.out.println(id);
		}else{
			System.out.println("����ԱID�������...");
		}
		return id;
	}
	
	//���ݷ���ԱID���ҷ���Ա
	public void findWaiter(){
		System.out.println("��������Ҫ���ҵķ���ԱID��");
		waiterID = scanner.next();
		service.findWaiter(waiterID);
	}
	
	 //�������Ա��Ϣ
	public void insertWaiter(){		
		String waiterID,waiterName,waiterBirthday,waiterIDCard,waiterJoinDate,waiterPhone,remarks;
		System.out.println("���������Ա��ţ�");
		waiterID = scanner.next();
		System.out.println("������");
		waiterName = scanner.next();
		System.out.println("���գ�");
		waiterBirthday = scanner.next();
		System.out.println("���֤�ţ�");
		waiterIDCard = scanner.next();
		System.out.println("��ְ���ڣ�");
        waiterJoinDate = scanner.next();
        System.out.println("�绰���룺");
        waiterPhone = scanner.next();
        System.out.println("��ע��");
        remarks = scanner.next();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date Bdate = (Date) format.parse(waiterBirthday);
            w.setWaiterBirthday(Bdate);
            Date Jdate = (Date) format.parse(waiterJoinDate);
            w.setWaiterJoinDate(Jdate);
        } catch (ParseException e) {
            System.out.println("���Ϸ�������");
            e.printStackTrace();
        }
        w.setWaiterID(waiterID);
        w.setWaiterName(waiterName);
        w.setWaiterIDCard(waiterIDCard);
        w.setWaiterPhone(waiterPhone);
        w.setRemarks(remarks);
        service.insertWaiter(w);        
        System.out.println("����ɹ���");
	}
	
	//�������еķ���Ա��Ϣ
	public void findAllWaiter(){
		service.findAllWaiter();		
	}
	
	//���·���Ա��Ϣ
	public void updateWaiter(Waiter w){
		System.out.println("��������Ҫ�޸ĵķ���Ա��ţ�");
		waiterID = scanner.next();
		System.out.println("�������޸ĺ����Ա����Ϣ��");
		System.out.println("������");
		waiterName = scanner.next();
		System.out.println("���գ�");
		waiterBirthday = scanner.next();
		System.out.println("���֤�ţ�");
		waiterIDCard = scanner.next();
		System.out.println("��ְ���ڣ�");
        waiterJoinDate = scanner.next();
        System.out.println("�绰���룺");
        waiterPhone = scanner.next();
        System.out.println("��ע��");
        remarks = scanner.next();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date Bdate = (Date) format.parse(waiterBirthday);
            w.setWaiterBirthday(Bdate);
            Date Jdate = (Date) format.parse(waiterJoinDate);
            w.setWaiterJoinDate(Jdate);
        } catch (ParseException e) {
            System.out.println("���Ϸ�������");
            e.printStackTrace();
        }
        w.setWaiterID(waiterID);
        w.setWaiterName(waiterName);
        w.setWaiterIDCard(waiterIDCard);
        w.setWaiterPhone(waiterPhone);
        w.setRemarks(remarks);
        service.updateWaiter(w); 
        System.out.println("���³ɹ���");
	}
		
	//ɾ������Ա��Ϣ
	public void deleteWaiter(String waiterID){
		System.out.println("��������ɾ������Ա�ı�ţ�");
		waiterID = scanner.next();
		service.deleteWaiter(waiterID);
		System.out.println("ɾ���ɹ���");
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
