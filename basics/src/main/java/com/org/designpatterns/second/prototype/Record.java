package com.org.designpatterns.second.prototype;

public class Record  implements Cloneable{

	private String recordName;
	
	public String getRecordName() {
		return recordName;
	}

	@Override
	protected Record clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Record)super.clone();
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	@Override
	public String toString() {
		return "Record [recordName=" + recordName + "]";
	}

	public Record(String name) {
		this.recordName = name;
	}
	
}
