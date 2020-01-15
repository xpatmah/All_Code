package com.org.problemsolving.ds.first.programming.practice.ds.prog;

import java.util.Stack;

public class ReversingStackWithPushPop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> intgerStack = new Stack<Integer>();
		
		intgerStack.push(1);
		intgerStack.push(2);
		intgerStack.push(3);
		intgerStack.push(4);
		intgerStack.push(5);
		intgerStack.push(6);
		intgerStack.push(7);
		
		int size = intgerStack.size()-1;
		System.out.println(intgerStack.toString());
		
		while(size>0){
			reverseStack(intgerStack, intgerStack.pop(),size--);
		}
		
		System.out.println(intgerStack.toString());
		
		for(int i=0;i<intgerStack.size();i++){
			System.out.println(intgerStack.get(i));
		}
		
	}
	
	
	public static Stack<Integer> reverseStack(Stack<Integer> stack,int element,int size){
		if(stack.empty() || size==0){
			stack.push(element);
			return stack;
		}else{
			int popedElement = stack.pop();
			reverseStack(stack, element,--size);
			stack.push(popedElement);
		}
		return stack;
		
		
	}

}
