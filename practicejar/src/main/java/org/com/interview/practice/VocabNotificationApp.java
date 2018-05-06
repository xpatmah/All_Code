package org.com.interview.practice;
 
import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.awt.event.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.*;
 
public class VocabNotificationApp {
	
	private static Enumeration<Object> keys;
	
	private static Object obj;
	
	private static AtomicInteger counter = new AtomicInteger(0);
	
    public static void main(String[] args) throws Exception {
        /* Use an appropriate Look and Feel */
    	URL url = VocabNotificationApp.class.getClassLoader().getResource("a.properties");
    	loadPropertyFile(url.getPath());
    	keys = ConfigurationPropertiesLoader.getInstance().getProperties();
        try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
     
    private static void loadPropertyFile(String path) throws Exception {
    	ConfigurationPropertiesLoader.getInstance().loadPropertiesFile(path);
	}

	private static void createAndShowGUI() {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon =
                new TrayIcon(createImage("vocab.gif", "tray icon"));    
        trayIcon.setImageAutoSize(true);
        final SystemTray tray = SystemTray.getSystemTray();
         
        // Create a popup menu components
        MenuItem nextQuestion = new MenuItem("Next Question");
        MenuItem aboutItem = new MenuItem("Explanation");
        MenuItem exitItem = new MenuItem("Exit");
        MenuItem skip_lot = new MenuItem("Skip 50 Item");
         
        //Add components to popup menu
        popup.add(nextQuestion);
        popup.addSeparator();
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(exitItem);
        popup.addSeparator();
        popup.add(skip_lot);
         
        trayIcon.setPopupMenu(popup);
         
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
        
        new Thread(() ->  {
        	while(keys.hasMoreElements()) {
        		obj = keys.nextElement();
        		trayIcon.displayMessage("Vocab No "+counter.incrementAndGet(), "            "+obj.toString()+"                 ", MessageType.INFO);
            	try {
    				Thread.sleep(300000);
    			} catch (InterruptedException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        	}
        	System.exit(0);
        }).start();
         
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,counter.get()+" "+obj.toString()+" : "+
                        ConfigurationPropertiesLoader.PROPERTIES.getProperty(obj.toString()) );
            }
        });
         
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.out.println("Vocab Counter was "+counter.get());
                System.exit(0);
            }
        });
        
        skip_lot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i< 50;i++) {
                	keys.nextElement();
                }
            }
        });
        
        nextQuestion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(keys.hasMoreElements()) {
            		obj = keys.nextElement();
            		trayIcon.displayMessage("Vocab No "+counter.incrementAndGet(), "            "+obj.toString()+"                 ", MessageType.INFO);
            	}
            }
        });
    }
     
    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = VocabNotificationApp.class.getClassLoader().getResource(path);
         
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}
