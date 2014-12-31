package cn.edu.xjtu.manage.action;

import cn.edu.xjtu.tools.String2IntergerCheck;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RateLimitationAction extends ActionSupport {
	
	String uploadRate;
	String downloadRate;
	
	String result;
	

	public String getUploadRate() {
		return uploadRate;
	}
	public void setUploadRate(String uploadRate) {
		this.uploadRate = uploadRate;
	}
	public String getDownloadRate() {
		return downloadRate;
	}
	public void setDownloadRate(String downloadRate) {
		this.downloadRate = downloadRate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String rateLimitStart() {
		boolean flag = String2IntergerCheck.check(uploadRate)&&String2IntergerCheck.check(downloadRate);
		if(flag){
			try {
				Runtime.getRuntime().exec(new StringBuffer("/botwall/script/wshaper ")
										.append(uploadRate).append(" ").append(downloadRate).append(" ").toString());
				result="success";
				ActionContext.getContext().getApplication().put("isRateLimitedStart", true);
				ActionContext.getContext().getApplication().put("globalUploadRate", uploadRate);
				ActionContext.getContext().getApplication().put("globalDownloadRate", downloadRate);
			} catch (Exception e) {
				e.printStackTrace();
				result="failure";
			}
		}else{
			result="error";
		}
		return "SUCCESS";
	}
	public String rateStop(){
		try {
			Runtime.getRuntime().exec("/botwall/script/wshaper stop");
			result="success";
			ActionContext.getContext().getApplication().put("isRateLimitedStart", false);
			ActionContext.getContext().getApplication().put("globalUploadRate", "还木有限制");
			ActionContext.getContext().getApplication().put("globalDownloadRate", "还木有限制");
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
		}
		return "SUCCESS";
	}
}
