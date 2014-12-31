package cn.edu.xjtu.tools;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BotWallInitListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		application.setAttribute("globalUploadRate","");
		application.setAttribute("globalDownloadRate","");
		application.setAttribute("globalLowestMB","");
		application.setAttribute("globalLowestMBEmail","");
		application.setAttribute("IPNum","");
		application.setAttribute("TCPNum","");
		application.setAttribute("ICMPRateNum","");
		application.setAttribute("TCPRateNum","");
		application.setAttribute("globalEmail","");
		application.setAttribute("globalHoneyTime","");
		//以下信息是判断是否启用了某项功能
		application.setAttribute("isHoneyFuntionStart",false);
		application.setAttribute("isRateLimitedStart",false);
		application.setAttribute("isSessionLimitedStart",false);
		application.setAttribute("isLowestMBStart",false);
		application.setAttribute("isPacp_captureStart",false);
		application.setAttribute("isBridgeStart",false);
		application.setAttribute("isAttackEventStart",false);
		application.setAttribute("isFindBotnetStart",false);
		application.setAttribute("isCheckLicenceStart",false);
		application.setAttribute("isDetectionCobehaveStart",false);
	}
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}


}
