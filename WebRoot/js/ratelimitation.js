
function rateLimitationSubmit(){
	var uploadRate = $("#uploadRate").val();
	var downloadRate = $("#downloadRate").val();
	if(check_Integer(uploadRate)&&check_Integer(downloadRate)){
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
	}else{
		alert("请输入数字!");  
	}
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
	if(check_Integer(IPNum)&&check_Integer(TCPNum)&&check_Integer(ICMPRateNum)&&check_Integer(TCPRateNum)){
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
	}else{
		alert("输入有误，请重新输入");
	}
};

function lowestMBSubmit(){
	var lowestMB = $("#lowestMB").val();
	var lowestMBEmail = $("#lowestMBEmail").val();
	//TODO 为什么这个地方会有问题，在后台显示lowestMB为null，我就奇了怪了
	//myAJAX("lowestMB.action","{'lowestMB':"+lowestMB+"}");
	if(check_Integer(lowestMB)&&check_Email(lowestMBEmail)){
		$.ajax({
		 url : "lowestMB.action",
		 type : "post",
         dataType : "json",
         data : {
		 	"lowestMB" : lowestMB,
		 	"lowestMBEmail":lowestMBEmail
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
	}else{
		alert("输入有误");
	}
	
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

function honeyPot(){
	var email = $("#honeyPotEmail").val();
	var honeyTime =$("#honeyPotTime").val();
	if(check_Integer(honeyTime)&&check_Email(email)){
		$.ajax({
		 url : "honeyFunction_start.action",
		 type : "post",
	     dataType : "json",
	     data : {
		 	"email":email,
			"honeyTime":honeyTime
		 },
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
	}else{
		alert("输入有误");
	}
	
};

function honeyPotTimeChange(){
	var honeyTime =$("#honeyPotTime").val();
	if(check_Integer(honeyTime)){
		$.ajax({
		 url : "honeyFunction_setTime.action",
		 type : "post",
	     dataType : "json",
	     data : {
			"honeyTime":honeyTime
		 },
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
	}else{
		alert("输入有误");
	}
	
};
//验证数字
function check_Integer(obj){
    //定义正则表达式部分
	 var Expression= /^\d+$/;  
    var reg=new RegExp(Expression);
    if(!reg.test(obj)){ 
	    return false;
    }else{
		return true;  
	}
}
//验证邮箱
function check_Email(obj){
    //定义正则表达式部分
	 var Expression= /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;  
    var reg=new RegExp(Expression);
    if(!reg.test(obj)){ 
	    return false;
    }else{
		return true;  
	}
}
