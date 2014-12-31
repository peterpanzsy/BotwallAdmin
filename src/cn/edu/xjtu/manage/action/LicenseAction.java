package cn.edu.xjtu.manage.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import cn.edu.xjtu.manage.business.License;
import cn.edu.xjtu.manage.dao.LicenseDao;
import cn.edu.xjtu.manage.service.HoneyFunctionService;
import cn.edu.xjtu.manage.service.LowestMBService;
import cn.edu.xjtu.tools.JavaShellUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LicenseAction  extends ActionSupport{
	
	String licensestr;
	Date expires;
	int isvalid;
	License license;
	List<License> dataList;
	//wangdi
	private String callJava="/control/script/checkLicense.sh";
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getLicensestr() {
		return licensestr;
	}
	public void setLicensestr(String licensestr) {
		this.licensestr = licensestr;
	}
	public Date getExpires() {
		return expires;
	}
	public void setExpires(Date expires) {
		this.expires = expires;
	}
	public int getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
	}
	public List<License> getDataList() {
		return dataList;
	}
	public void setDataList(List<License> dataList) {
		this.dataList = dataList;
	}

	String re;
	
	public String getRe() {
		return re;
	}

	private Object[] rowData;
	public Object[] getRowData() {
		return rowData;
	}
	public void setRowData(Object[] rowData) {
		this.rowData = rowData;
	}
	
	private String ID;

	public String execute(){
		
		return "SUCCESS";
	}
	
	public String update(){
		LicenseDao dao=new LicenseDao();
		int res=dao.updateLicense(id, licensestr,expires,isvalid);
/*		try {
			int issuccess=JavaShellUtil.executeShell("/botwall/script/checkLicense.sh");
			if(issuccess==1){
				re="success";
			}else{
				re="failure";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			re="failure";
		}*/
		try {
//			Process pid = Runtime.getRuntime().exec("/bin/sh /botwall/script/checkLicense.sh");
			//wangdi
			Runtime.getRuntime().exec("./botwall/script/checkLicense");
			//重启服务 
			systemRestart();
			re="success";
		} catch (Exception e) {
			e.printStackTrace();
			re="failure";
		}
		return "SUCCESS"; 
	}
	
	//用于重新启动原有的服务
	private void systemRestart() throws IOException {
		//停止所有的服务 
		 Runtime.getRuntime().exec("/botwall/script/stopAll");
		//重新开启
		if((Boolean)ActionContext.getContext().getApplication().get("isHoneyFuntionStart")){
			String email = (String)ActionContext.getContext().getApplication().get("globalEmail");
			String honeyTime = (String)ActionContext.getContext().getApplication().get("globalHoneyTime");
			int minute = Integer.parseInt(honeyTime);
			HoneyFunctionService.getInstance(email, minute);
		};
		if((Boolean)ActionContext.getContext().getApplication().get("isRateLimitedStart")){
			String uploadRate = (String)ActionContext.getContext().getApplication().get("globalUploadRate");
			String downloadRate = (String)ActionContext.getContext().getApplication().get("globalDownloadRate");
			Runtime.getRuntime().exec(new StringBuffer("/botwall/script/wshaper ")
				.append(uploadRate).append(" ").append(downloadRate).append(" ").toString());
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isSessionLimitedStart")){
			String IPNum = (String) ActionContext.getContext().getApplication().get("IPNum");
			String TCPNum = (String) ActionContext.getContext().getApplication().get("TCPNum");
			String ICMPRateNum = (String) ActionContext.getContext().getApplication().get("ICMPRateNum");
			String TCPRateNum = (String) ActionContext.getContext().getApplication().get("TCPRateNum");
			//wangdi注释
			//ActionContext.getContext().getApplication().put("TCPRateNum","");
			Runtime.getRuntime().exec("/limit start eth0 "+IPNum+" "+TCPNum+" "+ICMPRateNum+" "+TCPRateNum);
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isLowestMBStart")){
			String temp = (String)ActionContext.getContext().getApplication().get("globalLowestMB");
			String tempEmail = (String)ActionContext.getContext().getApplication().get("globalLowestMBEmail");
			int lowestMB = Integer.parseInt(temp);
			LowestMBService.getInstance(lowestMB,tempEmail);
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isPacp_captureStart")){
			Runtime.getRuntime().exec("/botwall/script/pacp_capture start" );
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isBridgeStart")){
			Runtime.getRuntime().exec("/botwall/script/bridge start" );
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isAttackEventStart")){
			Runtime.getRuntime().exec("java -jar /botwall/java/AttackEvent.jar" );
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isFindBotnetStart")){
			Runtime.getRuntime().exec("java -jar /botwall/java/findBotnet.jar" );
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isCheckLicenceStart")){
			Runtime.getRuntime().exec("java -jar /botwall/java/checkLicense.jar" );
		}
		if((Boolean)ActionContext.getContext().getApplication().get("isDetectionCobehaveStart")){
			Runtime.getRuntime().exec("java -jar /botwall/java/DetectionCobehave.jar" );
		}
	}
	
	public String getLicenseInfo(){
		LicenseDao dao=new LicenseDao();
		dataList=dao.getLicense();
		if(!dataList.isEmpty()){
			license= dataList.get(0);
		}
		return "SUCCESS";
	}
	
}
