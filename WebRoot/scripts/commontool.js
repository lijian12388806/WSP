$(document).ready(
	function() {   
	    $("#IDS").click(function() {   
	        var flag = $(this).attr("checked");   
	        $("[name=selectIDS]:checkbox").each(function() {   
	            $(this).attr("checked", flag);   
	        })   
	    })   
	}
);
function refreshMenupath(menuPath){
	window.parent.document.getElementById('menuPath').innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+menuPath;
}

//清除信息 id以clean开头即可
function cleanValue(){
var arr=new Array();
$("input[id*='cleanpro']").each(function(){
   $(this).val('');
});
}
/**
 * th 标题列 属性title不为空时视为导出项
 * td 列值 属性eee为excel时视为导出项
 * 
 * 
 */
function getThValueByTable(){
	var tbl_count = $(".table thead tr:first");
	var tr_info = tbl_count.eq(0);
	var str = "";
	tr_info.find("th").each(function(){ 
		if(this.title != null && this.title != "" && typeof(this.title) != "undefined"){
		str+=this.title+",";
		}
		 });
	return str;
}

function getThValue(){
	var str="";
	$("th").each(function(){ 
    if(this.title != null && this.title != "" && typeof(this.title) != "undefined"){
    	str+=this.title+",";
    }
    });
    return str;
}
//获得td的text值 需要设置tr的class属性为commonexcel
function getTdValue(){
	var str = "";
	$('.customexcel').each(function(){
$(this).children().each(function(){
	if($(this).attr('eee') == 'excel'){
		str+=trim($(this).text())+',';
	}
})
str+=';';
});
return str;
}