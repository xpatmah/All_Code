package com.org.problemsolving.ds.first.programming.practice.ds.tree;



public interface IBinarySearchTree {

	public boolean addElement(int key,String value);
	
	public void printBinarryTree();
	
	public void InOrderTraversalWithStack();
	
	public void postOrderWithStack();
	
	public void preOrderWithStack();
	
	public void findMaxWithPostOrderWithStack();
	
	public void findMaxWithPreOrderWithStack();
	
	public void findMaxWithInOrderWithStack();
	
	public int sizeOfBinaryTreewithInOrder();
	
	public void deleteBinaryTree();
	
	public void printLevelOrderTraversingInReverseOrder();
	
	public int findHightWithPostOrder();
	
	public void findHightUsingInOrder();
	
	public void findHeight();
	
	public void findHeightWithBFS();
	
	public void findDeepestNode();
	
	public void findDeepestNodeUsingPostOrder();
	
	public void findDeepestNodeUsingBFS();
	
}
