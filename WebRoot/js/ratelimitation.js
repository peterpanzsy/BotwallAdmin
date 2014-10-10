
function rateLimitationSubmit(){
	var uploadRate = $("#uploadRate").val();
	var downloadRate = $("#downloadRate").val();
	//TODO 缺验证，具体不是很清楚
	 $.ajax({
         url : "rateLimitation_rateLimitStart.action",
         type : "post",
         dataType : "json",
         data : {
        	 "uploadRate":uploadRate,
        	 "downloadRate":downloadRate
         },
         success : function(data) {
				if(data.result=="success"){
					alert("更新成功！");
				}else{
					alert("更新失败！");
				}							
			},
			error:function(msg){
				alert("通讯错误，更新失败！！");						
			}
		});
};

function rateLimitationStop(){
	$.ajax({
		 url : "rateLimitation_rateStop.action",
		 type : "post",
         dataType : "json",
         data : null,
         success : function(data) {
				if(data.result=="success"){
					alert("停止速率限制成功！");
				}else{
					alert("停止速率限制失败！");
				}							
			},
			error:function(msg){
				alert("通讯错误，更新失败！！");						
			}
		});
};


