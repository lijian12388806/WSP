function keyDown(form,queryForm)
{
  if(event.keyCode==13)
   {
     SetFormAction(form,queryForm);
   }
}	
function submitform(form ,opType,para,isdatacheck,isconfirm){
    //loading();	
	var objForm = document.forms[form];
	var checkedFlag = false;
	if(typeof(isdatacheck)!='undefined'&&isdatacheck==true){
		if (!checkOwnRule(objForm)){
			checkedFlag=false;
			return false;
		}else{
			checkedFlag=true;
		}
	}else{
		checkedFlag=true;
	}
	if (typeof(isdatacheck)!='undefined'&&isconfirm==true) {
		if (window.confirm("\u662f\u5426\u7ee7\u7eed")) {	
			checkedFlag=true;	
		}else{
			checkedFlag=false;
			return false;			
		}
	}else{
		checkedFlag=true;
	}
	if(checkedFlag){
		disablebutton(form);
		objForm.method.value = opType;
		var url  =objForm.action;
		url=url+"?method="+opType;
		if(typeof(para)!='undefined'&&para!=""){
			url=url+"&"+para
		}
		objForm.action=url;			
		objForm.submit();
	}
}
function SetFormActionNotCheck(form, opType) {
	var objForm = document.forms[form];
	objForm.method.value = opType;
	objForm.submit();
}
function SetFormAction(form, opType,para) {
	var objForm = document.forms[form];
	objForm.method.value = opType;
	
	if ((opType.indexOf("save") > -1) || (opType.indexOf("update") > -1 ) || (opType.indexOf("submit") > -1 ) ||(opType.indexOf("import") > -1 )||(opType.indexOf("addImpservice") > -1 )) {
		if (checkOwnRule(objForm)) {
			if (window.confirm("\u662f\u5426\u7ee7\u7eed")) {				
				var url  =objForm.action
				url=url+"?method="+opType;
				if(typeof(para)!='undefined'&&para!=""){
						url=url+"&"+para
				}			
				objForm.action=url;
				objForm.submit();
			} else {				
				return false;
			}
		}
	} else {
			var inputObj = objForm.getElementsByTagName("input");
			for (i = 0; i < inputObj.length; i++) {
				inputObj(i).value = trim(inputObj(i).value);				
			}
			var url  =objForm.action
				url=url+"?method="+opType;
				if(typeof(para)!='undefined'&&para!=""){
						url=url+"&"+para
				}			
				disablebutton(form);
				objForm.action=url;
				objForm.submit();
	}
}

function SetFormActionConfirm(form, opType,para) {
	var objForm = document.forms[form];
	var objLen = objForm.length;
	var checkedFlag = false;

	for (var iCount = 0; iCount < objLen; iCount++) {
		if (objForm.elements[iCount].type == "checkbox" && objForm.elements[iCount].checked == true) {
			checkedFlag = true;
			break;
		}
	}
	if (!checkedFlag) {
		alert("\u8bf7\u81f3\u5c11\u9009\u62e9\u4e00\u6761\u8bb0\u5f55\uff01");
		return;
	}
	if (window.confirm("\u662f\u5426\u7ee7\u7eed")) {
		//var objForm = document.forms[form];
		var url  =objForm.action
		url=url+"?method="+opType;
		if(para!=""&&typeof(para)!='undefined'){
				url=url+"&"+para
		}	
		objForm.action=url;
		if ((opType.indexOf("cance") > -1) || (opType.indexOf("bac") > -1) || (opType.indexOf("lis") > -1) || (opType.indexOf("del") > -1) || (opType.indexOf("return") > -1) || (opType.indexOf("gotoEdit") > -1) || (opType.indexOf("refresh") > -1) ||(opType.indexOf("examine") > -1)) {
			objForm.submit();
		} else {
			if (checkOwnRule(objForm)) {
				objForm.submit();
			}
		}
	}
}
function chkall(input1, input2, input3) {
	var objForm = document.forms[input1];
	var objLen = objForm.length;
	for (var iCount = 0; iCount < objLen; iCount++) {
		if (input2.checked == true) {
			if (objForm.elements[iCount].type == "checkbox" && objForm.elements[iCount].name == input3) {
				if (objForm.elements[iCount].disabled == true) {
					objForm.elements[iCount].checked = false;
				} else {
					objForm.elements[iCount].checked = true;
				}
			}
		} else {
			if (objForm.elements[iCount].type == "checkbox" && objForm.elements[iCount].name == input3) {
				objForm.elements[iCount].checked = false;
			}
		}
	}
}
function disablebutton(form){
	var objForm = document.forms[form];
	var inputObj = objForm.getElementsByTagName("input");
	for (i = 0; i < inputObj.length; i++) {
		if (inputObj(i).getAttribute("type").toLowerCase() == "button") {
			inputObj(i).disabled=true;
		}
	}
}
function enablebutton(form){
	var objForm = document.forms[form];
	var inputObj = objForm.getElementsByTagName("input");
	for (i = 0; i < inputObj.length; i++) {
		if (inputObj(i).getAttribute("type").toLowerCase() == "button") {
			inputObj(i).disabled=false;
		}
	}
}
function checkOwnRule(objfrm) {
	var inputObj = objfrm.getElementsByTagName("input");
	for (i = 0; i < inputObj.length; i++) {
		if (!inputObj(i).getAttribute("hint") || inputObj(i).getAttribute("hint") == "") {
			strHint = inputObj(i).name;
		} else {
			strHint = inputObj(i).getAttribute("hint");
		}
		inputObj(i).value = trim(inputObj(i).value);
		if (inputObj(i).getAttribute("allownull") == "false") {
			if (inputObj(i).value == "" || inputObj(i).value == "--") {
				alert(strHint + "\u4e0d\u80fd\u4e3a\u7a7a");
				inputObj(i).focus();
				return false;
			}
		}
		if (inputObj(i).getAttribute("className") == "digital") {
			if (inputObj(i).value != "" && isNaN(inputObj(i).value)) {
				alert(strHint + "\u5fc5\u987b\u4e3a\u6570\u5b57");
				inputObj(i).focus();
				return false;
			}
		}
		if (inputObj(i).getAttribute("digital") == "true") {
			if (inputObj(i).value != "" && isNaN(inputObj(i).value)) {
				alert(strHint + "\u5fc5\u987b\u4e3a\u6570\u5b57");
				inputObj(i).focus();
				return false;
			}
		}
		if (inputObj(i).getAttribute("isInt") == "true") {
			if (inputObj(i).value.indexOf(".") >= 0) {
				alert(strHint + "\u5fc5\u987b\u4e3a\u6574\u6570");
				inputObj(i).focus();
				return false;
			}
		}
		if (inputObj(i).getAttribute("allowzero") == "false") {
			if (inputObj(i).value == 0) {
				alert(strHint + "\u4e0d\u80fd\u4e3a0");
				inputObj(i).focus();
				return false;
			}
		}
		if (inputObj(i).getAttribute("allownegative") == "false") {
			if (inputObj(i).value < 0) {
				alert(strHint + "\u4e0d\u80fd\u4e3a\u8d1f\u6570");
				inputObj(i).focus();
				return false;
			}
		}
		if (inputObj(i).getAttribute("compare") == "true") {
			if (inputObj(i).getAttribute("compareflag") == "=") {
				if (inputObj(i).value != null && inputObj(i).value != "" && eval(inputObj(i).value) != eval(inputObj(i).getAttribute("comparevalue"))) {
					alert(strHint + "\u8f93\u5165\u91d1\u989d\u4e0d\u6b63\u786e");
					inputObj(i).value = "";
					inputObj(i).focus();
					return false;
				}
			} else {
				if (inputObj(i).value != null && inputObj(i).value != "" && eval(inputObj(i).value) > eval(inputObj(i).getAttribute("comparevalue"))) {
					alert(strHint + "\u8d85\u53ef\u7528\u989d\u5ea6");
					inputObj(i).value = "";
					inputObj(i).focus();
					return false;
				}
			}
		}
		if (inputObj(i).getAttribute("isdate") == "true") {
			if (inputObj(i).value != "" && !checkdate(inputObj(i).value)) {
				alert(strHint + "\u5fc5\u987b\u4e3a\u6b63\u786e\u7684\u65e5\u671f\u683c\u5f0f");
				inputObj(i).focus();
				return false;
			}
		}
	}
	var textareaObj = objfrm.getElementsByTagName("textarea");
	for (i = 0; i < textareaObj.length; i++) {
		if (!textareaObj (i).getAttribute("hint") || textareaObj (i).getAttribute("hint") == "") {
			strHint = textareaObj (i).name;
		} else {
			strHint = textareaObj (i).getAttribute("hint");
		}
		textareaObj (i).value = trim(textareaObj (i).value);
		if (textareaObj (i).getAttribute("allownull") == "false") {
			if (textareaObj (i).value == "") {
				alert(strHint + "\u4e0d\u80fd\u4e3a\u7a7a");
				textareaObj (i).focus();
				return false;
			}
		}
		if (textareaObj (i).getAttribute("className") == "digital") {
			if (textareaObj (i).value != "" && isNaN(textareaObj (i).value)) {
				alert(strHint + "\u5fc5\u987b\u4e3a\u6570\u5b57");
				textareaObj (i).focus();
				return false;
			}
		}
		if (textareaObj (i).getAttribute("isInt") == "true") {
			if (textareaObj (i).value.indexOf(".") >= 0) {
				alert(strHint + "\u5fc5\u987b\u4e3a\u6574\u6570");
				textareaObj (i).focus();
				return false;
			}
		}
		if (textareaObj (i).getAttribute("allowzero") == "false") {
			if (textareaObj (i).value == 0) {
				alert(strHint + "\u4e0d\u80fd\u4e3a0");
				textareaObj (i).focus();
				return false;
			}
		}
		if (textareaObj (i).getAttribute("allownegative") == "false") {
			if (textareaObj (i).value < 0) {
				alert(strHint + "\u4e0d\u80fd\u4e3a\u8d1f\u6570");
				textareaObj (i).focus();
				return false;
			}
		}
		if (textareaObj (i).getAttribute("compare") == "true") {
			if (textareaObj (i).getAttribute("compareflag") == "=") {
				if (textareaObj (i).value != null && textareaObj (i).value != "" && eval(textareaObj (i).value) != eval(textareaObj (i).getAttribute("comparevalue"))) {
					alert(strHint + "\u8f93\u5165\u91d1\u989d\u4e0d\u6b63\u786e");
					textareaObj (i).value = "";
					textareaObj (i).focus();
					return false;
				}
			} else {
				if (textareaObj (i).value != null && textareaObj (i).value != "" && eval(textareaObj (i).value) > eval(textareaObj (i).getAttribute("comparevalue"))) {
					alert(strHint + "\u8d85\u53ef\u7528\u989d\u5ea6");
					textareaObj (i).value = "";
					textareaObj (i).focus();
					return false;
				}
			}
		}
		if (textareaObj (i).getAttribute("isdate") == "true") {
			if (textareaObj (i).value != "" && !checkdate(textareaObj (i).value)) {
				alert(strHint + "\u5fc5\u987b\u4e3a\u6b63\u786e\u7684\u65e5\u671f\u683c\u5f0f");
				textareaObj (i).focus();
				return false;
			}
		}
	}

	
	var selectObj = objfrm.getElementsByTagName("select");
	for (i = 0; i < selectObj.length; i++) {
		if (!selectObj(i).getAttribute("hint") || selectObj(i).getAttribute("hint") == "") {
			strHint = selectObj(i).name;
		} else {
			strHint = selectObj(i).getAttribute("hint");
		}
		if (selectObj(i).getAttribute("allownull") == "false") {
			if (selectObj(i).value == "") {
				alert("\u8BF7\u9009\u62E9"+strHint);
				selectObj(i).focus();
				return false;
			}
		}
	}
	return true;
}
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
function checkdate(str) {
	var reg = /^(\d+)-(\d{1,2})-(\d{1,2})$/;
	var r = str.match(reg);
	if (r == null) {
		return false;
	}
	r[2] = r[2] - 1;
	var d = new Date(r[1], r[2], r[3]);
	if (d.getFullYear() != r[1]) {
		return false;
	}
	if (d.getMonth() != r[2]) {
		return false;
	}
	if (d.getDate() != r[3]) {
		return false;
	}
	return true;
}
function getFileExtName(astr) { 
  // removes leading and trailing spaces, and returns the shortened string
	var resultStr = "";
	var i = 0;
	if (astr.length > 2) {
		for (i = astr.length - 1; i >= 0; i--) {
			if (astr.charAt(i) == ".") {
				resultStr = astr.substring(i + 1, astr.length);
				break;
			}
		}
	}
	return resultStr;
}
function getValue(formid) {
	var l = new Number();
	l = formid.elements.length;
	for (var i = 0; i < l; i++) {
		var tempid = new String();
		var temptype = new String();
		tempid = formid.elements[i].name;
		temptype = formid.elements[i].type;
		//alert(tempid);
		//alert(temptype);	
		if (temptype == "text" || temptype =="hidden") {
			if (formid.elements[i].value != null) {
				formid.elements[i].value = "";
			}
		} else {
			if (temptype == "select-one") {
				if (formid.elements[i].value != null) {
					formid.elements[i].value = "";
				}
			}
		}
	}
}
function clearFormValue(formid) {
	var l = new Number();
	l = formid.elements.length;
	for (var i = 0; i < l; i++) {
		var tempid = new String();
		var temptype = new String();
		tempid = formid.elements[i].name;
		temptype = formid.elements[i].type;
		tempquery= formid.elements[i].query;		
		if(tempquery=='Y'){
			if (temptype == "text" || temptype =="hidden") {
				if (formid.elements[i].value != null) {
					formid.elements[i].value = "";
				}
			} else {
				if (temptype == "select-one") {
					if (formid.elements[i].value != null) {
						formid.elements[i].value = "";
					}
				}
			}
		}
	}
}
function getElement(name) {
	var result = null;
	var objs = document.getElementsByName(name);
	if (objs) {
		var o = objs[0];
		result = o;
	}
	return result;
}
function getElementById(id) {
	var obj = document.getElementById(id);
	return obj;
}
function getRadioValue(radioname) {
	return getRadioObject(radioname).value;
}
function getRadioObject(radioname) {
	var object = "";
	var objs = document.getElementsByName(radioname);
	for (i = 0; i < objs.length; i++) {
		var o = objs[i];
		if (o.checked) {
			object = o;
		}
	}
	return object;
}
function checkRadioSelect(target) {
	if (checkBoxSelectCount(target) < 1) {
		alert("\u5fc5\u987b\u9009\u62e9\u4e00\u884c\uff01");
		return false;
	}else{
		return true;
	}
}
/***************************************************************************************************************************************************
/  @author songfy
 * cancel the operation of menu's popup,it's not use at present
*/
  function removeDiv(objLeft){
    if(objLeft!=null){
       var leftDocument = objLeft.frames[0].document;
       if(leftDocument!=null){
	       var bgDiv =  leftDocument.getElementById("bgDiv");
		    if(bgDiv!=null){
		       leftDocument.body.removeChild(bgDiv);
		    }
       }
    }
  }
/***************************************************************************************************************************************************
/  @author songfy
 * when onbur operation is invoke,check input value is repeat or not
*/  
	var testObject = new Object();
    testObject.strs=new Array(); //the "checkrepeat" 's array in "page input".
    testObject.object=null; //first object for check repeat.
    testObject.object1=null;//second object for check repeat.
    testObject._id=new Boolean(false);;//flag for first object.
    testObject._name=new Boolean(false);;//flag for second object.
    testObject.submitBotton=null;//control button disbaled or not.
/**
 * return the object of you operation
 * @param objectform : document.forms[0]
 * @param submitBotton :control button disbaled or not.
 */
function initCheckRepeat0(objectform,submitBotton){
	testObject.submitBotton = submitBotton;
	//alert(testObject.submitBotton);
    var inputObj = objectform.getElementsByTagName("input");
    for (i = 0; i < inputObj.length; i++) {
       if(inputObj[i].getAttribute("checkrepeat")){
             testObject.strs.push(inputObj[i].getAttribute("checkrepeat"));
          }
    }
	if(testObject.strs.length==0){
		return null;
	}
    if(testObject.strs.length>0){
	   testObject.object=document.getElementById(testObject.strs[0]);
	}
	return testObject.object;
}
/**
 * return the object of you operation
 * @param objectform : document.forms[0]
 */
function initCheckRepeat1(objectform){
   // alert(testObject.strs.length);
	if(testObject.strs.length==0||testObject.strs.length<2){
		return null;
	}
    if(testObject.strs.length>0){
	   testObject.object1=document.getElementById(testObject.strs[1]);
	}
	//alert(testObject.object1);
	return testObject.object1;
}
/**
 * show repeat info
 */
  function showCodeResult(b) {
  	//alert('');
     if(b){
       testObject._id=new Boolean(true);
       testObject.submitBotton.disabled=true;
       var span=document.createElement("span");
       span.setAttribute("id","repeatid");
       span.style.color="red";
	    var mes = document.createTextNode(testObject.object.getAttribute("hint")+"\u91cd\u590d");
	    span.appendChild(mes);
	    if(!document.getElementById("repeatid")){
	      insertAfter(span,testObject.object);
	    }
     }else{
     	testObject._id = new Boolean(false);
     	 if(testObject._name==false){
     	   testObject.submitBotton.disabled=false;
     	}
     	if(document.getElementById("repeatid")){
     	  var parent = testObject.object.parentNode;
     	  parent.removeChild(document.getElementById("repeatid"));
     	}
     }
    }
/**
 * show repeat info
 */
  function showNameResult(b) {
      if(b){
       testObject._name=new Boolean(true);
        testObject.submitBotton.disabled=true;
        var span1=document.createElement("span");
        span1.setAttribute("id","repeatid1");
        span1.style.color="red";
	    var mes1 = document.createTextNode(testObject.object1.getAttribute("hint")+"\u91cd\u590d");
	    span1.appendChild(mes1);
	    if(!document.getElementById("repeatid1")){
	      insertAfter(span1,testObject.object1);
	    }
     }else{
     	testObject._name = new Boolean(false);
     	if(testObject._id==false){
     	   testObject.submitBotton.disabled=false;
     	}
     	if(document.getElementById("repeatid1")){
     	  var parent1 = testObject.object1.parentNode;
     	  parent1.removeChild(document.getElementById("repeatid1"));
     	}
     }
    }
function  insertAfter(newElement,targetElement)
{
    var parent=targetElement.parentNode;
    if(parent.lastChild==targetElement){
        parent.appendChild(newElement);
    }else{
        parent.insertBefore(newElement,targetElement.nextSibling);
    }
}  
//***************************************************************************************************************************************************  
/* åè½ï¼å¤æ­å­æ®µå¼æ¯å¦ä¸ºç©º
 * åæ°ï¼field æè¦è¿è¡å¤æ­çå­æ®µ
 *       fieldName å­æ®µå
 * è¿åï¼true  å­æ®µå¼ä¸ºç©º
 *       false å­æ®µå¼ä¸ä¸ºç©º
 */
function isNull(field,fieldName)
{
	selected = 0;
	fieldIsNull = 0;
	if ( field.value == "" )
		fieldIsNull = 1;
	if ( fieldIsNull )
	{
		alert( fieldName + "ä¸è½ä¸ºç©º" );
		field.focus();
		return true;
	}
	return false;
}
/**
 *åè½ï¼å¤æ­å¼å§æ¥ææ¯å¦å°äºç»ææ¥æ
 *è¿åï¼ture å¼å§æ¥æå°äºç»ææ¥æ
 *	false å¼å§æ¥æä¸å°äºç»ææ¥æ
 */
function isLate (begin_field,begin_fieldname, end_field, end_fieldname)
{
	if(begin_field.value>end_field.value){
		alert(begin_fieldname+" ä¸è½æ©äº "+end_fieldname+"!");
		return true;
	}
	return false;
}
/**
 * åºåº,éç½®éæåæäº¤åæ ¡éª
 */
function integrationSubmit(){
	var  a = document.getElementsByName('selectIDS');
	for(var i=0; i<a.length; i++) {
		if(a[i].checked && a[i].integrationMemo != 'success' ){
		a[i].focus();
			alert('éè´§ä¸æå');
			return false;
		} 
	}
	return true;
}
  
  

/**
 * serviceproperty not null check
 * æå®idéç©ºæ ¡éª
 */
function checkNotNull(id) {
	var obj = document.getElementById(id);
	var strHint; 
	if (!obj.getAttribute("hint") || obj.getAttribute("hint") == "") {
		strHint = obj.name;
	} else {
		strHint = obj.getAttribute("hint");
	}
	
	if (obj.value == "" || obj.value == null) {
		alert(strHint + "\u4e0d\u80fd\u4e3a\u7a7a");
		obj.focus();
		return false;
	}
	return true;
}
/**
 * åè½æè¿°ï¼éæ©æ¶è´§åæç»çæå¥åºåæ¶å¯¹æ°æ®è¿è¡æ ¡éªã
 * æ ¡éªåå®¹ï¼å¥½åãæ°æ§ãè´§ä½ãåºåå·ãæ°éä¸è½ä¸ºç©ºã
 */
function receiveSubmitCheck(idName,checkNumOrNot){
	var  ids = document.getElementsByName(idName);
	var  scmRcvdNumbers = document.getElementsByName('scmRcvdNumbers');
	var  goodBads = document.getElementsByName('goodBads');
	var  newOlds = document.getElementsByName('newOlds');
	var  scmRcvdBinlocations = document.getElementsByName('scmRcvdBinlocations');
	var  scmRcvdSns = document.getElementsByName('scmRcvdSns');
	var  idsForCheck = document.getElementsByName('hiddenIdsForCheck');
	for(var j = 0 ; j < ids.length ; j++) {
		if(ids[j].checked){
			for(var i = 0 ; i < idsForCheck.length ; i++){
				if(ids[j].value == idsForCheck[i].value){
					if(checkNumOrNot){
						if(scmRcvdNumbers[i].value == null || scmRcvdNumbers[i].value == ''){
							scmRcvdNumbers[i].focus();
							alert('è¯·è¡¥å¨æ¬æ¬¡æ°é');
							return false;
						}
					}
					if(goodBads[i].value == null || goodBads[i].value == ''){
						goodBads[i].focus();
						alert('è¯·è¡¥å¨å¥½åä¿¡æ¯');
						return false;
					}
					if(newOlds[i].value == null || newOlds[i].value == ''){
						newOlds[i].focus();
						alert('è¯·è¡¥å¨æ°æ§ä¿¡æ¯');
						return false;
					}
					if(scmRcvdBinlocations[i].value == null || scmRcvdBinlocations[i].value == ''){
						scmRcvdBinlocations[i].focus();
						alert('è¯·è¡¥å¨è´§ä½ä¿¡æ¯');
						return false;
					}
					if(scmRcvdSns[i].value == null || scmRcvdSns[i].value == ''){
						scmRcvdSns[i].focus();
						alert('è¯·è¡¥å¨åºåå·');
						return false;
					}
				}
			}
			
		} 
	}
	return true;
}

/**
 * åºåæå°
 */
function preview() { 
	bdhtml=window.document.body.innerHTML; 
	sprnstr="<!--startprint-->"; 
	eprnstr="<!--endprint-->"; 
	prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); 
	prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); 
	window.document.body.innerHTML=prnhtml; 
	window.print(); 
}
function changeTaboption(number,index,allIndex){
  if(number < index){
  	for (var i = 1; i <= number; i++) {
      document.getElementById('current' + i).className = '';
      document.getElementById('content' + i).style.display = 'block';
 	 }
 	 document.getElementById('current' + index).className = 'current';
  }else{
	  for (var i = 1; i <= number; i++) {
	      document.getElementById('current' + i).className = '';
	      document.getElementById('content' + i).style.display = 'none';
	  }
	  if(allIndex != null && allIndex != ''){
	  	document.getElementById('current' + allIndex).className = '';
	  }
	  document.getElementById('current' + index).className = 'current';
	  document.getElementById('content' + index).style.display = 'block';
  }
}

//id:标签id,lenth:限制的长度,p:显示错误信息的位置id
function checklength(id,lenth,p)
{
	if(document.getElementById(id).value.length>lenth)
	{
		document.getElementById(p).innerHTML="<em style=\"color:#F03F14;\">超"+lenth+"字了</em>";
		return false;
	}else
	{
		document.getElementById(p).innerHTML="";
	}
}
//id:标签id,lenth:限制的长度,p:显示错误信息的位置id
function checklength2(id,lenth,p)
{

	if(document.getElementById(id).value.length>lenth)
	{
	    document.getElementById(p).focus();
		document.getElementById(p).innerHTML="<em style=\"color:#F03F14;\">超"+lenth+"字了</em>";
		return false;
	}else
	{
		document.getElementById(p).innerHTML="请控制在"+lenth+"字以内";
	}
}
function showcontent(entityName,entityPk,i){
				var id=entityName+entityPk;
				if(i==1){
					document.getElementById(id).style.display="block";
					return false;
				}else{
					document.getElementById(id).style.display="none";
					return false;
				}
}
function SetFormActionConfirmWithoutCheck(form, opType,para) {
	var objForm = document.forms[form];
	var objLen = objForm.length;
	var checkedFlag = false;
	if (window.confirm("\u662f\u5426\u7ee7\u7eed")) {
		//var objForm = document.forms[form];
		var url  =objForm.action
		url=url+"?method="+opType;
		if(para!=""&&typeof(para)!='undefined'){
				url=url+"&"+para
		}	
		objForm.action=url;
		if ((opType.indexOf("cance") > -1) || (opType.indexOf("bac") > -1) || (opType.indexOf("lis") > -1) || (opType.indexOf("del") > -1) || (opType.indexOf("return") > -1) || (opType.indexOf("gotoEdit") > -1) || (opType.indexOf("refresh") > -1) ||(opType.indexOf("examine") > -1)) {
			objForm.submit();
		} else {
			if (checkOwnRule(objForm)) {
				objForm.submit();
			}
		}
	}
}
function showmore(id,i){
	if(i==1){
		document.getElementById(id).style.display="block";
		return false;
	}else{
		document.getElementById(id).style.display="none";
		return false;
	}
}

function maxLength(field,maxChars)
 {
       if(field.value.length >= maxChars) {
          event.returnValue=false;
          return false;
       }
 }  

 function maxLengthPaste(field,maxChars)
 {
       event.returnValue=false;
       if((field.value.length +  window.clipboardData.getData("Text").length) > maxChars) {
         return false;
       }
       event.returnValue=true;
 }
var  bval;
function loading() {
			try {
				bval.remove(); 
				bval='';
			}catch(e){
			  bval=getBusyOverlay('viewport',{color:'green',text:'Loading...',opacity:0.25});
			}
}
function highlightTableRows(tableId,i) {   
	    var previousClass = null;   
	    var table = document.getElementById(tableId);    
	    var tbody = table.getElementsByTagName("tbody")[i];  
	    if (tbody == null) {  
	        var rows = table.getElementsByTagName("tr");   
	    } else {   
	        var rows = tbody.getElementsByTagName("tr");   
	    }   
	    for (i=0; i < rows.length; i++) {  
	        rows[i].onmouseover = function(){ previousClass=this.className;this.className ='diaplayover' };   
	        rows[i].onmouseout = function(){ this.className=previousClass };   
	    }   
}
function len(s) {
	 var l = 0;
	 var a = s.split("");
	 for (var i=0;i<a.length;i++) {
		  if (a[i].charCodeAt(0)<299) {
		   l++;
		  }else {
		   l+=2;
		  }
	 }
	 return l;
}   