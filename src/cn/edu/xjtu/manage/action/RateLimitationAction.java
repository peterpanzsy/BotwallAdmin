package cn.edu.xjtu.manage.action;

import com.opensymphony.xwork2.Action;
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
		System.out.println(uploadRate);
		System.out.println(downloadRate);
		
		try {
			//Runtime.getRuntime().exec(new StringBuffer("sh /botwall/script/wshaper ")
				//					.append(uploadRate).append(" ").append(downloadRate).append(" ").toString());
			result="success";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
		}
		return "SUCCESS";
	}
	public String rateStop(){
		System.out.println("结束命令到了");
		try {
			//Runtime.getRuntime().exec("/botwall/script/wshaper stop");
			result="success";
		} catch (Exception e) {
			e.printStackTrace();
			result="failure";
		}
		return "SUCCESS";
	}
}
