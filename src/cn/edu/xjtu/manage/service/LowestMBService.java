package cn.edu.xjtu.manage.service;



import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

public class LowestMBService {
	private static LowestMBService ls = null; 
	
	Timer tim = null;
	int lowestMB;
	String lowestMBEmail;

	private LowestMBService(int lowestMB) {
		super();
		this.lowestMB = lowestMB;
		run();
	}
	
	public static LowestMBService getInstance(int lowestMB,String lowstestMBEmail){
		if(ls == null){
			ls = new LowestMBService(lowestMB);
		}else{
			ls.lowestMB = lowestMB;
			ls.lowestMBEmail = lowstestMBEmail;
			ls.run();
		}
		return null;
	}

	public void run(){
		if(tim !=null){
			tim.cancel();
		}
		tim = new Timer();
		TimerTask tTask = new TimerTask(){
			@Override
			public void run() {
				try {
//					Runtime.getRuntime().exec("./botwall/script/auto_upload "+ lowestMB+" "+lowestMBEmail);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		//每20分钟调用一次脚本
		tim.scheduleAtFixedRate(tTask,0,20*60*1000);
	}
	
}


