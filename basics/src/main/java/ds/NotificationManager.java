package com.java.basic.ds;

import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

import javax.swing.ImageIcon;

public class NotificationManager {

	public static void main(String[] args) throws InterruptedException {
	
		 if (!SystemTray.isSupported()) {
	            System.out.println("SystemTray is not supported");
	            return;
	        }
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				TrayIcon icon = new TrayIcon(new ImageIcon("Images/vocab.gif").getImage(),"erthelhteghl");
				icon.displayMessage("Vocab", "What is the meaning of", MessageType.INFO);
			}
		}).start();
		
		Thread.sleep(1000000);
		
		
		
	}
	
	
}
