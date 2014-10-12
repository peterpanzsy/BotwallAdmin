package cn.edu.xjtu.manage.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LowestMBAction extends ActionSupport {
	String msg;
	
	String lowestMB;
	String result;
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getLowestMB() {
		return lowestMB;
	}
	public void setLowestMB(String lowestMB) {
		this.lowestMB = lowestMB;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	public String execute() {
		System.out.println("---"+lowestMB);
		try {
			//Runtime.getRuntime().exec("/botwall/script/auto_upload "+ lowestMB +" );
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
