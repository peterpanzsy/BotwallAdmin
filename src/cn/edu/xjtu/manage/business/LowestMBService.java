package cn.edu.xjtu.manage.business;

import java.io.IOException;
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
		//TODO 这个地方的异常处理不太好，用map可以改进
		TimerTask tTask = new TimerTask(){
			@Override
			public void run() {
				System.out.println("aaa");
				/*try {
					Runtime.getRuntime().exec("./botwall/script/auto_upload "+ lowestMB);
				} catch (IOException e) {
					e.printStackTrace();
				}*/
			}
		};
		//暂时设置的是每隔一分钟调用一次
		tim.scheduleAtFixedRate(tTask,0,60*1000);
	}
	
}


