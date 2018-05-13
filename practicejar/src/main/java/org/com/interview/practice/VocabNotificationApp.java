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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
 
public class VocabNotificationApp {
	
	private static ConcurrentHashMap<String, String> keys;
	
	private static Map<String , String> previouseVocab; 
	
	private static Set<Map.Entry<String, String>> entrySedt;
	
	private static Iterator<Map.Entry<String, String>> it;
	
	private static Map.Entry<String, String> obj;
	
	private static AtomicInteger counter = new AtomicInteger(0);
	
    public static void main(String[] args) throws Exception {
        /* Use an appropriate Look and Feel */
    	InputStream inputStream = VocabNotificationApp.class.getClassLoader().getResourceAsStream("Words.csv");
    	keys = new ConcurrentHashMap<>();
    	previouseVocab = new HashMap<>();
    	entrySedt = loadCsvFile(inputStream);
    	it = entrySedt.iterator();
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
     
    private static Set<Map.Entry<String, String>> loadCsvFile(InputStream inputStream) {
		// TODO Auto-generated method stub
    	BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    	String str ;
    	try {
			while(null!=(str=reader.readLine())) {
				String[] splitString = str.split(",");
				keys.put(splitString[0], splitString[1]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return keys.entrySet();
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
        MenuItem previouseVocabs = new MenuItem("All PreviousWords");
        MenuItem exitItem = new MenuItem("Exit");
        MenuItem skip_lot = new MenuItem("Skip 50 Item");
         
        //Add components to popup menu
        popup.add(nextQuestion);
        popup.addSeparator();
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(exitItem);
        popup.addSeparator();
        popup.add(previouseVocabs);
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
        	while(it.hasNext()) {
        		obj = it.next();
        		previouseVocab.put(obj.getKey(), obj.getValue());
        		trayIcon.displayMessage("Vocab No "+counter.incrementAndGet(), "            "+obj.getKey().toString()+"                 ", MessageType.INFO);
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
                JOptionPane.showMessageDialog(null,counter.get()+"    :    "+obj.getValue().toString()+"   :   "+
                        obj.getKey().toString() );
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
                	previouseVocab.put(obj.getKey(), obj.getValue());
                	obj = it.next();
                	counter.incrementAndGet();
                }
            }
        });
        
        previouseVocabs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JFrame frame = new JFrame("Previous Vocab");
                frame.setSize(400,400);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                JTextArea textArea = new JTextArea();
                textArea.setSize(500, 500);
                textArea.setLineWrap(true);
                textArea.setEditable(false);
                textArea.setWrapStyleWord(true);
                JScrollPane sampleScrollPane = new JScrollPane (textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                StringBuilder builder = new StringBuilder();
                previouseVocab.entrySet().stream().forEach(ex -> builder.append(ex.getKey()+" : "+ ex.getValue()+"\n"+
                "---------------------------------------------------------------"+"\n"));
                textArea.setText(builder.toString());
                frame.add(sampleScrollPane); 
                frame.setVisible(true);
            }
        });
        
        nextQuestion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(it.hasNext()) {
            		obj = it.next();
            		previouseVocab.put(obj.getKey(), obj.getValue());
            		trayIcon.displayMessage("Vocab No "+counter.incrementAndGet(), "            "+obj.getKey().toString()+"                 ", MessageType.INFO);
            	}
            }
        });
    }
	
	//https://developer.oxforddictionaries.com/documentation#/ usename =mahesh.pathak  passwd=default-8@121
	
	private String dictionaryEntries(String word) {
        final String language = "en";
        final String word_id = word.toLowerCase(); //word id is case sensitive and lowercase is required
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/" + language + "/" + word_id;
    }
	
	private String getRequestedWord(String urls) {
             //TODO: replace with your own app id and app key
             final String app_id = "70077c9a";
             final String app_key = "21ed846568037f5d3fa969b5f6123250";
             try {
                 URL url = new URL(urls);
                 HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                 urlConnection.setRequestProperty("Accept","application/json");
                 urlConnection.setRequestProperty("app_id",app_id);
                 urlConnection.setRequestProperty("app_key",app_key);

                 // read the output from the server
                 BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                 StringBuilder stringBuilder = new StringBuilder();

                 String line = null;
                 while ((line = reader.readLine()) != null) {
                     stringBuilder.append(line + "\n");
                 }

                 return stringBuilder.toString();

             }
             catch (Exception e) {
                 e.printStackTrace();
                 return e.toString();
             }
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
