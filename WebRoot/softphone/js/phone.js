

function Phone(softphoneBar,callprocess,serviceip) {
    
    this._base = null;    
    //是否正在请求事件
    this._isWaitingEvent= false;
    
    this.dialoutData = null;
	
	this.errcount = 0;
    
    //通话下拉菜单中的值
	this._phoneNumList = new Array();
	
	this._srcNodePhoneNumRef = $("#softPhoneNum")[0];
    
    this.softphoneBar = softphoneBar;  
    
    this.callprocess = callprocess;  
	
    this.serviceip = serviceip;
	this.init = function(config) {	
	    var self = this; 	    
    	this._loadConfig(config);    	
    	this._waitEvent();
	};
	
	this._eventHandler = function(evtJsons){
	    try{
            var self = this;            
            SlLog.WriteLog("item evtJsons:*****"+evtJsons);
            $.each(evtJsons,function(n,item){ 
        		 if(self._base==null) {
            		self._base = new Base(self);	
            		self._base.init();
        		 }        
        		 self._base._switchState(item); 
            });
        } catch (e){
        	
        }
	};
	
	this._waitEvent = function() {		
	
       	if (this._isWaitingEvent) {
       	 	return; 
        } 
        this._isWaitingEvent = true;     
        var self = this;
        var url = this.proxy_url;           
        var phoneJson = {
         		Command:"Action",
         		Action:"GetState",
         		ActionID:"GetState"+Math.random(),
         		Exten:this.exten,
    		    WorkNo:this.workNo, 
         		SessionID:this.uniqueId         		
        };
        $.ajax({ 
            contentType: "application/json; charset=utf-8",
            type: "get",                //使用get方法访问后台
            dataType: "jsonp",          //返回json格式的数据
            url: url,                   //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){},     //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) { 
            SlLog.WriteLog("textStatus:*****"+textStatus+"*****hasEvent:*****"+result.HasEvent);
               
               if(textStatus=="success"){                   
                  if (!result.Succeed) {                     
                     self._isWaitingEvent = false;
                  }if (result.Succeed && !result.HasEvent) {
                  
                  }else{
                    if(result.Result == "201"){
                       return null;
                    }else if(result.Result == "208"){
                    	alert("工号被强制签出!");
			              //SlLog.WriteLog(" registerEvent() 工号被签出!"); 
			              console.log("工号被强制签出!");
			              return null;
                    }
                    else{      
                      var events = result.Event;
                      if(events != null){
                      	self._eventHandler(events);	
                      }                      
                    }  
                  }
                  self._isWaitingEvent = false;
                  self._waitEvent();
				  errcount = 0;
                                 
               }else{
                 //alert("请求服务器错误!");
				 if(errcount ++ > 3){
					alert("请求服务器错误!");
					return null;
				 }else{
					self._isWaitingEvent = false;
					self._waitEvent();
				 }
                 SlLog.WriteLog("_waitEvent() 请求服务器错误！");
                 //return null;
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                //alert("请求服务器错误!");
				if(errcount ++ > 3){
					alert("请求服务器错误!");
					return null;
				 }else{
					self._isWaitingEvent = false;
					self._waitEvent();
				 }
                SlLog.WriteLog("_waitEvent() 请求服务器错误！");
                //return null;
            }
      });
        
    };
	
	this._loadConfig = function(config) {   
		for (var i in config) {
			this[i] = config[i];
        }
    };
   
   this.login = function (workNo,exten,skillDesc){   
      SlLog.WriteLog("软电话操作：座席签入login()");  
     // alert("skillDesc111:"+skillDesc);
      try{
	      var self = this;   	      
	      var config = {
	    	 	workNo : workNo,                        //坐席工号
	    	 	password : '1234',                      //坐席密码
	    	 	agentType : 1,                          //坐席类型    	 	
	    	 	exten : exten,                          //分机号码
	    	 	//skillDesc : '1003=1;1002=1;', 
	    	 	skillDesc : skillDesc,			//坐席所在技能组
	    	 	transferFlag : '1',                     //转接类型
	    	 	dialOutPrefix : '9',                    //外呼前缀
	    	 	autoBusy : false,                       //自动置忙   
	    	 	transferType:1,                         //转接类型 0-咨询转 1-单步转
	    	 	proxy_url : 'http://'+serviceip+':8082/softphone/agentaction', 		    	 	
	    	 	monitor : false                         //是否推送监控
	     };    	     
		  var uniqueId = this.getCookie("uniqueId");   
		  var workNoCache = this.getCookie("workNo");  
	      if(uniqueId == "undefined" || typeof(uniqueId)=="undefined"){
	         config.sessionID ="";
	      }else{
	        config.sessionID =uniqueId;
	      }  
	      if(workNoCache != "undefined" && typeof(workNoCache)!="undefined" && workNo!=workNoCache){
	         self.clearCookie("uniqueId");
	         self.clearCookie("workNoCache");
	         config.sessionID ="";
	      }
	      self.registerEvent(config);  	
	           
	  }catch(Err){
		SlLog.WriteLog("软电话签入异常！login() "+Err.name+":"+Err.message);
		return false;
	 }
	 SlLog.WriteLog("软电话操作：座席签入login()完成");      
   };

   this.registerEvent = function(config){   
      var self = this;    	  
	  var url = config.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"Login",
    		ActionID:"Login"+Math.random(),
    		Exten:config.exten,
    		WorkNo:config.workNo, 
    		AgentType:config.agentType,   	
    		SkillDesc:config.skillDesc,
    		SessionID:config.sessionID    		
      };       
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {
            	var allspan = document.getElementById("workNoStatus");
            	allspan.innerHTML="工号:"+config.workNo;
               if(textStatus=="success"){               
                  if (!result.Succeed) {                                      
                      var code = result.Result;
                      SlLog.WriteLog(" registerEvent() code:"+ code); 
		              if(code && code == 205){
		            	  allspan.innerHTML="工号:"+config.workNo+"签入失败";
		                SlLog.WriteLog(" registerEvent()坐席签入携带非法Session,重新签入!"); 
		                self.clearCookie("uniqueId");
		                self.clearCookie("workNo");
		                self.login(config.workNo,config.exten,config.skillDesc);	 
		              }else if(code && code == 203){
		              	alert("工号已经签入!");
		              	allspan.innerHTML="工号:"+config.workNo+"签入失败";
		                SlLog.WriteLog(" registerEvent() 工号已经签入!"); 	
		              }else if(code && code == 206){
		              	alert("签入失败!");
		              	allspan.innerHTML ="工号:"+config.workNo+"签入失败";
		                SlLog.WriteLog(" registerEvent() 签入失败!"); 	
		              }else if(code && code == 208){
		            	  alert("工号被签出!");
		            	  allspan.innerHTML="工号:"+config.workNo+"签入失败";
			              //SlLog.WriteLog(" registerEvent() 工号被签出!"); 
			              console.log("工号被签出!");
		              }
		              else{
		                alert("签入失败，请联系管理员!");	
		                allspan.innerHTML="工号:"+config.workNo+"签入失败";
		                SlLog.WriteLog(" registerEvent() 签入失败，请联系管理员! code:"+code); 
		              }
		              
		              self.destroy();		              
                  }else if (result.SessionID) {   
	                config.uniqueId = result.SessionID;
	                var date = new Date();
	                var identity = date.valueOf();
					config.currentServerTime = identity - result.Timestamp*1000;
					config.PhonebarConfig = result.PhonebarConfig;				
					self.init(config);					
					self.setCookie("uniqueId",result.SessionID);  //将SessionID写入到Cookie					
					self.setCookie("workNo",config.workNo);		  //将工号写入到Cookie
										
	            }      
	            if(result.HasEvent){
	               var events = result.Event;
	                   if(events != null){
	                     self._eventHandler(events);	
	                }   
	             }	 
	            
               }else{
                 self.destroy();
                 alert("registerEvent() 请求服务器错误!");
                 allspan.innerHTML="工号:"+config.workNo+"签入失败";
                 SlLog.WriteLog(" registerEvent() 请求服务器错误!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {                
                alert("请求服务器错误!");
                allspan.innerHTML="工号:"+config.workNo+"签入失败";
                SlLog.WriteLog(" registerEvent() 请求服务器错误!"); 
            }
      });
      
   };
   
   this.setIdle = function(){
      SlLog.WriteLog("软电话操作:示闲开始! setIdle()"); 
      //判断当前状态是否为置闲
      if(this.softphoneBar.CurStatus==ConStatus_stIdle){         
         return null;
      }   
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"Idle",
    		ActionID:"Idle"+Math.random(),
    		Exten:this.exten,
    		WorkNo:this.workNo, 
    		SessionID:this.uniqueId
      };  
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",                 //使用get方法访问后台
            dataType: "jsonp",           //返回json格式的数据
            url: url,                    //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){},      //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {                                       
                      var code = result.Result;
		              alert("示闲失败，请联系管理员!");	
		              SlLog.WriteLog("示闲失败 setIdle()，请联系管理员!"); 
		              self.destroy();
                  }else {
                    
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 setIdle()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 setIdle()!"); 
            }
      });
      SlLog.WriteLog("软电话操作:示闲完成! setIdle()"); 
      
   };
   
   this.dialout = function(){   
      SlLog.WriteLog("坐席外呼开始! dialout()"); 
      if(this.softphoneBar.CurStatus!=ConStatus_stBusy){        
         return null;
      } 
      var self = this;
      var call_type = "";
      var phoneNum = "";
      var deviceType;
      phoneNum = document.getElementById("dialout_number").value;
      if(phoneNum.length==0){
        alert("请输入目的号码!");
        return null;
      }
      if(phoneNum.length >4) {
         call_type = "dialout";
         deviceType = 3;
         phoneNum = this.dialOutPrefix + phoneNum;
      }else if(phoneNum.length ==1 && this.softphoneBar.CurStatus == ConStatus_stTalking){
         this.sendDTMF(phoneNum);
         return null;
      } else {
         deviceType = 1;
         call_type = "inner";
      }
      this.addPhoneNumList(phoneNum);
      this.makeCall(phoneNum,deviceType);      
      SlLog.WriteLog("坐席外呼完成! dialout()");
   };
   this.makeCall = function(phoneNum,deviceType){
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"MakeCall",
    		ActionID:"MakeCall"+Math.random(),
    		DeviceDN:this.exten,
    		DestType:deviceType,
    		DestNum:phoneNum,
    		WorkNo:this.workNo, 
    		SessionID:this.uniqueId
      };  
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {                                       
                      var code = result.Result;
		              alert("坐席外呼失败，请联系管理员!");	
		              SlLog.WriteLog("坐席外呼失败 makeCall()，请联系管理员!"); 
		              self.destroy();
                  }else {
                    
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 makeCall()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 makeCall()!"); 
            }
      });
   };
   
   this.sendDTMF = function(phoneNum){
      SlLog.WriteLog("坐席二次拨号开始! sendDTMF()");
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"SendDTMF",
    		ActionID:"SendDTMF"+Math.random(),
    		DeviceDN:this.exten,
    		DTMFDigits:phoneNum,
    		WorkNo:this.workNo, 
    		SessionID:this.uniqueId
      };  
     
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {                                       
                      var code = result.Result;
		              alert("坐席二次拨号失败，请联系管理员!");	
		              SlLog.WriteLog("坐席二次拨号失败 sendDTMF()，请联系管理员!"); 
		              self.destroy();
                  }else {
                    
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 sendDTMF()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 sendDTMF()!"); 
            }
      });
      SlLog.WriteLog("坐席二次拨号完成! sendDTMF()");
   }
   
   this.addPhoneNumList = function(phoneNum) {
		var phoneNumLists = this._phoneNumList.join(",");
		if(this._phoneNumList) {
			if(this._phoneNumList.length > 10) {
				this._phoneNumList.shift();
				if(phoneNumLists.indexOf(phoneNum) == -1) {
					this._phoneNumList.push(phoneNum);	
					this.updPhoneNumListTable();
				}
				return;
			}
		}
		if(phoneNumLists.indexOf(phoneNum) == -1) {
			this._phoneNumList.push(phoneNum);
			this.updPhoneNumListTable();
		}
   };
   this.updPhoneNumListTable = function() {
		var self = this;
		self._srcNodePhoneNumRef.innerHTML = "<table width='100%' >";
	    $.each(self._phoneNumList,function(n,item){  
         	self._srcNodePhoneNumRef.innerHTML += "<tr><td><a href='javascript:void(0);' class='softphone_menu_1' onclick=javascript:phone.clickPhoneNum('"+ item +"')  >" +
					"<div style='float:left;padding-left: 5px;margin-top: 2px;font-weight: bold;color:#000'>" + item + "</div></a></td></tr>";  
         });
		self._srcNodePhoneNumRef.innerHTML += "<tr><td></td></tr></table>";
   };
   this.clickPhoneNum = function(phoneNum) {
   	 	if (/^\d+$/.test(phoneNum)) {
   	 		document.getElementById("dialout_number").value = phoneNum;
   	 		return true;
   	 	} else {
   	 		alert("请输入正确的电话号码");
   	 		return false;	
   	 	}
    };
   
   this.setBusy = function(){
      SlLog.WriteLog("软电话操作:置忙开始! setBusy()");
      //判断当前状态是否为置忙
      if(this.softphoneBar.CurStatus==ConStatus_stBusy){         
         return null;
      }      
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"Busy",
    		ActionID:"Busy"+Math.random(),
    		Exten:this.exten,
    		WorkNo:this.workNo, 
    		SessionID:this.uniqueId
      };  
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {                                       
                      var code = result.Result;
		              alert("示闲失败，请联系管理员!");	
		              SlLog.WriteLog("示闲失败 setBusy()，请联系管理员!"); 
		              self.destroy();
                  }else {
                    
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 setBusy()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 setBusy()!"); 
            }
      });
       SlLog.WriteLog("软电话操作:置忙完成! setBusy()");
   };
   
   this.hold = function(){
      SlLog.WriteLog("软电话操作:保持通话开始 hold()!"); 
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"HoldCall",
    		ActionID:"HoldCall"+Math.random(),
    		DeviceDN:this.exten,
    		WorkNo:this.workNo, 
    		SessionID:this.uniqueId
      }; 
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("保持失败，请联系管理员!");	
		              SlLog.WriteLog("保持通话失败 hold()，请联系管理员!"); 
		              self.destroy();
                  }else {
                      
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 hold()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 hold()!"); 
            }
      }); 
      SlLog.WriteLog("软电话操作:保持通话完成 hold()!"); 
   };
   
   this.cancelHold = function(){
      SlLog.WriteLog("软电话操作:取消保持通话开始 cancelHold()!"); 
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"RetrieveCall",
    		ActionID:"RetrieveCall"+Math.random(),
    		DeviceDN:this.exten,
    		WorkNo:this.workNo, 
    		SessionID:this.uniqueId
      }; 
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("取消保持失败，请联系管理员!");	
		              SlLog.WriteLog("取消通话失败 cancelHold()，请联系管理员!"); 
		              self.destroy();
                  }else {
                      
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 cancelHold()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 cancelHold()!"); 
            }
      }); 
      SlLog.WriteLog("软电话操作:取消保持通话完成 cancelHold()!"); 
   };
      
   this.dispatchMode = function(dispatchMode){ 
       var a;           
       //if(document.getElementById("msgbox").style.display=="none"){
        // document.getElementById("msgbox").style.display="";
       //}
       if(dispatchMode == "consult"){
         //a = new xWin("setConsultVal",400,160,600,70,"咨询");
         $.pdialog.open("dispatchMode.action?dispatchMode=consult", "setConsultVal", "咨询","{width:100px,height:100px,max:true,mask:true,mixable:true,minable:true,resizable:true,drawable:true,fresh:true}");
       }else if(dispatchMode == "transfer"){
         //a = new xWin("setTransferVal",400,160,600,70,"转接");
         $.pdialog.open("dispatchMode.action?dispatchMode=transfer", "setTransferVal", "转接","{width:100px,height:100px,max:true,mask:true,mixable:true,minable:true,resizable:true,drawable:true,fresh:true}");
       }else if(dispatchMode=="conference"){
         //a = new xWin("setConferenceVal",400,160,600,70,"会议");
         $.pdialog.open("dispatchMode.action?dispatchMode=conference", "setConferenceVal", "会议","{width:100px,height:100px,max:true,mask:true,mixable:true,minable:true,resizable:true,drawable:true,fresh:true}");
       } 
//       document.getElementById('xContent').innerHTML = "<table width='80%'  class='form_list' align='center' cellpadding='5' cellspacing='0'>"
//                                +"<tr><td align='right' class='grid'><input type='radio' name='choice' id ='choiceAgent' checked value='agent'>坐席工号:</td><td class='grid'><input type='text' id='agentDN' name='agentDN' value=''>&nbsp;&nbsp;</td></tr>"
//                                +"<tr><td align='right' class='grid'><input type='radio' name='choice' id ='choiceSkill' value='skillgroup'>&nbsp;&nbsp;技能组:</td><td class='grid'><select name='skillVal' id='skillVal' style='width: 153px;'><option value='1003'>订单处理&nbsp;</option></select></td></tr>"
//                                +"<tr><td colspan='2' align='center'><input type='button' value='确定' name='setDispathBtn' id='dispathBtn' onclick='javascript:phone."+dispatchMode+"();'></td></tr></table>";
   };
   
   this.consult = function (){
      SlLog.WriteLog("坐席咨询开始 consult()!"); 
      var modelValue;
      var destType;
      if(document.getElementById('choiceAgent').checked){
          destType = DISPATCH_TYPE_AGENT;
       	  //判断工号是否为空
	      modelValue=document.getElementById("agentDN").value;
	      if(modelValue==""){
	        alert("请输入坐席工号!");
	        return null;
	      }
      }else if(document.getElementById('choiceSkill').checked){
          destType = DISPATCH_TYPE_SKILL;
          modelValue=document.getElementById("skillVal").value;
          if(modelValue==""){
	        alert("请选择技能组!");
	        return null;
	      }
      }   
      var ctiData = new HashMap();
      ctiData.push ("ServiceID", "sv20120229000001");  
      this.setCallData(ctiData);
      //document.getElementById("msgbox").style.display="none";
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"ConsultCall",
    		ActionID:"ConsultCall"+Math.random(),
    		DeviceDN:this.exten,
    		WorkNo:this.workNo, 
    		DestType:destType,
    		DestNum:modelValue,
    		ConsultType:0,
    		SessionID:this.uniqueId
      };      
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("坐席咨询失败，请联系管理员!");	
		              SlLog.WriteLog("坐席咨询失败 consult()，请联系管理员!"); 
		              self.destroy();
                  }else {
                	  
	              }
                  $.pdialog.closeCurrent();
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 consult()!"); 
                 $.pdialog.closeCurrent();
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 consult()!"); 
                $.pdialog.closeCurrent();
            }
      }); 
      SlLog.WriteLog("坐席咨询完成 consult()!"); 
   };
   this.cancelConsult = function(){
      SlLog.WriteLog("软电话操作:坐席取消咨询开始 cancelConsult()!"); 
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action: "ReconnectCall",
    		ActionID: "ReconnectCall" +Math.random(),
    		DeviceDN:this.exten,
    		WorkNo:this.workNo, 
    		SessionID:this.uniqueId
      }; 
     
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("坐席咨询失败，请联系管理员!");	
		              SlLog.WriteLog("坐席取消咨询失败 cancelConsult()，请联系管理员!"); 
		              self.destroy();
                  }else {
                      
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 cancelConsult()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 cancelConsult()!"); 
            }
      }); 
      SlLog.WriteLog("软电话操作:坐席取消咨询完成 cancelConsult()!");
   };
   this.preTransfer = function(){
       //判断当前状态是否为咨询,咨询变转接
       if(this.softphoneBar.CurStatus==ConStatus_stConsult){
          SlLog.WriteLog("坐席咨询变转接开始 preTransfer()!");
          var url = this.proxy_url;
		  var phoneJson = {
	    		Command:"Action",
	    		Action:"ForwardCall",
	    		ActionID:"ForwardCall"+Math.random(),
	    		DeviceDN:this.exten,
	    		WorkNo:this.workNo, 
	    		SessionID:this.uniqueId
	      }; 
	      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("坐席咨询变转接，请联系管理员!");	
		              SlLog.WriteLog("坐席咨询变转接失败 preTransfer()，请联系管理员!"); 
		              self.destroy();
                  }else {
                      
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 preTransfer()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 preTransfer()!"); 
            }
	      }); 
	      SlLog.WriteLog("坐席咨询变转接完成 preTransfer()!");
       }else{
          this.dispatchMode("transfer");
       } 
   };   
   this.getCallData = function (){
       SlLog.WriteLog("获取随路数据开始 getCallData()!"); 
       var url = this.proxy_url;
	   var phoneJson = {
    		Command:"Action",
    		Action:"GetCallData",
    		ActionID:"GetCallData"+Math.random(),  
    		DeviceDN:this.exten,
	    	WorkNo:this.workNo,   					    	
    		SessionID:this.uniqueId
      }; 
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("获取随路数据失败，请联系管理员!");	
		              SlLog.WriteLog("获取随路数据失败 getCallData()，请联系管理员!"); 		            
                  }else {
                      
	              }
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 getCallData()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 getCallData()!"); 
            }
      }); 
      SlLog.WriteLog("获取随路数据完成 getCallData()!"); 
   };
   
   this.setCallData = function (ctiData){
       SlLog.WriteLog("设置随路数据开始 setCallData()!"); 
       var url = this.proxy_url;
       if(ctiData.keys.length==0){       
          return null       
       }
       var ctiBuffer;
       
       if(ctiData.keys.length==0){       
          return null       
       }
       var buffer;   
       var ctiJson;   
       buffer="{";
       for(var i=0;i<ctiData.keys.length;i++){   
		 buffer += "\""+ctiData.keys[i] + "\":" + "\"" + ctiData.values[i] + "\",";
	   }	
	   buffer = buffer.substring(0,buffer.lastIndexOf(','));
	   buffer +="}";
	   ctiJson=eval('('+buffer+')');
	   var phoneJson = {
    		Command:"Action",
    		Action:"SetCallData",
    		ActionID:"SetCallData"+Math.random(),
    		DeviceDN:this.exten,
	    	WorkNo:this.workNo,
    		CallData:ctiJson, 
    		SessionID:this.uniqueId
      }; 
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("设置随路数据失败，请联系管理员!");	
		              SlLog.WriteLog("设置随路数据失败 setCallData()，请联系管理员!"); 		            
                  }else {
                      
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 setCallData()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 setCallData()!"); 
            }
      }); 
      SlLog.WriteLog("设置随路数据完成 setCallData()!"); 
   };
   
   this.investigate = function (){
       SlLog.WriteLog("坐席转满意度开始 investigate()!");        
       var ctiData = new HashMap();
       ctiData.push ("IVRFlowFlag", "2");  
	ctiData.push ("AgentWorkNo", this.workNo);
	ctiData.push	("DeviceDN",this.exten);
       this.setCallData(ctiData);
       var url = this.proxy_url;
	   var phoneJson = {
    		Command:"Action",
    		Action:"SingleStepTransfer",
    		ActionID:"SingleStepTransfer"+Math.random(),
    		DeviceDN:this.exten,
    		WorkNo:this.workNo, 
    		DestType:3,
    		DestNum:IVR_LINE_NO,
    		ConsultType:1,
    		SessionID:this.uniqueId
      }; 
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("坐席转满意度失败，请联系管理员!");	
		              SlLog.WriteLog("坐席转满意度失败 investigate()，请联系管理员!"); 
		              self.destroy();
                  }else {
                      
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 investigate()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 investigate()!"); 
            }
      }); 
      SlLog.WriteLog("坐席转满意度完成 investigate()!"); 
   };
   
   this.transfer = function (){
      SlLog.WriteLog("坐席转接开始 transfer()!"); 
      var modelValue;
      var destType;
      var methodRef;
      if(document.getElementById('choiceAgent').checked){
          destType = DISPATCH_TYPE_AGENT;
       	  //判断工号是否为空
	      modelValue=document.getElementById("agentDN").value;
	      if(modelValue==""){
	        alert("请输入坐席工号!");
	        return null;
	      }
      }else if(document.getElementById('choiceSkill').checked){
          destType = DISPATCH_TYPE_SKILL;
          modelValue=document.getElementById("skillVal").value;
          if(modelValue==""){
	        alert("请选择技能组!");
	        return null;
	      }
      } 
      //document.getElementById("msgbox").style.display="none";   
      
      var ctiData = new HashMap();
      ctiData.push ("ServiceID", "sv20120229000003");  
      this.setCallData(ctiData);
       
      if(this.transferType == TRANSFER_TYPE_CONSULT){
         methodRef = "ConsultCall";
      }else{
         methodRef = "SingleStepTransfer"
      }
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:methodRef,
    		ActionID:methodRef+Math.random(),
    		DeviceDN:this.exten,
    		WorkNo:this.workNo, 
    		DestType:destType,
    		DestNum:modelValue,
    		ConsultType:1,
    		SessionID:this.uniqueId
      };      
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("坐席转接失败，请联系管理员!");	
		              SlLog.WriteLog("坐席转接失败 transfer()，请联系管理员!"); 
		              self.destroy();
                  }else {
                      
	              }
                  $.pdialog.closeCurrent();
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 transfer()!"); 
                 $.pdialog.closeCurrent();
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 transfer()!"); 
                $.pdialog.closeCurrent();
            }
      }); 
      SlLog.WriteLog("坐席转接完成 transfer()!"); 
   };
   this.preConference = function(){
       //判断当前状态是否为咨询,咨询变会议
       if(this.softphoneBar.CurStatus==ConStatus_stConsult){
          SlLog.WriteLog("坐席咨询变会议开始 preConference()!");
          var url = this.proxy_url;
		  var phoneJson = {
	    		Command:"Action",
	    		Action:"JoinCall",
	    		ActionID:"JoinCall"+Math.random(),
	    		DeviceDN:this.exten,
	    		WorkNo:this.workNo, 
	    		SessionID:this.uniqueId
	      }; 
	      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("坐席咨询变会议，请联系管理员!");	
		              SlLog.WriteLog("坐席咨询变会议失败 preConference()，请联系管理员!"); 
		              self.destroy();
                  }else {
                      
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 preConference()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 preConference()!"); 
            }
	      }); 
	      SlLog.WriteLog("坐席咨询变会议完成 preConference()!");
       }else{
          this.dispatchMode("conference");
       } 
   };
   this.conference = function (){
      SlLog.WriteLog("坐席会议开始 conference()!"); 
      var modelValue;
      var destType;
      if(document.getElementById('choiceAgent').checked){
          destType = DISPATCH_TYPE_AGENT;
       	  //判断工号是否为空
	      modelValue=document.getElementById("agentDN").value;
	      if(modelValue==""){
	        alert("请输入坐席工号!");
	        return null;
	      }
      }else if(document.getElementById('choiceSkill').checked){
          destType = DISPATCH_TYPE_SKILL;
          modelValue=document.getElementById("skillVal").value;
          if(modelValue==""){
	        alert("请选择技能组!");
	        return null;
	      }
      }   
      var ctiData = new HashMap();
      ctiData.push ("ServiceID", "sv20120229000002");  
      this.setCallData(ctiData);
     // document.getElementById("msgbox").style.display="none";
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"ConsultCall",
    		ActionID:"ConsultCall"+Math.random(),
    		DeviceDN:this.exten,
    		WorkNo:this.workNo, 
    		DestType:destType,
    		DestNum:modelValue,
    		ConsultType:2,
    		SessionID:this.uniqueId
      }; 
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("坐席会议失败，请联系管理员!");	
		              SlLog.WriteLog("坐席会议失败 conference()，请联系管理员!"); 
		              self.destroy();
                  }else {
                      
	              }  
                  $.pdialog.closeCurrent();
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 conference()!"); 
                 $.pdialog.closeCurrent();
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 conference()!");
                $.pdialog.closeCurrent();
            }
      }); 
      SlLog.WriteLog("坐席会议完成 conference()!"); 
   };
   
   this.cancelConf = function(){
      SlLog.WriteLog("坐席取消会议开始 cancelConf()!"); 
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action: "ReconnectCall",
    		ActionID: "ReconnectCall" +Math.random(),
    		DeviceDN:this.exten,
    		WorkNo:this.workNo, 
    		SessionID:this.uniqueId
      }; 
     
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("坐席取消会议失败，请联系管理员!");	
		              SlLog.WriteLog("坐席取消会议失败 cancelConf()，请联系管理员!"); 
		              self.destroy();
                  }else {
                      
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 cancelConf()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 cancelConf()!"); 
            }
      }); 
      SlLog.WriteLog("坐席取消会议完成 cancelConf()!");
   };
   
   this.cancelTransfer = function(){
      SlLog.WriteLog("坐席取消转接开始 cancelTransfer()!"); 
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action: "ReconnectCall",
    		ActionID: "ReconnectCall" +Math.random(),
    		DeviceDN:this.exten,
    		WorkNo:this.workNo, 
    		SessionID:this.uniqueId
      };      
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("坐席取消转接失败，请联系管理员!");	
		              SlLog.WriteLog("坐席取消转接失败 cancelTransfer()，请联系管理员!"); 
		              self.destroy();
                  }else {
                      
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 cancelTransfer()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 cancelTransfer()!"); 
            }
      }); 
      SlLog.WriteLog("坐席取消转接完成 cancelTransfer()!");
   };
   
   this.setPreRest = function(){
       //判断当前状态是否为休息
       if(this.softphoneBar.CurStatus == ConStatus_stRest){
         alert("当前状态为休息状态!");
         return null;
       }
       //if(document.getElementById("msgbox").style.display=="none"){
        // document.getElementById("msgbox").style.display="";
       //}
      // var a = new xWin("setRestVal",800,120,600,70,"休息原因");
      // document.getElementById('xContent').innerHTML = "<table width='100%' align='right' cellpadding='5' cellspacing='5'><tr><td><input id='radio'  type='radio' name='radioRest' value='1'/>开会</td>"
                                //+ "<td><input id='radio'  type='radio' name='radioRest' value='2'/>就餐</td><td><input id='radio'  type='radio' name='radioRest' value='3'/>培训</td></tr>"
                                //+"<tr><td><input id='radio'  type='radio' name='radioRest' value='4'/>离开</td>"
                               // + "<td><input id='radio'  type='radio' name='radioRest' value='5'/>外出</td><td><input id='radio'  type='radio' name='radioRest' value='6'/>辅导</td></tr>"
                                //+"<tr><td colspan='3' align='center'><input type='button' value='确定' name='setRestBtn' id='restBtn' onclick='javascript:phone.setRest();'></td></tr></table>";
       //navTab.openTab("indexCardNav", "restReason.action",{ title:"我的主页", fresh:false, data:{} });
       $.pdialog.open("restReason.action", "setRestValDiag", "休息原因","{width:100px,height:100px,max:true,mask:true,mixable:true,minable:true,resizable:true,drawable:true,fresh:true}");
   };
   
   
   this.setBookingRest = function(){
   
      SlLog.WriteLog("软电话操作:调用预约休息开始 setBookingRest()，reason code:" + ReasonCode);       
      IsBookingRest = false;  
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"OtherWork",
    		ActionID:"OtherWork"+Math.random(),    	
    		WorkNo:this.workNo, 
    		resoncode:ReasonCode,
    		SessionID:this.uniqueId
      };  
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("调用预约休息失败，请联系管理员!");	
		              SlLog.WriteLog("调用预约休息失败 setBookingRest()，请联系管理员!"); 
		              self.destroy();
                  }else {
                      
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 setBookingRest()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 setBookingRest()!"); 
            }
      });
      SlLog.WriteLog("软电话操作:调用预约休息完成 setBookingRest()!");  
   };

   
   this.setRest = function(){
     ReasonCode = 0;
     var restVal = null;    
     var restObj=document.getElementsByName("radioRest");
     if(restObj!=null){
        var i;
        for(i=0;i<restObj.length;i++){
            if(restObj[i].checked){
                 restVal = restObj[i].value; 
                 break;          
            }
        }
     } 
     if(restVal==null){
        alert("请选择休息原因!");
        return null;
     } 
     ReasonCode = restVal;
     //document.getElementById("msgbox").style.display="none";     
     //判断是否为通话状态预约休息
     if(this.softphoneBar.CurStatus == ConStatus_stTalking){
         IsBookingRest = true;
         return null;
     }            
     SlLog.WriteLog("软电话操作:调用休息开始 setRest()，reason code:" + restVal);   
     var url = this.proxy_url;
	 var phoneJson = {
    		Command:"Action",
    		Action:"OtherWork",
    		ActionID:"OtherWork"+Math.random(),    	
    		WorkNo:this.workNo, 
    		resoncode:restVal,
    		SessionID:this.uniqueId
      };  
      $.ajax({ 
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) { 
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("调用休息失败，请联系管理员!");	
		              SlLog.WriteLog("调用休息失败 setRest()，请联系管理员!"); 
		              self.destroy();
                  }else {
                      
	              }
                  $.pdialog.closeCurrent();
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 setRest()!"); 
                 $.pdialog.closeCurrent();
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 setRest()!"); 
                $.pdialog.closeCurrent();
            }
      });
      SlLog.WriteLog("软电话操作:调用休息完成 setRest()"); 
   };
   
   this.answer = function(){
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"AnswerCall",
    		ActionID:"AnswerCall"+Math.random(),
    		Exten:this.exten,
    		WorkNo:this.workNo, 
    		SessionID:this.uniqueId
      };  
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed) {  
		              alert("应答电话失败，请联系管理员!");	
		              SlLog.WriteLog("应答电话失败 answer()，请联系管理员!"); 
		              self.destroy();
                  }else {
                	  
	              }
                  this.onAnswerTel();
                  //navTab.openTab("addOrderinfoCardNav", "addWorkOrder.action",{ title:"来电工单", fresh:false, data:{} });
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 answer()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 answer()!"); 
            }
      });
   };
   
   this.hangup = function(){
	 //软电话挂机1
      SlLog.WriteLog("坐席挂机开始!"); 
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"HangupCall",
    		ActionID:"HangupCall"+Math.random(),
    		DeviceDN:this.exten,
    		WorkNo:this.workNo, 
    		SessionID:this.uniqueId
      };  
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",            //使用get方法访问后台
            dataType: "jsonp",      //返回json格式的数据
            url: url,               //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){}, //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {             
               if(textStatus=="success"){               
                  if (!result.Succeed){  
		              alert("挂机失败，请联系管理员!");	
		              SlLog.WriteLog("挂机失败 hangup()，请联系管理员!"); 
		              self.destroy();
                  }else {
                      
	              }
                  //软电话挂机3
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 hangup()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 hangup()!"); 
            }
      });
      SlLog.WriteLog("坐席挂机完成!");
   };
   

   this.logout = function(){      
      SlLog.WriteLog("软电话操作：座席签出logout()");      
      var self = this;      
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"Logout",
    		ActionID:"Logout"+Math.random(),
    		Exten:this.exten,
    		WorkNo:this.workNo, 
    		SessionID:this.uniqueId
      };  
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",               //使用get方法访问后台
            dataType: "jsonp",         //返回json格式的数据
            url: url,                  //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){},    //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {                           
               if(textStatus=="success"){               
                  if (!result.Succeed) {                                       
                      var code = result.Result;
					  alert("签出成功，请联系管理员!");	
						SlLog.WriteLog("签出成功!，请联系管理员!"); 
						self.destroy();
                  }else {
	                if(result.HasEvent){
	                   var events = result.Event;
	                   if(events != null){
	                     self._eventHandler(events);	
	                  }   
	                }
					alert("签出失败，请联系管理员!");
					
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 logout()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 logout()!"); 
            }
      });
   };
   
   this.queryIdleAgent = function(){
      SlLog.WriteLog("查询空闲坐席queryIdleAgent()开始!");      
      var self = this;      
      var url = this.proxy_url;
	  var phoneJson = {
    		Command:"Action",
    		Action:"QueryIdleAgent",
    		ActionID:"QueryIdleAgent"+Math.random(),
    		Businesstype:1000,
    		DeviceDN:this.exten,
    		WorkNo:this.workNo,
    		DestDesc:"3010", 
    		SessionID:this.uniqueId
      };  
      $.ajax({         
            contentType: "application/json; charset=utf-8",
            type: "get",               //使用get方法访问后台
            dataType: "jsonp",         //返回json格式的数据
            url: url,                  //要访问的后台地址
            jsonp: 'callbackName', 
            data: "json="+hojo.toJson(phoneJson),
            timeout: 15000,
            complete :function(){},    //AJAX请求完成时隐藏loading提示            
            success: function(result,textStatus,jqXHR) {                           
               if(textStatus=="success"){               
                  if (!result.Succeed) {                                       
                      var code = result.Result;
		              alert("查询空闲坐席失败，请联系管理员!");	
		              SlLog.WriteLog("查询空闲坐席失败 queryIdleAgent()，请联系管理员!"); 
		              self.destroy();
                  }else {
	                if(result.HasEvent){
	                   var events = result.Event;
	                   if(events != null){
	                     self._eventHandler(events);	
	                  }   
	                }	 
	              }                  
               }else{
                 alert("请求服务器错误!");
                 SlLog.WriteLog("请求服务器错误 queryIdleAgent()!"); 
               }                
            },                        
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("请求服务器错误!");
                SlLog.WriteLog("请求服务器错误 queryIdleAgent()!"); 
            }
      });
      SlLog.WriteLog("查询空闲坐席queryIdleAgent()完成!"); 
   }
   
   this.destroy = function() {   
       if(this.softphoneBar._peerCalculagraph != null) {
			window.clearInterval(this.softphoneBar._peerCalculagraph);
	   }
	   this.softphoneBar._srcNodePeerStateRef.innerHTML = "";
   };   
   //将SessionID设置到Cookie中
   this.setCookie = function(name, value){
   	 var expires = new Date();                                      
	 expires.setTime(expires.getTime() + (60 * 60 *  60 * 1000 )); 
     document.cookie = name+ "=" + escape(value)+ "; expires ="+ expires.toGMTString() + "; path=" + "/";
   };
   //获取Cookie中的SessionID
   this.getCookie = function(name){    
     var arg = name + "="; 
     var argLen = arg.length;
     var cookieLen = document.cookie.length; 
     var i = 0;
     while (i < cookieLen) { 
       var j = i + argLen; 
       if (document.cookie.substring(i, j) == arg)
        return this.getCookieVal(j); 
       i = document.cookie.indexOf(" ", i) + 1; 
       if (i == 0) break; 
     } 
   }; 
   
   this.getCookieVal = function(offset){
       var endstr = document.cookie.indexOf(";", offset);     
       if (endstr == -1) endstr = document.cookie.length;       
       return unescape(document.cookie.substring(offset, endstr)); 
   };
   
   //清空Cookie
   this.clearCookie = function(name){
     document.cookie = name+"=''; expires =0; path=" + "/";
   };

}
