$(function(){
	var $img=$("#img");
	var $id=$("#id");
	$img.click(function(){
		$.ajax({
			type:"post",
			url:"updateStatusManager.action",
			data:{pushinfoRecordKey:$id.val()},
			dataType:"text",
			success:function(data){
					 
			}	
		});	
	});
});