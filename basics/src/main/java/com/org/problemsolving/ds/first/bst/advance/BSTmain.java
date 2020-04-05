package com.org.problemsolving.ds.first.bst.advance;

public class BSTmain {

	
	public static void main(String[] args) {
		
		BST bst = new BST();
		
		bst.addNode(37);
		
		bst.addNode(20);
		bst.addNode(15);
		bst.addNode(45);
		bst.addNode(35);
		bst.addNode(49);
		bst.addNode(50);
		bst.addNode(25);
		bst.addNode(44);
		bst.addNode(17);
		bst.addNode(67);
		
	    bst.checkTree();
	    
	  /*  bst.deleteNode(49);*/
	    bst.deleteNode(37);
	    bst.checkTree();
	    
		
	}
	
}
