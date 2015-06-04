/**
 * 登录事件
 */
function Login() {
	if (aic.login() == false) {
		alert('登录失败.');
	}
}

/**
 * 退出事件
 */
function Logout() {
	aic.logout();
}

/**
 * 示闲事件
 */
function Ready() {
	aic.ready();
}

/**
 * 示忙事件
 */
function NotReady() {
	aic.notReady();
}

/**
 * 临时签退事件
 */
function NotReadyEx() {
	aic.notReady('1', '临时签退.');
}

/**
 * 应答事件
 */
function Answer() {

	if(aic.answer()) {
		navTab.openTab("addOrderinfoCardNav", "addWorkOrder.action?ordersource=&callinno="+aic.getPrimaryAni()+"&ucid="+aic.getUCID()+"&ordertype="+aic.getEDUData('servicename')+"&factoryname="+aic.getEDUData('factoryname')+"&servicemenu="+aic.getEDUData('servicemenu')+"&factorymenu="+aic.getEDUData('factorymenu'),{ title:"来电工单", fresh:false, data:{} });
	//$.pdialog.open("addWorkOrder.action?ordersource=", "workorderwclLiNav", "工单弹屏","{width:800px,height:500px,max:true,mask:true,mixable:true,minable:true,resizable:true,drawable:true,fresh:true,close:”function”, param:”{msg:’message’}”}");
	}

}

function AnswerEx(AgentID) {
	aic.setComment(aic.clientConfig.getAgentid());
	//aic.answerEx(AgentID);
	if (aic.answer()) {
		//if (len(AgentID) > 5) {
			setTimeout(function() {
				aic.singleConsult(AgentID, false);
			}, 1000);
			setTimeout(function() {
				Hold();
			}, 3000);
			setTimeout(function() {
				Retrieve();
			}, 6000);
			
		//}
	}
}

/**
 * 挂机事件
 */
function HangUp() {
	aic.hangUp();
}

/**
 * 外呼事件
 * DataNumber 外呼号码
 */
function Dail(DataNumber) {
	aic.dail(DataNumber);
}

/**
 * 拨分机事件
 * DTMFDigits 分机号
 */
function DigitDail(DTMFDigits) {
	aic.sendDTMF(DTMFDigits);
}

/**
 * 保持事件
 */
function Hold() {
	aic.hold();
}

/**
 * 保持接回事件
 */
function Retrieve() {
	aic.retrieve();
}

/**
 * 内部咨询事件
 * AgentID 座席号
 */
function Consult(DataNumber) {
	aic.consult(DataNumber, true);
}
/**
 *内部会议事件
 */
function Conference(DataNumber) {
	aic.consult(DataNumber, false);
}

/**
 * 忙转事件
 * DataNumber 转接号码
 */
function Transfer(DataNumber) {
	aic.singleTransfer(DataNumber);
}

/**
 * 内部会议成功事件
 * AgentID 座席号
 */
function Complete() {
	aic.complete();
}
/**
 * 咨询会议取消事件
 */
function Cancel() {
	aic.cancel();
}
/**
 * 退出话后处理状态
 */
function Finish() {
	aic.finish();
}

/**
 * 二合一转接
 * AccessCode IVR流程号
 */
function SingleTransfer(AccessCode) {
	aic.singleConsult(AccessCode, true);
}
/**
 * 二合一转会议
 * AccessCode IVR流程号
 */
function SingleConference(AccessCode) {
	aic.singleConsult(AccessCode, false);
}

/**
 * 转IVR客户输入
 * AccessCode IVR流程号
 */
function TransToIVRInput(AccessCode) {

	aic.conferenceTransfer(AccessCode);
}

function CheckLicense() {
	alert(aic.checkLicense());
}
function GetMac() {
	alert(aic.getLocalMac());
}

function GetUCID() {
	alert(aic.getUCID());
}

function GetAppletInfo() {
	alert(aic.getAppletInfo());
}
function SetVDUData(VDUField, VDUVvalue) {
	aic.setEDUData(VDUField, VDUVvalue);
}