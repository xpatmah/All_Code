package com.org.simulation.ne;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.org.simulation.ne.database.DataBaseManager;
import com.org.simulation.ne.domain.NeInfo;

public class NECreator {

	private static NECreator neCreator;
	
	private List<T6510> neList =  new ArrayList<T6510>();
	private ExecutorService executorService = Executors.newFixedThreadPool(50);
	
	private NECreator() {
	}
	
	public static NECreator getInstance(){
		
		if(neCreator==null){
			synchronized (NECreator.class) {
				if(neCreator==null){
					neCreator = new NECreator();
				}
			}
		}
		return neCreator;
	}
	
	
	public boolean createNe(String ip , String port,boolean isDataBaseReterieved,String shelf,NeInfo neinfo) throws IOException{
		if(!isDuplicated(ip,port)){
			T6510 ne  = new T6510(ip, port);
			new Thread(ne).start();
			//executorService.execute(ne);
			neList.add(ne);
			if(!isDataBaseReterieved){
				DataBaseManager.getInstance().insertNeDetails(ip,port,shelf,neinfo);
			}
			return true;
		}else if(isDataBaseReterieved){
			T6510 ne  = new T6510(ip, port);
			new Thread(ne).start();
			//executorService.execute(ne);
			neList.add(ne);
			return true;
		}
		return false;
	}
	
	public boolean startNe(String ip , String port) throws IOException{
			T6510 ne  = new T6510(ip, port);
			new Thread(ne).start();
			neList.add(ne);
			return true;
	}
	
	
	public void disposeAllNE() {
		for(T6510 task : neList){
			try {
				task.getIsdone().set(false);
				if(null!=task.getSocket()){
					task.getSocket().close();
				}
				if(null!=task.getListner()){
					task.getListner().close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DataBaseManager.getInstance().disposeConnection();
		//executorService.shutdown();
	}
	
	public boolean disposeNe(String ip , String port){
		boolean reslt=false;
		T6510 tasktoremove=null;;
		for(T6510 task : neList){
			if(task.getIp().equals(ip) && task.getPort().equals(port)){
				task.stopNe();
				tasktoremove=task;
				reslt=true;
			}
		}
		if(reslt){
			neList.remove(tasktoremove);
			return true;
		}
		return false;
	}
	
	public boolean isDuplicated(String ip , String port){
	    if(null!=DataBaseManager.getInstance().getShelfType(ip,port)){
	    	return true;
	    }	
		return false;
	}
}
