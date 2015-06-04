<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8" errorPage="/error.jsp"%>

<link href="${applicationScope.rootpath}css/aicimage.css"
	rel="stylesheet" type="text/css" media="screen" />
<script language="javascript" src="scripts/LiveneoAIC.js">
</script>
<script language="javascript" src="scripts/LiveneoInitAic.js">
</script>
<script language="javascript" src="scripts/SoftPhoneEvent.js">
</script>
<script language="javascript" src="scripts/SoftPhone.js">
</script>
<script language="javascript" src="scripts/Demo.js">
</script>

<script language="javascript">
function execStr(str) {
	str = str.replace(/(^\s*)|(\s*$)/g, "");
	if (str == null || str == "")
		return;
	eval(str);
}
</script>

<table>
	<tr height=48>
		<td width="26%">
	
		</td>
		<td>
			<input disabled name="TeleFree" value="示闲" onClick="Ready();"
				align=absMiddle border=0 type=image height=48 width=48
				src="aicimages/00READY1.gif" border="0" class="image" /><input disabled name="TeleBusy" value="示忙" onClick="NotReady();"
				align=absMiddle border=0 type=image height=48 width=48
				src="aicimages/00BUSY1.gif" border="0" class="image" /><input disabled name="TmpLogout" value="临时签退" onClick="NotReadyEx();"
				align=absMiddle border=0 type=image height=48 width=48
				src="aicimages/07MEAL1.gif" class="image" /><INPUT name="TeleLogin" type=image height=48 width=48 disabled
				align=absMiddle border=0 onclick="Login();"
				src="aicimages/00LOGIN1.gif" class="image" /><input disabled name="TeleDial" value="呼出"
				onClick="Dail(document.all.PhoneNumber.value);" align=absMiddle
				border=0 type=image height=48 width=48
				src="aicimages/10CallOut1.gif" class="image" /><input disabled name="TeleAnswer" value="应答" onClick="Answer();"
				align=absMiddle border=0 type=image height=48 width=48
				src="aicimages/01Answer1.gif" class="image" /><input disabled name="TeleHangUp" value="挂机" onClick="HangUp();"
				align=absMiddle border=0 type=image height=48 width=48
				src="aicimages/02RELEASE1.gif" class="image" /><input disabled name="TeleHold" value="保持" onClick="Hold();"
				align=absMiddle border=0 type=image height=48 width=48
				src="aicimages/03Hold1.gif" class="image" /><input disabled name="TeleHoldBack" value="接回" onClick="Retrieve();"
				align=absMiddle border=0 type=image height=48 width=48
				src="aicimages/03UnHold1.gif" class="image" /><input disabled name="TeleConsult" value="转接"
				onClick="Consult(document.all.PhoneNumber.value);" align=absMiddle
				border=0 type=image height=48 width=48
				src="aicimages/04ConsultTransf1.gif" class="image" /><input disabled name="TeleConference" value="会议"
				onClick="Conference(document.all.PhoneNumber.value);"
				align=absMiddle border=0 type=image height=48 width=48
				src="aicimages/07ConsultConf1.gif" class="image" /><input disabled name="TeleComplete" value="完成" onClick="Complete();"
				align=absMiddle border=0 type=image height=48 width=48
				src="aicimages/14Complete1.gif" class="image" /><input disabled name="TeleCancle" value="取消" onClick="Cancel();"
				align=absMiddle border=0 type=image height=48 width=48
				src="aicimages/13Cancel1.gif" class="image" /><input disabled name="TeleSingleTransfer" value="单步转接"
				onClick="SingleTransfer(document.all.PhoneNumber.value);"
				align=absMiddle border=0 type=image height=48 width=48
				src="aicimages/04Transf1.gif" class="image" /><input disabled name="TeleSingleConference" value="单步会议"
				onClick="SingleConference(document.all.PhoneNumber.value);"
				align=absMiddle border=0 type=image height=48 width=48
				src="aicimages/07Conf1.gif" class="image" /><input disabled name="TeleFinish" value="话后处理结束" onClick="Finish();"
				align=absMiddle border=0 type=image height=48 width=48
				src="aicimages/12WrapFinish1.gif" class="image" /><INPUT name="TeleLogout" disabled onclick="Logout();" align=absMiddle
				border=0 type=image height=48 width=48 src="aicimages/00LOGOUT1.gif"
				class="image" />
				
		</td>
		
		<td valign="bottom">
			<input type="text" size=8 maxsiz=18 name="PhoneNumber" />
			
		</td>
	</tr>
</table>


<object name="aic" id="aic"
	classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
	style="width: 1px; height: 1px;">
	<param name="code" value="com.liveneo.aic.ui.SoftPhone" />
	<param name="archive"
		value="${applicationScope.rootpath}liveneo-aic71client-1.4.jar" />
	<param name="name" value="aic" />
	<param name="type" value="application/x-java-applet;version=1.5" />
	<param name="primarysdk" value="${userinfo.ctiaddr}" />
	<param name="backupsdks"
		value="${userinfo.ctiaddrbak}" />
	<param name="lcsserver" value="${userinfo.authaddr}" />		
	 <param name="autoreport" value="true" />
	<param name="agentid" value="${userinfo.agentno}" />
	<param name="agentpw" value="${userinfo.ctipwd}" />
	<param name="stationid" value="${userinfo.extno}" />
	<param name="logpath" value="c:\Liveneo\AICPHONE\" />
</object>