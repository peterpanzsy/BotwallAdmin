package cn.edu.xjtu.manage.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Pacp_captureAction extends ActionSupport {
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
		try {
			Runtime.getRuntime().exec("/botwall/script/pacp_capture start" );
			ActionContext.getContext().getApplication().put("isPacp_captureStart", true);
			result="success";
			msg ="开始截获流量成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg ="开始截获流量失败";
		}
		return "SUCCESS";
	}

/*	不需要了
 * 	public String start1() {
		try {
			Runtime.getRuntime().exec("/botwall/script/pacp_capture start eth1" );
			result="success";
			msg ="开始截获流量，默认网口eth0成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg ="开始截获流量失败";
		}
		return "SUCCESS";
	}*/
	
	public String restart() {
		try {
			Runtime.getRuntime().exec("/botwall/script/pacp_capture restart");
			result="success";
			ActionContext.getContext().getApplication().put("isPacp_captureStart", true);
			msg ="重新开始截获流量成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg ="重新开始截获流量失败";
		}
		return "SUCCESS";
	}
	
	public String stop() {
		try {
			Runtime.getRuntime().exec("/botwall/script/pacp_capture stop" );
			result="success";
			ActionContext.getContext().getApplication().put("isPacp_captureStart", false);
			msg ="停止截获流量成功";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
			msg ="停止截获流量失败";
		}
		return "SUCCESS";
	}
	
}
