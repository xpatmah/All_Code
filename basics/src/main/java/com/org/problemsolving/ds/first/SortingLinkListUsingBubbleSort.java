package com.org.problemsolving.ds.first;

import java.util.Random;

public class SortingLinkListUsingBubbleSort {

class Node{
		
		Node next;
		
		Integer info;

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Integer getInfo() {
			return info;
		}

		public void setInfo(Integer info) {
			this.info = info;
		}
	} 

	private Node start;

	
	public void create(int x) {
		Random ran = new Random();
		start = new Node();
		start.setInfo(ran.nextInt(200));
		start.setNext(null);
		Node pointer = start;
       for(int i = 0; i < x;i++) {
    	   Node nd = new Node();
    	   nd.setInfo(ran.nextInt(200));
    	   nd.setNext(null);
    	   pointer.next = nd;
    	   pointer = nd;
       }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortingLinkListUsingBubbleSort list = new SortingLinkListUsingBubbleSort();
		list.sortList();
	}
	
	public void sortList() {
	   Node p,q, end;
	   
	   for(end = null ; end!=start.getNext(); end = p ) {
		   for(p = start  ; p.getNext()!=end ; p = p.getNext()) {
              q = p.getNext();
              if(p.getInfo() > q.getInfo()) {
            	  
              }
              
		   }
	   }
	   
		
		
		
		
		
	}
	

	
	
}
