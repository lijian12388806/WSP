package com.liveneo.plat.web.action.base;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;

import com.liveneo.plat.constants.GlobalConstants;
import com.liveneo.plat.hibernate.dao.BdDictdetail;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.service.iface.BdDictServiceIface;
import com.liveneo.plat.service.iface.LogmsgServiceIface;
import com.liveneo.plat.utils.IntegerUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @version 1.0 action的父类
 */
public abstract class AbstractActionSupport extends ActionSupport implements
		ApplicationAware, ServletContextAware, SessionAware,
		ServletRequestAware, ServletResponseAware, ParameterAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected transient final Log log = LogFactory.getLog(getClass());

	private Map applicationMap;

	private ServletContext servletContext;

	private Map parameters;

	private Map sessionMap;

	private HttpServletRequest request;

	private HttpServletResponse response;

	public static final String LIST = "returnToList";

	public static final String EDIT = "returnToEditPage";
	
	protected static final String OPERATION_DONE = "operationDone";
	
	private int statusCode = 200;
	private String message = null;
	private String forwardUrl = null;

	private boolean skipVC = false;
	private String validationCode; // 验证码

	// search form fields
	public final static String PAGE_SHOW_COUNT = "20";
	private String pageNum = "1";
	private String numPerPage = "0";
	private String orderField;
	private String orderDirection;
	private String keywords;
	private int totalCount = 0;
	public Map getSessionMap() {
		return sessionMap;
	}

	public void setSession(Map sessionMap) {
		this.sessionMap = sessionMap;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpSession getSession() {
		return request.getSession();
	}

	public Map getApplicationMap() {
		return applicationMap;
	}

	public void setApplication(Map applicationMap) {
		this.applicationMap = applicationMap;
	}

	public Map getParameters() {
		return parameters;
	}

	public void setParameters(Map parameters) {
		this.parameters = parameters;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public String getRemoteAddr(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

	public String getRemoteAddr() {
		return this.getRequest().getRemoteAddr();
	}
	/**
	 * 系统日志
	 * 
	 * @param request
	 * @param response
	 */
	public void addSystemLog(String type, Object object, String logcontent) {
		try {
		} catch (Exception ex) {
			log.error(ex.getStackTrace());
		}
	}
	
	public void addSystemLog(HttpServletRequest request, String logType,
			String entityName,String content) {
		try {
			LogmsgServiceIface logmsgService=(LogmsgServiceIface) getService(request,"logmsgService");
			logmsgService.addLog(request, logType, content, entityName);
		} catch (Exception ex) {
			log.error(ex.getStackTrace());
		}
	}

	protected void writeJsToFrontPage(String msgkey, String path) {
		response.setContentType("text/html; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");

		String prompt = "";
		String returnPath = (String) servletContext.getAttribute("rootpath");
		String href = returnPath + path;
		if (path == null || path.trim().equals("")) {
			prompt = "alert('" + msgkey + "');return;";
		} else {
			prompt = "alert('" + msgkey + "'); location.href='" + href + "';";
		}

		PrintWriter pw;

		try {
			pw = response.getWriter();
			pw.write("<SCRIPT TYPE='text/javascript'>" + prompt + "</SCRIPT>");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void execCmd(String cmd,String cmdname) {
		Runtime rt = Runtime.getRuntime();
		try {
			// String cmd = "fs_cli -x reloadxml";
			// String reloadCmd = "fs_cli -x reloadxml";
			// cmd = "/usr/local/freeswitch/conf/directory/default/test.sh"+name;
			if(StringUtils.isNotEmpty(cmd)){
				Process ppp = rt.exec(cmd);
				BufferedInputStream in = new BufferedInputStream(ppp
						.getInputStream());
				BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
				String lineStr;
				while ((lineStr = inBr.readLine()) != null)
					// 获得命令执行后在控制台的输出信息
					System.out.println(lineStr);
				if (ppp.waitFor() != 0) {
					if (ppp.exitValue() == 1)// p.exitValue()==0表示正常结束，1：非正常结束
						System.err.println(cmdname+"命令执行失败!");
				}
				inBr.close();
				in.close();
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("e:" + e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("e:" + e.getMessage());
			e.printStackTrace();
		}

	}
	
	protected String ajaxForwardSuccess(String message) {
		this.message = message;
		return ajaxForward(200);
	}
	protected String ajaxForwardError(String message) {
		this.message = message;
		return ajaxForward(300);
	}
	private String ajaxForward(int statusCode) {
		this.statusCode = statusCode;
		return OPERATION_DONE;
	}
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getForwardUrl() {
		return forwardUrl;
	}

	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}
	public boolean isSkipVC() {
		return skipVC;
	}

	public void setSkipVC(boolean skipVC) {
		this.skipVC = skipVC;
	}

	public String getValidationCode() {
		return validationCode;
	}

	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getNumPerPage() {
		if(StringUtils.isEmpty(numPerPage)){
			return PAGE_SHOW_COUNT;
		}else{
			return IntegerUtil.converStrToInteger(numPerPage) > 0 ? numPerPage : PAGE_SHOW_COUNT;
		}
	}

	public void setNumPerPage(String numPerPage) {
		this.numPerPage = numPerPage;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public String realOrderField(){
		if ("desc".equalsIgnoreCase(orderDirection))
			return orderField+" desc";
		return orderField;
	}
	public void testRequestMethod() {
		log.info("request.getScheme():" + request.getScheme());
		log.info("request.getContextPath():" + request.getContextPath());
		log.info("request.getRealPath():" + request.getRealPath("/"));
		log.info("request.getServletPath():" + request.getServletPath());
		log.info("request.getRequestURI():" + request.getRequestURI()
				+ ";request.getRequestURL():" + request.getRequestURL());
	}
	
	
	/**
	 * 获取用户信息
	 * 
	 * @param request
	 * @return
	 */
	protected static Userinfo getUserInfo(HttpServletRequest request) {
		return (Userinfo) request.getSession().getAttribute("userinfo");
	}
	/**
	 * 取注入服务
	 */
	public static Object getService(HttpServletRequest request,
			String servicename) {
		ServletContext webcontext = request.getSession().getServletContext();
		return getService(webcontext, servicename);

	}
	public static LogmsgServiceIface logService(HttpServletRequest request) {
		return (LogmsgServiceIface) getService(request,"logmsgService");

	}
	public static Object getService(ServletContext webcontext,
			String servicename) throws Error {
		WebApplicationContext webAppContext;
		Object obj = webcontext
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		if (obj == null)
			return null;
		if (obj instanceof RuntimeException)
			throw (RuntimeException) obj;
		if (obj instanceof Error)
			throw (Error) obj;
		if (!(obj instanceof WebApplicationContext))
			throw new IllegalStateException(
					(new StringBuilder())
							.append(
									"Root context attribute is not of type WebApplicationContext: ")
							.append(obj).toString());
		else
			webAppContext = (WebApplicationContext) obj;
		if (webAppContext.containsBean(servicename)) {
			return webAppContext.getBean(servicename);
		}
		return null;
	}
	public static String returnDictDetailJson(ServletContext application,String dictCode){
		String jsonResult = "";
		JSONObject json;
		try {
			BdDictServiceIface bdDictServcice = (BdDictServiceIface) AbstractActionSupport
					.getService(application, GlobalConstants.SERVICENAME_DICT);
			if (bdDictServcice == null) {
			}else{
				List<BdDictdetail> dictdetailList = bdDictServcice.queryBdDictdetail(dictCode, "Y");
				Map<String, String> map = new HashMap<String, String>();
				if(null != dictdetailList && !dictdetailList.isEmpty()){
					for(BdDictdetail o : dictdetailList){
						map.put(o.getCode(), o.getTitle());
					}
					json = JSONObject.fromObject( map );
					jsonResult = json.toString();
				}
				
			}

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return jsonResult;
	}

}
