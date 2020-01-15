package com.org.simulation.ne;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.java.webnms.response.NE;
import com.org.simulation.ne.database.DataBaseManager;
import com.org.simulation.ne.domain.Alarm;
import com.org.simulation.ne.domain.Card;
import com.org.simulation.ne.domain.Facility;
import com.org.simulation.ne.domain.NeInfo;

public class NESimulator{

	private JFrame frame;
	private JPanel infopanel;
	private JPanel buttonpanel;
	private JPanel detailspanel;
	private JLabel ipLabel;
	private JLabel sloganLabel;
	private JTextField ipTextFiled;
	private JLabel portLabel;
	private JTextField portTextFiled;
	private JLabel neName;
	private JTextField neNameTextFiled;
	private JLabel location;
	private JTextField locationTextFiled;
	private JLabel version;
	private JComboBox<String> versionField;
	private JLabel areaServed;
	private JTextField areaServedTextFiled;
	private JButton createNeButton;
	private JTable table;
	private JScrollPane scrollPane;
	private  JPopupMenu nePopupMenu;
	private  JMenuItem deleteItem;
	private  JMenuItem startItem;
	private  JMenuItem editItem;
	private  JMenuItem displayItem;
	AddDialog dialog = null;
	EditDialog editdialog =null;
	DisplayDialog displayDialog=null;
	
	private String ipText ;
	private String ipPort ;
	private String neNameValue ;
	private String neLocation ;
	private String neVersion ;
	private String areaServedLocation ;
	
	private MyButtonActionListener listner  = new MyButtonActionListener();
	
	private ComboListner comboListner = new ComboListner();
	
	private DialogListner dListner = new DialogListner();
	
	private EditDialogListner editdListner = new EditDialogListner();
	
	private EditComboListner editComboListner = new EditComboListner();
	
	private KeyListr keyListner = new KeyListr();
	
	Map<Integer, String>  seviourityMap = new HashMap<Integer, String>();
	
	Map<Integer, String> discriptionMap = new HashMap<Integer, String>();
	
	Map<Integer, String> unitMap = new HashMap<Integer, String>();
	
	private final AtomicInteger atomicint = new AtomicInteger(0);
	
	public NESimulator() {
        initializeMap();
		frame = new JFrame(NeConstants.NESIMULATORTITLE);
		try { 
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		    e.printStackTrace();
		}
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridBagLayout());
		frame.addWindowListener(new WindowAdapter() {
			 public void windowClosed(WindowEvent e) {
				 NECreator.getInstance().disposeAllNE();
				 System.exit(0);
			 }
		});
		infopanel = new JPanel(new GridBagLayout());
		buttonpanel=new JPanel(new GridBagLayout());
		table = new JTable();
		table.setModel(new NETableModel());
		table.setRowSelectionAllowed(true);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed( MouseEvent e )
			{
				if ( SwingUtilities.isRightMouseButton( e )){
					Point point = e.getPoint();
					int currentRow = table.rowAtPoint(point);
					table.setRowSelectionInterval(currentRow, currentRow);
					String value = (String)table.getValueAt(currentRow, 2);
					if(null!=value && value.equals(NeConstants.STARTED)){
						nePopupMenu.removeAll();
						nePopupMenu.add(deleteItem);
					    setCommonMenu();
					    table.setComponentPopupMenu(nePopupMenu);
					    
					}else if(null!=value && value.equals(NeConstants.STOPED)){
						nePopupMenu.removeAll();
						nePopupMenu.add(startItem);
					    setCommonMenu();
					    table.setComponentPopupMenu(nePopupMenu);
					}else{
						nePopupMenu.removeAll();
					}
				}	
			}
		});
		
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		nePopupMenu = new JPopupMenu();
		deleteItem = new JMenuItem(NeConstants.STOPNE);
		startItem = new JMenuItem(NeConstants.STARTNE);
		editItem = new JMenuItem(NeConstants.EDIT_ATTRIBUTE);
	    displayItem = new JMenuItem(NeConstants.DISPLAY_NE_ATTRIBUTE);
	    addListners();
	    nePopupMenu.add(startItem);
	    nePopupMenu.add(deleteItem);
	    nePopupMenu.add(editItem);
	    nePopupMenu.add(displayItem);
		table.setEnabled(true);
		table.setOpaque(true);
		table.setLayout(new GridLayout(1,0));
		scrollPane = new JScrollPane(table);
		detailspanel=new JPanel(new GridBagLayout());
		sloganLabel = new JLabel(NeConstants.NESIMULATORHEADING);
		ipLabel = new JLabel(NeConstants.IP);
		ipTextFiled = new JTextField(16);
		ipTextFiled.addKeyListener(keyListner);
		portLabel= new JLabel(NeConstants.PORT);
		portTextFiled = new JTextField(16);
		portTextFiled.addKeyListener(keyListner);
		neName= new JLabel("Name:");
		neNameTextFiled = new JTextField(16);
		neNameTextFiled.addKeyListener(keyListner);
		location= new JLabel("Location:");
		locationTextFiled = new JTextField(16);
		locationTextFiled.addKeyListener(keyListner);
		version= new JLabel("Version:");
		versionField = new JComboBox<String>();
		versionField.setModel(new DefaultComboBoxModel<>(new String[] { "V0.2", "V0.3", "G1.9","P10"}));
		areaServed= new JLabel("Area Served:");
		areaServedTextFiled = new JTextField(16);
		areaServedTextFiled.addKeyListener(keyListner);
		createNeButton = new JButton(NeConstants.ADD_BUTTON);
		createNeButton.setEnabled(false);
		GridBagConstraints constraints  = new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.anchor=GridBagConstraints.NORTH;
		infopanel.add(sloganLabel,constraints);
		
		constraints  = new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.ipadx=120;
		constraints.ipady=20;
		constraints.anchor=GridBagConstraints.WEST;
		detailspanel.add(ipLabel,constraints);
		
		constraints  = new GridBagConstraints();
		constraints.gridx=1;
		constraints.gridy=0;
		constraints.anchor=GridBagConstraints.EAST;
		detailspanel.add(ipTextFiled,constraints);
		
		constraints  = new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.anchor=GridBagConstraints.WEST;
		detailspanel.add(portLabel,constraints);
		
		
		constraints  = new GridBagConstraints();
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.anchor=GridBagConstraints.EAST;
		detailspanel.add(portTextFiled,constraints);
		
		constraints  = new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.anchor=GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 5, 0);
		detailspanel.add(neName,constraints);
		
		
		constraints  = new GridBagConstraints();
		constraints.gridx=1;
		constraints.gridy=2;
		constraints.anchor=GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 0, 5, 0);
		detailspanel.add(neNameTextFiled,constraints);
		
		constraints  = new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=3;
		constraints.anchor=GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 5, 0);
		detailspanel.add(location,constraints);
		
		
		constraints  = new GridBagConstraints();
		constraints.gridx=1;
		constraints.gridy=3;
		constraints.anchor=GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 0, 5, 0);
		detailspanel.add(locationTextFiled,constraints);
		
		constraints  = new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=4;
		constraints.anchor=GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 5, 0);
		detailspanel.add(version,constraints);
		
		constraints  = new GridBagConstraints();
		constraints.gridx=1;
		constraints.gridy=4;
		constraints.insets = new Insets(5, 0, 5, 0);
		versionField.setMaximumSize(new Dimension(180,25));
		versionField.setPreferredSize(new Dimension(180,25));
		detailspanel.add(versionField,constraints);

		constraints  = new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=5;
		constraints.anchor=GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 5, 0);
		detailspanel.add(areaServed,constraints);
		
		constraints  = new GridBagConstraints();
		constraints.gridx=1;
		constraints.gridy=5;
		constraints.anchor=GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 0, 5, 0);
		detailspanel.add(areaServedTextFiled,constraints);
		
		constraints  = new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weightx=1;
		constraints.anchor=GridBagConstraints.NORTH;
		createNeButton.addActionListener(listner);
		buttonpanel.add(createNeButton,constraints);
		
		constraints  = new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weighty=1;
		constraints.ipadx=5;
		constraints.ipady=5;
		constraints.insets = new Insets(10, 0, 10, 0);
		constraints.anchor=GridBagConstraints.NORTH;
		frame.add(infopanel,constraints);
		
		constraints  = new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.weighty=1;
		constraints.ipadx=5;
		constraints.ipady=5;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.anchor=GridBagConstraints.CENTER;
		frame.add(detailspanel,constraints);

		constraints  = new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.weighty=1;
		constraints.ipadx=5;
		constraints.ipady=5;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.anchor=GridBagConstraints.CENTER;
		frame.add(buttonpanel,constraints);
		
		constraints  = new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=3;
		constraints.weighty=1;
		constraints.ipadx=5;
		constraints.ipady=5;
		constraints.anchor=GridBagConstraints.CENTER;
		scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		frame.add(scrollPane,constraints);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int value = DataBaseManager.getInstance().getMaxAlarmId();
		atomicint.set(value);
		recoverAllNe();
		frame.setVisible(true);
		frame.pack();
	}
	
	private void initializeMap() {
		 seviourityMap.put(0, "Major");
		 seviourityMap.put(1, "Minor");
		 seviourityMap.put(2, "Warning");
		 seviourityMap.put(3, "Intermediate");
		 seviourityMap.put(4, "Clear");
		 unitMap.put(0, "SLOT");
		 unitMap.put(1, "CARD");
		 unitMap.put(3, "EQUIPMENT");
		 unitMap.put(2, "SERVICE");
		 discriptionMap.put(0, "Circuit pack low temperature");
		 discriptionMap.put(1, "Circuit pack high temperature");
		 discriptionMap.put(2, "Circuit pack low voltage");
		 discriptionMap.put(3, "Circuit pack high voltage");
		 discriptionMap.put(4, "Battery A supply fail");
		 discriptionMap.put(5, "Loss of power feed A");
		 discriptionMap.put(6, "Loss of power feed B");
		 discriptionMap.put(7, "Signal degrade");
		 discriptionMap.put(8, "Circuit pack vintage mismatch");
		 discriptionMap.put(9, "Timing ref forced switch request");
		 discriptionMap.put(10, "Comms and timing misalignment");
		 discriptionMap.put(11, "Lockout protection active");
		 discriptionMap.put(12, "Span protection switch complete");
		 discriptionMap.put(13, "Lock on oscillation cntrl active");
		 discriptionMap.put(14, "Default K-bytes");		
	}

	class KeyListr extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			String ip = ipTextFiled.getText();
			String port = portTextFiled.getText();
			String[] pattern = ip.split("\\.");
			if(pattern.length==4){
				for(String patter : pattern){
                  if(patter.length()==2 && port.length()==4){
                	  createNeButton.setEnabled(true);
                	  ipText = ip;
                	  ipPort = port;
                	  neNameValue = neNameTextFiled.getText();
                	  neLocation = locationTextFiled.getText();
                	  neVersion = (String)versionField.getSelectedItem();
                	  areaServedLocation = areaServedTextFiled.getText();
                	  if("".equals(neNameTextFiled.getText()) || neNameTextFiled.getText().length()<6){
                		  createNeButton.setEnabled(false);
                	  }
                	  if("".equals(locationTextFiled.getText()) || locationTextFiled.getText().length()<3){
                		  createNeButton.setEnabled(false);
                	  }
                	  if("".equals(areaServedTextFiled.getText()) || areaServedTextFiled.getText().length()<3){
                		  createNeButton.setEnabled(false);
                	  }
                  }else{
                	  createNeButton.setEnabled(false);
                	  break;
                  }
				}
			}
			else{
				createNeButton.setEnabled(false);
			}
		}
	}
	
	class MyButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==createNeButton){
				createDialog();
			}else if(e.getSource()==editItem){
				createEditDialog();
			}else if(e.getSource()==displayItem){
				createDisplayDialog();
			}
		}
	} 
	 
	class ComboListner implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(null!=dialog && e.getSource()==dialog.getSlotCombo()){
				if(isCardAvailable((String)dialog.getSlotCombo().getSelectedItem(),(String)dialog.getShelfModel().getSelectedItem())){
					enableDisableCardCombos(false);
				}else{
					enableDisableCardCombos(true);
				}
				dialog.getPortCombo().setSelectedIndex(0);
			}else if(null!=dialog && e.getSource()==dialog.getPortCombo()){
				if(isFacilityAvailable(dialog,(String)dialog.getSlotCombo().getSelectedItem(),(String)dialog.getShelfModel().getSelectedItem(),(String)dialog.getPortCombo().getSelectedItem())){
					enableDisableFields(false);
				}else{
					enableDisableFields(true);
				}
			}else if(null!=displayDialog && e.getSource()==displayDialog.getSlotCombo()){
				putTableValues();
			}
		}
	}
	
	class EditComboListner implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==editdialog.getSlotCombo()){
				Card card = DataBaseManager.getInstance().getCardOnSlot(ipText,(String)editdialog.getSlotCombo().getSelectedItem());
				if(null!=card){
					editdialog.getCardCombo().setSelectedItem(card.getCardName());
					editdialog.getCardCombo().setSelectedItem(card.getCardName());
					editdialog.getModCombo().setSelectedItem(card.getMod());
					editdialog.getTraficCombo().setSelectedItem(card.getTraficStatus());
					editdialog.getPrimaryCombo().setSelectedItem(card.getPrimaryState());
					editdialog.getPecCombo().setSelectedItem(card.getProvisionPec());
					editdialog.getSerialNo().setText(card.getSerialNo());
					editdialog.getProfileCombo().setSelectedItem(card.getProfile());
					editdialog.getCardCombo().setEnabled(false);
					editdialog.getPortCombo().setSelectedIndex(0);
				}else{
					setDefaultValues();
					editdialog.getCardCombo().setEnabled(true);
				}
			}else if(e.getSource()==editdialog.getPortCombo()){
				Facility fac = DataBaseManager.getInstance().getFacilityOnSlotAndPort(ipText, (String)editdialog.getSlotCombo().getSelectedItem(), (String)editdialog.getPortCombo().getSelectedItem());
			    setValues(fac);
			}
		}

		private void setValues(Facility fac) {
			if(null!=fac){
				editdialog.getFacilityCombo().setSelectedItem(fac.getFacility());
				editdialog.getServiceTypeCombo().setSelectedItem(fac.getServiceType());
				editdialog.getFrequencyCombo().setSelectedItem(fac.getFrequency());
				editdialog.getWavelengthCombo().setSelectedItem(fac.getWavelength());
				editdialog.getDiffrentialEncodingCombo().setSelectedItem(fac.getDiffrentialEncoding());
				editdialog.getCdfi().setText(fac.getCdfi());
			}
		}
	}
	class EditDialogListner implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==editdialog.getCancelButton()){
				editdialog.setVisible(false);
			}else if(e.getSource()==editdialog.getOkButton()){
				editdialog.setVisible(false);
				populateEditValues();
			}else if(e.getSource()==editdialog.getApplyButton()){
				populateEditValues();
			}
		}
	}
	
	private void recoverAllNe(){
		 Map<String, String> neMap = DataBaseManager.getInstance().getAllNe();
		 for(Map.Entry<String, String> entry : neMap.entrySet()){
			 try {
				 boolean result = NECreator.getInstance().createNe(entry.getKey(), entry.getValue(),true,null,null);
				 if(result){
					 ((NETableModel)table.getModel()).setAllValues(entry.getKey(), entry.getValue(), NeConstants.STARTED);
				 } 
			 } catch (IOException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }

		 }
		 
		 new Thread(new Runnable() {
			@Override
			public void run() {
				
				 Random random = new Random();
				while(true){
					Map<String, String> neinfo = DataBaseManager.getInstance().getAllNe();
					 for(Map.Entry<String, String> entry : neinfo.entrySet()){
						 NE ne = DataBaseManager.getInstance().getNEinfo(entry.getKey(), entry.getValue());
						 Alarm alarm = new Alarm();
						 alarm.setAlarmid(atomicint.incrementAndGet());
						 alarm.setDiscription(discriptionMap.get(random.nextInt(15)));
						 alarm.setDocumentid("Doc no."+random.nextInt(1000));
						 alarm.setIp(ne.getIp());
						 alarm.setLocation(ne.getLocation());
						 alarm.setNename(ne.getName());
						 alarm.setSeviourity(seviourityMap.get(random.nextInt(5)));
						 alarm.setTime(new Date(System.currentTimeMillis()).toString());
						 alarm.setUnit(unitMap.get(random.nextInt(4)));
						 DataBaseManager.getInstance().insertAlarm(alarm);
					 }
					 try {
						Thread.sleep(4*60000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
                				
			}
		},"Alarm Manager Thread").start();
	}
	
	class DialogListner implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(null!=dialog && e.getSource()==dialog.getOkButton()){
				dialog.setVisible(false);
				String ip = ipTextFiled.getText();
				String port  = portTextFiled.getText();
				String shelf = (String)dialog.getShelfModel().getSelectedItem();
				NeInfo neinfo = getNeInformation();				
				try {
					boolean result = NECreator.getInstance().createNe(ip, port,false,shelf,neinfo);
					if(result){
						((NETableModel)table.getModel()).setAllValues(ip, port, NeConstants.STARTED);
						DataBaseManager.getInstance().insertShelfRecord(ip, (String)dialog.getShelfModel().getSelectedItem());
						populateValues((String)dialog.getShelfModel().getSelectedItem());
						resetDialog();
					}else{
						JOptionPane.showMessageDialog(frame, NeConstants.ALREADY_CREATED_NE);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if(null!=dialog && e.getSource()==dialog.getCancel()){
				dialog.setVisible(false);
			}else if(null!=dialog && e.getSource()==dialog.getApply()){
				String shelf = (String)dialog.getShelfModel().getSelectedItem();
				NeInfo neinfo = getNeInformation();			
				try {
					boolean result = NECreator.getInstance().createNe(ipText, ipPort,false,shelf,neinfo);
					if(result){
						((NETableModel)table.getModel()).setAllValues(ipText, ipPort, NeConstants.STARTED);
						populateValues((String)dialog.getShelfModel().getSelectedItem());
						handleApplyButton();
					}else if(null!=DataBaseManager.getInstance().getShelfType(ipText,ipPort)){
						populateValues((String)dialog.getShelfModel().getSelectedItem());
						handleApplyButton();
					}else{
						JOptionPane.showMessageDialog(frame, NeConstants.ALREADY_CREATED_NE);
						dialog.setVisible(false);
					}
					resetDialog();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if(null!=displayDialog && e.getSource()==displayDialog.getOkButton()){
				displayDialog.setVisible(false);
			}else if(null!=displayDialog && e.getSource()==displayDialog.getClearButton()){
				displayDialog.setVisible(false);
				DataBaseManager.getInstance().clearAllTable();
				for(int i=0;i<table.getRowCount();i++){
					NECreator.getInstance().disposeNe((String)table.getValueAt(i, 0), (String)table.getValueAt(i, 1));
					table.setValueAt("", i, 0);
					table.setValueAt("", i, 1);
					table.setValueAt("", i, 2);
					table.clearSelection();
				}
				NETableModel tableMode = (NETableModel)table.getModel();
				tableMode.getIpList().clear();
				tableMode.setNewData();
			}
		}
	}
	
	private NeInfo getNeInformation(){
		NeInfo neinfo = new NeInfo();
		neinfo.setIp(ipText);
		neinfo.setPort(ipPort);
		neinfo.setLocation(neLocation);
		neinfo.setNeName(neNameValue);
		neinfo.setShelf((String)dialog.getShelfModel().getSelectedItem());
		neinfo.setSoftwareVersion(neVersion);
		neinfo.setStatus("Started");
		neinfo.setAreaServerd(areaServedLocation);
		neinfo.setSyncStatus("Synchronized");
		return neinfo;
		
	}
	
	private void resetDialog(){
		ipTextFiled.setText("");
		portTextFiled.setText("");
		createNeButton.setEnabled(false);
		neNameTextFiled.setText("");
  	    locationTextFiled.setText("");
  	    areaServedTextFiled.setText("");
	}
	
	private void addListners(){
		startItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(
						null,
						"Are You Sure you want to Start the NE",
						"Warning Dialog",
						JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION){
					int row= table.getSelectedRow();
					boolean result;
					try {
						result = NECreator.getInstance().startNe((String)table.getValueAt(row, 0), (String)table.getValueAt(row, 1));
						if(result){
							table.setValueAt(NeConstants.STARTED, row, 2);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}); 
		deleteItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n = JOptionPane.showConfirmDialog(
						null,
						"Are You Sure? \nyou want to stop the NE",
						"Warning Dialog",
						JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION){
					int row= table.getSelectedRow();
					boolean result = NECreator.getInstance().disposeNe((String)table.getValueAt(row, 0), (String)table.getValueAt(row, 1));
					if(result){
						table.setValueAt(NeConstants.STOPED, row, 2);
					}
				}
			}
		}); 
		editItem.addActionListener(listner); 
		displayItem.addActionListener(listner); 
	}
	
	private void setCommonMenu(){
		nePopupMenu.add(editItem);
		nePopupMenu.add(displayItem);
	}
	
	private void createDialog(){
      EventQueue.invokeLater(new Runnable() {
            public void run() {
               if(NECreator.getInstance().isDuplicated(ipTextFiled.getText(), ipTextFiled.getText())){
            	   JOptionPane.showMessageDialog(frame, NeConstants.ALREADY_CREATED_NE);
               }else{
            	    dialog = new AddDialog(new javax.swing.JFrame(), true);
                    dialog.setLocationRelativeTo(null);
                    dialog.getOkButton().addActionListener(dListner);
                    dialog.getCancel().addActionListener(dListner);
                    dialog.getApply().addActionListener(dListner);
                    dialog.getSlotCombo().addActionListener(comboListner);
     			    dialog.getPortCombo().addActionListener(comboListner);
                    dialog.setVisible(true);
               }
           
            }
        });
	}
	
	private void createEditDialog(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	int row = table.getSelectedRow();
            	ipText= (String)table.getValueAt(row, 0);
            	ipPort = (String)table.getValueAt(row, 1);
            	editdialog= new EditDialog(new javax.swing.JFrame(), true);
    			editdialog.setLocationRelativeTo(null);
    			editdialog.getSlotCombo().addActionListener(editComboListner);
    			editdialog.getPortCombo().addActionListener(editComboListner);
    			editdialog.getOkButton().addActionListener(editdListner);
    			editdialog.getApplyButton().addActionListener(editdListner);
    			editdialog.getCancelButton().addActionListener(editdListner);
    			editdialog.getSlotCombo().setSelectedIndex(0);
    			editdialog.setVisible(true);
            }
        });
	}
	
	private void createDisplayDialog(){
	      EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	displayDialog = new DisplayDialog(new JFrame(), true);
	            	displayDialog.setLocationRelativeTo(null);
	            	int row = table.getSelectedRow();
	            	ipText= (String)table.getValueAt(row, 0);
	            	ipPort = (String)table.getValueAt(row, 1);
					displayDialog.getSlotCombo().addActionListener(comboListner);
					displayDialog.getSlotCombo().setSelectedIndex(0);
					displayDialog.getOkButton().addActionListener(dListner);
					displayDialog.getClearButton().addActionListener(dListner);
					displayDialog.setVisible(true);
	            }
	        });
		}
	
	private void enableDisableFields(boolean enable){
		dialog.getfacility().setEnabled(enable);
		dialog.getServiceTypeCombo().setEnabled(enable);
		dialog.getFrequencyCombo().setEnabled(enable);
		dialog.getWavelengthCombo().setEnabled(enable);
		dialog.getDiffrentialEncodingCombo().setEnabled(enable);
		dialog.getCdfi().setEnabled(enable);
		dialog.getApply().setEnabled(enable);
		dialog.getOkButton().setEnabled(enable);
	}
	

	public void enableDisableCardCombos(boolean enableDisable) {
		dialog.getCardCombo().setEnabled(enableDisable);
		dialog.getModCombo().setEnabled(enableDisable);
		dialog.getTrafficCombo().setEnabled(enableDisable);
		dialog.getPrimaryCombo().setEnabled(enableDisable);
		dialog.getPecCombo().setEnabled(enableDisable);
		dialog.getSerialNo().setEnabled(enableDisable);
		dialog.getProfileCombo().setEnabled(enableDisable);
	}

	
	private void setDefaultValues(){
		editdialog.getFacilityCombo().setSelectedIndex(0);
		editdialog.getServiceTypeCombo().setSelectedIndex(0);
		editdialog.getFrequencyCombo().setSelectedIndex(0);
		editdialog.getWavelengthCombo().setSelectedIndex(0);
		editdialog.getDiffrentialEncodingCombo().setSelectedIndex(0);
		editdialog.getCdfi().setText("");
		editdialog.getSerialNo().setText("SFWB"+System.currentTimeMillis());
	}
		
	private void putTableValues(){
		  List<Facility> facList = DataBaseManager.getInstance().getAllFacilityOnSlot(ipText, (String)displayDialog.getSlotCombo().getSelectedItem());
		  Card card = DataBaseManager.getInstance().getCardOnSlot(ipText, (String)displayDialog.getSlotCombo().getSelectedItem());
		  if(null!=card){
			  displayDialog.getCardCombo().setSelectedItem(card.getCardName());
		  }else{
			  displayDialog.getCardCombo().setSelectedItem("-");
		  }
		  JTable table = displayDialog.getTable();
		  Object[][] data = getModel(facList);
		  table.setModel(new DefaultTableModel(data, displayDialog.getColumnName()));
	}
	
	
	private Object[][] getModel(List<Facility> facList){
		Iterator<Facility> it = facList.iterator();
		Object[][] objArray = new Object[facList.size()][displayDialog.getColumnName().length];
		for(int i=0;i<facList.size();i++){
			Facility fac = it.next();
		    objArray[i][0]=fac.getId().split("-")[2];
		    objArray[i][1]=fac.getFacility();
		    objArray[i][2]=fac.getServiceType();
		    objArray[i][3]=fac.getFrequency();
		    objArray[i][4]=fac.getWavelength();
		    objArray[i][5]=fac.getDiffrentialEncoding();
		    objArray[i][6]=fac.getCdfi();
		}
		return objArray;
	}
	
	private boolean isCardAvailable(String slot,String shelf){
		Card cardName = DataBaseManager.getInstance().getCardOnSlot(ipText, slot);
		if(null!=cardName){
			putCardValues(cardName);
			return true;
		}else{
			dialog.getSerialNo().setText("SFWB"+System.currentTimeMillis());
			return false;
		}
	}
	
	private void putCardValues(Card cardName) {
		dialog.getCardCombo().setSelectedItem(cardName.getCardName());
		dialog.getModCombo().setSelectedItem(cardName.getMod());
		dialog.getTrafficCombo().setSelectedItem(cardName.getTraficStatus());
		dialog.getPrimaryCombo().setSelectedItem(cardName.getPrimaryState());
		dialog.getPecCombo().setSelectedItem(cardName.getProvisionPec());
		dialog.getSerialNo().setText(cardName.getSerialNo());
		dialog.getProfileCombo().setSelectedItem(cardName.getProfile());
	}

	private boolean isFacilityAvailable(JDialog dialog , String slot,String shelf ,String port){
		Facility fac = DataBaseManager.getInstance().getFacilityOnSlotAndPort(ipText, slot, port);
		if(null!=fac){
			setAddDialogComboValue(dialog ,fac);
			return true;
		}else{
			return false;
		}
	}
	
	private void setAddDialogComboValue(JDialog dialog ,Facility fac){
		AddDialog addDialog = (AddDialog)dialog;
		addDialog.getfacility().setSelectedItem(fac.getFacility());
		addDialog.getServiceTypeCombo().setSelectedItem(fac.getServiceType());
		addDialog.getWavelengthCombo().setSelectedItem(fac.getWavelength());
		addDialog.getFrequencyCombo().setSelectedItem(fac.getFrequency());
		addDialog.getDiffrentialEncodingCombo().setSelectedItem(fac.getDiffrentialEncoding());
		addDialog.getCdfi().setText(fac.getCdfi());
	}
	
	private void handleApplyButton(){
		dialog.getShelfModel().setEnabled(false);
		dialog.getModCombo().setEnabled(false);
		dialog.getTrafficCombo().setEnabled(false);
		dialog.getPrimaryCombo().setEnabled(false);
		dialog.getPecCombo().setEnabled(false);
		dialog.getSerialNo().setEnabled(false);
		dialog.getProfileCombo().setEnabled(false);
		dialog.getCardCombo().setEnabled(false);
		dialog.getApply().setEnabled(false);
		dialog.getOkButton().setEnabled(false);
		dialog.getfacility().setEnabled(false);
		dialog.getServiceTypeCombo().setEnabled(false);
		dialog.getFrequencyCombo().setEnabled(false);
		dialog.getWavelengthCombo().setEnabled(false);
		dialog.getDiffrentialEncodingCombo().setEnabled(false);
		dialog.getCdfi().setEnabled(false);
	}

	private void populateValues(String ipShelf) {
		Facility f1 = new Facility();
     	f1.setCdfi(dialog.getCdfi().getText());
     	f1.setDiffrentialEncoding(((String)dialog.getDiffrentialEncodingCombo().getSelectedItem()));
     	f1.setFacility(((String)dialog.getfacility().getSelectedItem()));
     	f1.setId(getId(f1));
		f1.setFrequency((String)dialog.getFrequencyCombo().getSelectedItem());
		f1.setServiceType((String)dialog.getServiceTypeCombo().getSelectedItem());
		f1.setWavelength((String)dialog.getWavelengthCombo().getSelectedItem());
		DataBaseManager.getInstance().insertFacility(f1, ipText);
		List<Card> cardList = DataBaseManager.getInstance().getAllCards(ipText);
		String cardId = dialog.getCardCombo().getSelectedItem()+"-"+dialog.getSlotCombo().getSelectedItem();
		Card foundCard = null;
		if(null!=cardList){
			for(Card card : cardList){
				if(card.getIp().equals(ipText) && card.getId().equals(cardId)){
					foundCard=card;
					break;
				}
			}
		}
		if(foundCard==null){
			foundCard = new Card();
			foundCard.setId(cardId);
			foundCard.setSlot((String)dialog.getSlotCombo().getSelectedItem());
			foundCard.setIp(ipText);
			foundCard.setMod((String)dialog.getModCombo().getSelectedItem());
			foundCard.setPrimaryState((String)dialog.getPrimaryCombo().getSelectedItem());
			foundCard.setProfile((String)dialog.getProfileCombo().getSelectedItem());
			foundCard.setProvisionPec((String)dialog.getPecCombo().getSelectedItem());
			foundCard.setSerialNo(dialog.getSerialNo().getText());
			foundCard.setTraficStatus((String)dialog.getTrafficCombo().getSelectedItem());
			foundCard.setCardName((String)dialog.getCardCombo().getSelectedItem());
			DataBaseManager.getInstance().insertCard(foundCard,ipText);
		}
	}
	

	private void populateEditValues(){
		Card card = DataBaseManager.getInstance().getCardOnSlot(ipText, (String)editdialog.getSlotCombo().getSelectedItem());
		card.setMod((String)editdialog.getModCombo().getSelectedItem());
		card.setPrimaryState((String)editdialog.getPrimaryCombo().getSelectedItem());
		card.setProfile((String)editdialog.getProfileCombo().getSelectedItem());
		card.setProvisionPec((String)editdialog.getPecCombo().getSelectedItem());
		card.setTraficStatus((String)editdialog.getTraficCombo().getSelectedItem());
		DataBaseManager.getInstance().updateCard(card, ipText);
		
		Facility fac = DataBaseManager.getInstance().getFacilityOnSlotAndPort(ipText, (String)editdialog.getSlotCombo().getSelectedItem(), (String)editdialog.getPortCombo().getSelectedItem());
		if(null!=fac){
			DataBaseManager.getInstance().deleteFac(fac.getId(), ipText);
		}
		Facility f1 = new Facility();
		f1.setCdfi(editdialog.getCdfi().getText());
		f1.setDiffrentialEncoding(((String)editdialog.getDiffrentialEncodingCombo().getSelectedItem()));
		f1.setFacility(((String)editdialog.getFacilityCombo().getSelectedItem()));
		f1.setId(getEditId(f1));
		f1.setFrequency((String)editdialog.getFrequencyCombo().getSelectedItem());
		f1.setServiceType((String)editdialog.getServiceTypeCombo().getSelectedItem());
		f1.setWavelength((String)editdialog.getWavelengthCombo().getSelectedItem());
		DataBaseManager.getInstance().insertFacility(f1, ipText);	
		editdialog.getCardCombo().setEnabled(false);
	}
	
	private String getEditId(Facility obj) {
		 if(obj instanceof Facility){
		    	Facility fac = (Facility)obj;
		    	return fac.getFacility()+"-"+editdialog.getSlotCombo().getSelectedItem()+"-"+editdialog.getPortCombo().getSelectedItem(); 
		    }
			return null;
	}

	private String getId(Object obj){
	    if(obj instanceof Facility){
	    	Facility fac = (Facility)obj;
	    	return fac.getFacility()+"-"+dialog.getSlotCombo().getSelectedItem()+"-"+dialog.getPortCombo().getSelectedItem(); 
	    }
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new NESimulator();
			}
		});
	}
}
