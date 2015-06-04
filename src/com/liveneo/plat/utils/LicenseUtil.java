package com.liveneo.plat.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.liveneo.plat.constants.GlobalData;
import com.liveneo.plat.web.form.LicenseForm;

public class LicenseUtil {
	
	/**
	 * 判断lic是否异常
	 * 1  全查 包括日期校验
	 * 2 不包含日期校验
	 */
	public static Boolean readlic(String limit){
		Boolean licensedesc = null;
		String urlString = "http://" + GlobalData.getData().getAsteriskIP()
		 + ":8061/readlic";
		String responsestr = HttpGetMethod(urlString, 3);
		responsestr = StringUtils.trim(responsestr);
		Map<String, List<LicenseForm>> map = new HashMap<String, List<LicenseForm>>();
		if (StringUtils.equalsIgnoreCase(responsestr, "ERROR")) {
			licensedesc = false;
		} else if (responsestr.length() == 0) {
			if(StringUtils.contains(limit,"lcp")){
				licensedesc = true;
			}else{
				licensedesc = false;
			}
		} else if (StringUtils.equalsIgnoreCase(responsestr, "1001")) {
			licensedesc = false;
		} else if (StringUtils.equalsIgnoreCase(responsestr, "1002")) {
			licensedesc = false;
		} else if (StringUtils.equalsIgnoreCase(responsestr, "1003")) {
			licensedesc = false;
		} else {
				try{
					map = getLicInfo(responsestr);
					if (null != map && map.size() > 0) {
						licensedesc = true;
						for (String key : map.keySet()) {
							List<LicenseForm> list = map.get(key);
							Date expired_day = null;
							Date now = new Date();
							if (StringUtils.contains(limit,"lcp")&&StringUtils.equalsIgnoreCase(key, "lcp")) {
								//授权数量
								if (null != list && list.size() > 0) {
									for (LicenseForm l : list) {
										expired_day = DateUtil.parseFormatDate(l.getExpired_day(),
												"yyyy-MM-dd HH:mm:ss");
										if (StringUtils.equalsIgnoreCase(l
												.getFeature_name(), "lcp")) {
											if (expired_day.getTime() <= now.getTime()) {
												licensedesc = false;
											}else{
												licensedesc = true;
											}
										}
									}
								}
							}
							if(StringUtils.contains(limit, "ipcc")&&StringUtils.equalsIgnoreCase(key, "ipcc")) {
								//授权数量
								if (null != list && list.size() > 0) {
									for (LicenseForm l : list){
										expired_day = DateUtil.parseFormatDate(l.getExpired_day(),
										"yyyy-MM-dd HH:mm:ss");
										if (StringUtils.equalsIgnoreCase(l
												.getFeature_name(), "agent")){
											if (expired_day.getTime() <= now.getTime()) {
												licensedesc = false;
											}else{
												licensedesc = true;
											}
										}
										if (StringUtils.equalsIgnoreCase(l
												.getFeature_name(), "ivr")){
											if (expired_day.getTime() <= now.getTime()) {
												licensedesc = false;
											}else{
												licensedesc = true;
											}
										}
									}
								}
							}
						}
					}
				}catch(Exception e){
					e.getStackTrace();
					System.out.println("error:"+e.getStackTrace());
					return false;
				}
		}
		return licensedesc;
	}
	
	public static void initlicStatus(ServletContext application){
		//SessionFilter过滤验证
		Boolean a = LicenseUtil.readlic("all");
		application.setAttribute("lic_status_a",a);
		System.out.println("--- lic status a:"+a+" ---");
		//lcp任务验证
		Boolean b = LicenseUtil.readlic("lcp");
		application.setAttribute("lic_status_b",b);
		System.out.println("--- lic status b:"+b+" ---");
	}
	/**
	 * 新的lic - new
	 * 
	 * @param args
	 */
	public static HttpSession initLicNew(HttpSession se) {
		String licensedesc = null;
		// 权限判断
		String sys_permission_ipcc = "N";
		String sys_permission_lcp = "N";
		if(StringUtils.equals(GlobalData.getData().getLic(),"dev")){
			sys_permission_ipcc = "Y";
			sys_permission_lcp = "Y";
		}
		//参数
		String ipccAgentNum = "0";
		String ipccIvrNum = "0";
		String lcpUserNum = "0";
		String wspUserNum = "0";
		String urlString = "http://" + GlobalData.getData().getAsteriskIP()
		 + ":8061/readlic";
		String responsestr = HttpGetMethod(urlString, 3);
		responsestr = StringUtils.trim(responsestr);
		Map<String, List<LicenseForm>> map = new HashMap<String, List<LicenseForm>>();
		if (StringUtils.equalsIgnoreCase(responsestr, "ERROR")) {
			licensedesc = "许可异常！";
		} else if (responsestr.length() == 0) {
			licensedesc = "读取通信异常！";
		} else if (StringUtils.equalsIgnoreCase(responsestr, "1001")) {
			licensedesc = "授权验证失败！";
		} else if (StringUtils.equalsIgnoreCase(responsestr, "1002")) {
			licensedesc = "授权文件错误！";
		} else if (StringUtils.equalsIgnoreCase(responsestr, "1003")) {
			licensedesc = "授权产品信息不符！";
		} else {
			try{
				map = getLicInfo(responsestr);
				if (null != map && map.size() > 0) {
					for (String key : map.keySet()) {
						List<LicenseForm> list = map.get(key);
						Date expired_day = null;
						Date now = new Date();
						//授权类型
						if (StringUtils.equalsIgnoreCase(key, "ipcc")) {
							//授权数量
							if (null != list && list.size() > 0) {
								for (LicenseForm l : list){
									expired_day = DateUtil.parseFormatDate(l.getExpired_day(),
									"yyyy-MM-dd HH:mm:ss");
									if (StringUtils.equalsIgnoreCase(l
											.getFeature_name(), "agent")){
										ipccAgentNum=StringUtils.trim(l.getLicense_count());
										ipccAgentNum = StringUtils.isNumeric(ipccAgentNum)?ipccAgentNum:"0";
										if (expired_day.getTime() <= now.getTime()) {
											licensedesc += "呼叫中心>>坐席许可过期！";
											System.out.println("lic ipcc agent Expired!!!");
										}
									}
									if (StringUtils.equalsIgnoreCase(l
											.getFeature_name(), "ivr")){
										ipccIvrNum=StringUtils.trim(l.getLicense_count());
										ipccIvrNum = StringUtils.isNumeric(ipccIvrNum)?ipccIvrNum:"0";
										if (expired_day.getTime() <= now.getTime()) {
											licensedesc += "呼叫中心>>IVR许可过期！";
											System.out.println("lic ipcc IVR Expired!!!");
										}
									}
								}
							}
							//判断时间
							sys_permission_ipcc = "Y";
						}
						if (StringUtils.equalsIgnoreCase(key, "lcp")) {
							//授权数量
							if (null != list && list.size() > 0) {
								for (LicenseForm l : list) {
									expired_day = DateUtil.parseFormatDate(l.getExpired_day(),
											"yyyy-MM-dd HH:mm:ss");
									if (StringUtils.equalsIgnoreCase(l
											.getFeature_name(), "lcp")) {
										lcpUserNum=StringUtils.trim(l.getLicense_count());
										lcpUserNum = StringUtils.isNumeric(lcpUserNum)?lcpUserNum:"0";
										if (expired_day.getTime() <= now.getTime()) {
											licensedesc += "办公电话>>许可过期！";
											System.out.println("lic lcp Expired!!!");
											sys_permission_lcp = "N";
										}else{
											sys_permission_lcp = "Y";
										}
									}
								}
							}
						}
						if (StringUtils.equalsIgnoreCase(key, "wsp")) {
							//授权数量
							if (null != list && list.size() > 0) {
								for (LicenseForm l : list) {
									expired_day = DateUtil.parseFormatDate(l.getExpired_day(),
											"yyyy-MM-dd HH:mm:ss");
									if (StringUtils.equalsIgnoreCase(l
											.getFeature_name(), "wsp")) {
										wspUserNum=StringUtils.trim(l.getLicense_count());
										wspUserNum = StringUtils.isNumeric(wspUserNum)?wspUserNum:"0";
										if (expired_day.getTime() <= now.getTime()) {
											licensedesc += "工单系统>>许可过期！";
											System.out.println("lic wsp Expired!!!");
										}
									}
								}
							}
						}
					}
				}
			}catch(Exception e){
				e.getStackTrace();
				System.out.println("error:"+e.getStackTrace());
			}
		}
		se.setAttribute("map_lic", map);
		se.setAttribute("sys_permission_ipcc", sys_permission_ipcc);
		se.setAttribute("sys_permission_lcp", sys_permission_lcp);
		se.setAttribute("lcpUserNum", lcpUserNum);
		se.setAttribute("ipccIvrNum", ipccIvrNum);
		se.setAttribute("ipccAgentNum", ipccAgentNum);
		se.setAttribute("wspUserNum", wspUserNum);
		se.setAttribute("licensedesc", licensedesc);
		System.out.println("lic licensedesc:"+licensedesc);
		return se;
	}
	/**
	 * 更新授权
	 * @param se
	 * @return
	 */
	public static void updatelic() {
		 String urlString = "http://" + GlobalData.getData().getAsteriskIP()
		 + ":8061/updatelic";
		String responsestr = HttpGetMethod(urlString, 3);
		System.out.println("update lic info:"+responsestr);
	}
	/**
	 * 获取lic信息
	 * 
	 * @return
	 */
	private static Map<String, List<LicenseForm>> getLicInfo(String str) {
		JSONObject jsonobject = JSONObject.fromObject(str);
		// 版本
		// String version = jsonobject.getString("license_version");
		// String md5 = jsonobject.getString("license_md5");
		// String hostid = jsonobject.getString("hostid");
		JSONArray plist = jsonobject.getJSONArray("product_list");
		Map<String, List<LicenseForm>> map = new HashMap<String, List<LicenseForm>>();
		if (null != plist && plist.size() > 0) {
			for (int i = 0; i < plist.size(); i++) {
				JSONObject pobject = (JSONObject) plist.get(i);
				String pname = pobject.getString("product_name");
				if (null != pname) {
					String pversion = pobject.getString("product_version");
					JSONArray flist = pobject.getJSONArray("feature_list");
					List<LicenseForm> list = new ArrayList<LicenseForm>();
					if (null != flist && flist.size() > 0) {
						for (int j = 0; j < flist.size(); j++) {
							LicenseForm lf = new LicenseForm();
							lf.setProduct_version(pversion);
							JSONObject fobject = (JSONObject) flist.get(j);
							lf.setFeature_name(fobject
									.getString("feature_name"));
							String num = fobject.getString("license_count");
							num = StringUtils.isNumeric(num)?num:"0";
							lf.setLicense_count(num);
							lf.setLicense_type(fobject
									.getString("license_type"));
							lf.setExpired_day(fobject.getString("expired_day"));
							list.add(lf);
						}
					}
					map.put(pname, list);
				} else {
					continue;
				}
			}
		}
		return map;
	}

	private static String getValue(String str, String key) {
		String res = null;
		int index_b = str.indexOf(key);
		int index_e = str.indexOf(key, index_b + key.length());
		if (index_e > 1 && index_b > 1) {
			res = str.substring(index_b + key.length() + 1, index_e - 2);
		}
		return res;
	}

	public static String HttpGetMethod(String UrlSting, int timeout) {
		int count = 0;
		char[] recvbuff = new char[1024];
		StringBuffer ResponseString = new StringBuffer();
		URL url;
		try {
			url = new URL(UrlSting);
			URLConnection conn = url.openConnection();
			conn.setReadTimeout(timeout);
			Reader reader = new InputStreamReader(new BufferedInputStream(url
					.openStream()));
			while ((count = reader.read(recvbuff)) > 0) {
				ResponseString.append(recvbuff, 0, count);
			}
			reader.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseString.toString();
	}

	public static void main(String[] args) {
		
		System.out.println(StringUtils.isNumeric(" 123"));
	}
}
