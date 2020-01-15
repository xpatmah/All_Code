package com.org.problemsolving.ds.first.programming.practice.ds;

public class GenericTree {
	
	class Node{
		
		int key;
		
		String value;
		
		Node firstChild;
		
		Node sibling;
		
		public Node(int key, String value) {
               this.key=key;
               this.value=value;
		}
		
	}
	
    Node rootNode;

    public void insert(int key,String value){
    	if(rootNode==null){
    		rootNode=new Node(key, value);
    		return;
    	}if(rootNode.sibling==null){
    		rootNode.firstChild=new Node(key, value);
    	    return;
    	}
    	addNodeToTree(rootNode.firstChild,key, value);
    }
    
    public Node addNodeToTree(Node rootNode ,int key,String value){
		  if(null==rootNode){
			  rootNode = new Node(key, value);
			  rootNode.sibling=null;
			  rootNode.firstChild=null;
		  }else{
			  if(rootNode.key>key){
				  addNodeToTree(rootNode.sibling, key, value);
			  }else if(rootNode.key<key){
				  addNodeToTree(rootNode.firstChild, key, value);
			  }
		  }
		  return rootNode;
	}
	

}
