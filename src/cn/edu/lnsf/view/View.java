package cn.edu.lnsf.view;

import cn.edu.lnsf.controller.CustomersController;
import cn.edu.lnsf.controller.OrdersController;
import cn.edu.lnsf.controller.TimeExtensionController;
import cn.edu.lnsf.controller.UserController;
import cn.edu.lnsf.controller.WaiterController;
import cn.edu.lnsf.dbutils.OrderFactory;
import cn.edu.lnsf.model.Customers;

public class View {
	public static void main(String[] args) {
//		UserController u = new UserController();
//		u.login("2017764523","f77612366");
//		OrderFactory of = new OrderFactory();
//	    long t = OrderFactory.exchangeID("441226199711170013");
//		System.out.println(OrderFactory.getOrderCode(t));
//		CustomersController c = new CustomersController();
//		c.insertintofoCustomers();
//		OrdersController o = new OrdersController();
//		o.coumtYearOrders();
		WaiterController waiterCon = new WaiterController();
		waiterCon.findWaiterID();
//		waiterCon.countProportion();
//		WaiterController.getListWaiter().get(1);
//		o.findAllOrders();
//		TimeExtensionController extensionCon = new TimeExtensionController();
//		extensionCon.insertExtension();
		
		
	}

}
