var SlLog;
var SP_Debug = "0";
var SP_TraceLog = "1";
var agentInfo;
var IVR_LINE_NO = "989898";			            //IVR队列号

/************软电话状态*************/
PreStatus = 0;               //上一状态
CurStatus = 0;               //当前状态

/***********休息原因***************/
ReasonCode = 0;
IsBookingRest = false;

/***********状态码******************/
ConStatus_stReady = 0;
ConStatus_stIdle = 1;
ConStatus_stBusy = 2;
ConStatus_stBelling = 3;
ConStatus_stWaitingForIVR = 4;
ConStatus_stTalking = 5;
ConStatus_stConference = 6;
ConStatus_stConsult = 7;
ConStatus_stHoldTalk = 8;
ConStatus_stTransfering = 9;
ConStatus_stDialing = 10;
ConStatus_stConfDialing = 11;
ConStatus_stConsultDialing = 12;
ConStatus_stHoldDialing = 13;
ConStatus_stLogout = 14;
ConStatus_stNeaten = 15;
ConStatus_stRest = 16;
ConStatus_stRestTimeOut = 17;
ConStatus_stHold = 18;
ConStatus_stMute = 19;
ConStatus_stCounselor = 20;
ConStatus_stConfMember = 21;
ConStatus_stReading = 22;
ConStatus_OutDial = 23;
ConStatus_stNone = 24;


/************服务类型定义的呼出方向*************/
var SERVICEIN_DIRECTION				= "I";			//呼入
var SERVICEOUT_DIRECTION			= "O";		    //呼出

/*********** 咨询,转接,会议类型  *************/
var DISPATCH_TYPE_EXTEN = 1 ;                       //内线
var DISPATCH_TYPE_AGENT = 2 ;                       //工号
var DISPATCH_TYPE_PSTN  = 3 ;                       //外线
var DISPATCH_TYPE_SKILL = 4 ;                       //技能组

/*********** 转接类型 ******************/
var TRANSFER_TYPE_CONSULT     　= 0 ;                 //咨询转
var TRANSFER_TYPE_SINGLESTEP  = 1 ;                 //单步转

/*********** 呼叫类型 ******************/
ConCallType_ctUnknow = 0;                           //未定义
ConCallType_ctIVRTransIn = 1;                       //自动接入电话(IVR分配电话)
ConCallType_ctInnerTransIn = 2;                     //内部人工转入的电话
ConCallType_ctInnerDialIn = 3;                      //内部人工拨入的电话
ConCallType_ctConsultIn = 4;                        //咨询接入的电话
ConCallType_ctConfIn = 5 ;                          //会议接入的电话
ConCallType_ctInnerDialOut = 6;                     //人工内部呼叫电话（呼出）
ConCallType_ctManualDialOut = 7;                    //人工外拨呼叫电话（呼出）
ConCallType_ctAutoDialOut = 8;                      //自动外拨电话（呼出）
ConCallType_ctTransToIVR = 9;                       //转IVR流程

 /*********坐席信息对象定义**************/
 function AgentInfo(WorkNo,Password,Skill,AgentDN,TransferType,CTIDomain,IsAutoReady,IsAutoAnswer){     
     this.WorkNo            = WorkNo;               //坐席工号
     this.Password          = Password;             //坐席密码
	 this.Skill             = Skill;                //坐席所在技能组
	 this.AgentDN			= AgentDN;				//坐席分机
	 this.CTIDomain         = CTIDomain;            //CTI域
	 this.TransferType      = TransferType;         //转接类型
	 this.IsAutoReady	    = IsAutoReady;			//是否自动置闲
	 this.IsAutoAnswer	    = IsAutoAnswer;			//是否自动应答
 }
 
 
function CallData(){
    this.contactid					= "";   //话务标示
	this.direction					= "";   //呼叫方向
    this.callNo                     = "";   //来电号码
    this.calledNo                   = "";   //被叫号码
    this.callType                   = "";   //呼叫类型
	this.fileName					= "";   //录音文件名	
	this.workNo                     = "";   //坐席工号
	this.deviceNo                   = "";   //坐席分机
}
 
 
/************ CTI返回错误消息码 ****************/ 
var errMsgDic = new HashMap();
errMsgDic.push ("525", "未注册分机!"); 
errMsgDic.push ("1343225862", "工号已经签入!"); 
errMsgDic.push ("1343225881", "对方状态忙!"); 
errMsgDic.push ("1343225874", "无效的目标号码!"); 
errMsgDic.push ("1343225873", "无效的AGENTID!");
errMsgDic.push ("1343225863", "分机不存在!"); 
errMsgDic.push ("1343225865", "技能组错误!"); 

 
function HashMap(){
	this.keys = new Array();
	this.values = new Array();		
	this.push = function (key,value){
		for(var i=0;i<this.keys.length;i++){
			if(this.keys[i]==key){
				this.values[i] = value;
				return null;
			}
		}
		this.keys.push(key);
		this.values.push(value);
	};
	
	this.remove = function (key){
		for(var i=0;i<this.keys.length;i++){
			if(this.keys[i]==key){
					this.keys.splice(i,1);
					this.values.splice(i,1);
					break;
			}
		}
	};
	this.get  = function (key){
		for(var i=0;i<this.keys.length;i++){
			if(this.keys[i]==key){
				return this.values[i];
			}
		}
	};
	this.size = function (){
		if(this.keys.length==this.values.length){
			return this.values.length;
		}else{
			alert("error map structure");
			return 0;
		}
	};
	this.getIndexKey = function (index){
		try{
			return this.keys[index];
		}catch(e){
			alert("index error");
		}
	};
	this.getIndexValue = function (index){
		try{
			return this.values[index];
		}catch(e){
			alert("index error");
		}
	};
}




