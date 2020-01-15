package ds.programming.practice;

import java.util.Random;

public class SingleLinkedListGeneration {

	private int length;
	
	private Node start;
	
	private Random random = new Random();
	
	public SingleLinkedListGeneration(int length) {
		this.length = length;
	}
	
	public Node getList() {
		start  = new Node();
		start.setNext(null);
		start.setInfo(random.nextInt(199));
		Node temp = start;
		for(int i = 0 ; i < length-1 ; i++) {
			Node node = new Node();
			node.setInfo(random.nextInt(199));
			node.setNext(null);
			temp.setNext(node);
            temp = node; 			
		}
		return start;
		
	}
	
	
	public void printList(Node start) {
		for(Node node = start ; node!=null ; node = node.getNext()) {
			System.out.print(node.getInfo()+", ");
		}
	}
	
	
}
