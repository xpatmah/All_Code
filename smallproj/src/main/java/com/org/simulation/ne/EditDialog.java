package com.org.simulation.ne;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.FeatureDescriptor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.org.simulation.ne.AddDialog.ComboBoxListner;


public class EditDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2993392054149500169L;

	public static final DefaultComboBoxModel<String> pktotnModel = new DefaultComboBoxModel<>(new String[] { "PTP", "ODUTTP", "ODUCTP", "TCMTTP"});
    public static final DefaultComboBoxModel<String> _100GMuxModel = new DefaultComboBoxModel<>(new String[] { "OTM2", "OTM4", "OTM6", "OTM10"});
    public static final DefaultComboBoxModel<String> _100GOCLDModel = new DefaultComboBoxModel<>(new String[] { "OC12", "OC48", "OC192", "ODU1"});
    public static final DefaultComboBoxModel<String> _EmotrModel = new DefaultComboBoxModel<>(new String[] { "ODU3", "STM4", "STM16", "STM64"});
 
    private ComboBoxListner listner = new ComboBoxListner();
    
    
   	public static final DefaultComboBoxModel<String> pktotnpecModel = new DefaultComboBoxModel<>(new String[] { "NTK760MK", "NTK760MA", "NTK761AA", "NTK769AL"});
    public static final DefaultComboBoxModel<String> _100GMuxpecModel = new DefaultComboBoxModel<>(new String[] { "NTK539AA", "NTK537AA", "NTK538AB", "NTK536AJ"});
    public static final DefaultComboBoxModel<String> _100GOCLDpecModel = new DefaultComboBoxModel<>(new String[] { "NTK675AA", "NTK675AB", "NTK675AJ", "NTK675GT"});
    public static final DefaultComboBoxModel<String> _EmotrpecModel = new DefaultComboBoxModel<>(new String[] { "NTK428BB", "NTK429BA", "NTK427BK", "NTK424BL"});
    
	public EditDialog(java.awt.Frame parent, boolean modal) {
		 super(parent, modal);
	     initComponents();
	     setTitle("Edit Dialog");
	}
	
	 @SuppressWarnings("unchecked")                      
	    private void initComponents() {
		 java.awt.GridBagConstraints gridBagConstraints;

	        jPanel2 = new javax.swing.JPanel();
	        jPanel1 = new javax.swing.JPanel();
	        okButton = new javax.swing.JButton();
	        applyButton = new javax.swing.JButton();
	        cancelButton = new javax.swing.JButton();
	        jLabel2 = new javax.swing.JLabel();
	        slotCombo = new javax.swing.JComboBox<>();
	        jLabel3 = new javax.swing.JLabel();
	        cardCombo = new javax.swing.JComboBox<>();
	        jLabel4 = new javax.swing.JLabel();
	        portCombo = new javax.swing.JComboBox<>();
	        jLabel5 = new javax.swing.JLabel();
	        facilityCombo = new javax.swing.JComboBox<>();
	        jLabel6 = new javax.swing.JLabel();
	        wavelengthCombo = new javax.swing.JComboBox<>();
	        jLabel7 = new javax.swing.JLabel();
	        cdfi = new javax.swing.JTextField();
	        jLabel8 = new javax.swing.JLabel();
	        jLabel9 = new javax.swing.JLabel();
	        serviceTypeCombo = new javax.swing.JComboBox<>();
	        frequencyCombo = new javax.swing.JComboBox<>();
	        jLabel10 = new javax.swing.JLabel();
	        diffrentialEncodingCombo = new javax.swing.JComboBox<>();
	        jLabel11 = new javax.swing.JLabel();
	        primaryCombo = new javax.swing.JComboBox<>();
	        jLabel12 = new javax.swing.JLabel();
	        pecCombo = new javax.swing.JComboBox<>();
	        jLabel13 = new javax.swing.JLabel();
	        modCombo = new javax.swing.JComboBox<>();
	        jLabel14 = new javax.swing.JLabel();
	        profileCombo = new javax.swing.JComboBox<>();
	        jLabel15 = new javax.swing.JLabel();
	        traficCombo = new javax.swing.JComboBox<>();
	        jLabel16 = new javax.swing.JLabel();
	        serialNo = new javax.swing.JTextField();

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setResizable(false);
	        getContentPane().setLayout(new java.awt.GridBagLayout());

	        okButton.setText("OK");

	        cancelButton.setText("Cancel");

	        applyButton.setText("Apply");
	      

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap(161, Short.MAX_VALUE)
	                .addComponent(okButton)
	                .addGap(18, 18, 18)
	                .addComponent(applyButton)
	                .addGap(18, 18, 18)
	                .addComponent(cancelButton)
	                .addGap(161, 161, 161))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(applyButton)
	                    .addComponent(cancelButton)
	                    .addComponent(okButton))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 30;
	        gridBagConstraints.gridwidth = 10;
	        gridBagConstraints.ipadx = 30;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(37, 12, 13, 0);
	        getContentPane().add(jPanel1, gridBagConstraints);

	        jLabel2.setText("Slot No:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 0;
	        gridBagConstraints.gridwidth = 3;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(36, 184, 0, 0);
	        getContentPane().add(jLabel2, gridBagConstraints);

	        slotCombo.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4","5", "6", "7", "8","9", "10", "11", "12"}));
	       
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 0;
	        gridBagConstraints.gridwidth = 3;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(36, 53, 0, 0);
	        getContentPane().add(slotCombo, gridBagConstraints);

	        jLabel3.setText("Card:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 2;
	        gridBagConstraints.gridwidth = 3;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(10, 198, 0, 0);
	        getContentPane().add(jLabel3, gridBagConstraints);

	        cardCombo.setModel(new DefaultComboBoxModel<>(new String[] {  "PKTOTN", "100GMUX", "100GOCLD","EMOTR"}));
	        cardCombo.addActionListener(listner);
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 2;
	        gridBagConstraints.gridwidth = 4;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(7, 53, 0, 0);
	        getContentPane().add(cardCombo, gridBagConstraints);

	        jLabel4.setText("Port:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 16;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(10, 200, 0, 0);
	        getContentPane().add(jLabel4, gridBagConstraints);

	        portCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12" }));
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 16;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(7, 51, 0, 0);
	        getContentPane().add(portCombo, gridBagConstraints);

	        jLabel5.setText("Facility:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 18;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(10, 184, 0, 0);
	        getContentPane().add(jLabel5, gridBagConstraints);

	        facilityCombo.setModel(pktotnModel);
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 18;
	        gridBagConstraints.gridwidth = 2;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(7, 51, 0, 0);
	        getContentPane().add(facilityCombo, gridBagConstraints);

	        jLabel6.setText("Wavelength:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 24;
	        gridBagConstraints.ipady = 6;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(0, 156, 0, 0);
	        getContentPane().add(jLabel6, gridBagConstraints);

	        wavelengthCombo.setModel(new DefaultComboBoxModel<>(new String[] { "1601.2", "1602.1", "1603.4", "1604.6", "1605.5" }));
	        
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 24;
	        gridBagConstraints.gridwidth = 3;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(7, 51, 0, 0);
	        getContentPane().add(wavelengthCombo, gridBagConstraints);

	        jLabel7.setText("Customer Definend Identifier:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 28;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(10, 59, 0, 0);
	        getContentPane().add(jLabel7, gridBagConstraints);

	        cdfi.setText("");
	       
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 28;
	        gridBagConstraints.gridwidth = 6;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.ipadx = 176;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(7, 51, 0, 0);
	        getContentPane().add(cdfi, gridBagConstraints);

	        jLabel8.setText("Service Type:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 20;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(10, 149, 0, 0);
	        getContentPane().add(jLabel8, gridBagConstraints);

	        jLabel9.setText("Frequency:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 22;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(10, 164, 0, 0);
	        getContentPane().add(jLabel9, gridBagConstraints);

	        serviceTypeCombo.setModel(new DefaultComboBoxModel<>(new String[] { "10G", "20G", "30G", "40G","100G"})); 
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 20;
	        gridBagConstraints.gridwidth = 2;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(7, 51, 0, 0);
	        getContentPane().add(serviceTypeCombo, gridBagConstraints);

	        frequencyCombo.setModel(new DefaultComboBoxModel<>(new String[] { "10", "20", "30", "40" }));
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 22;
	        gridBagConstraints.gridwidth = 2;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(7, 51, 0, 0);
	        getContentPane().add(frequencyCombo, gridBagConstraints);

	        jLabel10.setText("Diffrential Encoding:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 26;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(10, 113, 0, 0);
	        getContentPane().add(jLabel10, gridBagConstraints);

	        diffrentialEncodingCombo.setModel(new DefaultComboBoxModel<>(new String[] { "HARD", "SOFT", "NONE"}));
	        
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 26;
	        gridBagConstraints.gridwidth = 2;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(7, 51, 0, 0);
	        getContentPane().add(diffrentialEncodingCombo, gridBagConstraints);

	        jLabel11.setText("Primary State:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 4;
	        gridBagConstraints.gridwidth = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(10, 146, 0, 0);
	        getContentPane().add(jLabel11, gridBagConstraints);

	        primaryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IS", "OSS", "OSS-MA"}));
	      
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 4;
	        gridBagConstraints.gridwidth = 3;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(7, 53, 0, 0);
	        getContentPane().add(primaryCombo, gridBagConstraints);

	        jLabel12.setText("Provision Pec: ");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 6;
	        gridBagConstraints.gridwidth = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(10, 145, 0, 0);
	        getContentPane().add(jLabel12, gridBagConstraints);

	        pecCombo.setModel(pktotnpecModel);
	        
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 6;
	        gridBagConstraints.gridwidth = 3;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(7, 53, 0, 0);
	        getContentPane().add(pecCombo, gridBagConstraints);

	        jLabel13.setText("MOD:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 8;
	        gridBagConstraints.gridwidth = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(10, 197, 0, 0);
	        getContentPane().add(jLabel13, gridBagConstraints);

	        modCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "QPSK", "BPSK", "100QPSK", "40BPSK"}));
	        
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 8;
	        gridBagConstraints.gridwidth = 3;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(7, 53, 0, 0);
	        getContentPane().add(modCombo, gridBagConstraints);

	        jLabel14.setText("Profile:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 10;
	        gridBagConstraints.gridwidth = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(16, 188, 0, 0);
	        getContentPane().add(jLabel14, gridBagConstraints);

	        profileCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "10G", "40GUNNI", "4X10G", "10GUII"}));
	        
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 10;
	        gridBagConstraints.gridwidth = 3;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(13, 53, 0, 0);
	        getContentPane().add(profileCombo, gridBagConstraints);

	        jLabel15.setText("Trafic Status:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 12;
	        gridBagConstraints.gridwidth = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(10, 151, 0, 0);
	        getContentPane().add(jLabel15, gridBagConstraints);

	        traficCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));     
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 12;
	        gridBagConstraints.gridwidth = 3;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(7, 53, 0, 0);
	        getContentPane().add(traficCombo, gridBagConstraints);

	        jLabel16.setText("Serial No:");
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 14;
	        gridBagConstraints.gridwidth = 2;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(10, 172, 0, 0);
	        getContentPane().add(jLabel16, gridBagConstraints);

	        serialNo.setText("");
	        
	        gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 3;
	        gridBagConstraints.gridy = 14;
	        gridBagConstraints.gridwidth = 5;
	        gridBagConstraints.gridheight = 2;
	        gridBagConstraints.ipadx = 144;
	        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	        gridBagConstraints.insets = new java.awt.Insets(7, 53, 0, 0);
	        getContentPane().add(serialNo, gridBagConstraints);

	        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	        setResizable(false);
	        
	        pack();
		
	    }// </editor-fold> 
	
	  public JComboBox<String> getPrimaryCombo() {
		return primaryCombo;
	}

	public JComboBox<String> getPecCombo() {
		return pecCombo;
	}

	public JComboBox<String> getModCombo() {
		return modCombo;
	}

	public JComboBox<String> getProfileCombo() {
		return profileCombo;
	}

	public JComboBox<String> getTraficCombo() {
		return traficCombo;
	}

	public JTextField getSerialNo() {
		return serialNo;
	}

	protected void jComboBox10ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JButton getApplyButton() {
		return applyButton;
	}

	class ComboBoxListner implements ActionListener{

	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		if(e.getSource()==cardCombo){
	    			String card = (String)cardCombo.getSelectedItem();
	    			if("100GOCLD".equals(card)){
	    				facilityCombo.setModel(_100GOCLDModel);
	    				pecCombo.setModel(_100GOCLDpecModel);
	    			}else if("PKTOTN".equals(card)){
	    				facilityCombo.setModel(pktotnModel);
	    				pecCombo.setModel(pktotnpecModel);
	    			}else if("100GMUX".equals(card)){
	    				facilityCombo.setModel(_100GMuxModel);
	    				pecCombo.setModel(_100GMuxpecModel);
	    			}else if("EMOTR".equals(card)){
	    				facilityCombo.setModel(_EmotrModel);
	    				pecCombo.setModel(_EmotrpecModel);
	    			}
	    		}
	    	}
	    }
	 
	                                    

	
	 // Variables declaration - do not modify                     
    private JButton okButton;
    private JButton cancelButton;
    private JButton applyButton;
  
    
    public JComboBox<String> getSlotCombo() {
		return slotCombo;
	}

	public JComboBox<String> getCardCombo() {
		return cardCombo;
	}

	public JComboBox<String> getPortCombo() {
		return portCombo;
	}

	public JComboBox<String> getFacilityCombo() {
		return facilityCombo;
	}

	public JComboBox<String> getWavelengthCombo() {
		return wavelengthCombo;
	}

	public JComboBox<String> getServiceTypeCombo() {
		return serviceTypeCombo;
	}

	public JComboBox<String> getFrequencyCombo() {
		return frequencyCombo;
	}

	public JComboBox<String> getDiffrentialEncodingCombo() {
		return diffrentialEncodingCombo;
	}

	public JTextField getCdfi() {
		return cdfi;
	}

    private JComboBox<String> primaryCombo;
	private JComboBox<String> pecCombo;
	private JComboBox<String> modCombo;
	private JComboBox<String> profileCombo;
    private JComboBox<String> traficCombo; 
    private JComboBox<String> cardCombo;
    private JComboBox<String> portCombo;
    private JComboBox<String> facilityCombo;
    private JComboBox<String> wavelengthCombo;
    private JComboBox<String> serviceTypeCombo;
    private JComboBox<String> frequencyCombo;
    private JComboBox<String> diffrentialEncodingCombo;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JComboBox<String> slotCombo;
    private JTextField cdfi;
    private JTextField serialNo;
    // End of variables declaration        
	
	
	
}
