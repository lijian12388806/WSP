/**
 * 软电话状态条
 * Allen Ma
 */

function SoftPhoneBar() {

   this.CurStatus  = 0;  //当前状态
   
   this.PreStatus = 0;   //上一状态

   this.statusDic   = new HashMap();  
   
   this.statusNameDic = new HashMap();
   
   
   //坐席状态的处理时间
   this._peerSecond = "1",
   this._peerMinute = "0",
   this._peerHour = "0",
   
   this._peerCalculagraph = null;  //状态计算器
   
   this._srcNodePeerStateRef = $("#peerState")[0];
   this._srcNodePeerTimeStateRef = $("#peerTimeState")[0];      
   
   this.arr_stReady = new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupDisable","HoldDisable","InvestigateDisable","ConsultDisable","TransferDisable","ConferenceDisable");
   this.arr_stIdle =  new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupDisable","HoldDisable","InvestigateDisable","ConsultDisable","TransferDisable","ConferenceDisable");
   this.arr_stBusy =  new Array("NavEnable","Nav2Enable","DialEnable","BellDisable","HangupDisable","HoldDisable","InvestigateDisable","ConsultDisable","TransferDisable","ConferenceDisable");
   this.arr_stBelling =  new Array("NavEnable","Nav2Enable","DialDisable","BellEnable","HangupDisable","HoldDisable","InvestigateDisable","ConsultDisable","TransferDisable","ConferenceDisable");
   this.arr_stTalking =  new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupEnable","HoldEnable","InvestigateEnable","ConsultEnable","TransferEnable","ConferenceEnable");
   this.arr_stNeaten = new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupDisable","HoldDisable","InvestigateDisable","ConsultDisable","TransferDisable","ConferenceDisable");
   this.arr_stHold = new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupDisable","HoldGetEnable","InvestigateDisable","ConsultDisable","TransferDisable","ConferenceDisable");
   this.arr_stRest = new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupDisable","HoldDisable","InvestigateDisable","ConsultDisable","TransferDisable","ConferenceDisable");
   this.arr_stConsultDialing = new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupDisable","HoldDisable","InvestigateDisable","ConsultEndEnable","TransferDisable","ConferenceDisable");
   this.arr_stConsult = new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupDisable","HoldDisable","InvestigateDisable","ConsultEndEnable","TransferEnable","ConferenceEnable");
   this.arr_stCounselor = new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupEnable","HoldDisable","InvestigateDisable","ConsultDisable","TransferDisable","ConferenceDisable");
   this.arr_stConfDialing = new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupDisable","HoldDisable","InvestigateDisable","ConsultDisable","TransferDisable","ConfEndEnable");
   this.arr_stConference = new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupEnable","HoldDisable","InvestigateDisable","ConsultDisable","TransferDisable","ConferenceDisable");
   this.arr_stConfMember = new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupEnable","HoldDisable","InvestigateDisable","ConsultDisable","TransferDisable","ConferenceDisable");
   this.arr_stTransfering  = new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupDisable","HoldDisable","InvestigateDisable","ConsultDisable","TransferEndEnable","ConferenceDisable");
   this.arr_stCallOutDialing  = new Array("NavEnable","Nav2Enable","DialDisable","BellDisable","HangupEnable","HoldDisable","InvestigateDisable","ConsultDisable","TransferDisable","ConferenceDisable");
  
   this.statusDic.push (ConStatus_stReady, this.arr_stReady);                  //0
   this.statusDic.push (ConStatus_stIdle, this.arr_stIdle);                    //1
   this.statusDic.push (ConStatus_stBusy, this.arr_stBusy);                    //2
   this.statusDic.push (ConStatus_stBelling, this.arr_stBelling);              //3
   this.statusDic.push (ConStatus_stWaitingForIVR, this.arr_stWaitingForIVR);  //4
   this.statusDic.push (ConStatus_stTalking, this.arr_stTalking);              //5
   this.statusDic.push (ConStatus_stNeaten,this.arr_stNeaten);                 //15   
   this.statusDic.push (ConStatus_stConference,this.arr_stConference);         //6
   this.statusDic.push (ConStatus_stConsult,this.arr_stConsult);               //7
   this.statusDic.push (ConStatus_stHoldTalk,this.arr_stHoldTalk);             //8
   this.statusDic.push (ConStatus_stTransfering,this.arr_stTransfering);       //9
   this.statusDic.push (ConStatus_stDialing,this.arr_stCallOutDialing); //10
   this.statusDic.push (ConStatus_stConfDialing,this.arr_stConfDialing);       //11
   this.statusDic.push (ConStatus_stConsultDialing,this.arr_stConsultDialing); //12
   this.statusDic.push (ConStatus_stHoldDialing,this.arr_stHoldDialing);       //13 
   this.statusDic.push (ConStatus_stLogout,this.arr_stLogout);                 //14
   this.statusDic.push (ConStatus_stRest,this.arr_stRest);                     //16
   this.statusDic.push (ConStatus_stRestTimeOut,this.arr_stRestTimeOut);       //17
   this.statusDic.push (ConStatus_stHold,this.arr_stHold);                     //18
   this.statusDic.push (ConStatus_stMute,this.arr_stMute);                     //19
   this.statusDic.push (ConStatus_stCounselor,this.arr_stCounselor);           //20
   this.statusDic.push (ConStatus_stConfMember,this.arr_stConfMember);         //21 
   
   this.statusNameDic.push (ConStatus_stIdle, "空闲");
   this.statusNameDic.push (ConStatus_stBusy, "忙碌");
   this.statusNameDic.push (ConStatus_stRest, "休息");
   this.statusNameDic.push (ConStatus_stBelling, "振铃");
   this.statusNameDic.push (ConStatus_stTalking, "通话");
   this.statusNameDic.push (ConStatus_stNeaten,  "整理");
   this.statusNameDic.push (ConStatus_stHold,  "保持"); 
   this.statusNameDic.push (ConStatus_stConsultDialing,  "咨询拨号");
   this.statusNameDic.push (ConStatus_stConsult,  "咨询");
   this.statusNameDic.push (ConStatus_stCounselor,  "被咨询通话");   
   this.statusNameDic.push (ConStatus_stConfDialing,  "会议拨号");
   this.statusNameDic.push (ConStatus_stConference,  "会议");
   this.statusNameDic.push (ConStatus_stConfMember,  "被会议通话");   
   this.statusNameDic.push (ConStatus_stTransfering,  "转接拨号");
   this.statusNameDic.push (ConStatus_stDialing,  "外呼拨号"); 
   if(hojo.isFF){
     this.imageAll = document.getElementsByTagName("img");
   }else{
     this.imageAll = document.getElementsByName("SoftButton");
   }
   this.setCurStatus = function(state){       
       var self = this; 
       self.PreStatus = self.CurStatus;
       self.CurStatus = state;            
       self._peerSecond = "1";
	   self._peerMinute = "0";
	   self._peerHour = "0"; 	      
	   var arr_display = this.statusDic.get(state);	//需要显示的图标id数组 	
       for(var i=0; i<this.imageAll.length; i++){
		 this.imageAll[i].style.display= "none";
		 for(var j=0; j<arr_display.length; j++){
			if(arr_display[j]==this.imageAll[i].id){
				this.imageAll[i].style.display= "";
			}
		 }
	   }	   
	   
	   this._srcNodePeerTimeStateRef.style.display = ""; 	   
	   if(self._peerCalculagraph != null) {
			window.clearInterval(self._peerCalculagraph);
	   }
	   self._peerCalculagraph = window.setInterval(function(){	   
         self._srcNodePeerTimeStateRef.innerHTML = ((self._peerHour<10)?("0"+self._peerHour):self._peerHour) + ":" + ((self._peerMinute<10)?("0"+self._peerMinute):self._peerMinute) + ":" + ((self._peerSecond<10)?("0"+self._peerSecond):self._peerSecond);
            self._peerSecond ++;
            if (self._peerSecond == 60) {
            	self._peerMinute++;
            	self._peerSecond = 0;
            }
            if (self._peerMinute == 60) {
            	self._peerHour++;
            	self._peerMinute = 0;
            }
        }, 1000);
              
       SlLog.WriteLog("当前状态:"+this.statusNameDic.get(this.CurStatus));               
       if(this.CurStatus == ConStatus_stBusy){
          this._srcNodePeerStateRef.innerHTML="<img src='softphone/skin/image/softphone/busy.png' />&nbsp;<span style='color: #d7563a'>" +this.statusNameDic.get(this.CurStatus)+"</span>";
       }else if(this.CurStatus == ConStatus_stIdle){
          this._srcNodePeerStateRef.innerHTML="<img src='softphone/skin/image/softphone/idle.png' />&nbsp;<span style='color: #3fb23f'>" +this.statusNameDic.get(this.CurStatus)+"</span>";
       }else if(this.CurStatus == ConStatus_stBelling){
          this._srcNodePeerStateRef.innerHTML="<img src='softphone/skin/image/softphone/belling.png' />&nbsp;<span style='color: #CE3F00'>" +this.statusNameDic.get(this.CurStatus)+"</span>";
       }else if(this.CurStatus == ConStatus_stTalking){
          this._srcNodePeerStateRef.innerHTML="<img src='softphone/skin/image/softphone/talking.png' />&nbsp;<span style='color: #CE0091'>" +this.statusNameDic.get(this.CurStatus)+"</span>";
       }else if(this.CurStatus == ConStatus_stRest){
          this._srcNodePeerStateRef.innerHTML="<img src='softphone/skin/image/softphone/rest.png' />&nbsp;<span style='color: #666666'>" +this.statusNameDic.get(this.CurStatus)+"["+ReasonCode+"]</span>";
       }else if(this.CurStatus == ConStatus_stNeaten){          
          this._srcNodePeerStateRef.innerHTML="&nbsp;&nbsp;<span style='color: #6C542F'>" +this.statusNameDic.get(this.CurStatus)+"</span>";
       }else if(this.CurStatus == ConStatus_stHold){           
          this._srcNodePeerStateRef.innerHTML="&nbsp;&nbsp;<span style='color: #914E4E'>" +this.statusNameDic.get(this.CurStatus)+"</span>";
       }else{
          this._srcNodePeerStateRef.innerHTML="&nbsp;&nbsp;<span style='color: #914E4E'>" +this.statusNameDic.get(this.CurStatus)+"</span>";
       }
   };
   
 
   
   this.getCurStatus = function(){
      return this.CurStatus;
   }
  
}
