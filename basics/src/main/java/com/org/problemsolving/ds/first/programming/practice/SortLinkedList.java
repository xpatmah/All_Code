package com.org.problemsolving.ds.first.programming.practice;

public class SortLinkedList {

	public static void main(String[] args) {
		
		SingleLinkedListGeneration list = new SingleLinkedListGeneration(12);
		Node startNode = list.getList();
		list.printList(startNode);
		SortLinkedList sortedList = new SortLinkedList();
		startNode = sortedList.getSortedListWithExLinks(startNode);
		Node secondNode = sortedList.getSortedList(list.getList());
		System.out.println();
		list.printList(startNode);
		System.out.println();
		list.printList(secondNode);
	}
	
	public Node getSortedList(Node startNode) {
		Node end, p , q;
		
		for(end = null ; end!=startNode.getNext() ; end = p) {
			for(p = startNode ; p.getNext()!=end ; p = p.getNext()) {
				q = p.getNext();
				if(p.getInfo() > q.getInfo()) {
					 int temp = p.getInfo();
					 p.setInfo(q.getInfo());
					 q.setInfo(temp);
				}
			}
		}
		return startNode;
	}
	
	public Node getSortedListWithExLinks(Node start) {

		Node p,q,r,end,temp;
		
		for(end = null ; end!=start.getNext(); end = p) {
			for(r = p = start ; p.getNext()!=end ;r=p, p=p.getNext()) {
				q =p.getNext();
				if(p.getInfo() > q.getInfo()) {
					p.setNext(q.getNext());
					q.setNext(p);
					if(p!=start) {
						r.setNext(q);
					}else {
						start = q;
					}
					temp = p;
					p = q;
					q = temp;
				}
			}
		}
		return start;
	}

}
