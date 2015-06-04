package com.liveneo.plat.constants;


/**
 * 全局静态参数
 * @version 1.0
 * @since 2009-07-20
 */
public class GlobalConstants {
	
	/***
	 * 版本信息
	 * */
	
	/*
	 * ================================help===============================
	 */
	/**
	 * 状态S_
	 * */
	public final static String HELP_S_ = "";
	/**
	 * 日期格式D_
	 * */
	public final static String HELP_D_ = "";
	/**
	 * 流水号相关常量NO_
	 * */
	public final static String HELP_NO_ = "";
	/**
	 * 系统参数SYSPARA_
	 */
	public final static String FITER_EMAIL = "email";
	public final static String HELP_SYSPARA_="";
	
	public final static String EMPTYSTR="";
	/**
	 * 安装申请单号前缀
	 */
	public final static String NO_TYPE_REQU="REQU";
	/**
	 * 服务单号前缀
	 */
	public final static String NO_TYPE_IMPS="IMPS";
	/**
	 * 任务单号前缀
	 */
	public final static String NO_TYPE_WORK="WORK";
	/*
	 * ============================ 日期格式定义 =========================
	 */
	public final static String D_YYYY = "yyyy";
	public final static String D_DD = "dd";
	public final static String D_MM = "MM";
	public final static String D_YYYYMM = "yyyyMM";
	public final static String D_YYYY_MM_DD = "yyyy-MM-dd";
	public final static String D_YYYYMMDD = "yyyyMMdd";
	public final static String D_YYYYMMDDKMSS = "yyyyMMddkmsS";
	public final static String D_YYYY_MM_DD_K_M_S = "yyyy-MM-dd kk:mm:ss";
	/**
	 * The global default encoding
	 */
	public static final String DEFAULT_ENCODING = "UTF-8";
	public static final String DEFAULT_ADMINID="1";
	/**
	 * 日志管理器名称
	 */
	public static final String LOG_MSG_SERVICE = "pubLogMsgService";
	/**
	 * 数据字典明细管理器名称
	 */
	public static final String DICT_DETAIL_SERVICE = "bdDictdetailService";
	public static final String SERVICENAME_PERSON = "bdPersonService";

	/**
	 * 数据字典代码 ： 发送邮件参数 EMAIL_PARA
	 */
	public static final String DATA_CODE_EMAIL_PARA = "EMAIL_PARA";
	public static final String EMAIL_ADDRESS_FORM  = "EMAIL_ADDRESS_FORM";
	public static final String EMAIL_SMTP   = "EMAIL_SMTP";
	public static final String EMAIL_USERNAME   = "EMAIL_USERNAME";
	public static final String EMAIL_USERPWD   = "EMAIL_USERPWD";
	
	/**
	 * 文件上载路径
	 * 
	 * @return
	 */
	public static final String SYSTEM_UPLOAD_PATH = System
			.getProperty("catalina.base")
			+ "\\webapps\\lcpmgr\\upload\\";
	/**
	 * 分隔符
	 */
	public static final String regex = ",";
	
	/**
	 * 菜单名称定义
	 */
	public static final String MENUNAME_ALL = "菜单列表";
	public static final String MENUNAME_BASEINFO = "基本信息";
	public static final String MENUNAME_SYSMANAGER = "系统管理";
	public static final String MENUNAME_PROJECT = "项目管理";
	public static final String MENUNAME_REQUISITION = "安装申请";
	public static final String MENUNAME_SERVICE = "服务单";
	public static final String MENUNAME_TASK = "任务单";
	public static final String MENUNAME_DAILY = "日报";
	public static final String MENUNAME_WEEKLY = "周报";
	public static final String MENUNAME_WORKLTIME = "工时";
	public static final String SERVICENAME_DICT = "bdDictService";
	public static final String SERVICENAME_LOG = "pubLogmsgService";
	public static final String dev_mode = "true";
	
	
	
	/**
	 * ****************************************************放入servletContext中的常量如下：*************************************
	 */
	public static final String SYSTEM_PARAMETER_INFO = "syspara";
	public static final String DICT_PARAMETER_INFO = "dictpara";
	public static final String PERSON_PARAMETER_INFO = "personpara";
	/**
	 * 菜单是否可见
	 * paraName：menuPara
	 * Y:可见
	 * N:不可见
	 * */
	public static final String SYSPARA_MENU = "menuPara";
	public static final String MENU_VALUE_1_OPEN = "Y";
	public static final String MENU_VALUE_2_CLOSE = "N";
	public static final String MENU_NAME_2_CLOSE = "不可见";
	public static final String MENU_NAME_1_OPEN = "可见";
	/**
	 * 人员是否在职
	 * paraName：personActiveOrNotPara
	 * Y:在职,管理员
	 * N:离职,非管理员
	 * */
	public static final String SYSPARA_PERSONACTIVEORNOT = "personActiveOrNotPara";
	public static final String PERSONACTIVEORNOT_VALUE_1_Y = "Y";
	public static final String PERSONACTIVEORNOT_VALUE_2_N = "N";
	public static final String PERSONACTIVEORNOT_NAME_1_Y = "在职";
	public static final String PERSONACTIVEORNOT_NAME_2_N = "离职";
	/**
	 * 性别
	 * paraName:sexPara
	 * M: 男
	 * F：女
	 * */
	public static final String SYSPARA_SEX = "sexPara";
	public static final String SEX_VALUE_NAN = "M";
	public static final String SEX_VALUE_NV = "F";
	public static final String SEX_NAME_NAN = "男";
	public static final String SEX_NAME_NV = "女";
	/**
	 * 定时任务开启关闭
	 * paraName：jobStatusPara
	 * Y：开启
	 * N: 关闭
	 * */
	public static final String SYSPARA_JOBSTATUS = "jobStatusPara";
	public static final String JOBSTATUS_VALUE_OPEN = "Y";
	public static final String JOBSTATUS_VALUE_CLOSE = "N";
	public static final String JOBSTATUS_NAME_OPEN = "开启";
	public static final String JOBSTATUS_NAME_CLOSE = "关闭";
	
	/**
	 * 邮件格式
	 * paraName:emailFormatPara
	 * TEXT:文本
	 * HTML:网页
	 */
	
	public static final String SYSPARA_EMAILFORMATPARA = "emailFormatPara";
	public static final String EMAILFORMATPARA_VALUE_TEXT = "TEXT";
	public static final String EMAILFORMATPARA_NAME_TEXT = "文本";
	public static final String EMAILFORMATPARA_VALUE_HTML = "HTML";
	public static final String EMAILFORMATPARA_NAME_HTML = "网页";
	public static final String EMAILFORMATPARA_VALUE_MSG = "MSG";
	public static final String EMAILFORMATPARA_NAME_MSG = "短信";
	/**
	 * 邮件发送状态
	 * paraName:emailsendstatus	
	 */
	public static final String SYSPARA_EMAILSENDSTATUS = "emailsendstatus";
	public static final String EMAILSENDSTATUS_VALUE_WF = "WF";
	public static final String EMAILSENDSTATUS_NAME_WF = "未发";
	public static final String EMAILSENDSTATUS_VALUE_CF = "CF";
	public static final String EMAILSENDSTATUS_NAME_CF = "重发";
	public static final String EMAILSENDSTATUS_VALUE_ZT = "ZT";
	public static final String EMAILSENDSTATUS_NAME_ZT = "暂停";
	public static final String EMAILSENDSTATUS_VALUE_CG = "CG";
	public static final String EMAILSENDSTATUS_NAME_CG = "成功";
	public static final String EMAILSENDSTATUS_VALUE_SB = "SB";
	public static final String EMAILSENDSTATUS_NAME_SB = "失败";
	/**
	 * 分机权限
	 * paraName：extnLimitPara
	 * GJ：国际
	 * GN: 国内
	 * NB：内部分机
	 * */
	public static final String SYSPARA_EXTNLIMIT = "extnLimitPara";
	public static final String EXTNLIMIT_VALUE_GJ = "international";
	public static final String EXTNLIMIT_VALUE_GN = "domestic";
	public static final String EXTNLIMIT_VALUE_NB = "local";
	public static final String EXTNLIMIT_NAME_GJ = "国际";
	public static final String EXTNLIMIT_NAME_GN = "国内";
	public static final String EXTNLIMIT_NAME_NB = "内部分机";
	/**
	 * 有效状态
	 * paraName：validstatusPara
	 * Y：有效
	 * N: 无效
	 * */
	public static final String SYSPARA_VALIDSTATUS = "validstatusPara";
	public static final String VALIDSTATUS_VALUE_OPEN = "Y";
	public static final String VALIDSTATUS_VALUE_CLOSE = "N";
	public static final String VALIDSTATUS_NAME_OPEN = "有效";
	public static final String VALIDSTATUS_NAME_CLOSE = "无效";
	/**
	 * 是否/true/false
	 * paraName：yesornotPara
	 * true：是
	 * false: 否
	 * */
	public static final String SYSPARA_YESORNOT = "yesornotPara";
	public static final String YESORNOT_VALUE_OPEN = "true";
	public static final String YESORNOT_VALUE_CLOSE = "false";
	public static final String YESORNOT_NAME_OPEN = "是";
	public static final String YESORNOT_NAME_CLOSE = "否";
	
	/**
	 * 拨号方案明细类型：条件、响应
	 * paraName：ItemCategoryPara
	 * condition：条件
	 * action: 响应
	 * */
	public static final String SYSPARA_ITEMCATEGORY = "itemcategoryPara";
	public static final String ITEMCATEGORY_VALUE_CON = "condition";
	public static final String ITEMCATEGORY_VALUE_ACT = "action";
	public static final String ITEMCATEGORY_VALUE_ANTIACT = "anti-action";
	public static final String ITEMCATEGORY_NAME_CON = "条件";
	public static final String ITEMCATEGORY_NAME_ACT = "响应";
	public static final String ITEMCATEGORY_NAME_ANTIACT = "反响应";
	
	/**
	 * 呼出路由使用网关/中继标志：网关、中继
	 * paraName：RouterflagPara
	 * condition：条件
	 * action: 响应
	 * */
	public static final String SYSPARA_ROUTERFLAG = "RouterflagPara";
	public static final String ROUTERFLAG_VALUE_G = "gate";
	public static final String ROUTERFLAG_VALUE_E = "eone";
	public static final String ROUTERFLAG_NAME_G = "网关";
	public static final String ROUTERFLAG_NAME_E = "中继";

	/**
	 * 数学比较符号
	 */
	public static final String SYSPARA_COMPARESIGN = "compareSignPara";
	public static final String COMPARESIGN_VALUE_GE = ">";
	public static final String COMPARESIGN_VALUE_GT = ">=";
	public static final String COMPARESIGN_VALUE_EQ = "=";
	public static final String COMPARESIGN_VALUE_LT = "<=";
	public static final String COMPARESIGN_VALUE_LE = "<";
	public static final String COMPARESIGN_NAME_GE = ">";
	public static final String COMPARESIGN_NAME_GT = ">=";
	public static final String COMPARESIGN_NAME_EQ = "=";
	public static final String COMPARESIGN_NAME_LT = "<=";
	public static final String COMPARESIGN_NAME_LE = "<";
	
	
	/**
	 * 变量类型
	 */
	public static final String SYSPARA_VARIABLES = "variables";
	public static final String VARIABLES_VALUE_CODECS = "codecs";
	public static final String VARIABLES_VALUE_MUSIC = "music";
	
	public static final String VARIABLES_NAME_CODECS = "编解码";
	public static final String VARIABLES_NAME_MUSIC = "音乐";
	
	public static final String IPCC_REPORT_TYPE_D = "DAY";
	public static final String IPCC_REPORT_TYPE_M= "MONTH";
	public static final String IPCC_REPORT_TYPE_Y= "YEAR";
	public static final String IPCC_REPORT_TYPE_C= "CALLLIST";
	
	//IPCC report
	public static final String IPCC_REPORT_TYPE_AGENTINFO = "agentinfo";
	public static final String IPCC_REPORT_TYPE_CALLINFO = "callinfo";
	public static final String IPCC_REPORT_TYPE_CALLPROC = "callproc";
	
	
}
