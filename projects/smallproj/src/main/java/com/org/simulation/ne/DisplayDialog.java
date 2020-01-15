package com.org.simulation.ne;

import java.awt.Frame;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class DisplayDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1480601588763404110L;

	public String[] columnName = new String [] {"Port", "Facility", "Service Type", "Frequency", "Wavelength", "Diffrential Encoding", "Label"};
	
	

	public DisplayDialog(Frame parent, boolean modal) {
		super(parent, modal);
        initComponents();
        setTitle("Display Dialog");
	}
	
	 @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        jPanel2 = new JPanel();
	        jPanel1 = new JPanel();
	        okButton = new JButton();
	        clearButton = new JButton();
	        jLabel2 = new JLabel();
	        slotCombo = new JComboBox<>();
	        jLabel3 = new JLabel();
	        cardCombo = new JComboBox<>();
	        jScrollPane1 = new JScrollPane();
	        table = new JTable();

	        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );

	        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	        setResizable(false);

	        okButton.setText("OK");

	        clearButton.setText("Clear");
	        
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
		            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(jPanel1Layout.createSequentialGroup()
		                .addContainerGap(161, Short.MAX_VALUE)
		                .addComponent(okButton)
		                .addGap(18, 18, 18)
		                .addComponent(clearButton)
		                .addGap(180, 180, 180))
		        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)		
	                .addComponent(okButton)
	                .addComponent(clearButton))
	                .addContainerGap(21, Short.MAX_VALUE))
	        );

	        jLabel2.setText("Slot No:");

	        slotCombo.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4","5", "6", "7", "8","9", "10", "11", "12"}));

	        jLabel3.setText("Card:");

	        cardCombo.setModel(new DefaultComboBoxModel<>(new String[] {"-",  "PKTOTN", "100GMUX", "100GOCLD","EMOTR"}));
	        
	        cardCombo.setEnabled(false);

	        table.setModel(new DefaultTableModel(
	            new Object [][] {
	            },columnName
	        ));
	        table.setEnabled(false);
	        jScrollPane1.setViewportView(table);

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap(79, Short.MAX_VALUE)
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addGap(102, 102, 102))
	            .addGroup(layout.createSequentialGroup()
	                .addGap(34, 34, 34)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 666, GroupLayout.PREFERRED_SIZE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel2)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(10, 10, 10)
	                                .addComponent(jLabel3)))
	                        .addGap(31, 31, 31)
	                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(slotCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                            .addComponent(cardCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(slotCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel2))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel3)
	                    .addComponent(cardCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(30, 30, 30)
	                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
	                .addGap(27, 27, 27)
	                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(44, Short.MAX_VALUE))
	        );

	        pack();
	    }// </editor-fold>                        

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                        

	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                        

	    // Variables declaration - do not modify                     
	    private JButton okButton;
	    private JButton clearButton;

		public JButton getClearButton() {
			return clearButton;
		}

		public void setClearButton(JButton clearButton) {
			this.clearButton = clearButton;
		}

		private JComboBox<String> slotCombo;
	    
	    public JComboBox<String> getSlotCombo() {
			return slotCombo;
		}

		public JComboBox<String> getCardCombo() {
			return cardCombo;
		}
		
		public String[] getColumnName() {
			return columnName;
		}

		public JButton getOkButton() {
			return okButton;
		}
		
		public JTable getTable() {
			return table;
		}

		private JComboBox<String> cardCombo;
	    private JLabel jLabel2;
	    private JLabel jLabel3;
	    private JPanel jPanel1;
	    private JPanel jPanel2;
	    private JScrollPane jScrollPane1;
	    private JTable table;
	    // End of variables declaration     
	    
}
