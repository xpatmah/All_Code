package ds.programming.practice;

public class SortLinkedList {

	public static void main(String[] args) {
		
		SingleLinkedListGeneration list = new SingleLinkedListGeneration(12);
		Node startNode = list.getList();
		list.printList(startNode);
		SortLinkedList sortedList = new SortLinkedList();
		startNode = sortedList.getSortedList(startNode);
		System.out.println();
		list.printList(startNode);
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
	
	public Node getSortedListWithExData(Node start) {

		Node p,q,r,end,temp;
		
		for(end = null ; end!=start.getNext(); end = p) {
			for(r = p = start ; p.getNext()!=null ;r=p, p=p.getNext()) {
				q =p.getNext();
				if(p.getInfo() > q.getInfo()) {
					p.setNext(q.getNext());
				}
			}
		}
		return start;
	}

}
