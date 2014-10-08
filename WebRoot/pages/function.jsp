<%@ page language="java" import="java.util.*,cn.edu.xjtu.manage.business.*" pageEncoding="UTF-8"%>
<div class="accordion" id="accordion-684299">
	<div class="accordion-group">
		<div class="accordion-heading">
			 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-684299" href="#accordion-element-341857">蜜网监视功能</a>
		</div>
		<div id="accordion-element-341857" class="accordion-body in collapse">
			<div class="accordion-inner">
				功能块...
			</div>
		</div>
	</div>
	<div class="accordion-group">
		<div class="accordion-heading">
			 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-684299" href="#accordion-element-681579">数据包速率限制</a>
		</div>
		<div id="accordion-element-681579" class="accordion-body collapse">
			<div class="span4 accordion-inner todo mrm" style="border:2px solid;border-radius:25px;padding:10px;">
				<div>
					<label for="upload_rate">上传速率限制（kpbs）</label><input type="text" id="upload_rate"/>
				</div>
				<div>
					<label for="download_rate">下载速率限制（kpbs）</label><input type="text" id="download_rate" class="span3">
				</div>
				<div>
				<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-primary">启动速率限制</a>
        		</div>	
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-danger">停止速率限制</a>
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
					<label for="session_num">会话个数  &nbsp;</label><input type="text" id="session_num"/>
				</div>
				<div>
				<div class="span3" style="width:300px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-primary">启动限制会话数，使用默认网口eth1</a>
        		</div>	
        		<div class="span3" style="width:300px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-primary">启动限制会话数, 使用指定网口eth0</a>
        		</div>	
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-danger">取消限制会话数</a>
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
					<label for="lowestMB">文件自动上传下限容量（MB）</label><input type="text" id="lowestMB"/>
				</div>
				<div>
				<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-primary">配置生效</a>
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
          			<a href="#" class="btn btn-large btn-block btn-primary">开启网桥</a>
        		</div>
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-danger">停止网桥</a>
        		</div>
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-warning">重启网桥</a>
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
          			<a href="#" class="btn btn-large btn-block btn-primary">开始截获流量，默认网口eth0</a>
        		</div>
        		<div class="span3" style="width:300px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-primary">开始截获流量，指定网口eth1</a>
        		</div>
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-danger">停止截获流量</a>
        		</div>
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-warning">重新开始截获流量</a>
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
          			<a href="#" class="btn btn-large btn-block btn-danger">检测证书合法性</a>
        		</div>
				<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-primary">检测恶意行为</a>
        		</div>
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-primary">检测IRC僵尸网络</a>
        		</div>
        		<div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
          			<a href="#" class="btn btn-large btn-block btn-primary">检测协同僵尸网络</a>
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