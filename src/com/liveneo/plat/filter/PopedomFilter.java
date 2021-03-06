/*
 */

package com.liveneo.plat.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;

import com.liveneo.plat.constants.GlobalConstants;

public final class PopedomFilter implements Filter {

	protected transient final Log log = LogFactory.getLog(this.getClass());

	/**
	 * The request attribute name under which we store a reference to ourself.
	 */
	private String attribute = null;

	/**
	 * The filter configuration object we are associated with. If this value is
	 * null, this filter instance is not currently configured.
	 */
	private FilterConfig filterConfig = null;

	private String[] freePages;

	/**
	 * Take this filter out of service.
	 */
	public void destroy() {

		this.attribute = null;
		this.filterConfig = null;

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 设置applicationScopt.rootpath,统一编码UTF-8
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hres = (HttpServletResponse) response;
		request.setCharacterEncoding("UTF-8");
		String path = ((HttpServletRequest) request).getContextPath();
		String url = ((HttpServletRequest) request).getRequestURI();
		log.info("requestPath: " + url);
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		ServletContext application = session.getServletContext();
		log.info("{applicationScopt.rootpath}=" + basePath);
		application.setAttribute("rootpath", basePath);
		String menupathname = this.getMenupathName(hreq);

		if (StringUtils.isNotEmpty(menupathname)) {
			hreq.getSession().setAttribute("menupathname", menupathname);
		}
		if (!basePath.equals(hreq.getRequestURL().toString())
				&& !isFreePage(hreq.getRequestURL().toString())
				&& session.getAttribute("userInfo") == null
				&& !StringUtils.isNotEmpty(hreq
						.getParameter(GlobalConstants.FITER_EMAIL))) {
			try {
				hres.setContentType("text/html; charset=UTF-8");
				PrintWriter out = hres.getWriter();
				String strURL = "<script language=\"javascript\">";
				strURL += " window.open('" + basePath + "','_top')";
				strURL += "</script>";
				out.println(strURL);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (!hres.isCommitted()) {// 如果响应未提交,交给过滤器链
			try {
				chain.doFilter(request, response);
			} catch (ServletException sx) {
				filterConfig.getServletContext().log(sx.getMessage());
			} catch (IOException iox) {
				filterConfig.getServletContext().log(iox.getMessage());
			}
		}

	}

	/**
	 * Place this filter into service.
	 * 
	 * @param filterConfig
	 *            The filter configuration object
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.attribute = filterConfig.getInitParameter("attribute");
		getInitParameter(filterConfig);
	}

	public void getInitParameter(FilterConfig filterConfig) {
		String unCheckPageStr = filterConfig.getInitParameter("freePages") != null ? filterConfig
				.getInitParameter("freePages")
				: "";
		setFreePages(unCheckPageStr.split(";"));
	}

	/**
	 * 判断一个请求URI是否是不过滤的页面
	 * 
	 * @param requestURI
	 *            String 请求URI
	 * @return boolean 返回true为不过滤页面
	 */

	private boolean isFreePage(String requestURI) {
		boolean isFree = false;
		for (int i = 0; i < freePages.length; i++) {
			if (StringUtils.contains(requestURI, freePages[i])) {
				return true;
			}
		}
		return isFree;
	}

	/**
	 * 模块名称
	 * 
	 * @param request
	 * @param response
	 */
	private String getMenupathName(HttpServletRequest request) {
		return "";
	}

	/**
	 * 系统日志
	 * 
	 * @param request
	 * @param response
	 */
	private void addSystemLog(HttpServletRequest request) {
		try {

		} catch (Exception ex) {
			// System.out.println(ex);
		}
	}

	private Object getService(HttpServletRequest request, String servicename) {
		ServletContext webcontext = request.getSession().getServletContext();
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

	public String[] getFreePages() {
		return freePages;
	}

	public void setFreePages(String[] freePages) {
		this.freePages = freePages;
	}

}
