package com.org.problemsolving.ds.first.programming.practice.ds;


public interface BinarySearchI {

	public boolean addElement(int key,String value);

	public boolean removeElement(int key);
	
	public String traverseElement(ALLCONSTTYPE traverseType);
	
	public String searchElement(int key);
	
	public void iteratveInorderTraversal();
	
	public void iteratvePreorderTraversal();
	
	public void iteratvePostorderTraversal();
	
	public void iteratveLevelorderTraversal();
	
	public void newIterativeNRLTaversal();
	
	public int maxElementInTree();
	
	public int maxElementInTreeWithOutRecursion();
	
	public void searchingInBinaryTree(int elementToSearch);
	
	public boolean searchingInBinaryTreeWithoutRecursion(int elementToSearch);
	
	public int sizeOfBinaryTree();
	
    public int sizeOfBinaryTreeWithOutRecursion();
    
    public String levelOrderTraversingInOpositOrder();
    
    public int hightOfBinaryTree();
    
    public int hightOfbinaryTreeWithUsingStack();
    
    public void traversePostOrderForPractice();
    
    public void treeTraversalInPreOrder();
    
	public int getHightWithOutRecursionUsingLevelOrderTravesing();
	
	public void inOrderTraversingPractice();
	
	public int minnimumDepthOfBinaryTree();
	
	public void printDeepestNodeInBinaryTree();
	
	public void findleafNodeinTheBonaryTree();
	
	public boolean isIdentical();
	
	public String  getAllThepathWithInOrderTraversal();
	
	public int finddiameterOftree();
	
	public int getSumOfAlltheNodes();
	
	public int getSumOfAlltheNumberWithLevelOrderTraversal();
    
}
