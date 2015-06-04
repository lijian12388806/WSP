<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE><s:text name="common.title" />
		</TITLE>
		<META http-equiv="Content-Type" content="text/html;charset=gb2312">
		<LINK href="css/css.css" type="text/css" rel="stylesheet">
		<link rel="stylesheet"
			href="${applicationScope.rootpath}style/screen.css" type="text/css"
			media="screen, projection" />
		<script type="text/javascript">
	function keyDown() {
		if (event.keyCode == 13) {
			document.loginForm.submit();
		}
	}
</script>

		<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html,body,#bg,#bg table,#bg td,#main {
	width: 100%;
	height: 100%;
	overflow: hidden
}

body {
	background: url(loading.gif) #333 repeat;
}

#bj {
	width: 100%;
	height: 101%;
	position: fixed;
	top: 0;
	left: 0;
	z-index: 1;
}

#main {
	width: 100%;
	position: absolute;
	z-index: 2;
}

#submit_btn {
	background: url(/images/button/87.gif) no-repeat center;
	cursor: pointer;
	display: block;
	font-size: 0;
	line-height: 0;
	text-indent: -9999px;
}
}
</style>

		<script language="javascript">
function fsubmit(obj){
  obj.submit();
}
function freset(obj){
  window.close();
}
document.onkeydown=function(){
	 if(event.keyCode==13){
     document.form1.submit();
   }
}
</script>
	</HEAD>


	<BODY background="images/frame/bg_login_liveneo.jpg">
		<div id="main">
			<div>
				<br>
				<br>
				<br>
				<br>
			</div>
			<table cellSpacing="0" cellPadding="0" width="100%" border="0">
				<tbody>
					<tr>
						<td width="24%" height="88" rowspan="2">
							<div align="center">

							</div>
						</td>
						<td width="56%" height="44">
							&nbsp;
						</td>
						<td width="20%" rowspan="2">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<div align="center" class="font18" style="color: white">

							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<div>
				<br>
				<br>
				<br>
				<br>
				<br>
			</div>
			<div align="center">
				<table cellspacing="2" cellpadding="4" width="650" align="center"
					border="0" background="" style="" height="250">
					<s:form name="form1" action="login.action">
						<tbody align="center">
							<tr>
								<td>
									<div align="center">
										<div>
											<em><span
												style="font-size: 12pt; font-family: 微软雅黑, 黑体, 宋体;">账&nbsp;&nbsp;&nbsp;&nbsp;号：</span>
											</em>
											<input id="userinfoForm.username"
												name="userinfoForm.username" value=""
												style="WIDTH: 150px; height: 22px; color: blue; font-family: 微软雅黑, 黑体, 宋体;"
												class="input" size="10">
										</div>
										<div>
											<em><span
												style="font-size: 12pt; font-family: 微软雅黑, 黑体, 宋体;">密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
											</em>
											<input id="userinfoForm.userpwd" type="password" value=""
												name="userinfoForm.userpwd"
												style="WIDTH: 150px; height: 22px" class="input" size="10">
										</div>
										<!-- <div>
											CTI地址：
											<input id="userinfoForm.ctiaddr" type="text" value=""
												name="userinfoForm.ctiaddr"
												style=" WIDTH: 150px; height: 22px"
												class="input" size="10">
										</div> -->
										<div align="center">
											<img src="./images/button/87.gif"
												onClick="javascript:fsubmit(document.form1);">
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</s:form>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="28" align="center">
										&nbsp;
										<font color="#ff0000" size="3"><em><span
												style="font-size: 12pt; font-family: 微软雅黑, 黑体, 宋体;">${msg}</span>
										</em> </font>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<img id="bj" src="images/frame/bg_121gg.jpg" alt="" />
	</BODY>
</HTML>

