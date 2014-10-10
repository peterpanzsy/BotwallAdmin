package cn.edu.xjtu.manage.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class SessionLimit extends ActionSupport {
	
	String sessionNum;
	String result;
	
	public String getSessionNum() {
		return sessionNum;
	}
	public void setSessionNum(String sessionNum) {
		this.sessionNum = sessionNum;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String start0() {
		boolean flag = check(sessionNum);
		if(flag){
			try {
				//Runtime.getRuntime().exec(/botwall/script/sessions_limit start eth0 5 );
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
	
	public String start1(){
		boolean flag = check(sessionNum);
		System.out.println(sessionNum);
		if(flag){
			try {
				//Runtime.getRuntime().exec("/botwall/script/sessions_limit start eth1 5 ");
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

	public String unlimited(){
		System.out.println("取消限制会话数命令到了");
		try {
			//Runtime.getRuntime().exec("/botwall/script/sessions_limit stop ");
			result="success";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
		}
		return "SUCCESS";
	}

	private boolean check(String sessionNum){
		Pattern pattern = Pattern.compile("[1-5]");
		Matcher matcher = pattern.matcher(sessionNum);
		if(matcher.matches()==false)
        {
             return false;
        }
        else
        {
             return true;
        }
	}
}
