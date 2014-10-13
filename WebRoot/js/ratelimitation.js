
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

function session(id){
	var IPNum = $("#IPNum").val();
	var TCPNum = $("#TCPNum").val();
	var ICMPRateNum = $("#ICMPRateNum").val();
	var TCPRateNum = $("#TCPRateNum").val();
	var ids = id.split("_");
	var action ="sessionLimit_"+ids[1]+".action";
	//验证，正整数小于5
	var reg = new RegExp("^[1-5]*$");
//	if(!reg.test(sessionNum)){
//       alert("请输入正确的数字，1-5!");
//    }else{
		 $.ajax({
		 url : action,
		 type : "post",
         dataType : "json",
         data : {
		 	"IPNum" : IPNum,
			"TCPNum" : TCPNum,
			"ICMPRateNum" : ICMPRateNum,
			"TCPRateNum" : TCPRateNum
         },
		 success : function(data) {
				if(data.result=="success"){
					alert("启动限制会话数，使用默认网口eth1成功！");
				}else if(data.result == "error"){
					alert("输入有误");
				}else{
					alert("配置失败！");
				}								
			},
			error:function(msg){
				alert("通讯错误，更新失败！！");						
			}
		});
	//}
};

function lowestMBSubmit(){
	var lowestMB = $("#lowestMB").val();
	//TODO 缺验证，不知道max和min
	//TODO 为什么这个地方会有问题，在后台显示lowestMB为null，我就奇了怪了
	//myAJAX("lowestMB.action","{'lowestMB':"+lowestMB+"}");
	$.ajax({
		 url : "lowestMB.action",
		 type : "post",
         dataType : "json",
         data : {
		 	"lowestMB" : lowestMB
		 },
		 success : function(data) {
				if(data.result=="success"){
					alert("配置成功");
				}else{
					alert("配置失败");
				}						
			},
			error:function(msg){
				alert("通讯错误，更新失败！！");						
			}
		});
};

function bridge(id){
	var ids = id.split("_");
	var action = "bridge_"+ids[1]+".action";
	myAJAX(action,null);
}

function pacp_capture(id){
	var ids = id.split("-");
	var action = "pacp_capture_"+ids[1]+".action";
	myAJAX(action,null);
};

function detectionBehavior(id){
	var	action = "detectionBehavior_"+id+".action"; 
	myAJAX(action,null);
};

function myAJAX(action,myData){
	$.ajax({
	 url : action,
	 type : "post",
     dataType : "json",
     data : myData,
	 success : function(data) {
			if(data.result=="success"){
				alert(data.msg);
			}else{
				alert(data.msg);
			}						
		},
		error:function(obj){
			alert("通讯错误，更新失败！！");						
		}
	});
};

/*function getData(){
	$.ajax({
	 url : "getDataAction",
	 type : "post",
     dataType : "json",
     data : null,
	 success : function(data) {
			if(data.globalUploadRate!=null){
				$("#uploadRate").val()=data.globalUploadRate;
			}
			if(data.globalUploadRate!=null){
				$("#downloadRate").val()=data.globalDownloadRate;
			}				
		},
		error:function(obj){
			alert("通讯错误，更新失败！！");						
		}
	});
};*/

