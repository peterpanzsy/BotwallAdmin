package cn.edu.xjtu.manage.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		boolean flag = check(IPNum)&&check(TCPNum)&&check(ICMPRateNum)&&check(TCPRateNum);
		if(flag){
			try {
				//Runtime.getRuntime().exec("/limit start eth0 "+IPNum+" "+TCPNum+" "+ICMPRateNum+" "+TCPRateNum);
				ActionContext.getContext().getApplication().put("TCPNum", TCPNum);
				ActionContext.getContext().getApplication().put("IPNum", IPNum);
				ActionContext.getContext().getApplication().put("ICMPRateNum", ICMPRateNum);
				ActionContext.getContext().getApplication().put("TCPRateNum", TCPRateNum);
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
			//Runtime.getRuntime().exec("/limit stop ");
			result="success";
			ActionContext.getContext().getApplication().put("IPNum","还木有限制");
			ActionContext.getContext().getApplication().put("TCPNum","还木有限制");
			ActionContext.getContext().getApplication().put("ICMPRateNum","还木有限制");
			ActionContext.getContext().getApplication().put("TCPRateNum","还木有限制");
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
