package com.org.java.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree implements IBinarySearchTree{

	class Node implements Cloneable{
		
		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			     Node CloneNode  = (Node)super.clone(); 
			     if(null!=CloneNode.leftNode){
			    	 CloneNode.leftNode = (Node)CloneNode.leftNode.clone();
			     }else{
			    	 CloneNode.leftNode=null;
			     }
			     if(null!=CloneNode.rightNode){
			    	 CloneNode.rightNode = (Node)CloneNode.rightNode.clone();
			     }else{
			    	 CloneNode.rightNode=null;
			     }
			     if(null!=CloneNode.nextSibling){
			    	 CloneNode.nextSibling = CloneNode.nextSibling;
			     }else{
			    	 CloneNode.nextSibling=null;
			     }
			return CloneNode;
		}

		int key;
		String value;   
	
		public Node(int key ,String value) {
			// TODO Auto-generated constructor stub
			this.key = key;
			this.value=value;
		}
		
		Node leftNode;
		Node rightNode;
		Node nextSibling;
		
	}
	Node rootNode;

	@Override
	public boolean addElement(int key, String value) {
        if(null==rootNode){
        	rootNode = new Node(key, value);
        	return true;
        }else{
        	Node temp = rootNode;
        	while(true){
        		if(temp.key>key){
        			if(null!=temp.leftNode){
        				temp =temp.leftNode;
        			}else{
        				temp.leftNode = new Node(key, value);
        				return true;
        			}
        		}else if(temp.key<key){
        			if(null!=temp.rightNode){
        				temp =temp.rightNode;
        			}else{
        				temp.rightNode = new Node(key, value);
        				return true;
        			}
        		}else{
        			return false;
        		}
        	}
        }
	}

	@Override
	public void printBinarryTree() {
		// TODO Auto-generated method stub
		if(null==rootNode){
			throw new RuntimeException("The tree is empty");
		}
		
		ArrayList<ArrayList<Integer>> twoDArray = new ArrayList<ArrayList<Integer>>();
		
		
		Queue<Node> nodeQueue = new LinkedList<Node>();
		ArrayList<Integer> nodeList = new ArrayList<Integer>();

		nodeQueue.offer(rootNode);
		nodeQueue.offer(null);
		
		while(!nodeQueue.isEmpty()){
			Node ele = nodeQueue.poll();
			if(null!=ele){
				nodeList.add(ele.key);
				if(null!=ele.leftNode){
					nodeQueue.offer(ele.leftNode);
				}
				if(null!=ele.rightNode){
					nodeQueue.offer(ele.rightNode);
				}
			}else{
				ArrayList<Integer> copyofNode = new ArrayList<Integer>(nodeList);
				 twoDArray.add(copyofNode);
				 nodeList.clear();
				 if(!nodeQueue.isEmpty()){
					 nodeQueue.add(null);
				 }
			}
		}
		
		for(ArrayList<Integer> node : twoDArray){
			 for(Integer nod : node){
                   System.out.print(" "+nod);				 
			 }
			 System.out.println();
		}
	}
	
	private void printBinarryTree(Node node) {
		// TODO Auto-generated method stub
		if(null==node){
			throw new RuntimeException("The tree is empty");
		}
		
		ArrayList<ArrayList<Integer>> twoDArray = new ArrayList<ArrayList<Integer>>();
		
		Queue<Node> nodeQueue = new LinkedList<Node>();
		ArrayList<Integer> nodeList = new ArrayList<Integer>();

		nodeQueue.offer(node);
		nodeQueue.offer(null);
		
		while(!nodeQueue.isEmpty()){
			Node ele = nodeQueue.poll();
			if(null!=ele){
				nodeList.add(ele.key);
				if(null!=ele.leftNode){
					nodeQueue.offer(ele.leftNode);
				}
				if(null!=ele.rightNode){
					nodeQueue.offer(ele.rightNode);
				}
			}else{
				ArrayList<Integer> copyofNode = new ArrayList<Integer>(nodeList);
				 twoDArray.add(copyofNode);
				 nodeList.clear();
				 if(!nodeQueue.isEmpty()){
					 nodeQueue.add(null);
				 }
			}
		}
		
		for(ArrayList<Integer> nodeoflevel : twoDArray){
			 for(Integer nod : nodeoflevel){
                   System.out.print(" "+nod);				 
			 }
			 System.out.println();
		}
	}
	

	@Override
	public void InOrderTraversalWithStack() {
		if(null==rootNode){
             throw new RuntimeException("No Element in the tree");			
		}
		
		Stack<Node> nodeStack = new Stack<Node>();
		Node currentNode = rootNode;
		boolean isDone = false;
		List<Integer> elementList = new ArrayList<Integer>();
		
		while(!isDone){
			if(null!=currentNode){
				nodeStack.push(currentNode);
				currentNode = currentNode.leftNode;
			}else{
				if(nodeStack.isEmpty()){
					isDone=true;
				}else{
					currentNode = nodeStack.pop();
					elementList.add(currentNode.key);
					currentNode=currentNode.rightNode;
				}
			}
		}
		System.out.println("Inorder :-> "+Arrays.toString(elementList.toArray()));
	}
	
	
	public void postOrderWithStack(){
		if(null==rootNode){
			throw new RuntimeException("No Element In The Tree");
		}
		Stack<Node> nodestack = new Stack<Node>();
		List<Integer> elementList = new ArrayList<Integer>();
		nodestack.push(rootNode);
		Node previousNode = null;
		
		while(!nodestack.isEmpty()){
			Node currentNode = nodestack.peek();      
			if(previousNode==null || previousNode.leftNode==currentNode || previousNode.rightNode==currentNode){
				if(null!=currentNode.leftNode){
					nodestack.push(currentNode.leftNode);					
				}else if(null!=currentNode.rightNode){
					nodestack.push(currentNode.rightNode);
				}
			}else if(currentNode.leftNode==previousNode){
				if(null!=currentNode.rightNode){
					nodestack.push(currentNode.rightNode);
				}
			}else{
				elementList.add(currentNode.key);
				nodestack.pop();
			}
			previousNode=currentNode;
		}
		System.out.println("Post Order: ->"+Arrays.toString(elementList.toArray()));
	}
	
	public void preOrderWithStack(){
		if(rootNode==null){
			throw new RuntimeException("No Element in the tree");
		}
		
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(rootNode);
		List<Integer> elementList = new ArrayList<Integer>();
		while(!nodeStack.isEmpty()){
			Node ele = nodeStack.pop();
			elementList.add(ele.key);
             if(null!=ele.rightNode){
            	 nodeStack.push(ele.rightNode);
             }
             if(null!=ele.leftNode){
            	 nodeStack.push(ele.leftNode); 
             }
		}
		
		System.out.println("Pre Order: ->"+Arrays.toString(elementList.toArray()));
	}

	@Override
	public void findMaxWithPostOrderWithStack() {
		if(null==rootNode){
			throw new RuntimeException("No element in the Tree");
		}
		Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(rootNode);		

        int maxelement=Integer.MIN_VALUE;
        Node previousNode = null;
        
        while(!nodeStack.isEmpty()){
        	Node currentNode = nodeStack.peek();
        	if(previousNode==null || previousNode.leftNode==currentNode || previousNode.rightNode==currentNode){
        		if(null!=currentNode.leftNode){
        			nodeStack.push(currentNode.leftNode);
        		}else if(null!=currentNode.rightNode){
        			nodeStack.push(currentNode.rightNode);
        		}
        	}else if(currentNode.leftNode==previousNode){
        		if(null!=currentNode.rightNode){
        			nodeStack.push(currentNode.rightNode);
        		}
        	}else{
        		currentNode = nodeStack.pop();
        		if(maxelement<currentNode.key){
        			maxelement = currentNode.key;
        		}
        	}
        	previousNode = currentNode;
        }
        System.out.println("Maximum no is "+maxelement);
	}

	@Override
	public void findMaxWithPreOrderWithStack() {
         if(null==rootNode){
        	 throw new RuntimeException("");
         }
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(rootNode);
        int maxelement  = Integer.MIN_VALUE;
        
        while(!nodeStack.isEmpty()){
        	Node ele = nodeStack.pop();
        	if(maxelement<ele.key){
        		maxelement = ele.key;
        	}
        	if(null!=ele.rightNode){
        		nodeStack.push(ele.rightNode);
        	}
        	if(null!=ele.leftNode){
        		nodeStack.push(ele.leftNode);
        	}
        }
        System.out.println("Maximum no is with Pre Order "+maxelement);
	}

	@Override
	public void findMaxWithInOrderWithStack() {
		// TODO Auto-generated method stub
		if(null==rootNode){
			throw new RuntimeException("N E I Q");
		}
		Stack<Node> nodeStack = new Stack<Node>();
		boolean isDone = false;
		int maxele = Integer.MIN_VALUE;
		Node curr_Node = rootNode;
		while(!isDone){
			if(curr_Node!=null){
				nodeStack.push(curr_Node);
				curr_Node = curr_Node.leftNode;
			}else{
				if(nodeStack.isEmpty()){
					isDone=true;
				}else{
					curr_Node = nodeStack.pop();
					if(curr_Node.key>maxele){
						maxele=curr_Node.key;
					}
					curr_Node= curr_Node.rightNode;
				}
			}
		}
		 System.out.println("Maximum no is with In Order "+maxele);
	}
	
	public boolean searchingWithPostOrderStack(int no){
		if(null==rootNode){
			throw new RuntimeException("N E I Q");
		}
		
		Node previousNode = null;
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(rootNode); 
		
		while(!nodeStack.isEmpty()){
			Node curr_Node = nodeStack.peek();			
			if(previousNode==null || previousNode.leftNode==curr_Node || previousNode.rightNode==curr_Node){
				if(null!=curr_Node.leftNode){
					nodeStack.push(curr_Node.leftNode);
				}else if(null!=curr_Node.rightNode) {
					nodeStack.push(curr_Node.rightNode);
				}
			}else if(curr_Node.leftNode==previousNode){
				if(null!=curr_Node.rightNode){
					nodeStack.push(curr_Node.rightNode);
				}
			}else{
				curr_Node = nodeStack.pop();
				if(no==curr_Node.key){
					System.out.println("element found "+no);
					return true;
				}
			}
			previousNode = curr_Node;
		}
		return false;
	}
	
	public int sizeOfBinaryTreewithInOrder(){
		int size=0;
		if(null==rootNode){
			return size;
		}
		
		Stack<Node> nodeStack = new Stack<Node>();
		boolean isDone = false;
		Node curr_Node = rootNode;
		while(!isDone){
			    if(null!=curr_Node){
			    	nodeStack.push(curr_Node);
			    	curr_Node = curr_Node.leftNode;
			    }else{
			    	if(nodeStack.isEmpty()){
			    		isDone=true;
			    	}else{
			    		curr_Node = nodeStack.pop();
			    		size++;
			    		curr_Node = curr_Node.rightNode;
			    	}
			    }
		}
		System.out.println("Size of the tree using Inorder "+size);
		
        return size;		
	}
	
	public void sizeOfBinaryTreeWithRecursion(){
		int size = sizeOfTree(rootNode);
		System.out.println("The Sizre of the tree is "+ size);
	}
	
	private int sizeOfTree(Node node){
		if(null!=node){
			int leftSize = sizeOfTree(node.leftNode);
			int rightSzie = sizeOfTree(node.rightNode);
			
			return leftSize+rightSzie+1;
		}
		return 0;
	}
	
	public void deleteBinaryTree(){

		if(null==rootNode){
              throw new RuntimeException("No Tree to delete");			
		}
		deleteNodes(rootNode);
		rootNode=null;
		System.out.println("\n \n Deleted All the node");
	}
	
	private void deleteNodes(Node node){
		if(null==node){
			return;
		}
		deleteNodes(node.leftNode);
		deleteNodes(node.rightNode);
        System.out.print(" "+node.key);
		node.leftNode=null;
		node.rightNode=null;
	}
	
	public void printLevelOrderTraversingInReverseOrder(){
		if(null==rootNode){
			throw new RuntimeException("No Element in the queue");
		}

		Stack<Integer> listOfInt = new Stack<Integer>();
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.offer(rootNode);
		while(!nodeQueue.isEmpty()){
			      Node curr_Node = nodeQueue.poll();
			      if(null!=curr_Node.leftNode){
			    	  nodeQueue.offer(curr_Node.leftNode);
			      }
			      if(null!=curr_Node.rightNode){
			    	  nodeQueue.offer(curr_Node.rightNode);
			      }
			      listOfInt.push(curr_Node.key);
		}
		while(!listOfInt.isEmpty()){
			System.out.print(" "+listOfInt.pop());
		}
		System.out.println();
	}
	
	public int findHightWithPostOrder(){
		if(null==rootNode){
			throw new RuntimeException("No Element in the queue");
		}
		
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(rootNode);
		int height=0;
		Node previousNode = null;
		while(!nodeStack.isEmpty()){
		          Node cur_Node = nodeStack.peek();
		          if(previousNode==null || previousNode.leftNode==cur_Node || previousNode.rightNode==cur_Node){
		        	     if(null!=cur_Node.leftNode){
		        	    	 nodeStack.push(cur_Node.leftNode);
		        	     }else if(null!=cur_Node.rightNode){
		        	    	 nodeStack.push(cur_Node.rightNode);
		        	     }     
		          }else if(cur_Node.leftNode==previousNode){
		        	   if(null!=cur_Node.rightNode){
		        		   nodeStack.push(cur_Node.rightNode);
		        	   }
		          }else{
		        	    nodeStack.pop(); 
		          }
		          previousNode= cur_Node;
		          if(height<nodeStack.size()){
		        	  height=nodeStack.size();
		          }
		}
		System.out.println("Max hight will with Post Order is  "+height);
		return height;
	}
	
	public void findHightUsingInOrder(){
		if(null==rootNode){
			throw new RuntimeException("No Element in the Queue");
		}
		boolean isDone=false;

		Stack<Node> nodeStack = new Stack<Node>();
		Node curr_node = rootNode;
		int height = 0;
		   //you can not find the height with in order and pre order;
		/*while(!isDone){
			      if(null!=curr_node){
			    	  nodeStack.push(curr_node);
                      curr_node = curr_node.leftNode;			    	  
			      }else{
			    	  if(nodeStack.isEmpty()){
			    		  isDone=true;
			    	  }
			    	  if(height<nodeStack.size()){
			    		  height=nodeStack.size();
			    	  }
			    	  curr_node = nodeStack.pop();   
			    	  curr_node = curr_node.rightNode;
			      }
		}*/
		System.out.println("Max hight will with Post Order is  "+height);
	}
	
	public void findHeight(){
		
		int height = findHeight(rootNode);
		System.out.println();
		System.out.println("Max hight Using Recursion  "+height);
		System.out.println();
	}
	
	private int findHeight(Node rootNode){
		if(null==rootNode){
			return 0;
		}
		int leftHeight = findHeight(rootNode.leftNode);
		
		int rightHeight = findHeight(rootNode.rightNode);
		
		return leftHeight>rightHeight ? leftHeight+1 : rightHeight+1;
		
	}
	
	public void findHeightWithBFS(){
		if(rootNode==null){
			throw new RuntimeException("N E I Q");
		}
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.offer(rootNode);
		nodeQueue.offer(null);
		int height=0;
		
		while(!nodeQueue.isEmpty()){
			Node curr_ele = nodeQueue.poll();   
			if(null!=curr_ele){
				if(null!=curr_ele.leftNode){
					nodeQueue.offer(curr_ele.leftNode);
				}
				if(null!=curr_ele.rightNode){
					nodeQueue.offer(curr_ele.rightNode);
				}
			}else{
                if(!nodeQueue.isEmpty()){
                	height++;
                	nodeQueue.offer(null);
                }				
				
			}
		}
		System.out.println("Height with Level order traversal will be "+height+"\n");
	}
	
    // the minimum depth is the depth where you find the first child without children  
	public void findMinimumDepth(){
		if(null==rootNode){
			throw new RuntimeException("N E I Q");
		}
		
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.offer(rootNode);
		nodeQueue.offer(null);
		int height=0;
		while(!nodeQueue.isEmpty()){
			Node curr_Node = nodeQueue.poll();
			if(null!=curr_Node){
				if(curr_Node.leftNode==null && curr_Node.rightNode==null){
					break;
				}
				else{
					if(null!=curr_Node.leftNode){
						nodeQueue.offer(curr_Node.leftNode);
					}
					if(null!=curr_Node.rightNode){
						nodeQueue.offer(curr_Node.rightNode);
					}
				}
			}else{
				if(!nodeQueue.isEmpty()){
					height++;
					nodeQueue.offer(null);
				}
			}
		}
		System.out.println("Min Height with Level order traversal will be "+height+"\n");
	}
	
	public void findDeepestNode(){
		if(null==rootNode){
			throw new RuntimeException("N E I Q");
		}
	   
		findDeepestNodeUsingRecursion(rootNode,0);
		
		if(null!=deepeNode){
			System.out.println(deepeNode.key+"\n");
		}
	}
	
	private void findDeepestNodeUsingRecursion(Node node ,int level){
		if(null!=node){
	     findDeepestNodeUsingRecursion(node.leftNode, ++level);
	     if(level>deepestNodeLevel){
	    	 deepeNode=node;
	    	 deepestNodeLevel=level;
	     }
	     findDeepestNodeUsingRecursion(node.rightNode, level);
		}
	}
	
	private int deepestNodeLevel=0;
	private Node deepeNode =null;
	
	public void findDeepestNodeUsingPostOrder(){
		if(null==rootNode){
			throw new RuntimeException("N E I Q");
		} 
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(rootNode);
		Node previousNode=null;
		int maxheight=0;
		Node maxEle=null;
		while(!nodeStack.isEmpty()){
			Node curr_Node = nodeStack.peek();
			if(maxheight<nodeStack.size()){
				maxheight = nodeStack.size();
				maxEle = curr_Node;
			} 
			if(previousNode==null || previousNode.leftNode==curr_Node || previousNode.rightNode==curr_Node){
				if(null!=curr_Node.leftNode){
					nodeStack.push(curr_Node.leftNode);
				}else if(null!=curr_Node.rightNode){
					nodeStack.push(curr_Node.rightNode);
				}
			}else if(curr_Node.leftNode==previousNode){
				if(null!=curr_Node.rightNode){
					nodeStack.push(curr_Node.rightNode);
				}
			}else{
				nodeStack.pop();
			}
			previousNode=curr_Node;
		}
		if(null!=maxEle){
			System.out.println(maxEle.key+"\n");
		}
	}

	public void findDeepestNodeUsingBFS(){
		if(null==rootNode){
			throw new RuntimeException("N E I Q");
		}

		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.offer(rootNode);
		nodeQueue.offer(null);
		Node previousNode=null;
		while(!nodeQueue.isEmpty()){
			Node currNode = nodeQueue.poll();
			if(currNode!=null){
				if(null!=currNode.leftNode){
					nodeQueue.offer(currNode.leftNode);
				}
				if(null!=currNode.rightNode){
					nodeQueue.offer(currNode.rightNode);
				}
				previousNode=currNode;
			}else{
				if(!nodeQueue.isEmpty()){
					nodeQueue.offer(null);
				}
			}
		}
		if(null!=previousNode){
			System.out.println("findDeepestNodeUsingBFS() "+previousNode.key+"\n");
		}

	}
	
	public void findNoOfLeavesWithoutRecursion(){
		if(null==rootNode){
			throw new RuntimeException("N E I Q");
		}
		
	   	int withPreOrder = withPreorder(rootNode);
		int withPostOrder = withPostOrder(rootNode);
		
		System.out.println("No of leaves with PreOrder is "+withPreOrder +" wth Post Order "+withPostOrder+"\n");
		
	}
	
	private int withPreorder(Node rootNode){
	  
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(rootNode);
		int noOfleaves = 0;
		
		while(!nodeStack.isEmpty()){
			       Node curr_Node = nodeStack.pop();
			       if(null!=curr_Node){
			    	   if(null!=curr_Node.rightNode){
			    		   nodeStack.push(curr_Node.rightNode);
			    	   }
			    	   if(null!=curr_Node.leftNode){
			    		   nodeStack.push(curr_Node.leftNode);
			    	   }
			    	   if(null==curr_Node.leftNode && null==curr_Node.rightNode){
			    		   noOfleaves++;
			    	   }
			       }
		}
		return noOfleaves;
	}
	
	private int withPostOrder(Node rootNode){
		int noOfLeaves =0;
		
		Stack<Node> nodeStack = new Stack<Node>();
		
		nodeStack.push(rootNode);
		Node previousNode =null;
		while(!nodeStack.isEmpty()){
			Node curr_Node = nodeStack.peek();
			  if(previousNode==null || previousNode.leftNode==curr_Node || previousNode.rightNode==curr_Node){
                    if(null!=curr_Node.leftNode){
                    	nodeStack.push(curr_Node.leftNode);
                    }else if(null!=curr_Node.rightNode){
                    	nodeStack.push(curr_Node.rightNode);
                    }				      
			  }else if(curr_Node.leftNode==previousNode){
				   if(null!=curr_Node.rightNode){
					   nodeStack.push(curr_Node.rightNode);
				   }  
			  }else{
				 Node nodeCheck=nodeStack.pop();
				 if(null==nodeCheck.leftNode && null==nodeCheck.rightNode){
					 noOfLeaves++;
				 }
				 
			  }
			  previousNode= curr_Node;
		}
		return noOfLeaves;
	}
	
	public void noOfFullNodesInBinaryTreeUsingBFS(){
		if(null==rootNode){
			throw new RuntimeException("N E I Q");
		}
		
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.offer(rootNode);
		nodeQueue.offer(null);
		int noofFullNodes=0;
		
		while(!nodeQueue.isEmpty()){
			Node curr_Node = nodeQueue.poll();   
			if(null!=curr_Node){
				if(null!=curr_Node.leftNode){
					nodeQueue.offer(curr_Node.leftNode);
				}
				if(null!=curr_Node.rightNode){
					nodeQueue.offer(curr_Node.rightNode);
				}
				if(null!=curr_Node.leftNode && null!=curr_Node.rightNode){
					noofFullNodes++;
				}
			}else{
				if(!nodeQueue.isEmpty()){
					nodeQueue.offer(null);
				}
			}
		}
		System.out.println("No of full nOdes with BFS is "+noofFullNodes+"\n");
	}
	
	public void findDiameterOnlyThroughCenter(){
		if(null==rootNode){
			throw new RuntimeException("N E I T");
		}
		
		findDiameter(rootNode);
		
		System.out.println("The diameter of the tree from root is "+diameter+"\n");

		int maxDiameter = findMaxDiameterOfTree(rootNode);
		
		System.out.println("The diameter of the tree's root or any point is "+maxDiameter+"\n");
		
	}
	
	int diameter=0;
	
	private int findDiameter(Node rootNode){
		if(null==rootNode){
			return 0;
		}
		 
		int leftDiameter = findDiameter(rootNode.leftNode);
		int rightDiameter = findDiameter(rootNode.rightNode);
		
		if(leftDiameter+rightDiameter>diameter){
			diameter=leftDiameter+rightDiameter;
		}
		
		return Math.max(leftDiameter,rightDiameter)+1;
		
	}
	
	private int findMaxDiameterOfTree(Node root){
		if(null==root){
             return 0;
		}
		
		int mainDiameter = findHeightForDiameter(root.leftNode)+ findHeightForDiameter(root.rightNode);
		
		int leftRightMaxDiameter = Math.max(findMaxDiameterOfTree(root.leftNode),findMaxDiameterOfTree(root.rightNode));

	    return Math.max(mainDiameter,leftRightMaxDiameter);
	}
	
	private int findHeightForDiameter(Node node){
		if(node==null){
			return 0;
		}
	
		int leftHeight = findHeightForDiameter(node.leftNode);
		
		int rightHeight = findHeightForDiameter(node.rightNode);
		
		return leftHeight > rightHeight? leftHeight+1:rightHeight+1;
		
	}

	public void findWidthOfBinaryTree(){
		if(null==rootNode){
			throw new RuntimeException("N E I T");
		}
		
		int height = findTheHeightForWidth(rootNode);
		int width=0;
		
		for(int i=0;i<=height;i++){
			int temp = findWidth(rootNode,i);
			if(temp>width){
				width=temp;
			}
		}
		
		System.out.println("The width of tree is "+width+"\n");
		
	}

	private int findTheHeightForWidth(Node node){
		if(null==node){
			return 0;
		}
		
		int leftheight = findTheHeightForWidth(node.leftNode);
		int rightHeight = findTheHeightForWidth(node.rightNode);
		
		return (leftheight>rightHeight?leftheight:rightHeight) +1;
	}
	
	
	private int findWidth(Node node , int depth){
		if(node==null){
			return 0;
		}
		if(depth==0){
			return 1;
		}
		
		return findWidth(node.leftNode, depth-1)+ findWidth(node.rightNode, depth-1);
		
	}
	
	public void findTheMaximumSum(){
		if(null==rootNode){
			throw new RuntimeException("N E I T");
		}
		
		int height = findHeightForMaximumSum(rootNode);
		int maxSum=0;
		
		
		for(int i=0;i<=height;i++){
			int temp = findMaxSumUsingRecursion(rootNode , i);
			if(temp> maxSum){
				maxSum =temp;
			}
		}
		System.out.println("The maxsum of any level in tree is "+maxSum+"\n");
		
	}
	
	private int findHeightForMaximumSum(Node node){
		if(node==null){
			return 0;
		}
		
		int leftHeight = findHeightForMaximumSum(node.leftNode);
		
		int rightHeight = findHeightForMaximumSum(node.rightNode);
		
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	private int findMaxSumUsingRecursion(Node node , int depth){
		if(node==null){
			return 0;
		}
		if(depth==0){
			return node.key;
		}
		return findMaxSumUsingRecursion(node.leftNode, depth-1) + findMaxSumUsingRecursion(node.rightNode, depth-1);
	}
	
    public void printAllthePath(){
    	if(null==rootNode){
    		throw new RuntimeException("N E I Q");
    	}
        Stack<Node> nodeStack = new Stack<Node>(); 
        
    	printAllNodePath(rootNode, nodeStack,242);
    	
    } 
	
	private void printAllNodePath(Node node , Stack<Node> nodeStack , int sum){
		if(node!=null){
			  nodeStack.push(node);
			  int remainingNo = sum-node.key;
			  printAllNodePath(node.leftNode, nodeStack,remainingNo);
			  printAllNodePath(node.rightNode, nodeStack,remainingNo);
			  Node ele = nodeStack.peek();
			  if(null==ele.leftNode && null==ele.rightNode && remainingNo==0)
			  printNodeStack(nodeStack);
			  nodeStack.pop();
		}
	}
	
	private void printNodeStack(Stack<Node> nodeStack) {
		// TODO Auto-generated method stub
		for(Node node : nodeStack){
			System.out.print(" "+node.key);
		}
		System.out.println();
	}
    
	public Node createCloned(){
		 if(null==rootNode){
			 throw new RuntimeException("N E I T");
		 }
		try {
			Node rootNode2 = (Node)rootNode.clone();
		    return rootNode2;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return null;
	}
	
	public void createMirror(Node node){
		if(null!=node){
			  createMirror(node.leftNode);
			  createMirror(node.rightNode); 
			  Node temp = node.leftNode;
			  node.leftNode=node.rightNode;
			  node.rightNode=temp;
		}
	}
	
	public void makeMirrorNode(){
		Node rootNode2 = createCloned();
		createMirror(rootNode2);
		System.out.println();
	}
	
	public void isNodeSyntecticallyIdentical(){
		Node rootNode2 = createCloned();
		createMirror(rootNode2);
        if(null==rootNode2 || null==rootNode){
        	throw new RuntimeException("Basic condition got failed in order to satisfy Identical behaviour");
        }
		
		System.out.println("Are both the trees idntical "+isIdentical(rootNode,rootNode2));
	}
	
	
	private boolean isIdentical(Node root1  , Node root2){
		if(null==root1 && null==root2){
			return true;
		}
		if(null==root1 || null==root2){
			return false;
		}
		if(root1.key != root2.key){
			return false;
		}
		return isIdentical(root1.leftNode, root2.rightNode) && isIdentical(root1.rightNode, root2.leftNode);
	}
    
	public void createTree(int[] inOrder , int[] preOrder){
		
		Node createdTreeNode = createBT(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
		printBinarryTree(createdTreeNode);
		
	}
	
	private Node createBT(int[] preOrder , int preStart , int preEnd , int[] inOrder , int inStart , int inEnd){
		if(preStart>preEnd || inStart>inEnd){
			return null;
		}
		
		int key = preOrder[preStart];
		Node curr_Node = new Node(key, "Local");
		int offSet = inStart;
		for(;offSet<inEnd ; offSet++){
			if(inOrder[offSet]==key){
				break;
			}
		}
		curr_Node.leftNode = createBT(preOrder, preStart+1, preStart+offSet-inStart, inOrder, inStart, offSet-1);
		curr_Node.rightNode= createBT(preOrder, preStart+offSet+1-inStart, preEnd, inOrder, offSet+1, inEnd);
		
		return curr_Node;
	}
	
	public void printAlltheAncesterOfTree(int no){
		if(null==rootNode){
			throw new RuntimeException("N E I T");
		}
		
		Stack<Node> nodeStack = new Stack<Node>();
		printSpecificPath(rootNode, nodeStack, no);
	}
	
	
	public void printSpecificPath(Node node , Stack<Node> nodeStack, int no){
		if(null!=node){
			   nodeStack.push(node);
			   printSpecificPath(node.leftNode,nodeStack,no);
			   printSpecificPath(node.rightNode, nodeStack, no);
			   if(nodeStack.peek().key==no){
				   System.out.println();
				   printAncister(nodeStack);
			   }
			   nodeStack.pop();
		}
		
	}

	private void printAncister(Stack<Node> nodeStack) {
		// TODO Auto-generated method stub
		 for(int i=0;i<nodeStack.size()-1;i++){
			 System.out.print(" "+nodeStack.get(i).key);
		 }
		   System.out.println();
	}
	
	public void printTheVerticelSum(){
		if(rootNode==null){
			throw new RuntimeException("N E I T");
		}
		
		HashMap<Integer ,Integer> verticelSUm = new HashMap<Integer ,Integer>();
        		
		doHasing(rootNode, verticelSUm, 0);
        
		for(Map.Entry<Integer,Integer > entrySey: verticelSUm.entrySet()){
			System.out.print(" "+entrySey.getValue());
		}
		System.out.println();
	}
	
	private HashMap<Integer ,Integer> doHasing(Node node , HashMap<Integer ,Integer> verticelSUm , int level ){
		if(null!=node){
			doHasing(node.leftNode, verticelSUm, level+1);
            doHasing(node.rightNode, verticelSUm, level-1);
            Integer sum = verticelSUm.get(level);
            if(null!=sum){
            	sum=sum+node.key;
            	verticelSUm.put(level, sum);
            }else{
            	verticelSUm.put(level, node.key);
            }
            return verticelSUm;
		}
		 return null;
 	}
	
	
	public void leastCommonAncestorOfTwoNodes(int key1 , int key2){
		if(null==rootNode){
			throw new RuntimeException("N E I Q");
		}
		
		Node ancestorNode = findLCA(rootNode,key1,key2);
		
		System.out.println("The least ancestor of Node will be "+ancestorNode.key+"\n");
		
	}

	private Node findLCA(Node node, int key1, int key2) {
        if(node==null){
        	return  node;
        }
        if(node.key==key1 || node.key==key2){
        	return node;
        }
        Node left = findLCA(node.leftNode, key1, key2);
        Node right = findLCA(node.rightNode, key1, key2);
        if(null!=left && null!=right){
        	return node;
        }else{
		    return left!=null?left:right;
        }
	}
	
	public void findNoOFBinaryWithGivenNoOfNode(int n){
		int[] count = new int[n+1];
		count[0]=1;
		count[1]=1;
		for(int i=2;i<=n;i++){
			for(int j=0;j<i;j++){
				count[i]+=count[j]*count[i-j-1];
			}
		}
	    System.out.println("Total no of Binary tree that will be possible :" +count[n] );
	}
	
	public void generateAllthetrees(int n){
		
		ArrayList<Node> nodeTree = generateAllTheTree(n);
		System.out.println();
	
		for(Node node : nodeTree){
			//printBinarryTree(node);
		}
	}
	
	
	private ArrayList<Node> generateAllTheTree(int n){
		if(n==0){
			return generateAllTheTree(1,0);
		}else{
			return generateAllTheTree(1,n);
		}
	}
	
	
	private ArrayList<Node> generateAllTheTree(int start ,int end){
		ArrayList<Node> subTree = new ArrayList<Node>();
		
		if(start>end){
			subTree.add(null);
			return subTree;
		}
        for(int i=start;i<=end;i++){
        	      for(Node left :generateAllTheTree(start,i-1)){
        	    	  for(Node right :generateAllTheTree(i+1,end)){
        	    		    Node  curr_Node = new Node(i,"Node"+i);
        	    		    curr_Node.leftNode=left;
        	    		    curr_Node.rightNode=right;
        	    		    subTree.add(curr_Node);
        	    	  }
        	      }   
        }		
		return subTree;
	}
	
	public void createTreeFromPreOrder(int[] arr){
		Node curr_rootNode = buildTreeFromPreOrder(arr, 0);
		printBinarryTree(curr_rootNode);
	}
	
	private Node buildTreeFromPreOrder(int[] arr , int i){
		if(arr==null){
			 return null;
		}
		if(arr.length==i){
			return null;
		}
		Node node = new Node(arr[i],""+arr[i]);
		node.leftNode=null;
		node.rightNode=null;
		
		if(arr[i]=='L'){
			return node;
		}
		i++;
		node.leftNode=buildTreeFromPreOrder(arr, i);
		i++;
		node.rightNode=buildTreeFromPreOrder(arr, i);
		return node;
	}
	
	public void setNextSibling(){
		if(null==rootNode){
			throw new RuntimeException("N E I Q");
		}
		Node copy_rootNode =null;
		try {
			copy_rootNode = (Node)rootNode.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Queue<Node> nodeQueue = new LinkedList<Node>();
		
		if(null!=copy_rootNode){
			nodeQueue.offer(copy_rootNode);
			nodeQueue.offer(null);

			while(!nodeQueue.isEmpty()){
				Node curr_Node = nodeQueue.poll();
				if(curr_Node!=null){
					curr_Node.nextSibling=nodeQueue.peek();
					if(null!=curr_Node.leftNode){
						nodeQueue.offer(curr_Node.leftNode);
					}
					if(null!=curr_Node.rightNode){
						nodeQueue.offer(curr_Node.rightNode);
					}
				}else{
					if(!nodeQueue.isEmpty()){
						nodeQueue.offer(null);
					}
				}
			}

		}
		System.out.println();
	}
	
	public void assignSibling(){
		if(rootNode==null){
			throw new RuntimeException("N E I T");
		}
		
		try {
			Node clonedNode = (Node)rootNode.clone();
			assignNewSbling(clonedNode);
			System.out.println();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private void assignNewSbling(Node node){
		if(node==null){
			return;
		}
		
		if(null!=node.leftNode){
			node.leftNode.nextSibling=node.rightNode;
		}
		if(null!=node.rightNode){
			if(node.nextSibling!=null){
				node.rightNode.nextSibling=node.nextSibling.rightNode;
			}else{
				node.rightNode.nextSibling=null;
			}
		}
		
		assignNewSbling(node.leftNode);
		assignNewSbling(node.rightNode);
		
		
	}
	
	
	public void inorderTraversalWithNew(){
		if(null==rootNode){
			throw new RuntimeException("No element in tree");
		}
		Stack<Node> nodeStack = new Stack<Node>();
		List<Integer> elelist = new ArrayList<Integer>();
	    Node curr_Node = rootNode;
        boolean isDone= false;		
		
		while(!isDone){
			 if(null!=curr_Node){
				 nodeStack.add(curr_Node);
				 curr_Node = curr_Node.leftNode;
			 }else{
				 if(nodeStack.isEmpty()){
					 isDone = true;
				 }else{
					 curr_Node = nodeStack.pop();
					 elelist.add(curr_Node.key);
					 curr_Node = curr_Node.rightNode; 
				 }
			 }
		}
		
		System.out.println("InOrder Traversal "+Arrays.toString(elelist.toArray())+"\n");
	}
	
	public void postOrderTraversalNew(){
		if(rootNode==null){
			
		}
		
		
	}
}
