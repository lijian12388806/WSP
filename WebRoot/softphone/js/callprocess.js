

function Callprocess() {
  this.onAnswerTel = function(paraCallData,item){
     var param = {};
     var paramStr = "";
     for(em in paraCallData){
		param[em] = paraCallData[em];
	}
   	if(param){
   		for(em in param){
   			paramStr += "&" + em + "=" + param[em];
   		}
   	}
   navTab.openTab("addOrderinfoCardNav", "addnewWorkOrder.action?callinno="+item.CallData.Key_IContact_ANI+"&factorymenu=1",{ title:"来电工单", fresh:true, data:{} });
   SlLog.WriteLog("paramStr :*****"+ paramStr);
   SlLog.WriteLog("serviceID :*****"+ item.CallData.ServiceID);
  };
  
  this.onHangup = function(paraCallData){
	 //软电话挂机2
   SlLog.WriteLog("filename :*****"+ paraCallData.fileName);
   paraCallData = null;
  };

}