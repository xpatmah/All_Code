package com.java.basic.interview.coding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

enum Downloader{
	
	Instance;
	
	private Semaphore semaphore = new Semaphore(3,true);
	
	
	public void downloadData() {
		try {
			semaphore.acquire();
			downLoad();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			semaphore.release();
		}
	}
	
	public  void downLoad() {
		System.out.println("Downloading data from the web....");
		try {
			Thread.sleep(2000);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}


public class SemaphoreDemo {

    public static void main(String[] args) throws InterruptedException {
		
    	ExecutorService service = Executors.newCachedThreadPool();
    	for(int i=0;i<12;i++) {
    		service.execute(()-> Downloader.Instance.downloadData());
    	}
    	service.shutdown();
    	
    	service.awaitTermination(4, TimeUnit.SECONDS);
    	
    	System.out.println("Local Task");
	}
	
}
