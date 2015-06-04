var aic_delayInitials=new Array();
var aic_listeners=new Array();
top.aic_initialMe=aic_initialMe;

function aic_initialMe(actionFunction){
  if(top.phone&&top.phone.ok){
    actionFunction();
  }else{
    aic_delayInitials[aic_delayInitials.length]=actionFunction;
  }
}

function aic_listen(teleEventType,actionFunction){
  var listener={
     teleEventType:teleEventType,
    actionFunction:actionFunction
  };
  aic_listeners[aic_listeners.length]=listener;
}

function Applet__Finished(){
  window.config=aic.config();
  window.teleEventType=aic.teleEventType;
  window.teleEnum=aic.teleEnum;
  
  top.phone=new Object();
  top.phone.listen=aic_listen;
  top.phone.aic=aic;
  top.phone.config=config;
  top.phone.teleEventType=teleEventType;
  top.phone.teleEnum=teleEnum;
  window.phone=top.phone;
  
  top.phone.ok=true;
  for(var i in aic_delayInitials){
    var actionFunction=aic_delayInitials[i];
    if(actionFunction)
      try{
        actionFunction();
      }catch(e){
      }
    delete aic_delayInitials[i];
  }
}

function AIC__EventHandler(teleEventType,event){
  var eventType=teleEventType.intValue();
  for(var i in aic_listeners){
    var listener=aic_listeners[i];
    if(listener.teleEventType=="all"||listener.teleEventType==eventType){
      if(!listener.actionFunction)delete aic_listeners[i];
      else{
        try{
          listener.actionFunction(event,teleEventType);
        }catch(e){
          delete aic_listeners[i];
        }
      }
    }
  }
}