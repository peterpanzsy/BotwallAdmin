<%@ page language="java" import="java.util.*,cn.edu.xjtu.manage.business.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!-- 暂时先加到这里了 -->
<script type="text/javascript" src="js/ratelimitation.js"></script>

<div class="accordion" id="accordion-684299">
	<div class="accordion-group">
		<div class="accordion-heading">
			 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-684299" href="#accordion-element-341857">蜜网监视功能</a>
		</div>
		<div id="accordion-element-341857" class="accordion-body in collapse">
			<div class="accordion-inner">
				<label for="honeyEmail">管理员邮箱</label><input type="text" name=honeyPotEmail id=honeyPotEmail value="${globalEmail}" class="span3"><br/>
				<label for="honeyTime">每隔XX分钟调用</label><input type="text" name=honeyPotTime id=honeyPotTime value="${globalHoneyTime}" class="span3"><br/>
			</div>
			<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a onclick="honeyPot()" class="btn btn-large btn-block btn-danger">开启蜜网监控</a>
          			<a onclick="honeyPotTimeChange()" class="btn btn-large btn-block btn-danger">修改间隔时间</a>
       		</div>
		</div>
	</div>
	<div class="accordion-group">
		<div class="accordion-heading">
			 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-684299" href="#accordion-element-681579">数据包速率限制</a>
		</div>
		<div id="accordion-element-681579" class="accordion-body collapse">
			<div class="span4 accordion-inner todo mrm" style="border:2px solid;border-radius:25px;padding:10px;">
				<form id="rateLimitationForm" action="rateLimitation.action" method="post"> 
					<div>
						<label for="upload_rate">上传速率限制（kpbs）</label><input name=uploadRate type="text" id="uploadRate" value="${globalUploadRate}"/>
					</div>
					<div>
						<label for="download_rate">下载速率限制（kpbs）</label><input type="text" name=downloadRate id="downloadRate" value="${globalDownloadRate}" class="span3">
					</div>
				</form>
				<div>
				<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a onclick="rateLimitationSubmit()" class="btn btn-large btn-block btn-primary">启动速率限制</a>
        		</div>	
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a onclick="rateLimitationStop()" class="btn btn-large btn-block btn-danger">停止速率限制</a>
        		</div>	
        		</div>		
			</div>
		</div>
	</div>
	<div class="accordion-group">
		<div class="accordion-heading">
			 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-684299" href="#accordion-element-3">IP并发会话数</a>
		</div>
		<div id="accordion-element-3" class="accordion-body collapse">
			<div class="span4 accordion-inner todo mrm" style="border:2px solid;border-radius:25px;padding:10px;">
				<div>
					<label for="session_num">IP会话数  &nbsp;</label><input type="text" id="IPNum" value="${IPNum}"/><br/>
					<label for="session_num">TCP会话数  &nbsp;</label><input type="text" id="TCPNum" value="${TCPNum}"/><br/>
					<label for="session_num">ICMP发包速率(个/s)  &nbsp;</label><input type="text" id="ICMPRateNum" value="${ICMPRateNum}"/><br/>
					<label for="session_num">TCP发包速率(个/s)  &nbsp;</label><input type="text" id="TCPRateNum" value="${TCPRateNum}"/>
				</div>
				<div>
				<div class="span3" style="width:300px;margin-top:10px;margin-left:5px;">
          			<a onclick="session(this.id)" id="session_start1" class="btn btn-large btn-block btn-primary">启动限制会话数，使用默认网口eth0</a>
        		</div>	
        		<!-- 
        		<div class="span3" style="width:300px;margin-top:10px;margin-left:5px;">
          			<a onclick="session(this.id)" id="session_start0" class="btn btn-large btn-block btn-primary">启动限制会话数, 使用指定网口eth0</a>
        		</div>	
        		 -->
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a onclick="session(this.id)" id="session_unlimited" class="btn btn-large btn-block btn-danger">取消限制会话数</a>
        		</div>	
        		</div>		
			</div>
		</div>
	</div>
	<div class="accordion-group">
		<div class="accordion-heading">
			 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-684299" href="#accordion-element-4">数据包上传</a>
		</div>
		<div id="accordion-element-4" class="accordion-body collapse">
			<div class="span4 accordion-inner todo mrm" style="border:2px solid;border-radius:25px;padding:10px;">
				<div>
					<label for="lowestMB">文件自动上传下限容量（MB）</label><input type="text" id="lowestMB" value="${globalLowestMB}"/>
				</div>
				<div>
				<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a onclick="lowestMBSubmit()" class="btn btn-large btn-block btn-primary">配置生效</a>
        		</div>		
        		</div>		
			</div>
		</div>
	</div>
	<div class="accordion-group">
		<div class="accordion-heading">
			 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-684299" href="#accordion-element-5">搭建网桥</a>
		</div>
		<div id="accordion-element-5" class="accordion-body collapse">
			<div class="span4 accordion-inner todo mrm" style="border:2px solid;border-radius:25px;padding:10px;">
				<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a onclick="bridge(this.id)" id="bridge_start" class="btn btn-large btn-block btn-primary">开启网桥</a>
        		</div>
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a onclick="bridge(this.id)" id="bridge_stop" class="btn btn-large btn-block btn-danger">停止网桥</a>
        		</div>
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a onclick="bridge(this.id)" id="bridge_restart" class="btn btn-large btn-block btn-warning">重启网桥</a>
        		</div>		       	
			</div>
		</div>
	</div>
	<div class="accordion-group">
		<div class="accordion-heading">
			 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-684299" href="#accordion-element-6">捕获流量</a>
		</div>
		<div id="accordion-element-6" class="accordion-body collapse">
			<div class="span4 accordion-inner todo mrm" style="border:2px solid;border-radius:25px;padding:10px;">
				<div class="span3" style="width:300px;margin-top:10px;margin-left:5px;">
          			<a onclick="pacp_capture(this.id)" id="pacpCapture-start" class="btn btn-large btn-block btn-primary">开始截获流量，默认网口eth0</a>
        		</div>
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a onclick="pacp_capture(this.id)" id="pacpCapture-stop" class="btn btn-large btn-block btn-danger">停止截获流量</a>
        		</div>
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a onclick="pacp_capture(this.id)" id="pacpCapture-restart" class="btn btn-large btn-block btn-warning">重新开始截获流量</a>
        		</div>		       	
			</div>
		</div>
	</div>
		<div class="accordion-group">
		<div class="accordion-heading">
			 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-684299" href="#accordion-element-7">检测行为</a>
		</div>
		<div id="accordion-element-7" class="accordion-body collapse">
			<div class="span4 accordion-inner todo mrm" style="border:2px solid;border-radius:25px;padding:10px;">
				<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a id="checkLicence" onclick="detectionBehavior(this.id)" class="btn btn-large btn-block btn-danger">检测证书合法性</a>
        		</div>
				<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a id="attackEvent" onclick="detectionBehavior(this.id)" class="btn btn-large btn-block btn-primary">检测恶意行为</a>
        		</div>
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a id="findBotnet" onclick="detectionBehavior(this.id)" class="btn btn-large btn-block btn-primary">检测IRC僵尸网络</a>
        		</div>
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a id="detectionCobehave" onclick="detectionBehavior(this.id,null)" class="btn btn-large btn-block btn-primary">检测协同僵尸网络</a>
        		</div>		       	
			</div>
		</div>
	</div>
	
</div>
<script>

$(".accordion-inner").each(function(){
	if($(this).find("input")!=null){
		$(this).css({
			"width":'50%'	
		});
	}else{
		$(this).css({
			"width":'30%'	
		});
	}
});

</script>