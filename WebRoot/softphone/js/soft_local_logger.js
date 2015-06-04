/*
 ****************************************************
 *************软电话本地日志**************
 ****************************************************
 */

/**
 * 本地日志对象
 */
function SoftLocalLog (){
   if(hojo.isIE){
//	   this.path = "C:\\SoftLog\\";
//	   this.Clearpath = "C:\\SoftLog";
//	   this.fso = new ActiveXObject("Scripting.FileSystemObject");
//	   var d = new Date();
//	   try{
//	     if (d.getDate()==1){
//	   	  this.fso.DeleteFolder(this.Clearpath);
//	     }
//	   }catch(e){
//	   }
//	   try{
//	     this.fso.CreateFolder(this.path);
//	   }catch(e){
//	   }
   }
   this.WriteLog = WriteLog;   
}

function ClearLog(){
//	this.fso.DeleteFolder(this.Clearpath);
}
function WriteLog(LogInfo){
//  var d = new Date();
//  if (SP_TraceLog=="1" && hojo.isIE){
//    try{
//     fs = this.fso.OpenTextFile(this.path+d.getFullYear()+"-"+((d.getMonth()*1+1)<10?'0'+(d.getMonth()*1+1):(d.getMonth()*1+1))+"-"+(d.getDate()<10?"0"+d.getDate():d.getDate())+".log",8,true);
//     fs.WriteLine("["+((d.getHours()<10)?'0'+d.getHours():d.getHours())+":"+(d.getMinutes()<10?'0'+d.getMinutes():d.getMinutes())+":"+(d.getSeconds()<10?'0'+d.getSeconds():d.getSeconds())+"]"+LogInfo);
//     fs.close();
//    }catch(e){  
//    }
//    return;
//   }
  return;
 
}
