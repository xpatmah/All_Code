package com.org.problemsolving.ds.first.tree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree tree = new BinarySearchTree();
		
		
		tree.addElement(60, "mahesh");
		tree.addElement(41, "ram");
		tree.addElement(74, "shyam");
		tree.addElement(16, "ramu");
		tree.addElement(53, "lokesh");
		tree.addElement(65, "munna");
		tree.addElement(25, "rani");
		tree.addElement(46, "pushpa");
		tree.addElement(55, "raja");
		tree.addElement(63, "raju");
		tree.addElement(70, "baburao");
		tree.addElement(42, "sandeep");
		tree.addElement(62, "sonu");
		tree.addElement(64, "suresh");
		
		tree.printBinarryTree();
		tree.InOrderTraversalWithStack();
		tree.postOrderWithStack();
		tree.preOrderWithStack();
		tree.findMaxWithPostOrderWithStack(); //if it is a binary search tree then you need to go in only left  or right based on the element
		tree.findMaxWithPreOrderWithStack();
		
		tree.findMaxWithInOrderWithStack();
		tree.searchingWithPostOrderStack(63);
		tree.sizeOfBinaryTreewithInOrder();
		tree.sizeOfBinaryTreeWithRecursion();
		
		tree.printLevelOrderTraversingInReverseOrder();
		
		tree.findHightWithPostOrder();
		
		tree.findHeight();
		
		tree. findMinimumDepth();
		tree.findHeightWithBFS();
		
		tree.findDeepestNode();
		
		tree.findDeepestNodeUsingPostOrder();
		
		tree.findDeepestNodeUsingBFS();
		
		tree.findNoOfLeavesWithoutRecursion();
		
		tree. noOfFullNodesInBinaryTreeUsingBFS();
		
        tree.findDiameterOnlyThroughCenter();
		
        tree.findWidthOfBinaryTree();
        
        tree.findTheMaximumSum();
        
        tree. printAllthePath();
        tree.createCloned();
        
        tree.makeMirrorNode();
        
        tree.isNodeSyntecticallyIdentical();
        
        tree.createTree(new int[]{'D','B','E','A','F','C'},new int[]{'A','B','D','E','F','C'});
        
        tree.printAlltheAncesterOfTree(64);
        
        tree.printTheVerticelSum();
        
        tree.leastCommonAncestorOfTwoNodes(46,55);
        
        tree.findNoOFBinaryWithGivenNoOfNode(10);
        
        tree.generateAllthetrees(3);
        
        tree.createTreeFromPreOrder(new int[]{'I','L','I','L','L'});
        
        tree.setNextSibling();
        
        tree.assignSibling();
        
        
        tree.inorderTraversalWithNew();
       
		//last Function
		tree.deleteBinaryTree();
		
	}

}
