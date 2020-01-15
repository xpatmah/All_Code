package com.org.utilities;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class JFrameForImage {

	private AtomicBoolean bool = new AtomicBoolean(false);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new JFrameForImage();
		
	}
	
	public JFrameForImage() {
		// TODO Auto-generated constructor stub
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        
        
        
        JLabel label = new JLabel();
        label.setSize(100,100);
        
    	try {
      
	
    		  ImageIcon 	icon1 = new ImageIcon( ImageIO.read(new File("./src/img/Logo-IM.com_.png")));
		    label.setIcon(icon1);
		
        ImageIcon icon2 = new ImageIcon( ImageIO.read(new File("./src/img/BITS_IMAGE2.png")));
    
        
       // frame.add("CAN",label);
        
        JButton button = new JButton();
        
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!bool.getAndSet(true)){
					label.setIcon(icon2);
				}else{
					label.setIcon(icon1);
					bool.set(false);
				}
				
			}
		});
        
        JEditorPane jep = new JEditorPane();
        jep.setEditable(false);   

        try {
          jep.setPage("http://google.com");
        }catch (IOException e) {
          jep.setContentType("text/html");
          jep.setText("<html>Could not load</html>");
        } 

        JScrollPane scrollPane = new JScrollPane(jep);     

        frame.getContentPane().add(scrollPane);
        
      //  frame.add(button);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        JFrame f = new JFrame("Test HTML");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(scrollPane);
        f.setPreferredSize(new Dimension(800,600));
        f.setVisible(true);
        
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
