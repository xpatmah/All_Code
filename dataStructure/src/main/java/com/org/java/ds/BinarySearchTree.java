package com.org.java.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class BinarySearchTree implements BinarySearchI {

	Node rootNode;

	class CharNode implements Cloneable {

		char key;

		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			CharNode clonedNMode =  (CharNode)super.clone();
			if(null!=clonedNMode.leftNode){
				clonedNMode.leftNode = (CharNode)clonedNMode.leftNode.clone();
			}else{
				clonedNMode.leftNode=null;
			}

			if(null!=clonedNMode.rightNode){
				clonedNMode.rightNode = (CharNode)clonedNMode.rightNode.clone();
			}else{
				clonedNMode.rightNode=null;
			}

			if(null!=clonedNMode.thirdPointer){
				clonedNMode.thirdPointer = (CharNode)clonedNMode.thirdPointer.clone();
			}else{
				clonedNMode.thirdPointer=null;
			}

			return clonedNMode;
		}

		CharNode leftNode;
		CharNode rightNode;

		CharNode thirdPointer;

		public CharNode(char key) {
			// TODO Auto-generated constructor stub
			this.key=key;
		}

	}


	class Node implements Cloneable{

		@Override
		protected Object clone() throws CloneNotSupportedException {
			Node cloneNode =  (Node)super.clone();
			if(null!=leftNode){
				cloneNode.leftNode=(Node)leftNode.clone();
			}else{
				cloneNode.leftNode=null;
			}
			if(null!=rightNode){
				cloneNode.rightNode=(Node)rightNode.clone();
			}else{
				cloneNode.rightNode=null;
			}
			return cloneNode;
		}

		int key;
		String value;

		Node(int key,String value){
			this.key=key;
			this.value=value;
		}

		Node leftNode;
		Node rightNode;

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Node getLeftNode() {
			return leftNode;
		}
		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}
		public Node getRightNode() {
			return rightNode;
		}
		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
	}


	@Override
	public boolean removeElement(int key) {
		// TODO Auto-generated method stub
		if(null==rootNode){
			throw new RuntimeException("There is no element in the BST");
		}
		Node temp = rootNode;
		Node parent = rootNode;
		Node nodeToRemove =null;

		while(null!=temp){
			if(temp.key==key){
				nodeToRemove=temp;
				break;
			}else if(temp.key<key){
				parent=temp;
				temp=temp.rightNode;
			}else{
				parent=temp;
				temp=temp.leftNode;
			}
		}
		if(null!=nodeToRemove){
			if(null!=nodeToRemove.leftNode && null!=nodeToRemove.rightNode){
				// need to work on hight calculation 

				int lefthight = findHightOfLeftSubTree(nodeToRemove.leftNode);

				int rightHight = findHightOfRightSubTree(nodeToRemove.rightNode);
				if(lefthight>rightHight){
					Node rightNode = findMaxInRightSubTree(nodeToRemove.rightNode);
				}else{
					Node leftNode  = findMinInRightSubTree(nodeToRemove.rightNode); 
				}

			}else if(null!=nodeToRemove.leftNode){
				if(parent.leftNode.key==nodeToRemove.key){
					parent.leftNode=nodeToRemove.leftNode;
				}else{
					parent.rightNode=nodeToRemove.leftNode;
				}
				nodeToRemove.leftNode=null;
			}else if(null!=nodeToRemove.rightNode){
				if(parent.leftNode.key==nodeToRemove.key){
					parent.leftNode=nodeToRemove.rightNode;
				}else{
					parent.rightNode=nodeToRemove.rightNode;
				}
			}else{
				if(parent.leftNode.key==nodeToRemove.key){
					parent.leftNode=null;
				}else{
					parent.rightNode=null;
				}
			}

		}else{
			throw new RuntimeException("There is no element found with that key in the BST");
		}


		return false;
	}


	private Node findMaxInRightSubTree(Node rightNode) {
		// TODO Auto-generated method stub
		return null;
	}


	private int findHightOfRightSubTree(Node rightNode) {
		// TODO Auto-generated method stub
		return 0;
	}


	private int findHightOfLeftSubTree(Node leftNode) {
		// TODO Auto-generated method stub
		return 0;
	}


	private Node findMinInRightSubTree(Node node) {


		return node;
	}


	private Node findMin(Node node){


		return node;
	}

	@Override
	public String traverseElement(ALLCONSTTYPE traverseType) {
		// TODO Auto-generated method stub
		StringBuilder str= new StringBuilder();
		if(null==rootNode){
			return new String("EMPTY");
		}
		if(traverseType.equals(ALLCONSTTYPE.POSTORDER)){
			str=doPostOrder(rootNode,str);
		}else if(traverseType.equals(ALLCONSTTYPE.PREORDER)){
			str=doPreOrder(rootNode,str);
		}else{
			str=doINOrder(rootNode,str);
		}
		return str.toString()+ "  "+ traverseType;
	}

	private StringBuilder doINOrder(Node node,StringBuilder str) {
		if(null!=node){
			doINOrder(node.leftNode, str); 
			str.append(node.key+" ");
			doINOrder(node.rightNode, str);
		}

		return str;
	}

	private StringBuilder doPreOrder(Node node,StringBuilder str) {
		if(null!=node){
			str.append(node.key+" ");
			doPreOrder(node.leftNode, str); 
			doPreOrder(node.rightNode, str);
		}
		return str;
	}

	private StringBuilder doPostOrder(Node node,StringBuilder str) {
		if(null!=node){
			doPostOrder(node.leftNode, str); 
			doPostOrder(node.rightNode, str);
			str.append(node.key+" ");
		}
		return str;
	}

	@Override
	public boolean addElement(int key,String value) {
		if(null==rootNode){
			rootNode=new Node(key, value);
			return true;
		}else{
			Node temp = rootNode;
			Node parentNode=rootNode;
			while(temp!=null){
				if(temp.key<key){
					parentNode=temp; 
					temp=temp.rightNode;
				}else{
					parentNode=temp;
					temp=temp.leftNode;
				}
			}
			if(parentNode.key>key){
				parentNode.leftNode=new Node(key, value);
				return true;
			}else{
				parentNode.rightNode=new Node(key, value);
				return true;
			}

		}
	}

	@Override
	public String searchElement(int key) {
		// TODO Auto-generated method stub
		String value="";
		if(null==rootNode){
			return "No element in Binary Tree";
		}
		else{
			Node temp=rootNode;

			while(temp!=null){
				if(temp.key==key){
					value=temp.value;
					break;
				}else if(key>temp.key){
					temp=temp.rightNode;
				}else{
					temp=temp.leftNode;
				}
			}
		}
		return value;
	}


	//LNR
	@Override
	public void iteratveInorderTraversal(){
		if(null==rootNode){
			throw new RuntimeException("There is no element in the array");
		}
		Stack<Node> nodeStack = new Stack<Node>();

		List<Integer> elementList = new ArrayList<Integer>();

		Node currenode = rootNode;

		boolean isDone=false;

		while(!isDone){
			if(null!=currenode){
				nodeStack.push(currenode);
				currenode = currenode.leftNode;
			}else{
				if(nodeStack.isEmpty()){
					isDone=true;
				}else{
					currenode = nodeStack.pop();
					elementList.add(currenode.key);
					currenode=currenode.rightNode;
				}
			}   			
		}

		System.out.println(elementList.toString() + "  Inorder");
	}

	//NLR
	@Override
	public void iteratvePreorderTraversal(){
		if(null==rootNode){
			throw new RuntimeException("No Element id found in the ");
		}

		Stack<Node> nodeStack = new Stack<Node>();

		List<Integer> elementList =new ArrayList<>();

		nodeStack.push(rootNode);
		Node currentNode;

		while(!nodeStack.empty()){
			currentNode=nodeStack.pop();
			elementList.add(currentNode.key); 

			if(null!=currentNode.rightNode){
				nodeStack.push(currentNode.rightNode);
			}
			if(null!=currentNode.leftNode){
				nodeStack.push(currentNode.leftNode);
			}
		}

		System.out.println(" Preorder");
		elementList.forEach((Integer x)->{System.out.print(x+" ");});
		System.out.println(" Preorder");


	}


	//LRN
	@Override
	public void iteratvePostorderTraversal(){
		if(null==rootNode){
			throw new RuntimeException("No Element Found in the tree");
		}

		Stack<Node> nodeStack = new Stack<>();
		List<Integer> integerList = new ArrayList<>();

		nodeStack.push(rootNode);
		Node currentNode;
		Node previousNode=null;


		while(!nodeStack.isEmpty()){
			currentNode=nodeStack.peek();	
			if(null==previousNode || previousNode.leftNode==currentNode || previousNode.rightNode==currentNode){
				if(null!=currentNode.leftNode){
					nodeStack.push(currentNode.leftNode);
				}else if(null!=currentNode.rightNode){
					nodeStack.push(currentNode.rightNode);
				}
			}else if(currentNode.leftNode==previousNode){
				if(currentNode.rightNode!=null){
					nodeStack.push(currentNode.rightNode);
				}
			}else{
				integerList.add(currentNode.key);
				nodeStack.pop();
			}
			previousNode=currentNode;
		}

		System.out.println(integerList.toString()+ " Postorder");

	}



	// NODE <ALL THE CHILD NODE>
	@Override
	public void iteratveLevelorderTraversal() {
		if(rootNode==null){
			throw new RuntimeException("There is no element in tree");
		}

		Queue<Node> nodeQueue = new LinkedList<>();
		List<Integer> listofNode =  new ArrayList<>();
		nodeQueue.offer(rootNode);
		Node currentNode = rootNode;
		while(!nodeQueue.isEmpty()){
			if(currentNode!=null){
				currentNode = nodeQueue.poll();	
				if(null!=currentNode.leftNode){
					nodeQueue.offer(currentNode.leftNode);
				}
				if(null!=currentNode.rightNode){
					nodeQueue.offer(currentNode.rightNode);
				}
			}

			if(null!=currentNode){
				listofNode.add(currentNode.key);
			}
		}		

		System.out.println(listofNode.toString() + "   Levelorder");
	}


	//NRL
	@Override
	public void newIterativeNRLTaversal(){
		if(null==rootNode){
			throw new RuntimeException("There is no Element in the tree");
		}

		Stack<Node> nodeStack = new Stack<>();

		nodeStack.push(rootNode);
		Node currentNode;
		List<Integer> elementList = new ArrayList<Integer>();

		while(!nodeStack.isEmpty()){
			currentNode = nodeStack.pop();
			elementList.add(currentNode.key);
			if(null!=currentNode.leftNode){
				nodeStack.push(currentNode.leftNode);
			}
			if(null!=currentNode.rightNode){
				nodeStack.push(currentNode.rightNode);
			}
		}

		System.out.println(elementList.toString() + "  NRL");
	}

	@Override
	public int maxElementInTree() {
		if(null==rootNode){
			throw new RuntimeException("There is no element in the arrays");
		}
		return findMax(rootNode, rootNode.key);
		// TODO Auto-generated method stub

	}

	private int findMax(Node node , int maxElement){

		if(null!=node){
			if(node.leftNode!=null){
				maxElement = (maxElement>node.leftNode.key)? maxElement: node.leftNode.key;
				maxElement=findMax(node.leftNode, maxElement);

			}

			if(node.rightNode!=null){
				maxElement= (maxElement>node.rightNode.key)? maxElement: node.rightNode.key;
				maxElement=findMax(node.rightNode, maxElement);

			}
		}
		return maxElement;

	}

	@Override
	public int maxElementInTreeWithOutRecursion() {
		if(null==rootNode){
			throw new RuntimeException("There is no element in the arrays");
		}

		int max = rootNode.key;
		Queue<Node> elementQueue = new LinkedList<Node>();
		elementQueue.offer(rootNode);
		while(!elementQueue.isEmpty()){
			Node currentele = elementQueue.poll();
			if(max<currentele.key){
				max= currentele.key;
			}			
			if(null!=currentele.leftNode){
				elementQueue.offer(currentele.leftNode);
			}
			if(null!=currentele.rightNode){
				elementQueue.offer(currentele.rightNode);
			}
		}

		System.out.println("Max Element is "+max);

		return max;
	}

	@Override
	public void searchingInBinaryTree(int elementToSearch){
		if(null==rootNode){
			throw new RuntimeException("There is no element in the Binary Tree");
		}

		boolean result = searchElement(rootNode , elementToSearch);

		if(result){
			System.out.println("found");
		}else{
			System.out.println("No element found in the tree");
		}
	}

	private boolean searchElement(Node currentNode , int elementToSearch){
		if(null!=currentNode){
			if(searchElement(currentNode.leftNode,elementToSearch)){
				return true;
			}
			if(searchElement(currentNode.rightNode,elementToSearch)){
				return true;
			}
			if(currentNode.key==elementToSearch){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean searchingInBinaryTreeWithoutRecursion(int elementToSearch){
		if(null==rootNode){
			throw new RuntimeException("There is no element in the Binary Tree");
		}

		Queue<Node> nodeQueue = new LinkedList<Node>();

		nodeQueue.offer(rootNode);

		while(!nodeQueue.isEmpty()){
			Node element = nodeQueue.poll();
			if(element.key==elementToSearch){
				return true;
			}
			else{
				if(null!=element.leftNode){
					nodeQueue.offer(element.leftNode);
				}
				if(null!=element.rightNode){
					nodeQueue.offer(element.rightNode);
				}
			}
		}
		return false;
	}

	@Override 
	public int sizeOfBinaryTree(){
		if(rootNode==null){
			throw new RuntimeException("There is no element in the binary tree");
		}

		int result = getSize(rootNode);


		return result;
	}

	private int getSize(Node node){
		if(null!=node){
			return  getSize(node.leftNode) + getSize(node.rightNode)+1;
		}else{
			return 0;
		}
	}

	@Override 
	public int sizeOfBinaryTreeWithOutRecursion(){
		if(rootNode==null){
			throw new RuntimeException("There is no element in the binary tree");
		}

		Queue<Node> node = new LinkedList<Node>();

		node.add(rootNode);
		Node currentNode = rootNode;

		int count=0;

		while(!node.isEmpty()){
			currentNode=node.poll();

			if(null!=currentNode){
				count++;
				if(null!=currentNode.leftNode){
					node.offer(currentNode.leftNode);	

				}
				if(null!=currentNode &&null!=currentNode.rightNode){
					node.offer(currentNode.rightNode);
				}
			}

		}



		return count;
	}

	@Override 
	public String levelOrderTraversingInOpositOrder(){

		if(null==rootNode){
			throw new RuntimeException("There is no element in the binary tree");
		}

		Queue<Node> nodeQueue = new LinkedList<Node>();

		Stack<Node> nodeStack = new Stack<>();
		nodeQueue.offer(rootNode);
		while(!nodeQueue.isEmpty()){
			Node currentElement = nodeQueue.poll();
			if(null!=currentElement){
				nodeStack.push(currentElement);

				if(null!=currentElement.leftNode){
					nodeQueue.offer(currentElement.leftNode);
				}

				if(null!=currentElement.rightNode){
					nodeQueue.offer(currentElement.rightNode);
				}
			}
		}

		StringBuilder returnsTring = new StringBuilder();
		while(!nodeStack.isEmpty()){

			int result = nodeStack.pop().key;
			returnsTring.append(result+" ");
		}


		return returnsTring.toString();
	}

	public int hightOfBinaryTree(){
		int hight = findHight(rootNode);

		return hight;
	}

	private int findHight(Node node){

		if(node==null){
			return -1;
		}

		int leftHight = findHight(node.leftNode);
		int rightHight = findHight(node.rightNode);

		return (leftHight > rightHight)? leftHight+1: rightHight+1;
	}


	public int hightOfbinaryTreeWithUsingStack(){



		return 0;

	}


	@Override
	public void traversePostOrderForPractice() {
		// TODO Auto-generated method stub
		if(null==rootNode){
			throw new RuntimeException("There is no node in the Binary Tree");
		}

		Stack<Node> nodeStack = new Stack<Node>();
		List<Integer> nodeDataList = new LinkedList<Integer>();

		Node previousNode=null;
		nodeStack.push(rootNode);
		while(!nodeStack.isEmpty()){
			Node currentNode = nodeStack.peek();
			if(null==previousNode || previousNode.leftNode==currentNode || previousNode.rightNode==currentNode){
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
				nodeDataList.add(currentNode.key);
				nodeStack.pop();
			}
			previousNode=currentNode;
		}

		System.out.println(nodeDataList.toString() + " PostOrderForPractice");
	}

	@Override
	public void treeTraversalInPreOrder(){
		if(null==rootNode){
			throw new RuntimeException("There is no element in the binary tree");
		}

		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(rootNode);
		List<Integer> elementList = new ArrayList<Integer>();

		while(!nodeStack.isEmpty()){
			Node currentNode = nodeStack.pop();
			elementList.add(currentNode.key);
			if(null!=currentNode.rightNode){
				nodeStack.push(currentNode.rightNode);
			}
			if(null!=currentNode.leftNode){
				nodeStack.push(currentNode.leftNode);
			}
		}

		System.out.println(elementList.toString() + " Prerder");

	}

	public int getHightWithOutRecursion(){
		if(null==rootNode){
			throw new RuntimeException("There is no element in the Array");
		}

		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(rootNode);
		int maxhight=0;
		Node previousNode =null;

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
				nodeStack.pop();
			}
			previousNode=currentNode;  
			if(maxhight< nodeStack.size()){
				maxhight = nodeStack.size()-1;
			}
		}
		return maxhight;
	}

	public int getHightWithOutRecursionUsingLevelOrderTravesing(){
		if(null==rootNode){
			return -1;
		}

		int count=0;
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.offer(rootNode);
		nodeQueue.offer(null);
		while(!nodeQueue.isEmpty()){
			Node currentNode = nodeQueue.poll();
			if(null!=currentNode){
				if(null!=currentNode.leftNode){
					nodeQueue.offer(currentNode.leftNode);
				}

				if(null!=currentNode.rightNode){
					nodeQueue.offer(currentNode.rightNode);
				}
			}else{
				if(!nodeQueue.isEmpty()){
					count++;   
					nodeQueue.offer(null);
				}else{
					return count;
				}

			}

		}
		return count;
	}

	public void inOrderTraversingPractice(){
		if(null==rootNode){
			throw new RuntimeException("There are no element in the tree");
		}
		Stack<Node> nodeStack = new Stack<Node>();

		List<Integer> elementList = new ArrayList<Integer>();

		boolean isDone =false;

		Node curNode=rootNode;

		while(!isDone){
			if(null!=curNode){
				nodeStack.push(curNode);
				curNode=curNode.leftNode;
			}else{
				if(nodeStack.isEmpty()){
					isDone=true;
				}else{
					curNode = nodeStack.pop();
					elementList.add(curNode.key);
					curNode = curNode.rightNode;
				}
			}
		}
		System.out.println(elementList.toString() + " INORDER");	
	}

	public int minnimumDepthOfBinaryTree(){
		if(null==rootNode){
			return -1;
		}
		Queue<Node> nodeQueue = new LinkedList<Node>();

		nodeQueue.add(rootNode);
		nodeQueue.offer(null);

		int minDepth=0;

		while(!nodeQueue.isEmpty()){
			Node ele = nodeQueue.poll();
			if(null!=ele){
				if(null==ele.leftNode && null==ele.rightNode){
					return minDepth;  
				}

				if(null!=ele.leftNode){
					nodeQueue.offer(ele.leftNode);
				}

				if(null!=ele.rightNode){
					nodeQueue.offer(ele.rightNode);
				}
			}else{
				if(!nodeQueue.isEmpty()){
					minDepth++;
					nodeQueue.offer(null);
				}

			}
		}
		return minDepth;
	}

	//Do it without level order traversal

	public void printDeepestNodeInBinaryTree(){
		if(null==rootNode){
			System.out.println("There is no node in the tree");
			return;
		}

		Queue<Node> nodeQueue = new LinkedList<Node>();

		nodeQueue.add(rootNode);

		nodeQueue.add(null);
		Node previousNode=rootNode;


		while(!nodeQueue.isEmpty()){
			Node currele = nodeQueue.poll();
			if(null!=currele){
				if(null!=currele.leftNode){
					nodeQueue.offer(currele.leftNode);
					previousNode=currele.leftNode;
				}
				if(null!=currele.rightNode){
					nodeQueue.offer(currele.rightNode);
					previousNode=currele.rightNode;
				}
			}else{
				if(!nodeQueue.isEmpty()){
					nodeQueue.offer(null);
				}
			}
		}
		System.out.println("Deepest node in the tree "+previousNode.key);
	}

	public void findleafNodeinTheBonaryTree(){
		if(null==rootNode){
			System.out.println("There is no element to print the tree");
		}

		Queue<Node> nodeQueue = new LinkedList<>();

		nodeQueue.offer(rootNode);

		nodeQueue.offer(null);

		List<Integer> arrayList = new ArrayList<Integer>();

		while(!nodeQueue.isEmpty()){
			Node  currNode = nodeQueue.poll();
			if(null!=currNode){
				//based on this condition you can find the leaf node and full node and and half node    
				if((null==currNode.leftNode && null!=currNode.rightNode) || (null!=currNode.leftNode && null==currNode.rightNode)){
					arrayList.add(currNode.key);
				}
				if(null!=currNode.leftNode){
					nodeQueue.offer(currNode.leftNode);
				}
				if(null!=currNode.rightNode){
					nodeQueue.offer(currNode.rightNode);
				}
			}else{
				if(!nodeQueue.isEmpty()){
					nodeQueue.offer(null);
				}
			}	
		}

		System.out.println("leaf node in Binary tree "+arrayList.size());

		System.out.println("leaf node in Binary tree "+arrayList.toString());
	}

	public boolean isIdentical(){
		if(null==rootNode){
			System.out.println("there is no identical behaviour in the tree");
			return false;
		}
		return checkIdenticalBehaviour(rootNode ,rootNode); 
	}

	private boolean checkIdenticalBehaviour(Node rootNode,Node rootNode2){
		if(rootNode==null && rootNode2==null){
			return true;
		}
		if(rootNode==null || rootNode2==null){
			return false;
		}
		if(rootNode.key != rootNode2.key){
			return false;
		}

		return (checkIdenticalBehaviour(rootNode.leftNode, rootNode2.leftNode) || checkIdenticalBehaviour(rootNode.rightNode, rootNode2.rightNode)); 
	}

	public int finddiameterOftree(){
		if(null==rootNode){
			return 0;
		}
		return diameter(rootNode);
	}

	private int diameter(Node node ){
		if(node==null){
			return 0;
		}

		int leftHight = findHightOfTree(node.leftNode);

		int righthight = findHightOfTree(node.rightNode);

		int leftDiameter = diameter(node.leftNode);

		int rightDiameter = diameter(node.rightNode);


		return Math.max(leftHight+righthight+2 , Math.max(leftDiameter, rightDiameter));
	}

	private int findHightOfTree(Node node){

		if(node==null){
			return -1;
		}

		int leftHight = findHightOfTree(node.leftNode);

		int rightHight = findHightOfTree(node.rightNode);

		return Math.max(leftHight, rightHight)+1;
	}



	public int findWidthOfTheNode(){
		if(null==rootNode){
			return -1;
		}

		int hightOfBinaryTree = findHightforWidth(rootNode);
		int maxWidth = 0;

		while(hightOfBinaryTree>=0){
			int calculatedWidth = findWidthAtnthLevel(rootNode,hightOfBinaryTree--);
			maxWidth = maxWidth>calculatedWidth ? maxWidth :calculatedWidth;
		}
		return maxWidth;
	}


	private int findHightforWidth(Node node){

		if(node==null){
			return -1;
		}

		int leftHight = findHightforWidth(node.leftNode);

		int rightHight = findHightforWidth(node.rightNode);

		return Math.max(leftHight, rightHight)+1;

	}

	private int findWidthAtnthLevel(Node node , int level){
		if(level==0 && node!=null){
			return 1;
		}

		if(node==null){
			return 0;
		}

		int leftItem = findWidthAtnthLevel(node.leftNode, --level);

		int rightItem = findWidthAtnthLevel(node.rightNode, level);

		return leftItem + rightItem;

	}

	public int findMaximumSumInOneLevel(){
		if(null==rootNode){
			return 0; 
		}
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.offer(rootNode);
		int maxSum = rootNode.key;
		nodeQueue.offer(null);
		int currentLeveklSum=0;

		while(!nodeQueue.isEmpty()){
			Node currNode = nodeQueue.poll();
			if(null!=currNode){
				if(null!=currNode.leftNode){
					nodeQueue.offer(currNode.leftNode);
					currentLeveklSum=currentLeveklSum+currNode.leftNode.key;
				}
				if(null!=currNode.rightNode){
					nodeQueue.offer(currNode.rightNode);
					currentLeveklSum=currentLeveklSum+currNode.rightNode.key;
				}
			}else{
				if(!nodeQueue.isEmpty()){
					nodeQueue.offer(null);	
					currentLeveklSum=0;
				}
			}
			if(maxSum<currentLeveklSum){
				maxSum=currentLeveklSum;
			}
		}
		return maxSum;

	}

	public String  getAllThepathWithInOrderTraversal(){
		if(null==rootNode){
			return "There are no node for printing the";
		}

		StringBuilder builder = new StringBuilder();

		Stack<Node> nodeStack = new Stack<>();
		List<Integer> arrayList = new LinkedList<Integer>();
		nodeStack.add(rootNode);
		Node previousNode = null;

		while(!nodeStack.isEmpty()){
			Node cuNode = nodeStack.peek();
			if(previousNode==null || previousNode.leftNode==cuNode || previousNode.rightNode==cuNode){
				if(null!=cuNode.leftNode){
					nodeStack.push(cuNode.leftNode);
				}else if(null!=cuNode.rightNode){
					nodeStack.push(cuNode.rightNode);
				}
			}else if(cuNode.leftNode==previousNode){
				if(null!=cuNode.rightNode){
					nodeStack.push(cuNode.rightNode);
				}
			}else{
				cuNode = nodeStack.pop();
				if(null==cuNode.leftNode && cuNode.rightNode==null){
					nodeStack.push(cuNode);
					String str = getStackOrder((Stack<Node>)nodeStack.clone() , new StringBuilder()).toString();

					builder.append(str.substring(0,str.length()-2)+"\n \n");
					nodeStack.pop();
				}
			}
			previousNode=cuNode;
		}

		return builder.toString();
	}

	private StringBuilder getStackOrder(Stack<Node> stack, StringBuilder builder){
		if(stack.isEmpty()){
			return builder;
		}
		Node node = stack.pop();

		builder = getStackOrder(stack,builder);

		builder.append(node.key+"->");

		return builder;

	}

	public boolean isGivenSumisAvailable(int sum){
		if(null==rootNode){
			return false;
		}
		return checkSum(rootNode ,0, sum);
	}


	private boolean checkSum(Node node ,int value , int desiredSum){
		if(null==node && value==desiredSum){
			return true;
		}else{
			if(null!=node){
				return checkSum(node.leftNode, value+node.key, desiredSum) || checkSum(node.rightNode, value+node.key, desiredSum) ;
			}else{
				return false;
			}
		}
	}

	public int getSumOfAlltheNodes(){
		if(null==rootNode){
			return 0;
		}
		return sumofAllgivenNoInTree(rootNode);
	}

	private int sumofAllgivenNoInTree(Node node){
		if(null==node){
			return 0;
		}

		return node.key+ sumofAllgivenNoInTree(node.leftNode)+sumofAllgivenNoInTree(node.rightNode);

	}

	public int getSumOfAlltheNumberWithLevelOrderTraversal(){
		if(Objects.isNull(rootNode)) {
			return 0;
		}
		int sum=0;

		String str = "sfks";


		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.add(rootNode);
		nodeQueue.add(null);
		while(!nodeQueue.isEmpty()){
			Node node = nodeQueue.poll();
			if(null!=node){
				sum +=node.key;
				if(null!=node.leftNode){
					nodeQueue.offer(node.leftNode);
				}
				if(null!=node.rightNode){
					nodeQueue.offer(node.rightNode);
				}
			}else{
				if(!nodeQueue.isEmpty()){
					nodeQueue.offer(null);
				}
			}
		}
		return sum;		
	}

	public void makeMirror(){
		if(null==rootNode){
			throw new RuntimeException("There is no new node in the tree");
		}

		System.out.println("\nOriginl root tree"); 
		printTree(rootNode);

		try {
			Node clonedNode = (Node)rootNode.clone();
			makeMirrorTree(clonedNode);
			System.out.println("\nCloned Node Mirror Tree");
			printTree(clonedNode);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	private void makeMirrorTree(Node node){
		if(null!=node){
			makeMirrorTree(node.leftNode);
			makeMirrorTree(node.rightNode);
			Node temp  = node.leftNode;
			node.leftNode=node.rightNode;
			node.rightNode=temp;
		}
	}

	private void printTree(Node newTree){
		if(null==rootNode){
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

	public boolean isMiror(){
		//this is because i have only one tree right now but there should be one more check
		Node rootNodeClone=null;
		try {
			rootNodeClone = (Node)rootNode.clone();
			makeMirrorTree(rootNodeClone);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkMirror(rootNode, rootNodeClone);
	}


	private  boolean checkMirror(Node nodeOne , Node nodeSecond){
		if(nodeOne==null && nodeSecond==null){
			return true;
		}
		if(nodeOne==null || nodeSecond==null){
			return false;
		}
		if(nodeOne.key!=nodeSecond.key){
			return false;
		}
		return checkMirror(nodeOne.leftNode, nodeSecond.rightNode) && checkMirror(nodeOne.rightNode, nodeSecond.leftNode);
	}

	public void createBTWIthGivenOrder(){
		char[] inorder = {'D','B','E','A','F','C'};

		char[] preOrder = {'A','B','D','E','C','F'};

		char[] postOrder = {'D','E','B','F','C','A'};

		Node rootNode= createBinaryTree(inorder,preOrder);	
		System.out.println("\nWith inorder,preOrder");
		printTree(rootNode);
		rootNode=createBTWithPostOrderorInoder(postOrder,inorder);
		System.out.println("\nWith postOrder,inorder");
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

		Node currentNode = new Node(firstNode,"XYZ");

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


	public Node createBTWithPostOrderorInoder(char[] postOrder ,char[] inorder){
		if(inorder.length==0 || inorder.length!=postOrder.length){
			return null;
		}
		return createBTPostPre(postOrder,0,postOrder.length-1,inorder,0,inorder.length-1);
	}


	public Node createBTPostPre(char[] postOrder,int postStart,int postEnd ,char[] inorder, int inStart , int inEnd){
		if(postStart>postEnd || inStart>inEnd){
			return null;
		}

		char data = postOrder[postEnd];
		Node curr = new Node(data, "sdcsdfsd");

		int offset = inStart;
		for(;offset<inEnd;offset++){
			if(inorder[offset]==data){
				break;
			}
		}
		curr.leftNode = createBTPostPre(postOrder, postStart, postStart+offset-inStart-1 , inorder, inStart, offset-1);
		curr.rightNode = createBTPostPre(postOrder, postStart+offset-inStart, postEnd-1, inorder, offset+1, inEnd);
		return curr;
	}

	public void printAlltheAncesterOftheNode(int no){
		if(null==rootNode){
			throw new RuntimeException("There are no element in the queue");
		}
		System.out.println();
		printAlltheancector(rootNode,no);
	}

	private boolean printAlltheancector(Node node,int key){
		if(null!=node && node.key==key){
			return true;
		}
		if(node==null){
			return false;
		}
		if(printAlltheancector(node.leftNode, key) || printAlltheancector(node.rightNode, key)){
			System.out.print(" "+node.key);
			return true;
		}
		return false;

	}


	public void printInZigZagTraversal(){
		if(null==rootNode){
			throw new RuntimeException("There is no element in the Binary tree");
		}

		Queue<Node> nodeQueue = new LinkedList<Node>();
		List<Integer> eleList = new LinkedList<Integer>();
		List<Integer> prinatableList = new LinkedList<Integer>();
		nodeQueue.offer(rootNode);
		nodeQueue.offer(null);
		boolean leftToRight=true;
		while(!nodeQueue.isEmpty()){
			Node currEle =  nodeQueue.poll();
			if(null!=currEle){
				eleList.add(currEle.key);
				if(null!=currEle.leftNode){
					nodeQueue.add(currEle.leftNode);
				}
				if(null!=currEle.rightNode){
					nodeQueue.add(currEle.rightNode);
				}
			}else{
				if(leftToRight && eleList.size()>0){
					for(int i=0;i<eleList.size();i++){
						prinatableList.add(eleList.get(i));
					}
					eleList.clear();
					leftToRight=false;
				}else if(!leftToRight && eleList.size()>0){
					for(int i=eleList.size()-1;i>=0;i--){
						prinatableList.add(eleList.get(i));
					}
					eleList.clear();
					leftToRight=true;
				}
				if(!nodeQueue.isEmpty()){
					nodeQueue.offer(null);
				} 
			}
		}
		System.out.println("\n");
		prinatableList.forEach((Integer ex) -> System.out.print(" "+ex));
	}

	public void createBinartFromInorder(char[] inorder){
		if(null==inorder || inorder.length==0){
			throw new RuntimeException("There are no element in the Pre Order string");
		}
		AtomicInteger integer= new AtomicInteger(0);

		CharNode node = createBinary(inorder,integer, 0 );
		printCharTree(node);
		try {
			createThirdPointer((CharNode)node.clone());
			CharNode charNode = createThirdWithLoopPointer((CharNode)node.clone());
			System.out.println();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}


	}

	private CharNode createThirdWithLoopPointer(CharNode node) {
         if(null!=node){
        	 createThirdWithLoopPointer(node.leftNode);
        	 createThirdWithLoopPointer(node.rightNode);
        	 if(null!=node.rightNode){
        		 node.leftNode.thirdPointer=node.rightNode;
        	 }
        	 return node;
         }else{
        	 return null;
         }
	}


	private CharNode createBinary(char[] inorder , AtomicInteger integer,int index){

		if(inorder.length==index){
			return null;
		}

		char data  = inorder[index];

		CharNode node = new CharNode(data);
		node.leftNode=null;
		node.rightNode=null;

		if(data=='L'){
			return node;
		}

		node.leftNode = createBinary(inorder,integer,integer.incrementAndGet());

		node.rightNode = createBinary(inorder,integer,integer.incrementAndGet());

		return node;

	}

	private void printCharTree(CharNode newTree){
		if(null==rootNode){
			System.out.println("There is no elementin the tree");
		}
		Queue<CharNode> nodeQueue = new LinkedList<CharNode>();

		List<CharNode> nodeList  = new ArrayList<CharNode>();

		nodeQueue.offer(newTree);
		nodeQueue.offer(null);
		while(!nodeQueue.isEmpty()){
			CharNode currEle = nodeQueue.poll();
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
					nodeList.forEach((CharNode node) -> System.out.print(" "+node.key));
					nodeList.clear();
				}
			}
		}
	}

	private void createThirdPointer(CharNode node){
		if(node==null){
			return;
		}

		List<CharNode> charNodeList = new ArrayList<>();

		Queue<CharNode> charNodeQueue = new LinkedList<CharNode>();
		charNodeQueue.offer(node);
		charNodeQueue.offer(null);

		while(!charNodeQueue.isEmpty()){
			CharNode charNode = charNodeQueue.poll();
			if(null!=charNode){
				charNodeList.add(charNode);
				charNode.thirdPointer=charNodeQueue.peek();
				if(null!=charNode.leftNode){
					charNodeQueue.offer(charNode.leftNode);
				}
				if(null!=charNode.rightNode){
					charNodeQueue.offer(charNode.rightNode);
				}

			}else{
				if(!charNodeQueue.isEmpty()){
					charNodeQueue.offer(null);
				}
			}
		}

		System.out.println("\n All Shibling of a given node");
		charNodeList.forEach((CharNode loopnode)->{
			if(null!=loopnode.thirdPointer)
				System.out.println(loopnode.key+" ===> "+loopnode.thirdPointer.key); 
		});
	}
	
    public void inOrderTraversalAfterBreak(){
    	
    	if(null==rootNode){
    		throw new RuntimeException("There is no element in the tree");
    	}
    	
    	List<Integer> ele = new ArrayList<Integer>();
    	
    	Stack<Node> nodeStack = new Stack<Node>();
     	
    	
    	boolean isDone = false;
    	Node curNode = rootNode;
    	while(!isDone){
                if(null!=curNode){
                	nodeStack.push(curNode);
                	curNode = curNode.leftNode;
                }   
                else{
                	if(nodeStack.isEmpty()){
                		isDone=true;
                	}else{
                     curNode=nodeStack.pop();
                     ele.add(curNode.key);
                     curNode= curNode.rightNode;
                	}
                }
    	}
    	
    	System.out.println("\n Printing the inorder after break"+ele.toString());
    }

    public void printPostOrderAfterBreak(){
    	
    }
    
}

