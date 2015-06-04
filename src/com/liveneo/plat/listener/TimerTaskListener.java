package com.liveneo.plat.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class TimerTaskListener implements ServletContextListener{
	private final Log log = LogFactory.getLog(getClass());
	private Timer recordtimer=new Timer(true);
	
	public void contextDestroyed(ServletContextEvent arg0) {
		recordtimer.cancel();
	}
	public void contextInitialized(ServletContextEvent arg0) {
			this.startBirthTask();
	}
	private void startBirthTask(){
//		BirthdayTask task=new BirthdayTask();
//		long daySpan = 24 * 60 * 60 * 1000;
//		 规定的每天时间10:00:00运行
//		 final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd '10:00:00'");
		 // 首次运行时间
//		 Date startTime;
//		try {
//			startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdf.format(new Date()));
			// 如果今天的已经过了 首次运行时间就改为明天
//			if(System.currentTimeMillis() > startTime.getTime())
//				startTime = new Date(startTime.getTime() + daySpan);
			// 以每24小时执行一次
//			recordtimer.scheduleAtFixedRate(new RecordingTask(), startTime, daySpan);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//recordtimer.schedule(new RecordingTask(),0,120000);
	}
	
	
}
