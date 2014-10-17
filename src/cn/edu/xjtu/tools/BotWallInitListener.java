package cn.edu.xjtu.tools;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BotWallInitListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		application.setAttribute("globalUploadRate","还木有限制");
		application.setAttribute("globalDownloadRate","还木有限制");
		application.setAttribute("globalLowestMB","还木有限制");
		application.setAttribute("IPNum","还木有限制");
		application.setAttribute("TCPNum","还木有限制");
		application.setAttribute("ICMPRateNum","还木有限制");
		application.setAttribute("TCPRateNum","还木有限制");
		application.setAttribute("globalEmail","还木有");
		application.setAttribute("globalHoneyTime","30");
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
