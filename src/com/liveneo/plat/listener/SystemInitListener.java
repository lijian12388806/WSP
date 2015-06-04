package com.liveneo.plat.listener;

import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liveneo.plat.constants.ConstantRegister;
import com.liveneo.plat.constants.GlobalConstants;
import com.liveneo.plat.constants.GlobalData;
import com.liveneo.plat.service.iface.BdDictServiceIface;
import com.liveneo.plat.utils.LicenseUtil;
import com.liveneo.plat.utils.ReadConfUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;


public class SystemInitListener implements ServletContextListener {
	protected transient final Log log = LogFactory.getLog(getClass());

	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		event.getServletContext().removeAttribute(
				GlobalConstants.SYSTEM_PARAMETER_INFO);
		event.getServletContext().removeAttribute(
				GlobalConstants.DICT_PARAMETER_INFO);
		GlobalData.setData(null);
	}

	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		ServletContext application = event.getServletContext();
		this.setSystemParameterToApplication(application);
	}

	/**
	 * @param application
	 *            
	 */
	private void setSystemParameterToApplication(ServletContext application) {
		// 系统参数
		initIpccConfConstants(application);
		setSysPara(application);
		setDictPara(application);
		setLicPara(application);
		return;
	}
	//license初始化
	private void setLicPara(ServletContext application) {
		log.info("---检测license文件并初始化参数---");
		LicenseUtil.initlicStatus(application);
	}
	//配置信息初始化
	private void initIpccConfConstants(ServletContext application){
		String path = application.getRealPath("WEB-INF/smtcc.conf");
		Properties p = ReadConfUtil.readProperties(path);
		GlobalData.getData().setDBHost(p.getProperty("dbhost"));
		GlobalData.getData().setDBname(p.getProperty("dbname"));
		GlobalData.getData().setDBPwd(p.getProperty("dbpassword"));
		GlobalData.getData().setDBUser(p.getProperty("dbuser"));
//		GlobalData.getData().setAsteriskConfDir(p.getProperty("astConfigDir"));
		GlobalData.getData().setAsteriskIP(p.getProperty("astIP"));
		GlobalData.getData().setSmartDir(p.getProperty("smartSetupDir"));
		GlobalData.getData().setIvrRoutPath(p.getProperty("IVRRoutPath"));
		GlobalData.getData().setCalldbname(p.getProperty("calldbname"));
		GlobalData.getData().setSadmin(p.getProperty("sadmin"));
		GlobalData.getData().setAdmin(p.getProperty("admin"));
		GlobalData.getData().setRecordPath(p.getProperty("recordPath"));
		GlobalData.getData().setLic(p.getProperty("lic"));
	}
	private void setSysPara(ServletContext application) {
		try {
			application.setAttribute(GlobalConstants.SYSTEM_PARAMETER_INFO,
					ConstantRegister.paraListRegister());

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void setDictPara(ServletContext application) {
		try {
			BdDictServiceIface bdDictServcice = (BdDictServiceIface) AbstractActionSupport
					.getService(application, GlobalConstants.SERVICENAME_DICT);
			if (bdDictServcice == null) {
				log.fatal("Initialization For DictPara is Failed!!!");
			}
			application.setAttribute(GlobalConstants.DICT_PARAMETER_INFO,
					bdDictServcice.registerBdDictPara());
			Timer timer = new Timer();
			timer.schedule(new ReSetTimer(application, bdDictServcice), 0,
					1000 * 1 * 30);

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	class ReSetTimer extends TimerTask {
		ServletContext application;

		Object service;

		ReSetTimer(ServletContext a, Object b) {
			application = a;
			service = b;
		}

		@Override
		public void run() {
			if (service instanceof BdDictServiceIface) {
				application.setAttribute(GlobalConstants.DICT_PARAMETER_INFO,
						((BdDictServiceIface) service).registerBdDictPara());
			}
		}

	}

}
