package com.org.java.ds;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree tree = new BinarySearchTree();
		
		Object obj = new Object();
		
		Set<Integer> set = new HashSet<Integer>();
		
		set.contains(new Object());

		tree.addElement(45, "Mahesh");
		tree.addElement(50,"Ramesh");
		tree.addElement(35, "Ram");
		tree.addElement(10,"Shyam");
		tree.addElement(55, "Rama");
		tree.addElement(60,"Raju");
		tree.addElement(37, "Rakesh");
		tree.addElement(36, "Mohan");
		tree.addElement(57,"Karan");
		tree.addElement(42, "Vihan");
		tree.addElement(12,"Ravi");
		tree.addElement(56,"Rony");
		tree.addElement(49,"Vimal");
		tree.addElement(54,"Vimala");
		tree.addElement(9,"Rohan");
		tree.addElement(48,"Rob");
		
		
		System.out.println(tree.traverseElement(ALLCONSTTYPE.INORDER));
		System.out.println(tree.traverseElement(ALLCONSTTYPE.PREORDER));
		System.out.println(tree.traverseElement(ALLCONSTTYPE.POSTORDER));
		System.out.println(tree.searchElement(57));
		
		System.out.println("Every object has hash code  "+tree.hashCode());
		
		System.out.println("Debuging.....");
		tree.iteratveInorderTraversal();
		tree.iteratvePreorderTraversal();
		tree.iteratvePostorderTraversal();
		tree.iteratveLevelorderTraversal();
		tree.newIterativeNRLTaversal();
		tree.searchingInBinaryTree(60);
		System.out.println(tree.searchingInBinaryTreeWithoutRecursion(42));
		System.out.println(tree.maxElementInTreeWithOutRecursion());
		System.out.println(tree.maxElementInTree());
		
		System.out.println(tree.sizeOfBinaryTree() + "  size of Binary tree");
		
		System.out.println(tree.sizeOfBinaryTreeWithOutRecursion());
		
		System.out.println(tree.levelOrderTraversingInOpositOrder());
		System.out.println("Debuging.....2");
		System.out.println(tree.hightOfBinaryTree());
		
		tree.treeTraversalInPreOrder();
		
		tree.traversePostOrderForPractice();
		
		System.out.println("Hight Without Recursion " + tree.getHightWithOutRecursion());
		
		System.out.println("Hight With level order traversing  " +tree.getHightWithOutRecursionUsingLevelOrderTravesing());
		
		tree.inOrderTraversingPractice();
		
		System.out.println("Min depth of binary tree "+tree.minnimumDepthOfBinaryTree());
		
		tree.printDeepestNodeInBinaryTree();
		
		tree.findleafNodeinTheBonaryTree();
		System.out.println("is identical tree "+tree.isIdentical());
		
		System.out.println("Diameter of tree is "+tree.finddiameterOftree());
		
		System.out.println("Width of the binary tree will be "+tree.findWidthOfTheNode());
		
		System.out.println("Maximum Sum of any one level is "+tree.findMaximumSumInOneLevel());
		
		
		System.out.println("All the path given below"+"\n\n" +tree.getAllThepathWithInOrderTraversal());
		
		System.out.println("The given sum is 323 " + tree.isGivenSumisAvailable(323));
		
		System.out.println("The given sum is 192 " + tree.isGivenSumisAvailable(192));
		
		System.out.println("Sum of all the nodes will be "+tree.getSumOfAlltheNodes());
		
		System.out.println("Sum of all the nodes will be "+tree.getSumOfAlltheNumberWithLevelOrderTraversal());
		 
		System.out.println(tree.isMiror());
		
		tree.createBTWIthGivenOrder();
		
		System.out.println("\nPrint All the ancestor");
		tree.printAlltheAncesterOftheNode(56);
		
        tree.inOrderTraversalAfterBreak();
		
		tree.makeMirror();
		
		tree.printInZigZagTraversal();
		
		tree.createBinartFromInorder(new char[]{'I','I','L','L','I','L','L'});
		
		AVL avl = new AVL();
		
		avl.addNode(35);
		avl.addNode(25);
		avl.addNode(45);
		avl.addNode(15);
		avl.addNode(55);
		avl.addNode(05);
		avl.addNode(60);
		avl.addNode(20);
		avl.addNode(34);
		System.out.println(avl);
		
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
		System.out.println(rbt);
		
		avl.deleteNode(55);
		System.out.println(avl);
		
		
	}

}
