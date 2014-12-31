package cn.edu.xjtu.manage.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.edu.xjtu.manage.service.HoneyFunctionService;
import cn.edu.xjtu.manage.service.LowestMBService;
import cn.edu.xjtu.tools.JavaShellUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ControlAction  extends ActionSupport{


	String re;
	String pid;
	String exeResult;
	
	public void setExeResult(String exeResult) {
		this.exeResult = exeResult;
	}
	public String getExeResult() {
		return exeResult;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getRe() {
		return re;
	}

	private Object[] rowData;
	public Object[] getRowData() {
		return rowData;
	}
	public void setRowData(Object[] rowData) {
		this.rowData = rowData;
	}
	
	public String execute(){
	
		return "SUCCESS";
	}
	
	public String restart(){
		try {
//			int res=JavaShellUtil.executeShell("/botwall/script/control restart");
		/*	String[] cmd1 = new String[]{"/bin/sh","-c","cd","/botwall/script/"};
			Process p1=Runtime.getRuntime().exec(cmd1);
			BufferedReader br1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			*/
//			String[] cmd = new String[]{"/bin/sh","-c","/botwall/script/controlRight.sh"};
			//Process p=Runtime.getRuntime().exec("sh /botwall/script/controlRight.sh");
			/*BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			StringBuffer sb = new StringBuffer();
			String line;
		
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			exeResult = sb.toString();
			System.out.println(exeResult);	*/		
			//pid=p.toString();
			systemRestart();
			System.out.println("control restart");
	/*		try{
	            if(p.waitFor() == 0){  //其中p.waitFor()语句用来等待子进程结束，其返回值为进程结束退出码。
	                System.out.println("controlRestart result is OK!");
	            }else{
	                System.out.println("controlRestart result is fail......");
	            }
	        }catch(InterruptedException e){
	            System.err.println("processes was interrupted");
	        }
	        int ret =p.exitValue();
	        System.out.println(ret);*/
			re="success";	
		} catch (Exception e) {
			e.printStackTrace();
			exeResult=e.toString();
			re="failure";
		}
		return "SUCCESS"; 
	}
	private void systemRestart() throws IOException {
		//停止所有的服务 wangdi
		 Runtime.getRuntime().exec("/botwall/script/stopAll");
		//重新开启
		if((Boolean)ActionContext.getContext().getApplication().get("isHoneyFuntionStart")){
			String email = (String)ActionContext.getContext().getApplication().get("globalEmail");
			String honeyTime = (String)ActionContext.getContext().getApplication().get("globalHoneyTime");
			int minute = Integer.parseInt(honeyTime);
			HoneyFunctionService.getInstance(email, minute);
		};
		if((Boolean)ActionContext.getContext().getApplication().get("isRateLimitedStart")){
			String uploadRate = (String)ActionContext.getContext().getApplication().get("globalUploadRate");
			String downloadRate = (String)ActionContext.getContext().getApplication().get("globalDownloadRate");
			Runtime.getRuntime().exec(new StringBuffer("/botwall/script/wshaper ")
				.append(uploadRate).append(" ").append(downloadRate).append(" ").toString());
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isSessionLimitedStart")){
			String IPNum = (String) ActionContext.getContext().getApplication().get("IPNum");
			String TCPNum = (String) ActionContext.getContext().getApplication().get("TCPNum");
			String ICMPRateNum = (String) ActionContext.getContext().getApplication().get("ICMPRateNum");
			String TCPRateNum = (String) ActionContext.getContext().getApplication().get("TCPRateNum");
			//wangdi注释
			//ActionContext.getContext().getApplication().put("TCPRateNum","");
			Runtime.getRuntime().exec("/botwall/script/limit start eth0 "+IPNum+" "+TCPNum+" "+ICMPRateNum+" "+TCPRateNum);
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isLowestMBStart")){
			String temp = (String)ActionContext.getContext().getApplication().get("globalLowestMB");
			String tempEmail = (String)ActionContext.getContext().getApplication().get("globalLowestMBEmail");
			int lowestMB = Integer.parseInt(temp);
			LowestMBService.getInstance(lowestMB,tempEmail);
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isPacp_captureStart")){
			Runtime.getRuntime().exec("/botwall/script/pacp_capture start" );
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isBridgeStart")){
			Runtime.getRuntime().exec("/botwall/script/bridge start" );
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isAttackEventStart")){
			Runtime.getRuntime().exec("java -jar /botwall/java/AttackEvent.jar" );
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isFindBotnetStart")){
			Runtime.getRuntime().exec("java -jar /botwall/java/findBotnet.jar" );
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isCheckLicenceStart")){
			Runtime.getRuntime().exec("java -jar /botwall/java/checkLicense.jar" );
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isDetectionCobehaveStart")){
			Runtime.getRuntime().exec("java -jar /botwall/java/DetectionCobehave.jar" );
		}
	}
	
	
}
