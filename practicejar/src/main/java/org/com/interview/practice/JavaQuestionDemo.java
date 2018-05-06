package org.com.interview.practice;
 
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
 
public class JavaQuestionDemo {
	
	private static BufferedReader reader;
	
	private static Object obj;

	
    public static void main(String[] args) throws Exception {
    	InputStream inputReder = JavaQuestionDemo.class.getClassLoader().getResourceAsStream("Question.txt");
    	reader = new BufferedReader(new InputStreamReader(inputReder));
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

	private static void createAndShowGUI() {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon =
                new TrayIcon(createImage("java.jpg", "Java Question"));    
        trayIcon.setImageAutoSize(true);
        final SystemTray tray = SystemTray.getSystemTray();
         
        // Create a popup menu components
        MenuItem aboutItem = new MenuItem("Explanation");
        MenuItem next = new MenuItem("Next Question");
        MenuItem exitItem = new MenuItem("Exit");
        MenuItem skip_lot = new MenuItem("Skip 5 Item");
         
        //Add components to popup menu
      //  popup.add(aboutItem);
       // popup.addSeparator();
        popup.add(next);
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
        	String str;
        	try {
				while(null!=(str=reader.readLine())) {
					trayIcon.displayMessage("", "            "+str+"                 ", MessageType.INFO);
					try {
						Thread.sleep(60000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	System.exit(0);
        }).start();
         
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,obj.toString()+" : "+
                        ConfigurationPropertiesLoader.PROPERTIES.getProperty(obj.toString()) );
            }
        });
         
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
        
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            		String str = reader.readLine();
            		if(null!=str) {
            			trayIcon.displayMessage("", "        "+str+"             ", MessageType.INFO);
            		}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
    }
     
    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = JavaQuestionDemo.class.getClassLoader().getResource(path);
         
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}
