package com.liveneo.plat.interceptor;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;

import com.liveneo.plat.hibernate.dao.Userinfo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 权限判断拦截器
 * 
 * @author Yuexl
 * @version 2013-1-19 16:54
 */
public class AuthorityInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1358600090729208361L;
	private String sessionKey = "userinfo";
	private String parmKey = "withoutAuthentication";
	private boolean excluded;

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();

		HttpServletRequest request = (HttpServletRequest) ctx
				.get(StrutsStatics.HTTP_REQUEST);
		request.setCharacterEncoding("UTF-8");
		String path = ((HttpServletRequest) request).getContextPath();

		HttpSession session = ((HttpServletRequest) request).getSession(true);
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		ServletContext application = session.getServletContext();
		application.setAttribute("rootpath", basePath);

		Map autsession = ctx.getSession();
		// 取出名为user的session属性
		String parm = (String) autsession.get(parmKey);
		if (parm != null) {
			excluded = parm.toUpperCase().equals("TRUE");
		}
		Userinfo userinfo = (Userinfo) autsession.get(sessionKey);
		// 如果没有登陆，都返回重新登陆
		if (excluded || userinfo != null) {
			return invocation.invoke();
		}
		// 没有登陆，将服务器提示设置成一个HttpServletRequest属性
		ctx.put("tip", "您还没有登录，请登陆系统");
		return Action.LOGIN;

	}
}
