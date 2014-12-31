package cn.edu.xjtu.manage.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DetectionBehaviorAction extends ActionSupport {
	
	String msg;
	
	String result;
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	//检验证书的合法性
	public String checkLicence(){
		try {
			Runtime.getRuntime().exec("java -jar /botwall/java/checkLicence.jar" );
			ActionContext.getContext().getApplication().put("isCheckLicenceStart",true);
			result="success";
			msg="配置成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg="配置失败";
		}
		return "SUCCESS";
	}
	//检测恶意行为
	public String attackEvent(){
		try {
			Runtime.getRuntime().exec("cd /botwall/java/;java -jar AttackEvent.jar" );
			ActionContext.getContext().getApplication().put("isAttackEventStart",true);
			result="success";
			msg="配置成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg="配置失败";
		}
		return "SUCCESS";
	}
	//检测IRC僵尸网络
	public String findBotnet(){
		try {
			Runtime.getRuntime().exec("java -jar /botwall/java/findBotnet.jar" );
			ActionContext.getContext().getApplication().put("isFindBotnetStart",true);
			result="success";
			msg="配置成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg="配置失败";
		}
		return "SUCCESS";
	}
	//检测协同僵尸网络
	public String detectionCobehave(){
		try {
			Runtime.getRuntime().exec("java -jar /botwall/java/DetectionCobehave.jar" );
			ActionContext.getContext().getApplication().put("isDetectionCobehaveStart",true);
			result="success";
			msg="配置成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg="配置失败";
		}
		return "SUCCESS";
	}
	
}
