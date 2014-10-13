package cn.edu.xjtu.manage.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.Action;
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
	public String checkLicence(){
		try {
			Runtime.getRuntime().exec("java -jar /botwall/java/checkLicence.jar" );
			result="success";
			msg="配置成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg="配置失败";
		}
		return "SUCCESS";
	}
	
	public String attackEvent(){
		try {
			Runtime.getRuntime().exec("java -jar /botwall/java/AttackEvent.jar" );
			result="success";
			msg="配置成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg="配置失败";
		}
		return "SUCCESS";
	}
	public String findBotnet(){
		try {
			Runtime.getRuntime().exec("java -jar /botwall/java/findBotnet.jar" );
			result="success";
			msg="配置成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg="配置失败";
		}
		return "SUCCESS";
	}
	public String detectionCobehave(){
		try {
			Runtime.getRuntime().exec("java -jar /botwall/java/DetectionCobehave.jar" );
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
