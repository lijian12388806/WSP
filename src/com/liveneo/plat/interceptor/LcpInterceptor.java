package com.liveneo.plat.interceptor;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LcpInterceptor extends AbstractInterceptor {

	protected transient final Log log = LogFactory.getLog(getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 5175424498866706361L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = actionInvocation.getInvocationContext();
		HttpServletResponse hres = (HttpServletResponse) ActionContext
				.getContext().get(StrutsStatics.HTTP_RESPONSE);
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(StrutsStatics.HTTP_REQUEST);
		request.setCharacterEncoding("UTF-8");
		String path = ((HttpServletRequest) request).getContextPath();
		String url = ((HttpServletRequest) request).getRequestURI();

		HttpSession session = ((HttpServletRequest) request).getSession(true);
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		ServletContext application = session.getServletContext();
		application.setAttribute("rootpath", basePath);

		return actionInvocation.invoke();
	}

}
