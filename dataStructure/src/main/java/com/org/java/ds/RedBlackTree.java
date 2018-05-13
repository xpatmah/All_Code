package com.org.java.ds;

public class RedBlackTree {
	
	enum Color{
		RED,
		BLACK;
	}
	
	class Node{
		public Node(int key){
			this.key =  key;
		}
		int key;
		Node left;
		Node right;
		Color color = Color.RED;
	}
	
	private Node rootNode;

	public Node getRootNode() {
		return rootNode;
	}

	public void addNode(int key){
		rootNode = addNode(rootNode , key);
	}
	
	private Node addNode(Node node, int key){
		if(node==null){
			if(rootNode==null){
				Node renode = new Node(key);
				renode.color = Color.BLACK;
				return renode;
			}else{
				return  new Node(key);
			}
		}else if(key > node.key){
			Node rightNode = addNode(node.right, key);
			node.right = rightNode ;
		}else if(key < node.key){
			Node leftNode = addNode(node.left, key);
			node.left = leftNode;
		}else{
			return node;
		}
		// Check for the right part of tree
		if(null!=node && key > node.key && ((isChildRed(node.right)) && (isChildRed(node.right.right)||isChildRed(node.right.left)))){
			if(null!=node.left && node.left.color==Color.RED){
				if(key > node.right.key && node.right.right.color ==Color.RED){
                     node.right.color= Color.BLACK;
                     node.left.color= Color.BLACK;
                     if(node !=rootNode){
                    	 node.color=Color.RED;
                     }
				}else if(key < node.right.key && node.right.left.color==Color.RED){
					node.right.color= Color.BLACK;
                    node.left.color= Color.BLACK;
                    if(node !=rootNode){
                   	 node.color=Color.RED;
                    }
				}
			}else{
				//Otherwise You have to perform the Rotation
				if(key > node.right.key){
					// Do Left Rotation on node
					node  = doLeftRotation(node, true);
				}else if(key < node.right.key){
				    node.right = doRightRotation(node.right , false);
					node  = doLeftRotation(node, true);
				}
			}
		}
		// Check for the left part of the Tree
		if(null!=node && key < node.key &&(isChildRed(node.left) && ((isChildRed(node.left.left)||isChildRed(node.left.right))))){
			if(null!=node.right && node.right.color == Color.RED){
				if(key < node.left.key && node.left.left.color ==Color.RED){
					if(node!=rootNode){
						node.color = Color.RED;
					}
					node.right.color = Color.BLACK;
					node.left.color = Color.BLACK;
				} else if (key > node.left.key && node.left.right.color == Color.RED){
					if(node!=rootNode){
						node.color = Color.RED;
					}
					node.right.color = Color.BLACK;
					node.left.color = Color.BLACK;
				}     
			}else{
				//You have to perform the rotation
				if(key < node.left.key){
					node = doRightRotation(node, true);
				}else if(key > node.left.key){
					node.left = doLeftRotation(node.left, false);
					node = doRightRotation(node, true);
				}
			}
		}
		return node;
	}
	
	private Node doRightRotation(Node node, boolean isColoringRequired) {
        Node pivot = node.left;
		
        node.left = pivot.right;
        
        pivot.right = node;
        
        if(isColoringRequired){
			Color temp = pivot.color;
			pivot.color = node.color;
			node.color = temp;
		}
		return pivot;
	}

	private Node  doLeftRotation(Node node, boolean isColoringRequired ) {
		Node pivot = node.right;
		node.right = pivot.left;
		
		pivot.left = node;
		
		if(isColoringRequired){
			Color temp = pivot.color;
			pivot.color = node.color;
			node.color = temp;
		}
		return pivot;
	}

	private  boolean isChildRed(Node node){
		if(node==null){
			return false;
		}
		if(node.color == Color.RED){
			return true;
		}
		return false;
	}
	
	public void printInOrder(Node node){
		if(null!=node){
			printInOrder(node.left);
			System.out.print(" "+node.key);
			printInOrder(node.right);
		}
		
	}
	
	public static void main(String[] args){
		RedBlackTree rbt = new RedBlackTree();

		rbt.addNode(35);
		rbt.addNode(25);
		rbt.addNode(45);
		rbt.addNode(15);
		rbt.addNode(55);
		rbt.addNode(05);
		rbt.addNode(60);
		rbt.addNode(20);
		rbt.addNode(34);
		rbt.addNode(76);
		rbt.addNode(02);
		rbt.addNode(99);
		rbt.addNode(04);
		rbt.addNode(78);
		rbt.addNode(45);

		rbt.printInOrder(rbt.getRootNode());
	}
}
