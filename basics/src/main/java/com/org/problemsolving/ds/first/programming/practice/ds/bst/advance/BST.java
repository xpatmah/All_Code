package com.org.problemsolving.ds.first.programming.practice.ds.bst.advance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST {
	
	class Node{
		int data;
		
		Node(int data){
			this.data = data;
		}
		Node left ;
		Node right;
	}

	Node rootNode;
	
	
	public boolean addNode(int data){
		if(rootNode==null){
			rootNode = new Node(data);
		}else{
			Node temp = rootNode;
			while(true){
				if(temp.left !=null && data < temp.data){
					temp = temp.left;
				}else if(temp.right !=null && data > temp.data){
					temp = temp.right;
				}else{
					break;
				}
			}
			if(data < temp.data){
				temp.left = new Node(data);
			}else if(data > temp.data){
				temp.right = new Node(data);
			}else{
				return false;
			}
		}
		return true;
	}
	
	
	public void checkTree(){
		
		Queue<Node> elementQueue = new LinkedList<Node>();
		
		elementQueue.offer(rootNode);
		elementQueue.offer(null);
		List<Object> eleList = new ArrayList<>(); 
		
		
		while(!elementQueue.isEmpty()){
			Node node =  elementQueue.poll();
			 if(null!=node){
				 if(node.data==0){
					 eleList.add("*"); 
				 }else{
					 eleList.add(node.data);
				 }
                 if(null!=node.left){
                	 elementQueue.offer(node.left);
                 }else if(node.data!=0){
                	 
                	 elementQueue.offer(new Node(0));
                 }
                 if(null!=node.right){
                	 elementQueue.offer(node.right);
                 }else if(node.data!=0){
                	 elementQueue.offer(new Node(0));
                 }			 
			 }else{
				 if(!elementQueue.isEmpty()){
					 elementQueue.offer(null);
					 eleList.add(null);
				 }
			 }
		}
		
		System.out.println("");
	}
	    
	  
	public boolean deleteNode(int data){
		if(null == rootNode){
			return false;
		}else{
           Node x = rootNode;
           Node p = null;
           while(x!=null){
        	    if(null != x && x.data == data){
        	    	break;
        	    }
        	    if(null != x && data > x.data   ){
        	    	p = x;
        	    	x = x.right;
        	    }else{
        	    	p = x;
        	    	x = x.left;
        	    }
           }
          if(null==x){
        	  return false;
          }
          return deleteNodeWithValue(p ,x);
		}
	}

	private boolean deleteNodeWithValue(Node p , Node x) {
		if(x.left==null && x.right==null){
			if(p==null){
				rootNode=null;
			}
			else if(p.left == x){
            	p.left = null;
            }else{
            	p.right = null;
            }
            return true;
		}else if(x.left !=null && x.right !=null){
			Node temp = x.right;
			while(temp.left!=null){
				p = temp;
				temp = temp.left;
			}
			x.data = temp.data;
			if(null!=temp.right){
				p.left = temp.right;
			}else{
				p.left = temp.left;
			}
			return true;
		}else if(x.left != null || x.right != null){
			if(p==null){
				if(x.left!=null){
					rootNode = x.left;
				}else{
					rootNode = x.right;
				}
			}
			else if(p.left == x){
				if(x.left!=null){
					p.left = x.left;
				}else{
					p.left = x.right;
				}
			}else{
				if(x.left!=null){
					p.right = x.left;
				}else{
					p.right = x.right;
				}
			}
			return true;
		}
		return false;
	}
	
}
