package cn.edu.xjtu.manage.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.edu.xjtu.manage.business.LowestMBService;
import cn.edu.xjtu.tools.String2IntergerCheck;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LowestMBAction extends ActionSupport {
	String msg;
	
	String lowestMB;
	String lowestMBEmail;
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
	public String getLowestMBEmail() {
		return lowestMBEmail;
	}
	public void setLowestMBEmail(String lowestMBEmail) {
		this.lowestMBEmail = lowestMBEmail;
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
		boolean flag = String2IntergerCheck.check(lowestMB);
		if(flag){
			try{
				int lowest = Integer.parseInt(lowestMB);
				System.out.println(lowestMBEmail);
				LowestMBService.getInstance(lowest,lowestMBEmail);
				result="success";
				msg="配置成功";
				ActionContext.getContext().getApplication().put("globalLowestMB", lowestMB);
				ActionContext.getContext().getApplication().put("globallowestMBEmail", lowestMBEmail);
				ActionContext.getContext().getApplication().put("isLowestMBStart", true);
			}catch(Exception e){
				e.printStackTrace();
				result="failure";
				msg="参数失败";
			}
		}else{
			result="error";
		}
		return "SUCCESS";
	}
}
