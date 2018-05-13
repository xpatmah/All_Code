package ds.programming.practice;

public class LinkedListReversal {
	
	private Node start;
	
	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}

	public static void main(String[] args) {
     
	  SingleLinkedListGeneration list = new SingleLinkedListGeneration(12);
	  LinkedListReversal reversal = new LinkedListReversal();
	  reversal.setStart(list.getList());
	  reversal.printlinkedList(reversal.getStart());
	  reversal.reverse();
	  System.out.println();
	  reversal.printlinkedList(reversal.getStart());
	}
	
	private void reverse() {
		// TODO Auto-generated method stub
		Node pre = null;
		Node current = start;
		while(current!=null) {
			Node next = current.getNext();
			current.setNext(pre);
			pre = current;
			current = next;
		}
		start = pre;
	}
	
	public void printlinkedList(Node node) {
		if(node==null) {
			return;
		}
		System.out.print(node.getInfo()+", ");
		printlinkedList(node.getNext());
	}
}
