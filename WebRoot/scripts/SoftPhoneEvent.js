var canLogin = false;
var canLogout = false;
var canReady = false;
var canNotReady = false;
var canAnswer = false;
var canHangUp = false;
var canDial = false;
var canHold = false;
var canRetrieve = false;
var canConsult = false;
var canCancel = false;
var canComplete = false;
var canTransfer = false;
var canSendDTMF = false;
var canFinish = false;

function updateUI() {
	this.canLogin = false;
	this.canLogout = false;
	this.canReady = false;
	this.canNotReady = false;
	this.canAnswer = false;
	this.canHangUp = false;
	this.canDial = false;
	this.canHold = false;
	this.canRetrieve = false;
	this.canConsult = false;
	this.canCancel = false;
	this.canComplete = false;
	this.canTransfer = false;
	this.canSendDTMF = false;
	this.canFinish = false;
	switch (aic.getAgentStatus()) {
	case teleEnum._Agent_Status_AUXWORK:
		this.canLogout = true;
		this.canReady = true;
		this.canDial = true;
		break;
	case teleEnum._Agent_Status_AVAILABLE:
		this.canLogout = true;
		this.canNotReady = true;
		this.canDial = true;
		break;
	case teleEnum._Agent_Status_ALERTING:
		this.canAnswer = true;
		break;
	case teleEnum._Agent_Status_RESET:
		this.canLogout = true;
		this.canReady = true;
		this.canDial = true;
		break;
	case teleEnum._Agent_Status_INITIATING:
		this.canHangUp = true;
		break;
	case teleEnum._Agent_Status_WORKING:
		this.canHangUp = true;
		this.canHold = true;
		this.canConsult = true;
		this.canTransfer = true;
		this.canSendDTMF = true;
		break;
	case teleEnum._Agent_Status_INACTIVE:
		this.canRetrieve = true;
		break;
	case teleEnum._Agent_Status_WRAPUP:
		this.canFinish = true;
		break;
	case teleEnum._Agent_Status_LOGGED_IN:
		this.canLogout = true;
		break;
	case teleEnum._Agent_Status_LOGGED_OUT:
		this.canLogin = true;
		break;
	case teleEnum._Agent_Status_CONSULTING:
	case teleEnum._Agent_Status_CONFERENCING:
	case teleEnum._Agent_Status_TRANSFERRING:
		this.canCancel = true;
		break;
	case teleEnum._Agent_Status_CONSULT_FINISH:
	case teleEnum._Agent_Status_CONFERENC_FINISH:
		this.canCancel = true;
		this.canComplete = true;
		break;
	case teleEnum._Agent_Status_CONFERENC_WORKING:
		this.canHangUp = true;
		this.canHold = true;
		break;
	}
}
function updateButton() {
	if (document.all.TeleLogin) {
		if (this.canLogin) {
			document.all.TeleLogin.src = "aicimages/00LOGIN2.gif"

		} else {
			document.all.TeleLogin.src = "aicimages/00LOGIN1.gif"

		}
		document.all.TeleLogin.disabled = !this.canLogin;
	}
	if (document.all.TeleLogout) {
		if (this.canLogout) {
			document.all.TeleLogout.src = "aicimages/00LOGOUT2.gif"

		} else {
			document.all.TeleLogout.src = "aicimages/00LOGOUT1.gif"

		}
		document.all.TeleLogout.disabled = !this.canLogout;
	}
	if (document.all.TeleFree) {
		if (this.canReady) {
			document.all.TeleFree.src = "aicimages/00READY2.gif"

		} else {
			document.all.TeleFree.src = "aicimages/00READY1.gif"

		}
		document.all.TeleFree.disabled = !this.canReady;
	}
	if (document.all.TeleBusy) {
		if (this.canNotReady) {
			document.all.TeleBusy.src = "aicimages/00BUSY2.gif"

		} else {
			document.all.TeleBusy.src = "aicimages/00BUSY1.gif"

		}
		document.all.TeleBusy.disabled = !this.canNotReady;
	}
	if (document.all.TmpLogout) {
		if (this.canNotReady) {
			document.all.TmpLogout.src = "aicimages/07MEAL2.gif"

		} else {
			document.all.TmpLogout.src = "aicimages/07MEAL1.gif"

		}

		document.all.TmpLogout.disabled = !this.canNotReady;

	}
	if (document.all.TeleDial) {
		if (this.canDial) {
			document.all.TeleDial.src = "aicimages/10CallOut2.gif"

		} else {
			document.all.TeleDial.src = "aicimages/10CallOut1.gif"

		}
		document.all.TeleDial.disabled = !this.canDial;
	}
	if (document.all.TeleAnswer) {
		if (this.canAnswer) {
			document.all.TeleAnswer.src = "aicimages/01Answer2.gif"

		} else {
			document.all.TeleAnswer.src = "aicimages/01Answer1.gif"

		}
		document.all.TeleAnswer.disabled = !this.canAnswer;
	}

	if (document.all.TeleAnswerEx) {
		document.all.TeleAnswerEx.disabled = !this.canAnswer;
	}
	if (document.all.TeleHangUp) {
		if (this.canHangUp) {
			document.all.TeleHangUp.src = "aicimages/02RELEASE2.gif"

		} else {
			document.all.TeleHangUp.src = "aicimages/02RELEASE1.gif"

		}
		document.all.TeleHangUp.disabled = !this.canHangUp;
	}
	if (document.all.TeleHold) {
		if (this.canHold) {
			document.all.TeleHold.src = "aicimages/03Hold2.gif"

		} else {
			document.all.TeleHold.src = "aicimages/03Hold1.gif"

		}				
		document.all.TeleHold.disabled = !this.canHold;
	}
	if (document.all.TeleHoldBack) {
		if (this.canRetrieve) {
			document.all.TeleHoldBack.src = "aicimages/03UnHold2.gif"

		} else {
			document.all.TeleHoldBack.src = "aicimages/03UnHold1.gif"

		}			
		
		document.all.TeleHoldBack.disabled = !this.canRetrieve;
	}
	if (document.all.TeleConsult) {		
		if (this.canConsult) {
			document.all.TeleConsult.src = "aicimages/04ConsultTransf2.gif"

		} else {
			document.all.TeleConsult.src = "aicimages/04ConsultTransf1.gif"

		}				
		document.all.TeleConsult.disabled = !this.canConsult;
	}

	if (document.all.TeleConference) {
		if (this.canConsult) {
			document.all.TeleConference.src = "aicimages/07ConsultConf2.gif"

		} else {
			document.all.TeleConference.src = "aicimages/07ConsultConf1.gif"

		}		
		
		document.all.TeleConference.disabled = !this.canConsult;
	}

	if (document.all.TeleComplete) {
		if (this.canComplete) {
			document.all.TeleComplete.src = "aicimages/14Complete2.gif"

		} else {
			document.all.TeleComplete.src = "aicimages/14Complete1.gif"

		}		
		
		
		document.all.TeleComplete.disabled = !this.canComplete;
	}
	if (document.all.TeleCancle) {
		if (this.canCancel) {
			document.all.TeleCancle.src = "aicimages/13Cancel2.gif"

		} else {
			document.all.TeleCancle.src = "aicimages/13Cancel1.gif"

		}		
		document.all.TeleCancle.disabled = !this.canCancel;
	}
	
	if (document.all.TeleSingleTransfer) {
		if (this.canConsult) {
			document.all.TeleSingleTransfer.src = "aicimages/04Transf2.gif"

		} else {
			document.all.TeleSingleTransfer.src = "aicimages/04Transf1.gif"

		}		
		document.all.TeleSingleTransfer.disabled = !this.canConsult;
	}
	if (document.all.TeleSingleConference) {
		if (this.canConsult) {
			document.all.TeleSingleConference.src = "aicimages/07Conf2.gif"

		} else {
			document.all.TeleSingleConference.src = "aicimages/07Conf1.gif"

		}				
		document.all.TeleSingleConference.disabled = !this.canConsult;
	}
	if (document.all.TeleDigitDial) {
		document.all.TeleDigitDial.disabled = !this.canSendDTMF;
	}
	if (document.all.TeleFinish) {
		if (this.canFinish) {
			document.all.TeleFinish.src = "aicimages/12WrapFinish2.gif"

		} else {
			document.all.TeleFinish.src = "aicimages/12WrapFinish1.gif"

		}			
		
		
		document.all.TeleFinish.disabled = !this.canFinish;
	}

	if (document.all.TeleTranIvrInput) {
		document.all.TeleTranIvrInput.disabled = !this.canConsult;
	}

}
function initPhone() {
	updateUI();
	updateButton();
}
function EventAgentStatusChanged() {
	updateUI();
	updateButton();
	var EventContent = document.all.EventContent;
	if (EventContent) {
		EventContent.value += "AgentStatus=[" + aic.getAgentStatus() + "]\n";
	}
	var ani= document.all.ani;
	if(ani){
		ani.innerHTML=aic.getAni()+"座席工号："+aic.clientConfig.getAgentid();
	}
}
function EventContactAttributesChanged() {
	var CallData = document.all.CallData;
	if (CallData) {
		CallData.value = "";
		var edu = aic.getEDUData();
		if (edu) {
			var it = edu.getNameValues().iterator();
			while (it.hasNext()) {
				var nv = it.next();
				CallData.value += nv.getName() + "=" + nv.getValue() + "\n";
			}
		}
	}

}