package com.org.java.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.org.java.ds.BinarySearchTree.Node;

public class CreateBinaryTreeWithPreOrderAndInOrder {

	class Node{
		
		char key;
		
		String value;
		
		
		
		public Node(char key) {
			super();
			this.key = key;
		}


		public Node leftNode;
		public Node rightNode;
		
		
		public int getKey() {
			return key;
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] inorder = {'D','B','E','A','F','C'};
		
		char[] preOrder = {'A','B','D','E','C','F'};
		
		CreateBinaryTreeWithPreOrderAndInOrder treee = new CreateBinaryTreeWithPreOrderAndInOrder();
		
        Node rootNode= treee.createBinaryTree(inorder,preOrder);		
        
        printTree(rootNode);
	}


	private  Node createBinaryTree(char[] inorder, char[] preOrder) {
		// TODO Auto-generated method stub
		if(preOrder.length==0 || inorder.length!=preOrder.length){
			throw new RuntimeException("We can not build the tree As the order is inconsistant");
		}
		
		return createBT(preOrder, 0,preOrder.length-1, inorder,0,inorder.length);
	}

	private Node createBT(char[] preOrder, int startPointPreOrder , int endPointPreOrder, char[] inorder , int startPointInOrder,int endPointInOrder){
		
		  if((startPointPreOrder> endPointPreOrder)|| startPointInOrder>endPointInOrder){
			  return null;
		  }
		
		  char firstNode = preOrder[startPointPreOrder];

		  Node currentNode = new Node(firstNode);
		  
		  int offset = startPointInOrder;
		  
		  for(;offset<endPointInOrder;offset++){
			  if(currentNode.getKey()==inorder[offset]){
				  break;
			  }
		  } 
		  currentNode.leftNode = createBT(preOrder,startPointPreOrder+1, startPointPreOrder+offset-startPointInOrder,inorder,startPointInOrder,offset-1);		  
		  
		  currentNode.rightNode= createBT(preOrder,startPointPreOrder+offset-startPointInOrder+1,endPointPreOrder,inorder,offset+1, endPointInOrder);
		  
		return currentNode;
		
	}
	
	private static void printTree(Node newTree){
		 if(null==newTree){
			 System.out.println("There is no elementin the tree");
		 }

		 Queue<Node> nodeQueue = new LinkedList<Node>();

		 List<Node> nodeList  = new ArrayList<Node>();

		 nodeQueue.offer(newTree);
		 nodeQueue.offer(null);
		 while(!nodeQueue.isEmpty()){
			 Node currEle = nodeQueue.poll();
			 if(null!=currEle){
				 nodeList.add(currEle);
				 if(null!=currEle.leftNode){
					 nodeQueue.offer(currEle.leftNode);
				 }
				 if(null!=currEle.rightNode){
					 nodeQueue.offer(currEle.rightNode);
				 }
			 }else{
				 if(!nodeQueue.isEmpty()){
					 nodeQueue.offer(null);
				 }

				 if(!nodeList.isEmpty()){
					 System.out.println("");
					 nodeList.forEach((Node node) -> System.out.print(" "+node.key));
					 nodeList.clear();
				 }
			 }
		 }
	 }
	 
	
}
