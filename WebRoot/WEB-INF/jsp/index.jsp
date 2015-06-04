<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8" errorPage="/error.jsp"%>
<%@ include file="/include.inc.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title><s:text name="common.title" /></title>
		<link href="css/but/lcp-button.css" rel="stylesheet" type="text/css"
			media="screen" />
		<link href="css/but/lcp-core.css" rel="stylesheet" type="text/css"
			media="screen" />
		<link href="dwz/themes/azure/style.css" rel="stylesheet"
			type="text/css" media="screen" />
		<link href="dwz/themes/green/style.css" rel="stylesheet"
			type="text/css" media="screen" />
		<link href="dwz/themes/purple/style.css" rel="stylesheet"
			type="text/css" media="screen" />
		<link href="dwz/themes/silver/style.css" rel="stylesheet"
			type="text/css" media="screen" />
		<link href="dwz/themes/default/style.css" rel="stylesheet"
			type="text/css" media="screen" />
		<link href="dwz/themes/css/core.css" rel="stylesheet" type="text/css"
			media="screen" />
		<link href="dwz/themes/css/print.css" rel="stylesheet" type="text/css"
			media="print" />
		<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
		<!--[if IE]>
		<link href="dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
		<![endif]-->
		<script src="dwz/js/speedup.js" type="text/javascript"></script>
		<script src="dwz/js/jquery-1.7.1.js" type="text/javascript"></script>
		<script src="dwz/js/jquery.cookie.js" type="text/javascript"></script>
		<script src="dwz/js/jquery.validate.js" type="text/javascript"></script>
		<script src="dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
		<script src="dwz/xheditor/xheditor-1.1.12-zh-cn.min.js"
			type="text/javascript"></script>
		<!-- <script src="dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script> -->
		<script src="dwz/js/dwz.core.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.util.date.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.validate.method.js" type="text/javascript"></script>
		<!-- <script src="dwz/js/dwz.regional.zh.js" type="text/javascript"></script> -->
		<script src="dwz/js/dwz.barDrag.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.drag.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.tree.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.accordion.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.ui.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.theme.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.navTab.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.tab.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.resize.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.dialog.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.cssTable.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.stable.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.taskBar.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.ajax.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.pagination.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.database.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.datepicker.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.effects.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.panel.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.checkbox.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.history.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.combox.js" type="text/javascript"></script>
		<script src="dwz/js/dwz.print.js" type="text/javascript"></script>
		<script src="${applicationScope.rootpath}dwz/js/dwz.regional.zh.js"
			type="text/javascript"></script>
		<script language="JavaScript"
			src="${applicationScope.rootpath}scripts/formcheck.js"></script>
		<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
		<script type="text/javascript"
			src="${applicationScope.rootpath}dwz/chart/raphael.js"></script>
		<script type="text/javascript"
			src="${applicationScope.rootpath}dwz/chart/raphael-min.js"></script>
		<script type="text/javascript"
			src="${applicationScope.rootpath}dwz/chart/g.raphael.js"></script>
		<script type="text/javascript"
			src="${applicationScope.rootpath}dwz/chart/g.bar.js"></script>
		<script type="text/javascript"
			src="${applicationScope.rootpath}dwz/chart/g.line.js"></script>
		<script type="text/javascript"
			src="${applicationScope.rootpath}dwz/chart/g.pie.js"></script>
		<script type="text/javascript"
			src="${applicationScope.rootpath}dwz/chart/g.dot.js"></script>
		<script type="text/javascript"
			src="${applicationScope.rootpath}scripts/dateUtil.js"></script>
		<script type="text/javascript"
			src="${applicationScope.rootpath}scripts/commontool.js"></script>
		<script language="JavaScript"
			src="${applicationScope.rootpath}scripts/formcheck.js"></script>
		<!-- play -->
		<script type="text/javascript"
			src="${applicationScope.rootpath}scripts/play/swfobject.js"></script>
		<script type="text/javascript"
			src="${applicationScope.rootpath}scripts/play/1bit.js"></script>
		<script type="text/javascript"
			src="${applicationScope.rootpath}scripts/play/player.js"></script>
		<!-- zTree -->
		<link rel="stylesheet"
			href="${applicationScope.rootpath}zTree/css/zTreeStyle/zTreeStyle.css"
			type="text/css">
			<script type="text/javascript"
				src="${applicationScope.rootpath}zTree/js/jquery.ztree.core-3.5.js"></script>
			<script type="text/javascript"
				src="${applicationScope.rootpath}zTree/js/jquery.ztree.excheck-3.5.js"></script>
			<script type="text/javascript"
				src="${applicationScope.rootpath}zTree/js/jquery.ztree.exedit-3.5.js"></script>
			<style type="text/css">
#header {
	height: 60px
}

#leftside,#container,#splitBar,#splitBarProxy {
	top: 62px
}
</style>
			<script type="text/javascript">
	$(function() {
		$(function() {
			DWZ.init("${applicationScope.rootpath}dwz/dwz.frag.xml", {
				loginTitle : "登录", // 弹出登录对话框
				loginUrl : "${applicationScope.rootpath}login.jsp",
				statusCode : {
					ok : 200,
					error : 300,
					timeout : 301
				}, //【可选】
				pageInfo : {
					pageNum : "pageNum",
					numPerPage : "numPerPage",
					orderField : "orderField",
					orderDirection : "orderDirection"
				}, //【可选】
				debug : false, // 调试模式 【true|false】
				callback : function() {
					initEnv();
					$("#themeList").theme( {
						themeBase : "dwz/themes"
					}); // themeBase 相对于index页面的主题base路径
				if ('${empty userinfo.ctiaddr}') {
					//initMainPage();
			}
		}
			});
		});
	});

	function pageUnload() {
		btnSignOut_onclick();
		window.close();
	}
	function initMainPage() {
		navTab
				.openTab(
						"ipccReportLiNav",
						"listIpccReport.action?fileName=ipcc_report_agentinfo.xls&changeUrl=Y&pageNum=1&numPerPage=20&reportType=agentinfo",
						{
							title : "坐席签入签出明细",
							fresh : true,
							data : {}
						});
	}
</script>
	</head>
	<body scroll="no">
		<div id="layout">
			<div id="header">
				<div class="headerNav">
					<a class="logo" href="http://www.liveneo.com" target="_bank">官网</a>
					<ul class="nav">
						<c:if test="${sessionScope.userinfo.isadmin != 'true'}">
							<li>
								<OBJECT classid="clsid:42C1C5DF-A048-43A7-B23D-A2199044C0FA"
									id="Phone" width="888" height="53"></OBJECT>
							</li>
						</c:if>
						<c:if test="${not empty sessionScope.userinfo.username}">
							<li>
								<a href="#"><i class="icon-user"></i> </a>
								<b><span style="color: black; font-family: Microsoft YaHei">
										Hello,${sessionScope.userinfo.username}!</span> </b>
							</li>
						</c:if>
						<li>
							<a href="changePwd.action" rel="changePwdCardNav" target="dialog"
								reloadFlag=1 mask="true"><span
								style="color: black; font-family: Microsoft YaHei"><i
									class="icon-exclamation-sign"></i> <s:text
										name="common.updatepwd"></s:text> </span> </a>
						</li>
						<li>
							<a href="logout.action" target="_top"><span
								style="color: black; font-family: Microsoft YaHei"><i
									class="icon-remove"></i> <s:text name="common.logout"></s:text>
							</span> </a>
						</li>
					</ul>
					<ul class="themeList" id="themeList">
						<li>
							<a
								href="${applicationScope.rootpath}download.action?loadflag=softphone&fileName=IPCCSoftPhoneSetup.rar"
								target="_black" title="<s:text name="common.askload"/>"
								class="btn btn-mini btn-warning"> <i class="icon-circle-arrow-down"></i>
								<s:text name="下载软电话 " /> </a>
						</li>
					</ul>
				</div>
			</div>
			<div id="leftside">
				<div id="sidebar_s">
					<div class="collapse">
						<div class="toggleCollapse">
							<div></div>
						</div>
					</div>
				</div>
				<div id="sidebar">
					<div class="toggleCollapse">
						<h2>
							<s:text name="common.mainmenu" />
						</h2>
						<div>
							收缩
						</div>
					</div>
					<div class="accordion" fillSpace="sidebar">
						<div class="accordionHeader">
							<h2>
								<span>Folder</span>
								<s:text name="common.sysmenu" />
							</h2>
						</div>
						${menu}
					</div>
				</div>
			</div>
			<div id="container">
				<div id="navTab" class="tabsPage">
					<div class="tabsPageHeader">
						<div class="tabsPageHeaderContent">
							<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
							<ul class="navTab-tab">
								<li tabid="main" class="main">
									<a href="javascript:;"><span><span class="home_icon"><s:text
													name="menutitle.myhomepage" /> </span> </span> </a>
								</li>
							</ul>
						</div>
						<div class="tabsLeft">
							left
						</div>
						<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
						<div class="tabsRight">
							right
						</div>
						<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
						<div class="tabsMore">
							more
						</div>
					</div>
					<ul class="tabsMoreList">
						<li>
							<a href="javascript:;"><s:text name="menutitle.myhomepage" />
							</a>
						</li>
					</ul>
					<div class="navTab-panel tabsPageContent layoutBox">
						<div class="page unitBox">
							<c:if test="${not empty userinfo.ctiaddr}">
								<jsp:include page="/WEB-INF/jsp/woStatistics.jsp"></jsp:include></c:if>
							<c:if test="${empty userinfo.ctiaddr}">
								<img src="${applicationScope.rootpath}images/mainbg.jpg" />
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="footer">
			Copyright &copy; 2015
			<a href="http://www.liveneo.com.cn" target="_blank"><s:text
					name="common.login.right" /> </a>
		</div>

	</body>
	<script type="text/javascript">
	//自动登录
	window.onload = function() {
		btnSignIn_onclick();
	}
	//软电话初始化
	var statedisc = new Array();
	function init() {
		statedisc[0] = "就绪";
		statedisc[1] = "休息";
		statedisc[2] = "吃饭";
		statedisc[3] = "话后处理";
		statedisc[4] = "通话中";
		statedisc[5] = "保持";
		statedisc[6] = "会议中三方会议";
		statedisc[7] = "对方振铃";
		statedisc[8] = "对方忙";
		statedisc[9] = "咨询中";
		statedisc[10] = "振铃中";
		statedisc[11] = "签出";
		statedisc[12] = "未知状态";
		statedisc[13] = "咨询会议发起";
		statedisc[14] = "咨询转接发起";
		statedisc[15] = "强插中";
		statedisc[16] = "监听中";
		statedisc[17] = "播放工号中";
		statedisc[18] = "被咨询振铃";
		statedisc[19] = "被咨询通话";
		statedisc[20] = "被会议振铃";
		statedisc[21] = "被会议通话";
	}
	function phone_init() {
		init();
	}
	//签入
	function btnSignIn_onclick() {
		init();
		Phone.Logon('${sessionScope.workNo}', '${sessionScope.ctipwd}',
				'${sessionScope.exten}', '${sessionScope.skill}');
	}
	//签退
	function btnSignOut_onclick() {
		Phone.Logout();
	}
	//-->
</script>
	<!-- 呼入弹屏 -->
	<script language="javascript" for="Phone"
		event="OnUserCallIN(strANI,strDNIS,strAcdSplit,strUCID)"
		type="text/javascript">
	var inin = '${inbound_tp}';
	if (inin == 'Y') {
		navTab.openTab("addCallsCardNav", "addCallsWo.action?caller=" + strANI
				+ "&callmode=inbound&callucid=" + strUCID
				+ "&agentid=${workNo}&his_wo=7&tmp_code=wo_inbound", {
			title : "来电工单",
			fresh : true,
			data : {}
		});
	}
</script>
	<!-- 外呼弹屏 -->
	<script language="javascript" for="Phone"
		event="OnRingOutbound(strUCID,strCalled)" type="text/javascript">
	var out = '${outbound_tp}';
	if (out == 'Y') {
		navTab.openTab("addCallsCardNav", "addCallsWo.action?caller="
				+ strCalled + "&callmode=outbound&callucid=" + strUCID
				+ "&agentid=${workNo}&his_wo=7&tmp_code=wo_outbound", {
			title : "外呼工单",
			fresh : true,
			data : {}
		});
	}
</script>
</html>