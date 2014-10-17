package cn.edu.xjtu.manage.business;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

public class HoneyFunctionService {
	private static HoneyFunctionService hfs= null; 
	
	Timer tim = null;
	String email;
	int minute;
	private HoneyFunctionService(String email,int minute) {
		super();
		this.email = email;
		this.minute = minute;
		run();
	}
	
	public static HoneyFunctionService getInstance(String email,int minute){
		if(hfs == null){
			hfs = new HoneyFunctionService(email,minute);
		}else{
			hfs.email = email;
			hfs.minute = minute;
			hfs.run();
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
					Runtime.getRuntime().exec("/botwall/script/pingpots "+email);
					Runtime.getRuntime().exec("/botwall/script/pingReport "+email);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		tim.scheduleAtFixedRate(tTask,0,minute*60*1000);
		//tim.scheduleAtFixedRate(tTask,0,minute*1000);
	}
	
}


