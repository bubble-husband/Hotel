package cn.edu.lnsf.dbutils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderFactory {
//	订单类别头
	private static final String ORDER_CODE = "1";
//	续费类别头
	private static final String ORDER_RE = "2";
//  网上预定类别号
	private static final String ORDER_LINU = "3";
//	随即编码 
	private static final int[] r = new int[] { 7, 9, 6, 2, 8, 1, 3, 0, 5, 4 };
//	用户id和随机数总长度
	private static final int maxLength = 8;

//	更具id进行加密+加随机数组成固定长度编码  
	private static String toCode(Long id) {
		String idStr = id.toString();
		StringBuilder idsbs = new StringBuilder();
		for (int i = idStr.length() - 1; i >= 0; i--) {
			idsbs.append(r[idStr.charAt(i) - '0']);
		}
		return idsbs.append(getRandom(maxLength - idStr.length())).toString();
	}

//	生成时间戳 
	private static String getDateTime() {
		DateFormat sdf = new SimpleDateFormat("MMddhhmmss");
		return sdf.format(new Date());
	}

//	生成固定长度随机码  
	private static long getRandom(long n) {
		long min = 1, max = 9;
		for (int i = 1; i < n; i++) {
			min *= 10;
			max *= 10;
		}
		long rangeLong = (((long) (new Random().nextDouble() * (max - min))))
				+ min;
		return rangeLong;
	}

//	生成不带类别标头的编码  
	private static synchronized String getCode(Long userId) {
		userId = userId == null ? 10000 : userId;
		return getDateTime() + toCode(userId);
	}

//	生成订单单号编码
	public static String getOrderCode(Long userId) {
		return ORDER_CODE + getCode(userId);
	}
//	生成续费订单单号编码
	public static String getOrderRe(Long userId) {
		return ORDER_RE + getCode(userId);
	}
	
//	生成续费订单单号编码
	public static String getOrderLinu(Long userId) {
		return ORDER_LINU + getCode(userId);
	}
	
	public static long exchangeID(String userID){
		String userId = userID.substring(13);
		String numbers[] = {userId};
		long total = 0L;
		for (int x = 0; x < (numbers.length); x++) {
			long num = Long.parseLong(((numbers[x]).trim()));
			total += num;
		}
		return total;
	}



}