package com.org.simulation.ne;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.table.AbstractTableModel;

public class NETableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7442210830030717273L;
	
	private String[] columnNames = {"IP","Port","Status"};
	private Object[][] data = new Object[1][3];
	private Set<String> ipList = new HashSet<String>();

	public Set<String> getIpList() {
		return ipList;
	}
	
	public void setNewData(){
		data = new Object[1][3];
		integer.set(0);
	}

	private AtomicInteger integer = new AtomicInteger(0);
	
	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	public boolean isCellEditable(int row, int col) {
		return  false;
	}


	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}
	
	public boolean setAllValues(String ip,String port, String Sta){
		 
		  Object[][] temp ;
		  
		  if(!ipList.contains(ip)){
			  if(data.length==integer.get()){
				  temp = new Object[data.length*2][columnNames.length];
				  for(int r = 0 ;r<data.length;r++){
					  for(int c =0;c<columnNames.length;c++){
						  temp[r][c]=data[r][c];
					  }
				  }
				  data=temp;
			  }
			  int row = integer.get();
			  data[row][0]=ip;
			  data[row][1]=port;
			  data[row][2]=Sta;
			  ipList.add(ip);
			  integer.incrementAndGet();
			  fireTableDataChanged();
			  return true;
		  }
		  return false;
	}


}
