<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8" errorPage="/error.jsp"%>
<title>演示环境-电话条</title>

<link rel="stylesheet" href="softphone/skin/css/softphone.css"
	type="text/css"></link>

<script language="javascript" src="softphone/js/graph.js"></script>


<script language="javascript" src="softphone/js/common.js"></script>

<script language="javascript" src="softphone/js/softphone_constants.js"></script>

<script language="javascript" src="softphone/js/soft_local_logger.js"></script>

<script language="javascript" src="softphone/js/base.js"></script>

<script language="javascript" src="softphone/js/phone.js"></script>

<script language="javascript" src="softphone/js/softphoneBar.js"></script>

<script language="javascript" src="softphone/js/callprocess.js"></script>



<script type="text/javascript" language="javascript">
	function getUrlValue(param) {

		var query = window.location.search;

		var iLen = param.length;

		var iStart = query.indexOf(param);

		if (iStart == -1)

			return "";

		iStart += iLen + 1;

		var iEnd = query.indexOf("&", iStart);

		if (iEnd == -1)

			return query.substring(iStart);

		return query.substring(iStart, iEnd);

	}

	$(document).ready( function() {

		SlLog = new SoftLocalLog();

		softphoneBar = new SoftPhoneBar();

		callprocess = new Callprocess();

		var IPaddrs = $("#ipaddr").val();
		//alert(IPaddrs);
			phone = new Phone(softphoneBar, callprocess, IPaddrs);

			var workNo = $("#workNo").val();
			var skillDesc = $("#skill").val();
			//alert(skillDesc);
			var exten = $("#exten").val();
			//alert(exten);

			//自动签入
			
			phone.login(workNo,exten,skillDesc);
			setStyle();

		});
	
		function setStyle() { 
			var div = document.getElementById("softphonebar.select");
			if(hojo.isIE){
				if ((screen.width == 1024))
					 div.style.right="";
				else if ((screen.width == 1280)) 
					div.style.right="330px";
				else if ((screen.width == 1366)) 
					div.style.right="385px";
				}
			if(hojo.isChrome){
		if ((screen.width == 1024))
			 div.style.right="";
		else if ((screen.width == 1280)) 
			div.style.right="340px";
		else if ((screen.width == 1366)) 
			div.style.right="410px";
		} 
		}
	

	function showMenu(myNode) {

		var menuPop = $("#softPhonePopId")[0];

		var box = hojo.marginBox(myNode);

		if (hojo.isIE) {

			hojo.marginBox(menuPop, {
				l :box.l + 115,
				t :box.t + 39,
				w :box.w + 75
			});

		} else if (hojo.isChrome) {

			hojo.marginBox(menuPop, {
				l :box.l + 125,
				t :box.t + 39,
				w :box.w + 70
			});

		} else if (hojo.isFF) {

			hojo.marginBox(menuPop, {
				l :box.l - 75,
				t :box.t + 39,
				w :box.w + 75
			});

		} else {

			hojo.marginBox(menuPop, {
				l :box.l - 35,
				t :box.t + 39,
				w :box.w + 75
			});

		}

		if (menuPop.style.display == 'none') {

			hojo.style(menuPop, "display", "block");

			return;

		} else {

			hojo.style(menuPop, "display", "none");

		}

	}

	function showPhoneNum(myNode) {

		var menuPop = $("#softPhoneNumId")[0];

		var box = hojo.marginBox(myNode);

		if (hojo.isIE) {

			hojo.marginBox(menuPop, {
				l :box.l + 45,
				t :box.t + 40,
				w :box.w + 150
			});

		} else if (hojo.isChrome) {

			hojo.marginBox(menuPop, {
				l :box.l + 45,
				t :box.t + 40,
				w :box.w + 150
			});

		} else if (hojo.isFF) {

			hojo.marginBox(menuPop, {
				l :box.l - 145,
				t :box.t + 40,
				w :box.w + 150
			});

		} else {

			hojo.marginBox(menuPop, {
				l :box.l - 110,
				t :box.t + 40,
				w :box.w + 150
			});

		}

		if (menuPop.style.display == 'none') {

			hojo.style(menuPop, "display", "block");

			return;

		} else {

			hojo.style(menuPop, "display", "none");

		}

	}
</script>
<form>

	<input type="hidden" value="${sessionScope.skill}" id="skill">
	<input type="hidden" value="${sessionScope.ipaddr}" id="ipaddr">
	<input type="hidden" value="${sessionScope.workNo}" id="workNo">
	<input type="hidden" value="${sessionScope.exten}" id="exten">
	<table cellspacing=0 cellpadding=0 id="softPhonePopId"
		style="position: absolute; -moz-opacity: 0.9; opacity: 0.9; z-index: 9999; border: 1px solid #aeaeae; background-color: #fff; display: none;"
		onclick="showMenu(document.getElementById('softphonebar.select'));">

		<tr>

			<td style="background-repeat: repeat-y;">

				<div id="softphonebar.selectMenu">

					<table width='100%'>

						<tr>

							<td>

								<a href='javascript:void(0);' class='softphone_menu'
									onclick='javascript:phone.setIdle();'>

									<div style='float: left; padding-left: 5px; margin-top: 2px;'>
										<img src='softphone/skin/image/softphone/idle.png'
											style='border: 0px' />
									</div>

									<div
										style='float: left; padding-left: 5px; margin-top: 2px; color: #3fb23f'>
										置闲
									</div> </a>

							</td>

						</tr>



						<tr>

							<td>

								<a href='javascript:void(0);' class='softphone_menu'
									onclick='javascript:phone.setBusy();'>

									<div style='float: left; padding-left: 5px; margin-top: 2px;'>
										<img src='softphone/skin/image/softphone/busy.png'
											style='border: 0px' />
									</div>

									<div
										style='float: left; padding-left: 5px; margin-top: 2px; color: #d7563a'>
										置忙
									</div> </a>

							</td>

						</tr>



						<tr>

							<td>

								<a href='javascript:void(0);' class='softphone_menu'
									onclick='javascript:phone.setPreRest();'>

									<div style='float: left; padding-left: 5px; margin-top: 2px;'>
										<img src='softphone/skin/image/softphone/rest.png'
											style='border: 0px' />
									</div>

									<div
										style='float: left; padding-left: 5px; margin-top: 2px; color: #666666'>
										休息
									</div> </a>

							</td>

						</tr>

					</table>

				</div>

			</td>

		</tr>

	</table>

	<table cellspacing=0 cellpadding=0 id="softPhoneNumId"
		style="position: absolute; -moz-opacity: 0.9; opacity: 0.9; z-index: 9999; border: 1px solid #aeaeae; background-color: #fff; display: none"
		onclick="showPhoneNum(document.getElementById('input.select'));">

		<tr>

			<td style="background-repeat: repeat-y;">

				<div id="softPhoneNum">

				</div>

			</td>

		</tr>

	</table>

	<div style="float: left; width: 10px;">
		&nbsp;
	</div>



	<div
		style="width: 84%; height: 50px; overflow: hidden; text-align: left; padding-left: 15px; float: left; border: 0px solid #6499ce; margin-top: 0px"
		id="softphonebar">



		<div style="height: 3px; overflow: hidden; clear: both">
			&nbsp;
		</div>

		<div style="float: left; width: 251px;">

			<div style="height: 12px; overflow: hidden; clear: both">
				&nbsp;
			</div>

			<div
				style="background-image: url(softphone/skin/image/softphone/a1_r2_c2.png); background-repeat: no-repeat; width: 169px; height: 30px; float: left;">

				<input type="text" id="dialout_number"
					style="height: 26px; font-size: 18px; font-weight: bold; border: 0px; background: transparent; padding-left: 7px; padding-top: 3px; width: 154px;"
					onkeydown="if(event.keyCode == 13){javascript:phone.dialout();}" />

			</div>

			<div id="input.select"
				style="float: left; padding-top: 1px; width: 19px; height: 27px; position: absolute; left: 169px;"
				onclick="showPhoneNum(this)">
				<img id="NavEnable"
					src="softphone/skin/image/softphone/select_1.png"
					onmouseover="this.src='softphone/skin/image/softphone/select_2.png'"
					onmouseout="this.src='softphone/skin/image/softphone/select_1.png'"
					style="cursor: pointer;" />
			</div>

			<div style="float: left; width: 65px; padding-top: 0px;">

				<img src="softphone/skin/image/softphone/a3_r2_c4.png"
					style="width: 74px; height: 30px; cursor: pointer;"
					name="SoftButton" id="DialDisable">

				<img src="softphone/skin/image/softphone/a1_r2_c4.png"
					style="width: 74px; height: 30px; cursor: pointer; display: none;"
					name="SoftButton" id="DialEnable"
					onclick="javascript:phone.dialout();" />

			</div>





		</div>

		<div style="float: left; padding-left: 5px; min-width: 360px;">

			<div style="padding-top: -1px;">

				<img src="softphone/skin/image/Sp_belling_disable.png"
					name="SoftButton" id="BellDisable" class="a7" alt="应答"
					style="cursor: pointer;" />
				<img src="softphone/skin/image/Sp_belling_enable.png"
					name="SoftButton" id="BellEnable" class="a7" alt="应答"
					style="cursor: pointer; display: none"
					onclick="javascript:phone.answer();" />

				<img src="softphone/skin/image/Sp_hangup_disable.png"
					name="SoftButton" id="HangupDisable" class="a7" alt="挂机"
					style="cursor: hand" />
				<img src="softphone/skin/image/Sp_hangup_enable.png"
					name="SoftButton" id="HangupEnable" class="a7" alt="挂机"
					style="cursor: pointer; display: none"
					onclick="javascript:phone.hangup();" />

				<img src="softphone/skin/image/Sp_hold_disable.png"
					name="SoftButton" id="HoldDisable" class="a7" alt="保持"
					style="cursor: hand" />
				<img src="softphone/skin/image/Sp_hold_enable.png" name="SoftButton"
					id="HoldEnable" class="a7" alt="保持"
					style="cursor: pointer; display: none"
					onclick="javascript:phone.hold();" />
				<img src="softphone/skin/image/Sp_holdget_enable.png"
					name="SoftButton" id="HoldGetEnable" class="a7" alt="恢复"
					style="cursor: pointer; display: none"
					onclick="javascript:phone.cancelHold();" />

				<img src="softphone/skin/image/Sp_consult_disable.png"
					name="SoftButton" id="ConsultDisable" class="a7" alt="咨询"
					style="cursor: hand" />
				<img src="softphone/skin/image/Sp_consult_enable.png"
					name="SoftButton" id="ConsultEnable" class="a7" alt="咨询"
					style="cursor: pointer; display: none"
					onclick="javascript:phone.dispatchMode('consult');" />
				<img src="softphone/skin/image/Sp_consultEnd_disable.png"
					name="SoftButton" id="ConsultEndEnable" class="a7" alt="结束咨询"
					style="cursor: pointer; display: none"
					onclick="javascript:phone.cancelConsult();" />

				<img src="softphone/skin/image/Sp_transfer_disable.png"
					name="SoftButton" id="TransferDisable" class="a7" alt="转接"
					style="cursor: hand" />
				<img src="softphone/skin/image/Sp_transfer_enable.png"
					name="SoftButton" id="TransferEnable" class="a7" alt="转接"
					style="cursor: pointer; display: none"
					onclick="javascript:phone.preTransfer();" />
				<img src="softphone/skin/image/Sp_transferEnd_disable.png"
					name="SoftButton" id="TransferEndEnable" class="a7" alt="结束转接"
					style="cursor: pointer; display: none"
					onclick="javascript:phone.cancelTransfer();" />

				<img src="softphone/skin/image/Sp_conference_disable.png"
					name="SoftButton" id="ConferenceDisable" class="a7" alt="会议"
					style="cursor: hand" />
				<img src="softphone/skin/image/Sp_conference_enable.png"
					name="SoftButton" id="ConferenceEnable" class="a7" alt="会议"
					style="cursor: pointer; display: none"
					onclick="javascript:phone.preConference();" />
				<img src="softphone/skin/image/Sp_conferenceEnd_disable.png"
					name="SoftButton" id="ConfEndEnable" class="a7" alt="结束会议"
					style="cursor: pointer; display: none"
					onclick="javascript:phone.cancelConf();" />

				<img src="softphone/skin/image/Sp_investigate_disable.png"
					name="SoftButton" id="InvestigateDisable" class="a7" alt="转满意度调查"
					style="cursor: hand" />
				<img src="softphone/skin/image/Sp_investigate_enable.png"
					name="SoftButton" id="InvestigateEnable" class="a7" alt="转满意度调查"
					style="cursor: pointer; display: none"
					onclick="javascript:phone.investigate();" />

			</div>

		</div>



		<div style="float: left; width: 15px;">
			&nbsp;
		</div>



		<div style="float: left; padding-top: 12px; width: 200px;">



			<div class="softphone_timer">



				<div
					style="float: left; padding-top: 8px; width: 84px; text-align: center; height: 22px;"
					id="peerState">



				</div>


<!-- right385px -->
				<div id="softphonebar.select"
					style="float: left; padding-top: 1px; width: 19px; height: 27px; position: absolute;"
					onclick="showMenu(this);">
					<img id="Nav2Enable"
						src="softphone/skin/image/softphone/select_1.png"
						onmouseover="this.src='softphone/skin/image/softphone/select_2.png'"
						onmouseout="this.src='softphone/skin/image/softphone/select_1.png'"
						style="cursor: pointer;" />
				</div>



				<div
					style="float: left; padding-top: 3px; font-size: 18px; padding-left: 18px; display: none"
					id="softphonebar.callTimeState">



				</div>

				<div
					style="float: left; padding-top: 3px; font-size: 20px; padding-left: 24px; display: none"
					id="peerTimeState">

				</div>

			</div>

		</div>
	</div>

</form>