package cn.edu.xjtu.manage.action;

import cn.edu.xjtu.manage.business.HoneyFunctionService;
import cn.edu.xjtu.manage.business.LowestMBService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HoneyFunctionAction extends ActionSupport{
	String email;
	String honeyTime;
	String result;
	String msg;
	
	public String start(){
		try{
			int minute = Integer.parseInt(honeyTime);
			HoneyFunctionService.getInstance(email, minute);
			result="success";
			msg="配置成功";
			ActionContext.getContext().getApplication().put("globalEmail", email);
			ActionContext.getContext().getApplication().put("globalHoneyTime",honeyTime);
		}catch(Exception e){
			e.printStackTrace();
			result="failure";
			msg="参数失败";
		}
		return "SUCCESS";
	}
	
	public String setTime(){
		try{
			email = (String)ActionContext.getContext().getApplication().get("globalEmail");
			int minute = Integer.parseInt(honeyTime);
			HoneyFunctionService.getInstance(email, minute);
			result="success";
			msg="配置成功";
			ActionContext.getContext().getApplication().put("globalHoneyTime",honeyTime);
		}catch(Exception e){
			e.printStackTrace();
			result="failure";
			msg="参数失败";
		}
		return "SUCCESS";
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHoneyTime() {
		return honeyTime;
	}

	public void setHoneyTime(String honeyTime) {
		this.honeyTime = honeyTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
