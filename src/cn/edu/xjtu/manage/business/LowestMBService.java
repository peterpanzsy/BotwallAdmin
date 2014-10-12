package cn.edu.xjtu.manage.business;

import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

public class LowestMBService {
	private static LowestMBService ls = null; 
	
	Timer tim = null;
	int lowestMB;

	private LowestMBService(int lowestMB) {
		super();
		this.lowestMB = lowestMB;
		run();
	}
	
	public static LowestMBService getInstance(int lowestMB){
		if(ls == null){
			ls = new LowestMBService(lowestMB);
		}else{
			ls.lowestMB = lowestMB;
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
				System.out.println("aaa");
				//Runtime.getRuntime().exec("/botwall/script/auto_upload "+ lowestMB +" );
			}
		};
		tim.scheduleAtFixedRate(tTask,0,lowestMB*1000);
	}
}


