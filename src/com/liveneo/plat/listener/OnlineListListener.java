package com.liveneo.plat.listener;

import java.util.*;

import javax.servlet.http.*;

public class OnlineListListener implements HttpSessionAttributeListener {

	private static Map<Object, OnlineModel> list = new HashMap<Object, OnlineModel>();

	Date date = new Date();

	public void attributeAdded(HttpSessionBindingEvent se) {

		if ("online".equals(se.getName())) {
			OnlineModel onlineModel = (OnlineModel) se.getValue();
			if (!list.containsKey(onlineModel.getUserId())) {
				onlineModel.setAddress(0);
				list.put(onlineModel.getUserId(), onlineModel);
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
						"yyyy年MM月dd日HH:mm:ss");
				String time = sdf.format(java.util.Calendar.getInstance()
						.getTime());
//				System.out.println(time + " ?:"
//						+ ((OnlineModel) se.getValue()).getUserName());
			} else {
				System.out.println("");
			}

		}
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		if ("online".equals(se.getName())) {
			OnlineModel onlineModel = (OnlineModel) se.getValue();
			if (list.containsKey(onlineModel.getUserId())) {
				list.remove(onlineModel.getUserId());
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
						"yyyy年MM月dd日HH:mm:ss");
				String time = sdf.format(java.util.Calendar.getInstance()
						.getTime());
//				System.out.println(time + " :"
//						+ onlineModel.getUserName());
			}
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Destroyed");
	}

	public static Map<Object, OnlineModel> getList() {
		return (list);
	}
	public static Boolean isOnline(Object userId) {
		return list.containsKey(userId);
	}
}
