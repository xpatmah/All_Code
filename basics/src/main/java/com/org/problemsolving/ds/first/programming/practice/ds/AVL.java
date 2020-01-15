package com.org.problemsolving.ds.first.programming.practice.ds;

public class AVL {

	class Node{
		public Node(int key) {
           this.key = key;
		}
		int height=1;	
		int key;
		Node right;
		Node left;	
	}
	
	Node rootNode;
	
	public void addNode(int key){
		rootNode = addNode(rootNode,key);
	}
	
	private Node addNode(Node node,int key){
		if(node==null){
			return new Node(key);
		}else if (key > node.key){
			node.right = addNode(node.right, key);
		}else if(key < node.key){
			node.left = addNode(node.left, key);
		}else{
			return node;
		}
		node.height = 1+Math.max(getHeight(node.left), getHeight(node.right));

		int balance  = getBalacnce(node);
 
		//this will not case of null pointer exception because 
		//in case of balance > 1 we only check in the left side
		if(balance > 1 && key > node.left.key){
			node.left = doLeftRotation(node.left);
			node = doRightRotation(node);
		}
		
		if(balance > 1 && key < node.left.key){
			node = doRightRotation(node);
		}
		
		if(balance < -1 && key > node.right.key){
			node = doLeftRotation(node);
		}
		
		if(balance < -1 &&  key < node.left.key){
			node.right = doRightRotation(node.right);
			node = doLeftRotation(node);
		}
		
		return node;
	}
	
	private Node doLeftRotation(Node node) {
		Node pivot = node.right;

		node.right = pivot.left;
		
		pivot.left = node;
		
		node.height = 1+ Math.max(getHeight(node.left), getHeight(node.right));
		
		pivot.height = 1+ Math.max(getHeight(pivot.left), getHeight(pivot.right));


		return pivot;
	}

	private Node doRightRotation(Node node) {
		
		Node pivot = node.left;
		
		node.left = pivot.right;
		
		pivot.right = node;
		
		node.height = 1+ Math.max(getHeight(node.left), getHeight(node.right));
		
		pivot.height = 1+ Math.max(getHeight(pivot.left), getHeight(pivot.right));
		
		
		
		return pivot;
	}

	private int getBalacnce(Node node) {
		if(node==null){
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}

	private int getHeight(Node node){
		if(node==null){
			return 0;
		}else{
			return node.height;
		}
	}
	
	
	public void deleteNode(int node){
		rootNode = deleteNode(rootNode , node);
	}
	
	private Node deleteNode(Node node,int key){
		if(node==null){
			return node;
		}else if(key > node.key){
			node.right = deleteNode(node.right, key);
		}else if(key < node.key){
			node.left = deleteNode(node.left, key); 
		}else{
			//Found the node
			if(node.left!=null && node.right!=null){
				Node replacement = getReplacedNode(node.right);
				node.key = replacement.key;
				node.right = deleteNode(node.right , node.key);
			}else{
			     if(node.left==null){
			    	 node = node.right;
			     }else{
			    	 node = node.left;
			     }
			}
		}
		if(node==null){
			return node;
		}
		
		
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		
		int balance = getBalacnce(node);
		
		if(balance > 1 && key > node.left.key){
			node.left = doLeftRotation(node.left);
			node = doRightRotation(node);
		}
		
		if(balance > 1 && key < node.left.key){
			node = doLeftRotation(node);
		}
		
		if(balance < -1 && key > node.right.key){
			node = doLeftRotation(node);
		}
		
		if(balance <-1 && key < node.right.key ){
			node.right = doRightRotation(node.right);
			node = doLeftRotation(node);
		}
		return node;
	}

	private  Node  getReplacedNode(Node node) {
		while(node.left!=null){
			node = node.left;
		}
		return node;
	}
	
}
