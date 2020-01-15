package com.org.multithreading.first.impl;

public class MySignal {

		private boolean hasDataToProcess = false;
		
		public synchronized boolean hasDatatoProcess() {
			return hasDataToProcess;
		}
		
		public synchronized void setDataToProcess(boolean data) {
			this.hasDataToProcess = data;
		}
}
