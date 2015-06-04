$(doucment).ready(function(){
	alert($hour.val());
		$.ajax({
			url:'hourSelect.action',
			type:'post',
			dataType:'xml',
			success:function(data){
			$(data).find('name').each(function(){
			var value=$(this).attr('value');
			var text=$(this).text();
			$("#selectHour").append("<option value='"+value+"'>"+text+"</option>");
			})
		}
		})
	})