package com.liveneo.plat.web.action;

import com.liveneo.plat.utils.BuildXml;
import com.liveneo.plat.utils.CreateXml;
import com.liveneo.plat.web.action.base.AbstractActionSupport;

public class SysServiceAction extends AbstractActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String restartFreeswitch(){
		BuildXml.excCmd(CreateXml.restartFreeswitch);
		this.logService(getRequest()).addLog(this.getRequest(), "LOGTYPE-CQ", "satrt freeswitch", "");
		return ajaxForwardSuccess(getText("common.restart"));
	}
	public String restartLinux(){
		BuildXml.excCmd(CreateXml.restartLinux);
		this.logService(getRequest()).addLog(this.getRequest(), "LOGTYPE-CQ", "satrt linux", "");
		return ajaxForwardSuccess(getText("common.restart"));
	}

}
