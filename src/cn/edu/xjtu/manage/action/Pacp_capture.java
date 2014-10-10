package cn.edu.xjtu.manage.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class Pacp_capture extends ActionSupport {
	//用于返回信息
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
		System.out.println("start");
		try {
			//Runtime.getRuntime().exec("/botwall/script/pacp_capture start" );
			result="success";
			msg ="开始截获流量成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg ="开始截获流量失败";
		}
		return "SUCCESS";
	}

	public String start1() {
		System.out.println("start1");
		try {
			//Runtime.getRuntime().exec("/botwall/script/pacp_capture start eth1" );
			result="success";
			msg ="开始截获流量，默认网口eth0成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg ="开始截获流量失败";
		}
		return "SUCCESS";
	}
	
	public String restart() {
		System.out.println("restart");
		try {
			//Runtime.getRuntime().exec("/botwall/script/pacp_capture restart");
			result="success";
			msg ="重新开始截获流量成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg ="重新开始截获流量失败";
		}
		return "SUCCESS";
	}
	
	public String stop() {
		System.out.println("stop");
		try {
			//Runtime.getRuntime().exec("/botwall/script/pacp_capture stop" );
			result="success";
			msg ="停止截获流量成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg ="停止截获流量失败";
		}
		return "SUCCESS";
	}
	
}
