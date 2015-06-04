
function Base(phone) {
   
   this._phone = phone;
   
   this._handles = new Array();   
   
   this._callData; 
   
   this.init = function(){ 
     this._handles.push(this.register("OnEvtHeld", this, "onEvtHold"));   
     this._handles.push(this.register("OnEvtFailed", this, "onEvtFailed"));
     this._handles.push(this.register("OnEvtDialing", this, "onEvtDialing"));   
     this._handles.push(this.register("OnEvtOffering", this, "onEvtOffering"));   
     this._handles.push(this.register("OnEvtReleased", this, "onEvtReleased")); 
     this._handles.push(this.register("OnEvtConnected", this, "onEvtConnected"));    
     this._handles.push(this.register("OnEvtAgentReady", this, "onEvtAgentReady"));  
     this._handles.push(this.register("OnEvtAgentLogin", this, "onEvtAgentLogin"));  
     this._handles.push(this.register("OnEvtAgentLogout", this, "onEvtAgentLogout"));
     this._handles.push(this.register("OnEvtAgentNotReady", this, "onEvtAgentNotReady")); 
     this._handles.push(this.register("OnEvtAgentOtherWork", this, "onEvtAgentOtherWork"));  
     this._handles.push(this.register("OnEvtAgentAfterCallWork", this, "onEvtAgentAfterCallWork"));     
     this._handles.push(this.register("OnEvtConsultOffHook", this, "onEvtConsultOffHook"));     
     this._handles.push(this.register("OnEvtConsultDialing", this, "onEvtConsultDialing")); 
     this._handles.push(this.register("OnEvtConsultConnected", this, "onEvtConsultConnected")); 
     this._handles.push(this.register("OnEvtConsultFailed", this, "onEvtConsultFailed"));     
     this._handles.push(this.register("OnEvtAgentLocked", this, "onEvtAgentLocked"));   
     this._handles.push(this.register("OnEvtBeConsultOffering", this, "onEvtBeConsultOffering"));   
     this._handles.push(this.register("OnEvtBeConsultConnected", this, "onEvtBeConsultConnected"));       
     this._handles.push(this.register("OnEvtConferenced", this, "onEvtConferenced")); 
     this._handles.push(this.register("OnEvtBeConferenced", this, "onEvtBeConferenced")); 
     this._handles.push(this.register("OnEvtConferenceDialing", this, "onEvtConferenceDialing"));      
     this._handles.push(this.register("OnEvtTransferDailing", this, "onEvtTransferDailing"));     
     this._handles.push(this.register("OnGetCallData", this, "onGetCallData"));  
     this._handles.push(this.register("OnUniversalFailure", this, "onUniversalFailure")); 
     this._handles.push(this.register("OnEvtRecording", this, "onEvtRecording")); 
     this._handles.push(this.register("OnQueryIdleAgents", this, "onQueryIdleAgents"));
   }    	    
   
   this.register = function(evtType, obj, method) {        
        return hojo.subscribe(evtType, obj, method);         
   };
      
   this.onUniversalFailure = function(item) {
       alert("软电话操作失败: " + errMsgDic.get(item.universalfailureid));
       SlLog.WriteLog("软电话操作失败 onEvtFailed! *******:"+ item.universalfailureid +"  ***universalfailuredesc *****:"+item.universalfailuredesc);
   }; 
   
   this.onEvtAgentLocked = function(item){
     SlLog.WriteLog("坐席被锁定 onEvtAgentLocked!");
   };
   
   this.onEvtBeConsultOffering = function(item){
      this._phone.softphoneBar.setCurStatus(ConStatus_stBelling);
      SlLog.WriteLog("被咨询方振铃 onEvtBeConsultOffering!");
   };
   
   this.onEvtDialing = function(item){
     SlLog.WriteLog("坐席外呼拨号 onEvtDialing !");
     this._phone.softphoneBar.setCurStatus(ConStatus_stDialing);     
   };
   
   this.onEvtTransferDailing = function(item){
     this._phone.softphoneBar.setCurStatus(ConStatus_stTransfering);
     SlLog.WriteLog("转接拨号 onEvtTransferDailing!");
   };
   
   this.onEvtBeConsultConnected = function(item){
     SlLog.WriteLog("被咨询方通话 onEvtBeConsultConnected! contactid:"+item.contactid);
     this._phone.softphoneBar.setCurStatus(ConStatus_stCounselor);   
     if(this._callData==null){
        callData = new CallData();
        callData.contactid = item.contactid;
        callData.direction = item.calldirection;
        callData.callNo = item.ani;
        callData.calledNo = item.dnis;
        callData.callType = item.calltype;
        this._callData = callData;
     }
     if(this._callData!=null){        
	   this._phone.getCallData();//获取随路数据   
     } 
   };
   
   this.onEvtConferenceDialing = function(item){
     this._phone.softphoneBar.setCurStatus(ConStatus_stConfDialing);
     SlLog.WriteLog("会议拨号事件到达 onEvtConferenceDialing!");
   }
   
   this.onEvtConferenced = function(item){
     this._phone.softphoneBar.setCurStatus(ConStatus_stConference);
     SlLog.WriteLog("会议成功事件到达 onEvtConferenced!");
   };
   
   this.onEvtBeConferenced = function(item){
       SlLog.WriteLog("被会议通话 onEvtBeConferenced! contactid:"+item.contactid);
       this._phone.softphoneBar.setCurStatus(ConStatus_stConfMember);
       if(this._callData==null){
         callData = new CallData();
         callData.contactid = item.contactid;
         callData.direction = item.calldirection;
         callData.callNo = item.ani;
         callData.calledNo = item.dnis;
         callData.callType = item.calltype;
         this._callData = callData;
      }
     if(this._callData!=null){        
	   this._phone.getCallData();//获取随路数据   
     } 
       
   };
   
   this.onEvtConsultOffHook = function(item){
       SlLog.WriteLog("onEvtConsultOffHook!");
   };
   
   this.onEvtConsultDialing = function(item){
       this._phone.softphoneBar.setCurStatus(ConStatus_stConsultDialing);
       SlLog.WriteLog("咨询拨号事件到达 onEvtConsultDialing!");
   };
   
   this.onEvtConsultConnected = function(item){
       this._phone.softphoneBar.setCurStatus(ConStatus_stConsult);
       SlLog.WriteLog("咨询成功事件到达 onEvtConsultConnected!");
   };
   
   this.onEvtConsultFailed = function(item){
       SlLog.WriteLog("onEvtConsultFailed!");
   };
   
   this.onEvtRecording = function(item){
      SlLog.WriteLog("录音事件到达 onEvtRecording! contactid :" +item.contactid +"       filename:"+item.recordfilename);
      SlLog.WriteLog("contactid :" +this._callData.contactid);
      if(this._callData!=null && this._callData.contactid == item.contactid){
         this._callData.fileName = item.recordfilename;
      } 
   };   
   
   this.onEvtConnected = function(item){
     SlLog.WriteLog("通话事件到达 onEvtConnected! contactid:" +item.contactid);    
     this._phone.softphoneBar.setCurStatus(ConStatus_stTalking);     
     if(this._callData==null){
        callData = new CallData();
        callData.contactid = item.contactid;
        callData.direction = item.calldirection;
        callData.callNo = item.ani;
        callData.calledNo = item.dnis;
        callData.callType = item.calltype;
        this._callData = callData;
     }
     if(this._callData!=null){
	    this._phone.getCallData();//获取随路数据      
     } 
   };  
    
  this.onEvtReleased = function(item){
     SlLog.WriteLog("挂机事件到达 onEvtReleased! contactid:" +item.contactid);
     if(this._callData!=null){
       this._phone.callprocess.onHangup(this._callData);
       this._callData = null; 
     } 
   };
   
   this.onGetCallData = function(item){     
      SlLog.WriteLog("获取随路数据事件到达 onGetCallData! item Key_IContact_ANI: "+item.CallData.Key_IContact_ANI); 
      this._phone.callprocess.onAnswerTel(this._callData,item);   	     
   };
   
   this.onEvtAgentOtherWork = function(item){
     this._phone.softphoneBar.setCurStatus(ConStatus_stRest);
     SlLog.WriteLog("休息事件到达,开始休息!");
   };
   

   
   this.onEvtAgentAfterCallWork = function(item){
      SlLog.WriteLog("事后整理事件到达! onEvtAgentAfterCallWork()");
     this._phone.softphoneBar.setCurStatus(ConStatus_stNeaten);
     if(IsBookingRest == true){
        this._phone.setBookingRest();       
     }
    
   };
   
   this.onEvtOffering = function(item){
     this._phone.softphoneBar.setCurStatus(ConStatus_stBelling);
     SlLog.WriteLog("振铃事件到达-来电号码:"+item.ani);
   };
   
   this.onAutoBusyTimeChanged = function(autoBusyTime) {
    	this.autoBusyTime = autoBusyTime; 
   };
    
   this.onEvtFailed = function(item) {
       alert("软电话操作失败: " + errMsgDic.get(item.universalfailureid));
       SlLog.WriteLog("软电话操作失败 onEvtFailed! *******:"+ item.universalfailureid +"  ***universalfailuredesc *****:"+item.universalfailuredesc);
   };
   
   this.onEvtAgentReady = function(){     
     this._phone.softphoneBar.setCurStatus(ConStatus_stIdle);
     SlLog.WriteLog("软电话操作：示闲成功!");
   };
   
   this.onEvtAgentNotReady = function(){
     this._phone.softphoneBar.setCurStatus(ConStatus_stBusy);
     SlLog.WriteLog("软电话操作：示忙成功!");
   };
   
   this.onEvtAgentLogin = function(){
       SlLog.WriteLog("软电话操作：签入成功!");
   };
   
   this.onEvtAgentLogout = function(){
       this._phone.softphoneBar.setCurStatus(ConStatus_stReady);
       SlLog.WriteLog("软电话操作：签出成功!");
   };
   
   this.onEvtHold = function(){
      this._phone.softphoneBar.setCurStatus(ConStatus_stHold);
      SlLog.WriteLog("软电话操作：保持成功!");
   };
   
   this.onQueryIdleAgents = function(item){
      SlLog.WriteLog("软电话操作：查询空闲坐席事件到达 onQueryIdleAgents()!");
   };
   
   this._switchState = function(item){ 
      if(item.Event == "MediaControl" ){
         SlLog.WriteLog("item event name:*****"+item.MediaControl);
         hojo.publish(item.MediaControl, [item]);        
      }else if(item.Event == "AgentStatus"){
         SlLog.WriteLog("item event name:*****"+item.AgentStatus);
         hojo.publish(item.AgentStatus, [item]);
         
      }
   };	
}