package cn.edu.xjtu.manage.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class BridgeSetAction extends ActionSupport {
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
	
	
	public String start() {
		try {
			Runtime.getRuntime().exec("/botwall/script/bridge start" );
			result="success";
			msg = "开启网桥成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg = "开启网桥失败";
		}
		return "SUCCESS";
	}
	
	public String restart() {
		try {
			Runtime.getRuntime().exec("/botwall/script/bridge restart");
			result="success";
			msg = "重启网桥成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg = "重启网桥失败";
		}
		return "SUCCESS";
	}
	
	public String stop() {
		try {
			Runtime.getRuntime().exec("/botwall/script/bridge stop" );
			result="success";
			msg = "停止网桥成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg = "停止网桥失败";
		}
		return "SUCCESS";
	}
	
}
