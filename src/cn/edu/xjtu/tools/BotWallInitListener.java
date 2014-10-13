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
	}
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}


}
