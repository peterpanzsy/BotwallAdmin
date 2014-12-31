package cn.edu.xjtu.manage.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.edu.xjtu.tools.String2IntergerCheck;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SessionLimitAction extends ActionSupport {
	
	String IPNum;
	String TCPNum;
	String ICMPRateNum;
	String TCPRateNum;
	String result;
	
	
	public String getIPNum() {
		return IPNum;
	}
	public void setIPNum(String iPNum) {
		IPNum = iPNum;
	}
	public String getTCPNum() {
		return TCPNum;
	}
	public void setTCPNum(String tCPNum) {
		TCPNum = tCPNum;
	}
	public String getICMPRateNum() {
		return ICMPRateNum;
	}
	public void setICMPRateNum(String iCMPRateNum) {
		ICMPRateNum = iCMPRateNum;
	}
	public String getTCPRateNum() {
		return TCPRateNum;
	}
	public void setTCPRateNum(String tCPRateNum) {
		TCPRateNum = tCPRateNum;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String start1() {
		boolean flag = String2IntergerCheck.check(IPNum)&&String2IntergerCheck.check(TCPNum)&&
				String2IntergerCheck.check(ICMPRateNum)&&String2IntergerCheck.check(TCPRateNum);
		if(flag){
			try {
				Runtime.getRuntime().exec("/botwall/script/limit start eth0 "+IPNum+" "+TCPNum+" "+ICMPRateNum+" "+TCPRateNum);
				ActionContext.getContext().getApplication().put("TCPNum", TCPNum);
				ActionContext.getContext().getApplication().put("IPNum", IPNum);
				ActionContext.getContext().getApplication().put("ICMPRateNum", ICMPRateNum);
				ActionContext.getContext().getApplication().put("TCPRateNum", TCPRateNum);
				ActionContext.getContext().getApplication().put("isSessionLimitedStart", true);
				result="success";
			} catch (Exception e) {
				e.printStackTrace();
				result="failure";
			}
		}else{
			result = "error";
		}
		return "SUCCESS";
	}
	
	/*public String start0(){
		boolean flag = check(IPNum)&&check(TCPNum)&&check(ICMPRateNum)&&check(TCPRateNum);
		
		if(flag){
			try {
				Runtime.getRuntime().exec("/botwall/script/sessions_limit start eth1 5 ");
				result="success";
			} catch (Exception e) {
				e.printStackTrace();
				result="failure";
			}
		}else{
			result = "error";
		}
		return "SUCCESS";
	}
*/
	public String unlimited(){
		try {
			Runtime.getRuntime().exec("/botwall/script/limit stop ");
			result="success";
			ActionContext.getContext().getApplication().put("isSessionLimitedStart", false);
			ActionContext.getContext().getApplication().put("IPNum","");
			ActionContext.getContext().getApplication().put("TCPNum","");
			ActionContext.getContext().getApplication().put("ICMPRateNum","");
			ActionContext.getContext().getApplication().put("TCPRateNum","");
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
		}
		return "SUCCESS";
	}

}
